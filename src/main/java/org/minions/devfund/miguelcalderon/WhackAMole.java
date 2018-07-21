package org.minions.devfund.miguelcalderon;

import java.util.Random;

/**
 * Solution for "Whackmole game" excercise.
 *
 * @author Miguel Calderon
 * @version 1.0 16 Jul 2018
 */

public class WhackAMole {
    private int molesLeft;
    private int attemptsLeft;
    private char[][] moleGrid;
    private int score;
    private static final char MOLE = 'M';
    private static final char WHACKED_MOLE = 'W';
    private static final char EMPTY = '*';

    /**
     * Constructor.
     *
     * @param numAttempts   number of attempts.
     * @param gridDimension number of rows and columns of the grid.
     */
    public WhackAMole(int numAttempts, int gridDimension) {
        this.moleGrid = new char[gridDimension][gridDimension];
        attemptsLeft = numAttempts;
        this.molesLeft = 0;
        score = 0;
        createEmptyGrid();
        setRandomPlaceForMoles();
    }

    /**
     * Creates empty grid.
     */
    public void createEmptyGrid() {
        for (int i = 0; i < moleGrid.length; i++) {
            for (int j = 0; j < moleGrid.length; j++) {
                moleGrid[i][j] = EMPTY;
            }
        }
    }

    /**
     * Set moles in a cell.
     *
     * @param x axis.
     * @param y axis.
     * @return True if the Mole was added properly otherwise false.
     */

    public boolean place(int x, int y) {
        if (isValidPosition(x, y)) {
            moleGrid[x][y] = MOLE;
            molesLeft++;
            return true;
        } else {
            return false;
        }

    }

    /**
     * Set moles in random positions in grid, using "place" method.
     */
    private void setRandomPlaceForMoles() {
        while (molesLeft < moleGrid.length) {
            int xRandomValue = new Random().nextInt(moleGrid.length);
            int yRandomValue = new Random().nextInt(moleGrid.length);
            place(xRandomValue, yRandomValue);
        }
    }

    /**
     * Whack a specified cell.
     *
     * @param x axis.
     * @param y axis.
     */
    public void whack(int x, int y) {
        if (stillHavingAttempts() && !giveUp(x, y)) {
            if (moleGrid[x][y] == MOLE) {
                moleGrid[x][y] = WHACKED_MOLE;
                molesLeft--;
                attemptsLeft--;
                score++;
            } else {
                attemptsLeft--;
            }

        }
    }

    /**
     * Verifies if  player gives up.
     *
     * @param x axis.
     * @param y axis.
     * @return True if the player insert (-1, -1) otherwise false.
     */
    public boolean giveUp(int x, int y) {
        return x == -1 && y == -1;
    }

    /**
     * Verifies if user still having attempts.
     *
     * @return true if the rules are applied otherwise false.
     */
    private boolean stillHavingAttempts() {
        return attemptsLeft > 0;
    }

    /**
     * Shows the grid without show moles.
     *
     * @return StringBuilder without moles.
     */

    public StringBuilder printGridToUser() {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < moleGrid.length; i++) {
            for (int j = 0; j < moleGrid.length; j++) {
                if (moleGrid[i][j] == MOLE) {
                    stringBuilder.append(EMPTY);
                } else {
                    stringBuilder.append(moleGrid[i][j]);
                }
            }
            stringBuilder.append("\n");
        }

        return stringBuilder;
    }

    /**
     * Shows the grid including moles.
     *
     * @return StringBuilder with entire grid including moles.
     */
    public StringBuilder printGrid() {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < moleGrid.length; i++) {
            for (int j = 0; j < moleGrid.length; j++) {
                stringBuilder.append(moleGrid[i][j]);
            }
            stringBuilder.append("\n");
        }
        return stringBuilder;
    }


    /**
     * Verify if the cell is empty.
     *
     * @param x axis
     * @param y axis
     * @return true if it is an empty cell, otherwise false
     */
    public boolean isValidPosition(int x, int y) {
        boolean valid = false;
        if (x >= 0 && y >= 0 && x < moleGrid.length && y < moleGrid.length) {
            valid = moleGrid[x][y] == EMPTY;
        }
        return valid;
    }

    /**
     * Gets moles left.
     *
     * @return int
     */
    public int getMolesLeft() {
        return molesLeft;
    }

    /**
     * Gets attempts left.
     *
     * @return int
     */
    public int getAttemptsLeft() {
        return attemptsLeft;
    }

    /**
     * Gets score.
     *
     * @return int
     */
    public int getScore() {
        return score;
    }

    /**
     * Gets all the grid.
     *
     * @return char[][]
     */
    public char[][] getMoleGrid() {
        return moleGrid;
    }

}


