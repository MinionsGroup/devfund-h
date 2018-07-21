package org.minions.devfund.damianvp;

import java.util.Arrays;
import java.util.Random;

/**
 * Class to build whack a mole game.
 */
public class WhackAMole {
    private int score;
    private int molesLeft;
    private int attemptsLeft;
    private char[][] moleGrid;
    private char[][] trackerMoleGrid;
    static final char MOLE = 'M';
    static final char EMPTY = '*';
    static final char WHACKED = 'W';
    static final int INVALID_RANGE = -2;

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
     * Method to randomly place n quantity of moles.
     * @param moles quantity of moles to place randomly.
     */
    void randomPlace(int moles) {
        Random random = new Random();
        int max = this.moleGrid.length;
        int min = 0;
        boolean moleIsPlaced;
        if (moles <= this.moleGrid.length * this.moleGrid.length) {
            while (moles > 0) {
                int x = random.nextInt(max - min);
                int y = random.nextInt(max - min);
                moleIsPlaced = place(x, y);
                if (moleIsPlaced) {
                    moles--;
                }
            }
        }
        System.out.println("Is not possible place more than fdsfsdf");
    }

    /**
     * Method to whack a location in order to search a mole.
     * @param x x location of grid game.
     * @param y y location of grid game
     */
    void whack(int x, int y) {
        if (validatedCoordinates(x, y)) {
            if (this.moleGrid[x][y] == MOLE) {
                System.out.println("Good, you found a mole!!");
                this.molesLeft--;
                this.score++;

                this.trackerMoleGrid[x][y] = WHACKED;
                this.moleGrid[x][y] = WHACKED;
            }
            this.attemptsLeft--;
            verifyGameStatus();
        }
    }

    /**
     * Method to print the grid available for user.
     */
    void printGridToUser() {
        System.out.println(Arrays.deepToString(this.trackerMoleGrid));
    }

    /**
     * Method to print the complete grid game status.
     */
    void printGrid() {
        System.out.println(Arrays.deepToString(this.moleGrid));
    }

    /**
     * Method to validate locations.
     * @param x x location of grid game.
     * @param y y location of grid game.
     * @return true, if locations are valid.
     *         false, if location are not valid.
     */
    boolean validatedCoordinates(int x, int y) {
        if (x > INVALID_RANGE && y > INVALID_RANGE && x < this.moleGrid.length && y < this.moleGrid.length) {
            if (x == -1 && y == -1) {
                this.attemptsLeft = 0;
                verifyGameStatus();
                return false;
            }
            return true;
        } else {
            System.out.println(String.format("valid coordinates should be between 0 - %s", this.moleGrid.length - 1));
            return false;
        }
    }

    /**
     * Method to verify if game continue.
     */
    void verifyGameStatus() {
        if (this.molesLeft == 0) {
            System.out.println("Great you win!!!");
            System.out.println(String.format("Score: %s", this.score));
            return;
        }
        if (this.attemptsLeft <= 0) {
            System.out.println("You Loss...  Try Again");
            printGrid();
        }
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

}
