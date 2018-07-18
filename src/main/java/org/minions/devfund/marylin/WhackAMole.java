package org.minions.devfund.marylin;

import java.util.Arrays;

/**
 * Class to simulate whack a mole.
 */
public class WhackAMole {
    private int score;
    private int molesLeft;
    private int attemptsLeft;
    private char[][] moleGrid;

    /**
     * Constructor of WhackAMole class.
     *
     * @param numAttempts   Number of the attempts.
     * @param gridDimension Number of the grid dimension.
     */
    WhackAMole(int numAttempts, int gridDimension) {
        this.moleGrid = new char[gridDimension][gridDimension];
        this.attemptsLeft = numAttempts;

        for (char[] row : this.moleGrid) {
            Arrays.fill(row, '*');
        }
    }

    /**
     * Get score.
     *
     * @return score.
     */
    public int getScore() {
        return score;
    }
    /**
     * Get Moles left.
     *
     * @return molesLeft.
     */
    public int getMolesLeft() {
        return molesLeft;
    }

    /**
     * Get Attempts left.
     *
     * @return attemptsLeft.
     */
    public int getAttemptsLeft() {
        return attemptsLeft;
    }

    /**
     * Get Mole grid.
     *
     * @return moleGrid.
     */
    public char[][] getMoleGrid() {
        return this.moleGrid.clone();
    }

    /**
     * Method to place a mole into the grid.
     *
     * @param x X axis in the grid.
     * @param y Y axis in the grid.
     * @return Returns true if the mole was place, false otherwise.
     */
    public boolean place(int x, int y) {
        if (this.moleGrid[x][y] != 'M') {
            this.moleGrid[x][y] = 'M';
            this.molesLeft++;
            return true;
        }
        return false;
    }

    /**
     * Method to whack a mole in the grid.
     *
     * @param x X axis in the grid.
     * @param y Y axis in the grid.
     */
    public void whack(int x, int y) {
        if (this.moleGrid[x][y] == 'M') {
            this.moleGrid[x][y] = 'W';
            this.score++;
            this.molesLeft--;
        }
        this.attemptsLeft--;
    }

    /**
     * Method to print the status of the game without shows the moles.
     *
     * @return return the grid in a string.
     */
    public StringBuilder printGridToUser() {
        StringBuilder strBuilderRow = new StringBuilder();
        for (char[] rowGrid : this.moleGrid) {
            for (char charItem : rowGrid) {
                if (charItem == 'M') {
                    strBuilderRow.append("*  ");
                } else {
                    strBuilderRow.append(charItem);
                    strBuilderRow.append("  ");
                }
            }
        }
        return strBuilderRow;
    }

    /**
     * Method to print the grid showing the status of the game even moles.
     *
     * @return return the grid in a string.
     */
    public StringBuilder printGrid() {
        StringBuilder strBuilderRow = new StringBuilder();
        for (char[] rowGrid : this.moleGrid) {
            for (char charItem : rowGrid) {
                strBuilderRow.append(charItem);
                strBuilderRow.append("  ");
            }
        }
        return strBuilderRow;
    }
}
