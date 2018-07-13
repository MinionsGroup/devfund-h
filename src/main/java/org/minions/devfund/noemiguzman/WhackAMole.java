package org.minions.devfund.noemiguzman;

/**
 * Created by Noemi on 11-07-18.
 */
public class WhackAMole {

    /**
     * Create a class called WhackAMole.
     */
    private static final char WHACKED = '-';
    public static final char MOLE = '*';
    private static final char DEFAULTCHARACTER = '0';
    private static final String SPACES = "  ";

    // three integer instance variables called score, molesLeft, and attemptsLeft
    private int score;
    private int molesLeft;
    private int attemptsLeft;

    // instance variable called moleGrid which is a 2-dimensional array of chars.
    private char[][] moleGrid;
    private int gridDimension;

    /**
     * The methods to get the moleGrid.
     * @return the char [][]
     */
    public char[][] getMoleGrid() {

        return moleGrid.clone();
    }
    /**
     Constructor for the game, specifies total number of whacks allowed, and the grid dimension.
     *
     * @param numAttempts numero of attempts.
     * @param gridDimension the arrays.
     */
    public WhackAMole(int numAttempts, int gridDimension) {
        attemptsLeft = numAttempts;
        this.gridDimension = gridDimension;
        this.initializeMoleGrid();
    }

    /**
     * Methods to fill the mole grid for the game whack a mole.
     *
     */
    public void initializeMoleGrid() {
        moleGrid = new char[gridDimension][gridDimension];
        for (int i = 0; i < gridDimension; i++) {
            for (int j = 0; j < moleGrid[i].length; j++) {
                moleGrid[i][j] = DEFAULTCHARACTER;
            }
        }
    }

    /**
     * Given a location, place a mole at that location.
     * @param posX position in x.
     * @param posY position.
     * @return true or false, true if exist mole.
     */
    public boolean place(int posX, int posY) {
        if (moleGrid[posX][posY] != MOLE) {
            moleGrid[posX][posY] = MOLE;
            molesLeft++;
            return true;
        }
        return false;
    }

    /**
     *  Given a location, take a whack at that location.
     *  If that location contains a mole, the score, number of attemptsLeft, and molesLeft is updated.
     * @param posX is the location.
     * @param posY is the location
     */
    public void whack(int posX, int posY) {
        if (moleGrid[posX][posY] == MOLE) {
            updateForScoreMolesLeft();
            updateForTheGrid(posX, posY);
            return;
        }
        updateForTheGrid(posX, posY);
    }

    /**
     * This methods update the molesGrid and attemptsLeft.
     * @param posX this is the position x.
     * @param posY this is the position y.
     */
    public  void updateForTheGrid(int posX, int posY) {
        moleGrid[posX][posY] = WHACKED;
        attemptsLeft--;
    }

    /**
     * This method update the score and moles left.
     */
    public void updateForScoreMolesLeft() {
        score++;
        molesLeft--;
    }

    /**
     * Methods that print the grid.
     */
    public void printGrid() {
        StringBuilder grid = new StringBuilder();
        for (char[] row : moleGrid) {
            for (char value : row) {
                grid.append(String.valueOf(value).concat(" "));
            }
            grid.append('\n');
        }
        System.out.print(grid.toString());
    }

    /**
     * Methods that print the grid to user.
     */
    public void printGridToUser() {
        StringBuilder userGrid = new StringBuilder();
        for (char[] row : moleGrid) {
            for (char value : row) {
                existTheMole(userGrid, value);
            }
            userGrid.append('\n');
        }
        System.out.print(userGrid.toString());
    }

    /**
     * The methods to get the moles left.
     * @return the number of moles.
     */
    public int getMolesLeft() {
        return molesLeft;
    }

    /**
     * Gets the score value.
     * @return int
     */
    public int getScore() {
        return  score;
    }

    /**
     * Gets the AttemptsLeft.
     * @return int
     */
    public int getAttemptsLeft() {
        return attemptsLeft;
    }

    /**
     * This methods to verify the moles in the game.
     * @param userGrid the userGrid.
     * @param typeCharacter the caracter.
     */
    private void existTheMole(final StringBuilder userGrid, char typeCharacter) {
        if (typeCharacter == 'M') {
            userGrid.append(String.valueOf("*").concat(" "));
            return;
        }
        userGrid.append(String.valueOf(typeCharacter).concat(SPACES));
    }

    /**
     * This public main methods.
     * @param args string
     */
    public static void main(final String[] args) {
        System.out.println(play());
    }

    /**
     * This private main methods.
     * @return string
     */
    private static String play() {
        final int gridDimension = 10;
        final int mAXATTEMPTS = 50;
        int attempts = mAXATTEMPTS;
        WhackAMole whackAMole = new WhackAMole(attempts, gridDimension);
        whackAMole.initializeMoleGrid();
        whackAMole.printGridToUser();
        return "THANKS TO PAY ... WHACKMOLE";
    }
}

