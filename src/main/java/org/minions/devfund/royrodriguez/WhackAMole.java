package org.minions.devfund.royrodriguez;

import java.util.Arrays;

/**
 * Whack a Mole game.
 */
public class WhackAMole {

    private char[][] moleGrid;
    private int score;
    private int attemptsLeft;
    private int molesLeft;
    private static final char MOLE = 'M';
    private static final char WHACKED = 'W';
    private static final char EMPTY_PLACE = '*';

    /**
     * Constructor.
     *
     * @param numAttempts   max. attempts.
     * @param gridDimension dimensions.
     */
    public WhackAMole(int numAttempts, int gridDimension) {
        this.attemptsLeft = numAttempts;
        moleGrid = new char[gridDimension][gridDimension];
        initializeMoleGrid();
    }

    /**
     * Initializes grid to play.
     */
    private void initializeMoleGrid() {
        for (char[] c : moleGrid) {
            Arrays.fill(c, EMPTY_PLACE);
        }
    }

    /**
     * Places a mole.
     *
     * @param x position
     * @param y position
     * @return true if it was possible to place a mole, false otherwise.
     */
    public boolean place(int x, int y) {
        if (x < moleGrid.length && y < moleGrid.length && moleGrid[x][y] == EMPTY_PLACE) {
            moleGrid[x][y] = MOLE;
            molesLeft++;
            return true;
        }
        return false;
    }

    /**
     * Whacks a mole.
     *
     * @param x position.
     * @param y position.
     */
    public void whack(int x, int y) {
        if (x < 0 || y < 0) {
            attemptsLeft = 0;
            return;
        }

        if (moleGrid[x][y] == MOLE) {
            moleGrid[x][y] = WHACKED;
            score++;
            molesLeft--;
        }
        attemptsLeft--;
    }

    /**
     * Builds a grid for the user to print.
     *
     * @return {@link StringBuilder}
     */
    public StringBuilder printGridToUser() {
        StringBuilder stringBuilder = new StringBuilder();
        for (char[] row : moleGrid) {
            for (char position : row) {
                stringBuilder.append(position == MOLE ? EMPTY_PLACE : position);
            }
            stringBuilder.append("\n");
        }

        return stringBuilder;
    }

    /**
     * Verifies if the game continues or ends.
     *
     * @return true to continue playing.
     */
    public boolean rules() {
        return attemptsLeft > 0 && molesLeft > 0;
    }

    /**
     * Gets the score.
     *
     * @return score.
     */
    public int getScore() {
        return score;
    }

    /**
     * Gets attempts left.
     *
     * @return attempts value.
     */
    public int getAttemptsLeft() {
        return attemptsLeft;
    }

    /**
     * Gets moles left.
     *
     * @return moles left value.
     */
    public int getMolesLeft() {
        return molesLeft;
    }

}
