package org.minions.devfund.katerinaanzoleaga;

/**
 * WhackAMole game class and main.
 * */

import java.util.Scanner;
import java.util.Random;

/**
 * WhackAMole class is the main class of whckamole game.
 */
public class WhackAMole {
    private int score = 0;
    private int molesLeft;
    private int attemptsLeft;
    private char[][] moleGrid;
    static final int DIMENSION = 10;
    static final int TOTAL_MOLES = 10;
    static final int MAX_ATTEMPTS = 50;

    /**
     * getScore method returns the current score of the game.
     * @return int score
     */
    public int getScore() {
        return score;
    }

    /**
     * getMolesLeft metod returns the moles that were not whacked yet.
     * @return int moles left
     */
    public int getMolesLeft() {
        return molesLeft;
    }

    /**
     * getAttemptsLeft returns he number of attempts left.
     * @return in attemptsLeft
     */
    public int getAttemptsLeft() {
        return attemptsLeft;
    }

    /**
     * getMoleGrid returns a reference to the moleGrid.
     * @return bidirectional array moleGrid
     */
    public char[][] getMoleGrid() {
        return moleGrid;
    }

    /**
     * WhackaMole constructor.
     * It requires the maximum number of attempts and array dimension.
     * @param numAttempts maximum number of attempts
     * @param gridDimension whackamole grid
     */
    WhackAMole(int numAttempts, int gridDimension) {
        if (numAttempts < 0 || gridDimension < 0) {
            throw new NegativeArraySizeException();
        }

        this.attemptsLeft = numAttempts;
        this.moleGrid = new char[gridDimension][gridDimension];
        this.molesLeft = 0;
    }

    /**
     * Places a mole in the row and column indicated.
     * Returns false if it is not possible either because there is a mole there
     * or when the row and column are invalid for the dimensions of the grid
     * Also increases the number of moles left in the grid.
     * @param x row
     * @param y column
     * @return boolean true if it was possible to place a mole there
     */
    boolean place(int x, int y) {
        if (x < 0 || y < 0) {
            return false;
        }
        int maxIndex = this.moleGrid.length - 1;
        if (x <= maxIndex && y <= maxIndex && this.moleGrid[x][y] != 'M') {
            this.moleGrid[x][y] = 'M';
            this.molesLeft = this.molesLeft + 1;
            return true;
        } else {
            return false;
        }
    }

    /**
     * Whacks a position indicated by the row and column parameter.
     * If the position is out of the grid it will count as a failure.
     * If there is a mole in the position, then the score will increase
     * @param x row
     * @param y column
     */
    void whack(int x, int y) {
        if (x < 0 || y < 0) {
            this.attemptsLeft = this.attemptsLeft - 1;
        } else {
            int maxIndex = this.moleGrid.length - 1;
            if (x <= maxIndex && y <= maxIndex && this.moleGrid[x][y] == 'M') {
                this.moleGrid[x][y] = 'W';
                this.molesLeft = this.molesLeft - 1;
                this.score = this.score + 1;
            }
            this.attemptsLeft = this.attemptsLeft - 1;
        }
    }

    /**
     * Prints the grid in user mode.
     * This means without showing where the moles are,
     * except the ones already whacked
     */
    void printGridToUser() {
        int maxIndex = this.moleGrid.length - 1;
        for (int i = 0; i <= maxIndex; i++) {
            for (int j = 0; j <= maxIndex; j++)  {
                if (this.moleGrid[i][j] == 'M' || this.moleGrid[i][j] == '\u0000') {
                    System.out.print("   *");
                } else {
                    System.out.print("   " + this.moleGrid[i][j]);
                }
            }
            System.out.println();
        }
    }

    /**
     * Prints the grid with the moles positions.
     */
    void printGrid() {
        int maxIndex = this.moleGrid.length - 1;
        for (int i = 0; i <= maxIndex; i++) {
            for (int j = 0; j <= maxIndex; j++)  {
                if (this.moleGrid[i][j] == '\u0000') {
                    System.out.print("   *");
                } else {
                    System.out.print("   " + this.moleGrid[i][j]);
                }
            }
            System.out.println();
        }
    }


    /**
     * Places N moles in randomic positions.
     * @param n number of moles
     */
    void placeNMoles(int n) {
        int i = 1;
        while (i <= n) {
            Random randomGenerator = new Random();
            int x = randomGenerator.nextInt(this.moleGrid.length);
            int y = randomGenerator.nextInt(this.moleGrid.length);
            if (this.place(x, y)) {
                i = i + 1;
            }
        }
    }

    /**
     * Main.
     * @param args arguments
     */
    public static void main(final String[] args) {
        WhackAMole whackAMole = new WhackAMole(MAX_ATTEMPTS, DIMENSION);
        whackAMole.placeNMoles(TOTAL_MOLES);
        System.out.println("Welcome to WhackAMole game. Enter -1 and -1 to exit");
        System.out.println();
        whackAMole.printGridToUser();
        int r = 0;
        int c = 0;
        while (whackAMole.getAttemptsLeft() > 0 && whackAMole.getScore() < TOTAL_MOLES) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter row number: ");
            System.out.println();
            r = scanner.nextInt();
            System.out.print("Enter column number: ");
            System.out.println();
            c = scanner.nextInt();
            if (r == -1 && c == -1) {
                System.out.println("Good bye! ");
                System.out.println();
                whackAMole.printGrid();
                break;
            }
            whackAMole.whack(r, c);
            whackAMole.printGridToUser();
            System.out.println("Remaining attempts: " + whackAMole.getAttemptsLeft());
            System.out.println("Remaining moles:  " + whackAMole.getMolesLeft());
            System.out.println("Score:  " + whackAMole.getScore());
            System.out.println();
        }
        if (whackAMole.getScore() == TOTAL_MOLES) {
            System.out.println("You won! ");
        }
        if (whackAMole.getAttemptsLeft() == 0) {
            System.out.println("You lost! ");
            System.out.println();
            whackAMole.printGrid();
        }

    }

}
