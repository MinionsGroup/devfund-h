package org.minions.devfund.abel;

import java.util.Arrays;

/**
 * Class Squarelotron consists basically of a matrix of numbers.
 */
public class Squarelotron {


    private static final int MAX_ROTATIONS = 4;
    private int[][] squarelotronMatrix;
    private int size;

    /**
     * Constructor to fill a normal Squarelotron.
     *
     * @param size size of the Squarelotron matrix.
     */
    public Squarelotron(int size) {
        squarelotronMatrix = new int[size][size];
        int number = 1;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                squarelotronMatrix[i][j] = number;
                number++;
            }
        }
        this.size = size;
    }

    /**
     * Constructor to assign values to the Squarelotron.
     *
     * @param squarelotron value assigned to the Squarelotron matrix.
     */
    public Squarelotron(final int[][] squarelotron) {
        this.squarelotronMatrix = deepCopy(squarelotron);
        this.size = this.squarelotronMatrix.length;
    }

    /**
     * Get the Squarelotron.
     *
     * @return The Squarelotron.
     */
    public int[][] getSquarelotronMatrix() {
        return deepCopy(squarelotronMatrix);
    }

    /**
     * This method performs the Upside-Down Flip of the squarelotronMatrix, as described above,
     * and returns the new squarelotronMatrix.
     *
     * @param ring The ring to be modified.
     * @return A new Squarelotron object.
     */
    public Squarelotron upsideDownFlip(int ring) {
        Function<int[][], Boolean, Integer, Integer, Integer> upsideDown = (tArray, condition, row, col) ->
                condition ? tArray[size - row - 1][col] : tArray[row][col];
        return new Squarelotron(flip(ring, squarelotronMatrix, upsideDown));
    }

    /**
     * This method performs the Main Diagonal Flip of the squarelotronMatrix, as described above,
     * and returns the new squarelotronMatrix.
     *
     * @param ring The ring to be modified.
     * @return A new Squarelotron object.
     */
    public Squarelotron mainDiagonalFlip(int ring) {
        Function<int[][], Boolean, Integer, Integer, Integer> mainDiagonal = (tArray, condition, row, col) ->
                condition ? tArray[col][row] : tArray[row][col];
        return new Squarelotron(flip(ring, squarelotronMatrix, mainDiagonal));
    }

    /**
     * Method to flip based on a Function.
     *
     * @param ring The ring to be modified.
     * @param ints The 2dArray to be modified.
     * @param fn   The lambda function to execute.
     * @return 2d array flipped.
     */
    private int[][] flip(int ring, final int[][] ints, final Function<int[][], Boolean, Integer, Integer, Integer> fn) {
        int[][] copy = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                copy[i][j] = fn.apply(ints, isInRing(ring, i, j), i, j);
            }
        }
        return copy;
    }


    /**
     * Custom Functional interface.
     *
     * @param <T1> The first parameter, the array to be modified.
     * @param <T2> The second parameter, the boolean condition.
     * @param <T3> The third parameter, the row position.
     * @param <T4> The fourth parameter, the col position.
     * @param <R>  The result response.
     */
    @FunctionalInterface
    interface Function<T1, T2, T3, T4, R> {
        /**
         * Method to execute the function.
         *
         * @param tArray     First parameter.
         * @param tCondition Second parameter.
         * @param tRow       Third parameter.
         * @param tCol       Fourth parameter.
         * @return The response type.
         */
        R apply(T1 tArray, T2 tCondition, T3 tRow, T4 tCol);
    }

    /**
     * The argument numberOfTurns indicates the number of times the entire squarelotronMatrix
     * should be rotated 90° clockwise.
     * Any integer, including zero and negative integers, is allowable as the argument.
     * A value of -1 indicates a 90° counterclockwise rotation.
     *
     * @param numberOfTurns The times to rotate.
     */
    public void rotateRight(int numberOfTurns) {
        for (int x = 0; x < Math.abs(numberOfTurns) % MAX_ROTATIONS; x++) {
            squarelotronMatrix = rotate(numberOfTurns);
        }
    }

    /**
     * Rotate the squarelotronMatrix 2d array.
     *
     * @param numberOfTurns Numbers of rotations.
     * @return a rotated 2d int array.
     */
    private int[][] rotate(int numberOfTurns) {
        int[][] cloned = deepCopy(squarelotronMatrix);
        int[][] copy = new int[size][size];
        Function<int[][], Boolean, Integer, Integer, Integer> right = (tArray, condition, row, col) ->
                condition ? tArray[size - 1 - col][row] : tArray[col][size - 1 - row];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                copy[i][j] = right.apply(cloned, numberOfTurns > 0, i, j);
            }
        }
        return copy;
    }

    /**
     * Creates a deep copy of the squarelotronMatrix matrix.
     *
     * @param original The original 2d array.
     * @return a Deep Copy of the 2d array.
     */
    private static int[][] deepCopy(final int[][] original) {
        if (original == null) {
            return new int[][]{};
        }

        final int[][] result = new int[original.length][];
        for (int i = 0; i < original.length; i++) {
            result[i] = Arrays.copyOf(original[i], original[i].length);
        }
        return result;
    }

    /**
     * Check the current value is in the Ring to be flipped.
     *
     * @param ring The ring to be checked.
     * @param row  The current row position.
     * @param col  The current col position.
     * @return True if is inside the Ring, false otherwise.
     */
    private boolean isInRing(int ring, int row, int col) {
        int min = ring - 1;
        int max = size - ring;
        boolean inRow = row == min || row == max;
        boolean inCol = col == min || col == max;
        boolean rowInRange = min <= row && row <= max;
        boolean colInRange = min <= col && col <= max;
        return inRow && colInRange || inCol && rowInRange;
    }
}
