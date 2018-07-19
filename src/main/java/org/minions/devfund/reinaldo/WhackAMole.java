package org.minions.devfund.reinaldo;

/**
 * Created by reinaldo on 02-07-18.
 */
public class WhackAMole {

    private static final char DEFAULTCHARACTER = '*';
    private static final String NEWLINE = "\n";
    private static final String SPACES = "  ";
    private static final char WHACKED = 'W';
    private static final char MOLE = 'M';

    //instance variables called score, molesLeft, and attemptsLeft.
    // Make one more instance variable called moleGrid which is a 2-dimensional array of chars.
    private int score;
    private int molesLeft;
    private int attemptsLeft;
    private char[][] moleGrid;
    private int gridDimension;

    /**
     * The methods to get the mole grid.
     * @return the char [][]
     */
    public char[][] getMoleGrid() {
        return moleGrid.clone();
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
     *
     *
     Constructor for the game, specifies total number of whacks allowed, and the grid dimension.
     *
     *
     * @param numAttempts numero of attempts.
     * @param gridDimension the arrays.
     */
    public WhackAMole(int numAttempts, int gridDimension) {
        attemptsLeft = numAttempts;
        this.gridDimension = gridDimension;
        createTheMoleGrid();
    }

    /**
     * Methods to fill the mole grid for the game whack a mole.
     *
     */
    private void createTheMoleGrid() {
        moleGrid = new char[gridDimension][gridDimension];
        for (int i = 0; i < gridDimension; i++) {
            for (int j = 0; j < moleGrid[i].length; j++) {
                moleGrid[i][j] = DEFAULTCHARACTER;
            }
        }
    }

    /**
     * This is the location for a wack a mole.
     * @param posX position in x.
     * @param posY position.
     * @return true or false in the location from (x,y).
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
     * location, take a whack at that location. If that location.
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
     *
     * @return grid string.
     */
    public String printGrid() {
        StringBuilder grid = new StringBuilder();
        for (char[] row : moleGrid) {
            for (char value : row) {
                grid.append(value).append(SPACES);
            }
            grid.append(NEWLINE);
        }
        return grid.toString();
    }

    /**
     * Methods that print the grid to user.
     *
     * @return string to user.
     */
    public String printGridToUser() {
        StringBuilder userGrid = new StringBuilder();
        for (char[] row : moleGrid) {
            for (char value : row) {
                userGrid.append(value == MOLE ? DEFAULTCHARACTER : value).append(SPACES);
            }
            userGrid.append(NEWLINE);
        }

        return userGrid.toString();
    }

}
