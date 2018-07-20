package org.minions.devfund.reinaldo;

/**
 * Created by reinaldo on 19-07-18.
 */
public class Squarelotron {

    private int[][] squarelotronGame;
    private int size;

    /**
     * Constructor for the squarelotron.
     * @param size the dimension for matriz.
     */
    public Squarelotron(int size) {
        this.size = size;
        squarelotronGame = new int[size][size];
        fillSquarelotron(size);
    }

    /**
     * Methods for to fill the squarelotron game.
     * @param size the dimension for matriz
     */
    private void fillSquarelotron(int size) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                squarelotronGame[i][j] = size * i + j + 1;
            }
        }
    }

    /**
     * Methods that changes the position of upside down flip .
     * @param ring rotation.
     * @return squarelotron object.
     */
    public Squarelotron upsideDownFlip(int ring) {
        Squarelotron squarelotronCopy = new Squarelotron(size);
        int sizeMatrix = size - 1;
        for (int i = 0; i <= sizeMatrix; i++) {
            swapFirstAndLastColumns(squarelotronCopy, ring - 1, size - ring, i, sizeMatrix);
        }
        return squarelotronCopy;
    }

    /**
     * Methods that swap the position for first and last columns.
     * @param squarelotronCopy squarelotroncopy.
     * @param first firstPosition.
     * @param last lastPosition.
     * @param i currencyRow.
     * @param sizeMatrix size.
     */
    private void swapFirstAndLastColumns(final Squarelotron squarelotronCopy, int first,
                                        int last, int i, int sizeMatrix) {
        for (int j = 0; j <= sizeMatrix; j++) {
            if ((i == first || i == last) && j >= first && j <= last) {
                squarelotronCopy.squarelotronGame[i][j] = squarelotronGame[sizeMatrix - i][j];
            }
            if (i > first && i < last && (j == first || j == last)) {
                squarelotronCopy.squarelotronGame[i][j] = squarelotronGame[sizeMatrix - i][j];
            }

        }
    }

    /**
     * Methods that swap the diagonal right.
     *
     * @param squarelotronCopy matrix copy.
     * @param j                position column.
     * @param ring             move the ring.
     */
    public void moveDiagonalRight(final Squarelotron squarelotronCopy, final int j, final int ring) {
        for (int i = ring - 1; i <= size - ring; i++) {
            swapTheValues(squarelotronCopy, j, i);
        }
    }

    /**
     * methods that swap the diagonal Left.
     *
     * @param squarelotronCopy matrix copy.
     * @param j                position column.
     * @param ring             move the Left.
     */
    public void moveDiagonalLeft(final Squarelotron squarelotronCopy, final int j, final int ring) {
        for (int i = size - ring; i >= ring; i--) {
            swapTheValues(squarelotronCopy, j, i);
        }

    }

    /**
     * Methods that swap the values of format diagonal.
     *
     * @param squarelotronCopy squarelotronCopy.
     * @param j                columns.
     * @param i                rows.
     */
    private void swapTheValues(final Squarelotron squarelotronCopy, int j, int i) {
        if (j != i) {
            squarelotronCopy.squarelotronGame[i][j] = squarelotronGame[j][i];
            squarelotronCopy.squarelotronGame[j][i] = squarelotronGame[i][j];
        }
    }

    /**
     * Diagonals Flip of the squarelotron.
     *
     * @param ring for move.
     * @return squarelotron.
     */
    public Squarelotron mainDiagonalFlip(final int ring) {
        Squarelotron squarelotronCopy = new Squarelotron(size);
        moveDiagonalRight(squarelotronCopy, ring - 1, ring);
        moveDiagonalLeft(squarelotronCopy, size - ring, ring);
        return squarelotronCopy;
    }

    /**
     * Rotates the squarelotron game.
     *
     * @param numberOfTurns Integer that represent the moves number.
     */
    public void rotateRight(int numberOfTurns) {
        while (numberOfTurns != 0) {
            if (numberOfTurns > 0) {
                rotateRightClockWise();
                numberOfTurns--;
            }
            if (numberOfTurns < 0) {
                rotateLeftClockWise();
                numberOfTurns++;
            }
        }
    }

    /**
     * Methods that rotateRightClockWise.
     */
    public void rotateRightClockWise() {

        final int[][] squarelotronClone = new int[size][size];

        for (int i = 0; i < size; ++i) {
            for (int j = 0; j < size; ++j) {
                squarelotronClone[i][j] = squarelotronGame[(size - 1) - j][i];
            }
        }
        squarelotronGame = squarelotronClone.clone();
    }

    /**
     * Methods that rotateLeftClockWise.
     */
    public void rotateLeftClockWise() {

        final int[][] squarelotronClone = new int[size][size];

        for (int i = 0; i < size; ++i) {
            for (int j = 0; j < size; ++j) {
                squarelotronClone[i][j] = squarelotronGame[j][(size - 1) - i];
            }
        }

        squarelotronGame = squarelotronClone.clone();
    }

    /**
     * Gets the new squarelotron clone.
     *
     * @return current squarelotron value.
     */
    public int[][] getSquarelotron() {
        return squarelotronGame.clone();
    }
}
