package org.minions.devfund.damianvp;

import java.util.Arrays;

/**
 * Class to build whack a mole game.
 */
public class WhackAMole {
    private int score;
    private int molesLeft;
    private int attemptsLeft;
    private char[][] moleGrid;
    private char[][] trackerMoleGrid;
    private static final char MOLE = 'M';
    private static final char EMPTY = '*';
    private static final char WHACKED = 'W';
    private static final int INVALID_RANGE = -2;

    /**
     * constructor class.
     * @param numAttempts num of attempts available for game
     * @param gridDimension dimension of grid game
     */
    WhackAMole(int numAttempts, int gridDimension) {
        this.attemptsLeft = numAttempts;
        this.moleGrid = initializeGrid(gridDimension);
        this.trackerMoleGrid = initializeGrid(gridDimension);
        this.molesLeft = 0;
        this.score = 0;
    }

    /**
     * Initialize the grid game with empty values.
     * @param gridDimension  dimension of grid to build.
     * @return a grid loaded with empty values.
     */
    private char[][] initializeGrid(int gridDimension) {
        char[][] grid = new char[gridDimension][gridDimension];
        for (char[] row: grid) {
            Arrays.fill(row, EMPTY);
        }
        return grid;
    }

    /**
     * Method to place a specific mole by Location x, y.
     * @param x  x location of grid.
     * @param y  y location of grid.
     * @return  true, if place is successful.
     *          false, if place was not performed.
     */
    boolean place(int x, int y) {
        if (validatedCoordinates(x, y) && this.moleGrid[x][y] != MOLE) {
            this.moleGrid[x][y] = MOLE;
            this.molesLeft++;
            return true;
        }
        return false;
    }

    /**
     * Method to whack a location in order to search a mole.
     * @param x x location of grid game.
     * @param y y location of grid game
     */
    void whack(int x, int y) {
        if (validatedCoordinates(x, y)) {
            if (this.moleGrid[x][y] == MOLE) {
                this.molesLeft--;
                this.score++;

                this.trackerMoleGrid[x][y] = WHACKED;
                this.moleGrid[x][y] = WHACKED;
            }
            this.attemptsLeft--;
        }
    }

    /**
     * Method to validate locations.
     * @param x x location of grid game.
     * @param y y location of grid game.
     * @return true, if locations are valid.
     *         false, if location are not valid.
     */
    private boolean validatedCoordinates(int x, int y) {
        return x > INVALID_RANGE && y > INVALID_RANGE && x < this.moleGrid.length && y < this.moleGrid.length;
    }

    /**
     * Method to get the score game.
     * @return current score of game.
     */
    int getScore() {
        return this.score;
    }

    /**
     * Method to get the current moles left.
     * @return number of current moles left.
     */
    int getMolesLeft() {
        return this.molesLeft;
    }

    /**
     * Method to get the left attempts.
     * @return the attemps left.
     */
    int getAttemptsLeft() {
        return this.attemptsLeft;
    }

    /**
     * Method to get the mole grid.
      * @return mole grid matrix.
     */
    char[][] getMoleGrid() {
        return this.moleGrid;
    }

    /**
     * This method returns the grid available for user.
     * @return String trackerMoleGrid.
     */
    char[][] getTrackerMoleGrid() {
        return this.trackerMoleGrid;
    }

}
