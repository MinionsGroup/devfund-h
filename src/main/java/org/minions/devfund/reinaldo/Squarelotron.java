package org.minions.devfund.reinaldo;

/**
 * Created by reinaldo on 19-07-18.
 */
public class Squarelotron {

    private static final int LIMITROTATIONFORMATRIX = 4;
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
        int value = 1;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                squarelotronGame[i][j] = value++;
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
        for (int row = 0; row < size; row++) {
            swapFirstAndLastColumns(squarelotronCopy, ring - 1, size - ring, row);
        }
        return squarelotronCopy;
    }

    /**
     * Methods that swap the position for first and last columns.
     * @param squarelotronCopy squarelotroncopy.
     * @param first row.
     * @param last row.
     * @param row currencyRow.
     */
    private void swapFirstAndLastColumns(final Squarelotron squarelotronCopy, int first,
                                        int last, int row) {
        for (int column = 0; column < size; column++) {
            if (verifyThecolumnsInTheMatrix(row, column, first, last)) {
                squarelotronCopy.squarelotronGame[row][column] = squarelotronGame[size - 1 - row][column];
            }
        }
    }

    /**
     *
     * @param row position on the matrix.
     * @param column position on the matrix.
     * @param first row.
     * @param last row.
     * @return boolean.
     */
    public boolean verifyThecolumnsInTheMatrix(int row, int column, int first, int last) {

        boolean firsAndLastColumn = (row == first || row == last) && column >= first && column <= last;
        boolean diferentThatFirstAndLastColmun = row > first && row < last && (column == first || column == last);
      return firsAndLastColumn || diferentThatFirstAndLastColmun;
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
        numberOfTurns = numberOfTurns % LIMITROTATIONFORMATRIX;
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
        squarelotronGame = squarelotronClone;
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
        squarelotronGame = squarelotronClone;
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
