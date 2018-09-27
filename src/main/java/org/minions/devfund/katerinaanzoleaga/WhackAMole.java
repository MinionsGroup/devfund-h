package org.minions.devfund.katerinaanzoleaga;

/**
 * WhackAMole class is the main class of whack a mole game.
 */
public class WhackAMole {

    static final char MOLE = 'M';
    static final char WACKED = 'W';
    private static final char DEFAULT_PLACE = '*';
    private static final char BREAK_LINE = '\n';
    private int score = 0;
    private int molesLeft;
    private int attemptsLeft;
    private char[][] moleGrid;

    /**
     * getScore method returns the current score of the game.
     *
     * @return int score
     */
    public int getScore() {
        return score;
    }

    /**
     * getMolesLeft method returns the moles that were not whacked yet.
     *
     * @return int moles left
     */
    public int getMolesLeft() {
        return molesLeft;
    }

    /**
     * getAttemptsLeft returns he number of attempts left.
     *
     * @return in attemptsLeft
     */
    public int getAttemptsLeft() {
        return attemptsLeft;
    }

    /**
     * getMoleGrid returns a reference to the moleGrid.
     *
     * @return bidirectional array moleGrid
     */
    public char[][] getMoleGrid() {
        return moleGrid.clone();
    }

    /**
     * WhackaMole constructor.
     * It requires the maximum number of attempts and array dimension.
     *
     * @param numAttempts   maximum number of attempts
     * @param gridDimension whackamole grid
     */
    WhackAMole(int numAttempts, int gridDimension) {
        this.attemptsLeft = numAttempts;
        this.moleGrid = new char[gridDimension][gridDimension];
        this.fillMoleGrid();
    }

    /**
     * This method fills the grid with '*'.
     */
    private void fillMoleGrid() {
        for (int i = 0; i < this.moleGrid.length; i++) {
            for (int j = 0; j < this.moleGrid.length; j++) {
                this.moleGrid[i][j] = DEFAULT_PLACE;
            }
        }
    }

    /**
     * Places a mole in the row and column indicated.
     * Returns false if it is not possible either because there is a mole there
     * or when the row and column are invalid for the dimensions of the grid
     * Also increases the number of moles left in the grid.
     *
     * @param x row
     * @param y column
     * @return boolean true if it was possible to place a mole there
     */
    boolean place(int x, int y) {
        if (this.moleGrid[x][y] != MOLE) {
            this.moleGrid[x][y] = MOLE;
            this.molesLeft++;
            return true;
        }
        return false;
    }

    /**
     * Whacks a position indicated by the row and column parameter.
     * If the position is out of the grid it will count as a failure.
     * If there is a mole in the position, then the score will increase
     *
     * @param x row
     * @param y column
     */
    void whack(int x, int y) {
        if (this.moleGrid[x][y] == MOLE) {
            this.moleGrid[x][y] = WACKED;
            this.molesLeft--;
            this.score++;
        }
        this.attemptsLeft--;
    }

    /**
     * Prints the grid in user mode.
     * This means without showing where the moles are,
     * except the ones already whacked
     *
     * @return grid to user
     */
    String printGridToUser() {
        StringBuilder gridToUser = new StringBuilder();
        for (char[] rowMoleGrid : moleGrid) {
            for (char colMoleGrid : rowMoleGrid) {
                gridToUser.append(colMoleGrid == WACKED ? WACKED : DEFAULT_PLACE);
            }
            gridToUser.append(BREAK_LINE);
        }
        return gridToUser.toString();
    }

    /**
     * Prints the grid with the moles positions.
     *
     * @return grid
     */
    String printGrid() {
        StringBuilder grid = new StringBuilder();
        for (char[] rowMoleGrid : moleGrid) {
            for (char colAMoleGrid : rowMoleGrid) {
                grid.append(colAMoleGrid);
            }
            grid.append(BREAK_LINE);
        }
        return grid.toString();
    }
}
