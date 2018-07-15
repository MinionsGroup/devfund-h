package org.minions.devfund.abel;

import java.util.Arrays;

/**
 * Class Squarelotron consists basically of a matrix of numbers.
 */
public class Squarelotron {


    private int[][] squarelotron;
    private int size;

    /**
     * Constructor to fill a normal Squarelotron.
     *
     * @param size size of the Squarelotron matrix.
     */
    public Squarelotron(int size) {
        squarelotron = new int[size][size];
        int number = 1;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                squarelotron[i][j] = number;
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
        this.squarelotron = deepCopy(squarelotron);
        if (this.squarelotron != null) {
            this.size = squarelotron.length;
        }
    }

    /**
     * Get the Squarelotron.
     *
     * @return The Squarelotron.
     */
    public int[][] getSquarelotron() {
        return deepCopy(squarelotron);
    }

    /**
     * This method performs the Upside-Down Flip of the squarelotron, as described above,
     * and returns the new squarelotron.
     *
     * @param ring The ring to be modified.
     * @return A new Squarelotron object.
     */
    public Squarelotron upsideDownFlip(int ring) {
        Function<Integer, Integer, Integer> upsideDown = (i, j) -> squarelotron[size - i - 1][j];
        return new Squarelotron(flip(ring, upsideDown));
    }

    /**
     * This method performs the Main Diagonal Flip of the squarelotron, as described above,
     * and returns the new squarelotron.
     *
     * @param ring The ring to be modified.
     * @return A new Squarelotron object.
     */
    public Squarelotron mainDiagonalFlip(int ring) {
        Function<Integer, Integer, Integer> upsideDown = (i, j) -> squarelotron[j][i];
        return new Squarelotron(flip(ring, upsideDown));
    }

    /**
     * Method to flip based on a Function.
     *
     * @param ring The ring to be modified.
     * @param fn   The lambda function to execute.
     * @return 2d array flipped.
     */
    private int[][] flip(int ring, final Function<Integer, Integer, Integer> fn) {
        int[][] copy = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (isInRing(ring, i, j)) {
                    copy[i][j] = fn.apply(i, j);
                } else {
                    copy[i][j] = squarelotron[i][j];
                }
            }
        }
        return copy;
    }

    /**
     * Custom Functional interface.
     *
     * @param <One> The first parameter.
     * @param <Two> The second parameter.
     * @param <R>   The result response.
     */
    @FunctionalInterface
    interface Function<One, Two, R> {
        /**
         * Method to execute the function.
         *
         * @param one First parameter.
         * @param two Second parameters.
         * @return The response type.
         */
        R apply(One one, Two two);
    }

    /**
     * The argument numberOfTurns indicates the number of times the entire squarelotron should be rotated 90° clockwise.
     * Any integer, including zero and negative integers, is allowable as the argument.
     * A value of -1 indicates a 90° counterclockwise rotation.
     *
     * @param numberOfTurns The times to rotate.
     */
    public void rotateRight(int numberOfTurns) {
        int[][] copy = new int[size][size];
        for (int x = 0; x < Math.abs(numberOfTurns); x++) {
            int[][] cloned = deepCopy(squarelotron);
            rotate(numberOfTurns, copy, cloned);
            squarelotron = copy;
        }
    }

    /**
     * Rotate the squarelotron 2d array.
     *
     * @param numberOfTurns Numbers of rotations.
     * @param copy          the roteted 2d array.
     * @param cloned        a clone on squarelotron.
     */
    private void rotate(int numberOfTurns, final int[][] copy, final int[][] cloned) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (numberOfTurns > 0) {
                    copy[i][j] = cloned[size - 1 - j][i];
                } else {
                    copy[i][j] = cloned[j][size - 1 - i];
                }
            }
        }
    }

    /**
     * Creates a deep copy of the squarelotron matrix.
     *
     * @param original The original 2d array.
     * @return a Deep Copy of the 2d array.
     */
    private static int[][] deepCopy(final int[][] original) {
        if (original == null) {
            return null;
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
