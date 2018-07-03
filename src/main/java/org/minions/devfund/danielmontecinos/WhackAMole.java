package org.minions.devfund.danielmontecinos;

import java.util.Arrays;

/**
 * Class simulates WhackAMoles game.
 */
public class WhackAMole {
    private static final String SPACE = " ";
    private static final String NEW_LINE = "\n";
    private static final char MOLE = 'M';
    private static final char NO_MOLE = '*';
    private static final char WHACKED = 'W';
    private int score;
    private int molesLeft;
    private int attemptsLeft;
    private char[][] moleGrid;

    /**
     * Initializes an instance of {@link WhackAMole} class.
     *
     * @param numAttempts   max number of attempts.
     * @param gridDimension array dimension value.
     */
    public WhackAMole(final int numAttempts, final int gridDimension) {
        moleGrid = new char[gridDimension][gridDimension];
        attemptsLeft = numAttempts;
        initGrid();
    }

    /**
     * Gets score.
     *
     * @return score value.
     */
    public int getScore() {
        return score;
    }

    /**
     * Gets number of moles left.
     *
     * @return molesLeft value.
     */
    public int getMolesLeft() {
        return molesLeft;
    }

    /**
     * Gets number of attempts left.
     *
     * @return attemptsLeft value.
     */
    public int getAttemptsLeft() {
        return attemptsLeft;
    }

    /**
     * Puts a mole in a given location inside the array.
     *
     * @param x represents position x on array.
     * @param y represents position y on array.
     * @return true if location is valid, false otherwise
     */
    public boolean place(int x, int y) {
        if (isValidLocation(x, y) && moleGrid[x][y] != MOLE) {
            moleGrid[x][y] = MOLE;
            molesLeft++;
            return true;
        }
        return false;
    }

    /**
     * Tries to hit a mole in a given location.
     *
     * @param x represents position x on array.
     * @param y represents position y on array.
     */
    public void whack(int x, int y) {
        if (isValidLocation(x, y) && moleGrid[x][y] == MOLE) {
            moleGrid[x][y] = WHACKED;
            score++;
            attemptsLeft--;
            molesLeft--;
        } else {
            attemptsLeft--;
        }
    }

    /**
     * Prints moleGrid on console without shows where a mole is positioned in.
     *
     * @return grid without displayed moles position.
     */
    public String printGridToUser() {
        StringBuilder userGrid = new StringBuilder();
        for (char[] row : moleGrid) {
            for (char place : row) {
                char currentPlace = place == WHACKED ? WHACKED : NO_MOLE;
                userGrid.append(String.valueOf(currentPlace)).append(SPACE);
            }
            userGrid.append(NEW_LINE);
        }
        return userGrid.toString();
    }

    /**
     * Prints moleGris on console.
     *
     * @return grid that displays moles position.
     */
    public String printGrid() {
        StringBuilder gridBuilder = new StringBuilder();
        for (char[] row : moleGrid) {
            for (char value : row) {
                gridBuilder.append(String.valueOf(value)).append(SPACE);
            }
            gridBuilder.append(NEW_LINE);
        }
        return gridBuilder.toString();
    }

    /**
     * Checks if a given location is a valid one.
     *
     * @param x represents position x on array.
     * @param y represents position y on array.
     * @return true if location is valid, false otherwise
     */
    private boolean isValidLocation(int x, int y) {
        return x >= 0 && x < moleGrid.length && y >= 0 && y < moleGrid.length;
    }

    /**
     * Initializes 2 dimensional array.
     */
    private void initGrid() {
        for (char[] row : moleGrid) {
            Arrays.fill(row, NO_MOLE);
        }
    }
}
