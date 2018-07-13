package org.minions.devfund.marylin;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Class to simulate whack a mole.
 */
public class WhackAMole {
    private static final Logger LOGGER = Logger.getLogger(WhackAMole.class.getName());
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
    public WhackAMole(int numAttempts, int gridDimension) {
        this.moleGrid = new char[gridDimension][gridDimension];
        this.attemptsLeft = numAttempts;

        for (char[] row : this.moleGrid) {
            Arrays.fill(row, '*');
        }
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
     */
    public void printGridToUser() {
        for (char[] rowGrid : this.moleGrid) {
            StringBuilder strBuilderRow = new StringBuilder();
            for (char charItem : rowGrid) {
                if (charItem == 'M') {
                    strBuilderRow.append("*  ");
                } else {
                    strBuilderRow.append(charItem);
                    strBuilderRow.append("  ");
                }
            }
            LOGGER.fine(strBuilderRow.toString());
        }
    }


    /**
     * Method to print the grid showing the status of the game even moles.
     */
    public void printGrid() {
        for (char[] rowGrid : this.moleGrid) {
            StringBuilder strBuilderRow = new StringBuilder();
            for (char charItem : rowGrid) {
                strBuilderRow.append(charItem);
                strBuilderRow.append("  ");
            }
            LOGGER.fine(strBuilderRow.toString());
        }
    }
}
