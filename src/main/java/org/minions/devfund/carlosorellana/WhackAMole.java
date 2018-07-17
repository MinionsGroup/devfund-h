package org.minions.devfund.carlosorellana;

import java.util.Arrays;

/**
 * The goal is create backend the WhackAMole.
 *
 * @author Carlos Orellana.
 * @since 07/10/2018.
 */
public class WhackAMole {

    private int score;
    private int molesLeft;
    private int attemptsLeft;
    private char[][] moleGrid;

    private static final String SPACE = " ";
    private static final String NEW_LINE = "\n";
    private static final char MOLE_CHAR = 'M';
    private static final char NO_MOLE_CHAR = '*';
    private static final char WHACKED_CHAR = 'W';

    private String messageAttempts;

    /**
     * Constructor WhackAMole class.
     *
     * @param numAttempts - Number Attempts.
     * @param gridDimension - Grid dimensions.
     */
    public WhackAMole(final int numAttempts, final int gridDimension) {
        this.attemptsLeft = numAttempts;
        this.moleGrid = new char[gridDimension][gridDimension];

        for (char[] mole : this.moleGrid) {
            Arrays.fill(mole, NO_MOLE_CHAR);
        }
    }

    /**
     * Sends the Mole positions in the Grid.
     *
     * @param x - X positions.
     * @param y - Y positions.
     * @return True if the position is correct, otherwise false.
     */
    public boolean place(final int x, final int y) {
        int xPosition = x - 1;
        int yPosition = y - 1;

        if (isCorrectPosition(xPosition, yPosition)
             && moleGrid[xPosition][yPosition] != MOLE_CHAR) {
                moleGrid[xPosition][yPosition] = MOLE_CHAR;
                molesLeft++;
                return true;
        }

        return false;
    }

    /**
     * Validate if the coordinate is correct in the grid.
     *
     * @param x - X position.
     * @param y - Y position.
     * @return True fi the position is correct in the grid, otherwise false.
     */
    private boolean isCorrectPosition(final int x, final int y) {
        return x >= 0 && x < moleGrid.length && y >= 0 && y < moleGrid.length;
    }

    /**
     * Sends the Whack position in the Grid.
     *
     * @param x - X position.
     * @param y - Y positions.
     */
    public void whack(final int x, final int y) {
        int xPosition = x - 1;
        int yPosition = y - 1;

        if (attemptsLeft <= 0) {
            messageAttempts = "The number of attempts exceeds the allowed";
            return;
        }

        if (attemptsLeft > 0) {
            if (isCorrectPosition(xPosition, yPosition) && moleGrid[xPosition][yPosition] == MOLE_CHAR) {
                moleGrid[xPosition][yPosition] = WHACKED_CHAR;
                score++;
                attemptsLeft--;
                molesLeft--;
            } else {
                attemptsLeft--;
            }
        }
    }

    /**
     * Prints the Grid to User.
     *
     * @return String value.
     */
    public String printGridToUser() {
        StringBuilder gridToUser = new StringBuilder();

        for (char[] row : moleGrid) {
            for (char place : row) {
                char currentPlace = place == WHACKED_CHAR ? WHACKED_CHAR : NO_MOLE_CHAR;
                gridToUser.append(String.valueOf(currentPlace)).append(SPACE);
            }
            gridToUser.append(NEW_LINE);
        }
        System.err.println(gridToUser.toString());
        return gridToUser.toString();
    }

    /**
     * Prints the Grid initial.
     *
     * @return String value.
     */
    public String printGrid() {
        StringBuilder gridBuilder = new StringBuilder();

        for (char[] row : moleGrid) {
            for (char value : row) {
                gridBuilder.append(String.valueOf(value)).append(SPACE);
            }
            gridBuilder.append(NEW_LINE);
        }
        System.err.println(gridBuilder.toString());
        return gridBuilder.toString();
    }

    /**
     * Gets the Score value.
     *
     * @return Score value.
     */
    public int getScore() {
        return score;
    }

    /**
     * Gets the Moles left value.
     *
     * @return Moles left value.
     */
    public int getMolesLeft() {
        return molesLeft;
    }

    /**
     * Gets the Attempts Left value.
     * @return Attempts Left value.
     */
    public int getAttemptsLeft() {
        return attemptsLeft;
    }

    /**
     * Gets the message Attempts Left value.
     * @return Attempts Left value.
     */
    public String getMessageAttempts() {
        return messageAttempts;
    }
}
