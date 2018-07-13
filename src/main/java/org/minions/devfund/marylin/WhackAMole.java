package org.minions.devfund.marylin;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Logger;

/**
 * Class to simulate whack a mole.
 */
public final class WhackAMole {
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
    private WhackAMole(int numAttempts, int gridDimension) {
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
    private boolean place(int x, int y) {
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
    private void whack(int x, int y) {
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
    private void printGridToUser() {
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
            LOGGER.info(strBuilderRow.toString());
        }
    }


    /**
     * Method to print the grid showing the status of the game even moles.
     */
    private void printGrid() {
        for (char[] rowGrid : this.moleGrid) {
            StringBuilder strBuilderRow = new StringBuilder();
            for (char charItem : rowGrid) {
                strBuilderRow.append(charItem);
                strBuilderRow.append("  ");
            }
            LOGGER.info(strBuilderRow.toString());
        }
    }

    /**
     * Main method to play the game.
     *
     * @param args Default Argument.
     */
    public static void main(final String[] args) {
        int numberOfMoles = 10;
        int numAttemps = 50;
        int gridLenght = 10;

        //create a 10 by 10 grid
        WhackAMole whackAMole = new WhackAMole(numAttemps, gridLenght);

        //Place randomly a total of 10 moles
        for (int i = 0; i < numberOfMoles; i++) {
            Random rand = new Random();
            int x = rand.nextInt(numberOfMoles);
            int y = rand.nextInt(numberOfMoles);
            StringBuilder strBuilderMessage = new StringBuilder();
            if (!whackAMole.place(x, y)) {
                strBuilderMessage.append("There is already a mole at ");
                strBuilderMessage.append(x);
                strBuilderMessage.append(",");
                strBuilderMessage.append(y);
                strBuilderMessage.append(". Trying again!");
                i--;
            } else {
                strBuilderMessage.append("Mole places at ");
                strBuilderMessage.append(x);
                strBuilderMessage.append(",");
                strBuilderMessage.append(y);
            }
            LOGGER.info(strBuilderMessage.toString());
        }

        //Try to whack 50 times the moles given the x and y
        //Finish the game if we enter xAxis -1 and yAxis -1 printing the grid
        //The game ends if the user is able to uncover all the moles or if the user runs out of attempts.

        LOGGER.info("-------------------------------------");
        whackAMole.printGrid();
        LOGGER.info("-----You have a maximum of " + numAttemps + " attempts to get all the moles wacked-----");

        int xAxis;
        int yAxis;
        Scanner xScanner;
        Scanner yScanner;
        for (int i = numAttemps; i > 0; i--) {
            xScanner = new Scanner(System.in);
            LOGGER.info("Enter the x coordinates: ");
            xAxis = xScanner.nextInt();

            yScanner = new Scanner(System.in);
            LOGGER.info("Enter the y coordinates: ");
            yAxis = yScanner.nextInt();

            if (xAxis == -1 || yAxis == -1) {
                LOGGER.info("Giving up!!");
                whackAMole.printGrid();
                break;
            } else {
                LOGGER.info("State of Game");
                whackAMole.whack(xAxis, yAxis);
                whackAMole.printGridToUser();
            }

            if (whackAMole.molesLeft == 0) {
                LOGGER.info("All moles were whacked with score: " + whackAMole.score);
                break;
            }

            if (whackAMole.attemptsLeft == 0) {
                LOGGER.info("There are no more attemps with score: " + whackAMole.score);
                break;
            }
        }
    }
}
