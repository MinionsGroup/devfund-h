package org.minions.devfund.miguelcalderon;

import java.util.Random;
import java.util.Scanner;

/**
 * Solution for "Whackmole game" excercise.
 *
 * @version 1.0 16 Jul 2018
 * @author
 * Miguel Calderon
 */

public class WhackAMole {
    private int molesLeft;
    private int attemptsLeft;
    private char[][] moleGrid;
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
        createEmptyGrid();

    }

    /**
     * Creates empty grid.
     */
    private void createEmptyGrid() {
        for (int i = 0; i < moleGrid.length; i++) {
            for (int j = 0; j < moleGrid.length; j++) {
                moleGrid[i][j] = EMPTY;
            }
        }
    }

    /**
     * Set moles in a cell.
     * @param x axis.
     * @param y axis.
     * @return True if the Mole was added properly otherwise false.
     */

    public boolean place(int x, int y) {
        if (x >= 0 && y >= 0 && x < moleGrid.length && y < moleGrid.length) {
            moleGrid[x][y] = MOLE;
            molesLeft++;
            return true;
        } else
            return false;
    }

    /**
     * Set moles in random positions in grid, using "place" method.
     */
    public void setRandomPlaceForMoles() {
        while (molesLeft < moleGrid.length) {
            int xRandomValue = new Random().nextInt(moleGrid.length);
            int yRandomValue = new Random().nextInt(moleGrid.length);
            place(xRandomValue, yRandomValue);
        }
    }

    /**
     * Whack a specified cell.
     */

    public void whack(int x, int y) {
        if (stillHavingAttempts() && !giveUp(x, y)) {
            if (moleGrid[x][y] == MOLE) {
                moleGrid[x][y] = WHACKED_MOLE;
                molesLeft++;
            } else
                attemptsLeft--;
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
    public boolean stillHavingAttempts() {
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

    //Main method, test a 10x10 grid with 50 attempts.

    public static void main(String[] args) {
        WhackAMole whackAMole = new WhackAMole(50, 10);
        whackAMole.setRandomPlaceForMoles();
        System.out.println(whackAMole.printGridToUser());
        while(whackAMole.stillHavingAttempts()) {
            Scanner sc = new Scanner(System.in);
            System.out.println("You have 50 attempts, if you give up enter -1,-1, good luck!");
            System.out.println("Enter X");
            int userX = sc.nextInt();
            System.out.println("Enter Y");
            int userY = sc.nextInt();
            if (!(whackAMole.giveUp(userX, userY))) {
                whackAMole.whack(userX, userY);
                System.out.println(whackAMole.printGridToUser());
            } else {
                whackAMole.attemptsLeft = 0;
                System.out.println(whackAMole.printGrid());
            }

        }
        System.out.println("You have no more attempts, now you can see the moles!");
        System.out.println(whackAMole.printGrid());

    }

}


