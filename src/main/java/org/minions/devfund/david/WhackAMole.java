package org.minions.devfund.david;

import java.util.Arrays;

/**
 * Homework Assignment 1: WhackAMole game.
 */
public class WhackAMole {
    private static final char DEFAULT_CHAR = '*';
    private static final char MOLE = 'M';
    private static final char WHACKED = 'W';
    private static final String SPACE = " ";
    private static final String NEW_LINE = "\n";

    private int score;
    private int molesLeft;
    private int attemptsLeft;
    private char[][] moleGrid;

    /**
     * Gets score value.
     *
     * @return Score quantity as integer.
     */
    public int getScore() {
        return score;
    }

    /**
     * Gets molesLeft value.
     *
     * @return MolesLeft quantity.
     */
    public int getMolesLeft() {
        return molesLeft;
    }

    /**
     * Gets attemptsLeft value.
     *
     * @return AttemptsLeft quantity as integer.
     */
    public int getAttemptsLeft() {
        return attemptsLeft;
    }

    /**
     * Constructor of WhackAMole class.
     *
     * @param numAttempts   Number of attempts that user have.
     * @param gridDimension Grid dimension for game.
     */
    public WhackAMole(int numAttempts, int gridDimension) {
        attemptsLeft = numAttempts;
        moleGrid = new char[gridDimension][gridDimension];
        initMoleGrid();
    }

    /**
     * Method to place a mole into Grid.
     *
     * @param x represent x position on 2D array.
     * @param y represent y position on 2D array.
     * @return return true if mole exist on position otherwise false.
     */
    public boolean place(int x, int y) {
        if (isValidPosition(x, y) && moleGrid[x][y] != MOLE) {
            moleGrid[x][y] = MOLE;
            molesLeft++;
            return true;
        }

        return false;
    }

    /**
     * method to place a whacked mole into Grid.
     *
     * @param x represent x position on 2D array.
     * @param y represent y position on 2D array.
     */
    public void whack(int x, int y) {
        if (isValidPosition(x, y) && moleGrid[x][y] == MOLE) {
            moleGrid[x][y] = WHACKED;
            score++;
            molesLeft--;
        }
        attemptsLeft--;
    }

    /**
     * Prints grid to user without show mole/s position.
     * @return {@link StringBuilder}
     */
    public StringBuilder printGridToUser() {
        StringBuilder userGrid = new StringBuilder();
        for (char[] array : moleGrid) {
            for (char element : array) {
                char elementToUser = element == WHACKED ? WHACKED : DEFAULT_CHAR;
                userGrid.append(elementToUser).append(SPACE);
            }
            userGrid.append(NEW_LINE);
        }

        return userGrid;
    }

    /**
     * Prints all grid.
     * @return {@link StringBuilder}
     */
    public StringBuilder printGrid() {
        StringBuilder grid = new StringBuilder();
        for (char[] array : moleGrid) {
            for (char element : array) {
                grid.append(element).append(SPACE);
            }
            grid.append(NEW_LINE);
        }
        return grid;
    }

    /**
     * Initialize Whack a mole grid.
     */
    private void initMoleGrid() {
        for (char[] row : moleGrid) {
            Arrays.fill(row, DEFAULT_CHAR);
        }
    }

    /**
     * Validates position in a Grid.
     *
     * @param x represents x position in 2D array.
     * @param y represents y position in 2D array.
     * @return return true if is a valid position otherwise false.
     */
    private boolean isValidPosition(int x, int y) {
        return x >= 0 && y >= 0 && x < moleGrid.length && y < moleGrid.length;
    }
}
