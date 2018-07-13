package org.minions.devfund.abel;

import java.util.Random;
import java.util.Scanner;

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
        for (int i = 0; i < gridDimension; i++) {
            for (int j = 0; j < gridDimension; j++) {
                this.moleGrid[i][j] = EMPTY_MOLE;
            }
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
        if (isValidPosition(row, col, EMPTY_MOLE)) {
            this.moleGrid[row][col] = MOLE;
            this.molesLeft++;
            return true;
        } else {
            return false;
        }
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
        if (isValidPosition(row, col, MOLE)) {
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
     * @param output char value to verify.
     * @return if the position is valid.
     */
    private boolean isValidPosition(int row, int col, char output) {
        int size = this.moleGrid.length;
        boolean checkRow = ZERO <= row && row < size;
        boolean checkCol = ZERO <= col && col < size;
        return checkRow && checkCol && output == this.moleGrid[row][col];
    }

    /**
     * Print the grid without showing where the moles are.
     * For every spot that has recorded a “whacked mole,” print out a W, or * otherwise.
     *
     * @return the grid completely without moles.
     */
    public String printGridToUser() {
        int length = this.moleGrid.length;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                stringBuilder.append(this.moleGrid[i][j] == MOLE ? EMPTY_MOLE : this.moleGrid[i][j]);
            }
            stringBuilder.append(System.lineSeparator());
        }
        return stringBuilder.toString();
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
        int length = this.moleGrid.length;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                stringBuilder.append(this.moleGrid[i][j]);
            }
            stringBuilder.append(System.lineSeparator());
        }
        return stringBuilder.toString();
    }

    /**
     * The psvm method.
     *
     * @param args Args.
     */
    public static void main(final String[] args) {
        final int numAttempts = 50;
        final int gridDimension = 10;
        final int totalMoles = 10;
        final int givingUp = -1;
        WhackAMole whackAMole = new WhackAMole(numAttempts, gridDimension);
        Random random = new Random();
        do {
            int row = random.nextInt(gridDimension);
            int col = random.nextInt(gridDimension);
            whackAMole.place(row, col);
        } while (whackAMole.molesLeft < totalMoles);
        while (whackAMole.attemptsLeft > 0) {
            System.out.println(String.format("You have %d attempts left.", numAttempts));
            System.out.println(whackAMole.printGridToUser());
            Scanner scanner = new Scanner(System.in, "UTF-8");
            System.out.print("Row: ");
            int row = scanner.nextInt();
            System.out.print("Col: ");
            int col = scanner.nextInt();
            whackAMole.whack(row, col);
            if (row == givingUp && col == givingUp) {
                break;
            }
        }
        System.out.println(whackAMole.printGrid());
    }
}
