package org.minions.devfund.abel;

import java.util.Arrays;

/**
 * Class to simulate a variant of the classic whack-a-mole game.
 */
public class WhackAMole {

    private static final int ZERO = 0;
    private static final char MOLE = 'M';
    private static final char MOLE_WHACKED = 'W';
    private char[][] moleGrid;
    private int score;
    private int molesLeft;
    private int attemptsLeft;
    private static final char EMPTY_MOLE = '*';

    /**
     * Constructor for the game, specifies total number of whacks allowed, and the grid dimension.
     *
     * @param numAttempts   number of attempts.
     * @param gridDimension size of moleGrid.
     */
    public WhackAMole(int numAttempts, int gridDimension) {
        this.moleGrid = new char[gridDimension][gridDimension];
        for (char[] row : this.moleGrid) {
            Arrays.fill(row, EMPTY_MOLE);
        }
        this.attemptsLeft = numAttempts;
    }

    /**
     * Gets Score.
     *
     * @return score value.
     */
    public int getScore() {
        return this.score;
    }

    /**
     * Gets Attempts Left.
     *
     * @return attemptsLeft value.
     */
    public int getAttemptsLeft() {
        return this.attemptsLeft;
    }

    /**
     * Gets Moles Left.
     *
     * @return molesLeft value.
     */
    public int getMolesLeft() {
        return this.molesLeft;
    }

    /**
     * Given a location, place a mole at that location.
     *
     * @param row row position of char array.
     * @param col col position of char array.
     * @return if the mole can be placed.
     */
    public boolean place(int row, int col) {
        if (isValidPosition(row, col) && EMPTY_MOLE == this.moleGrid[row][col]) {
            this.moleGrid[row][col] = MOLE;
            this.molesLeft++;
            return true;
        }
        return false;
    }

    /**
     * Given a location, take a whack at that location.
     * If that location contains a mole, the score, number of attemptsLeft, and molesLeft is updated.
     * If that location does not contain a mole, only attemptsLeft is updated.
     *
     * @param row row position to whack.
     * @param col col position to whack.
     */
    public void whack(int row, int col) {
        this.attemptsLeft--;
        if (isValidPosition(row, col) && MOLE == this.moleGrid[row][col]) {
            this.molesLeft--;
            this.score++;
            this.moleGrid[row][col] = MOLE_WHACKED;
        }
    }

    /**
     * Verifies if the position contains an specific char.
     *
     * @param row    row position to check.
     * @param col    col position to check.
     * @return if the position is valid.
     */
    private boolean isValidPosition(int row, int col) {
        int size = this.moleGrid.length;
        boolean checkRow = ZERO <= row && row < size;
        boolean checkCol = ZERO <= col && col < size;
        return checkRow && checkCol;
    }

    /**
     * Print the grid without showing where the moles are.
     * For every spot that has recorded a “whacked mole,” print out a W, or * otherwise.
     *
     * @return the grid completely without moles.
     */
    public String printGridToUser() {
        return printGrid().replace(MOLE, EMPTY_MOLE);
    }

    /**
     * Print the grid completely. This is effectively dumping the 2d array on the screen.
     * The places where the moles are should be printed as an ‘M’.
     * The places where the moles have been whacked should be printed as a ‘W’.
     * The places that don’t have a mole should be printed as *.
     *
     * @return the grid completely.
     */
    public String printGrid() {
        StringBuilder stringBuilder = new StringBuilder();
        for (char[] row : this.moleGrid) {
            stringBuilder.append(String.format("%s%s", String.valueOf(row), System.lineSeparator()));
        }
        return stringBuilder.toString();
    }
}
