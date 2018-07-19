package org.minions.devfund.danielmontecinos;

import java.util.Arrays;

/**
 * Solution for Squarelotron homework.
 */
public class Squarelotron {
    private static final int MAX_NUMBER_OF_ROTATIONS = 4;
    private int[][] squarelotronMatrix;
    private int size;

    /**
     * Initializes an instance of {@link Squarelotron}.
     *
     * @param n as int.
     */
    public Squarelotron(final int n) {
        size = n;
        squarelotronMatrix = new int[n][n];
        initMatrix();
    }

    /**
     * Makes an upside-down flip.
     *
     * @param ring as int.
     * @return {@link Squarelotron}.
     */
    public Squarelotron upsideDownFlip(final int ring) {
        Squarelotron newSquarelotron = new Squarelotron(size);
        newSquarelotron.setSquarelotronMatrix(replaceNoRingValues(upsideDown(squarelotronMatrix), squarelotronMatrix, ring));
        return newSquarelotron;
    }

    /**
     * Makes a main diagonal flip.
     *
     * @param ring as int.
     * @return {@link Squarelotron}.
     */
    public Squarelotron mainDiagonalFlip(final int ring) {
        Squarelotron newSquarelotron = new Squarelotron(size);
        newSquarelotron.setSquarelotronMatrix(replaceNoRingValues(transposeMatrix(squarelotronMatrix), squarelotronMatrix, ring));
        return newSquarelotron;
    }

    /**
     * Rotates squarelotronMatrix.
     *
     * @param numberOfRotations as int.
     */
    public void rotateRight(final int numberOfRotations) {
        int rotations = numberOfRotations % MAX_NUMBER_OF_ROTATIONS;
        if (rotations >= 0) {
            rotateClockwise(rotations);
        } else {
            rotateAntiClockwise(rotations);
        }
    }

    /**
     * Gets squarelotronMatrix instance.
     *
     * @return squarelotronMatrix.
     */
    public int[][] getSquarelotronMatrix() {
        return Arrays.copyOf(squarelotronMatrix, size);
    }

    /**
     * Sets squarelotronMatrix matrix.
     *
     * @param squarelotronMatrix as an Array on ints.
     */
    public void setSquarelotronMatrix(final int[][] squarelotronMatrix) {
        this.squarelotronMatrix = squarelotronMatrix.clone();
    }

    /**
     * FIlls array with values from 1 to n.
     */
    private void initMatrix() {
        int value = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                squarelotronMatrix[i][j] = ++value;
            }
        }
    }

    /**
     * Checks if element is on the ring.
     *
     * @param ring as int.
     * @param i    as int.
     * @param j    as int.
     * @return true if element is on the ring, false otherwise.
     */
    private boolean isInRing(final int ring, final int i, final int j) {
        int lowerRingLimit = ring - 1;
        int upperRingLimit = size - ring;
        int innerLowerRingLimit = lowerRingLimit - 1;
        int innerUpperRingLimit = upperRingLimit + 1;

        boolean isOnOuterRing = i == lowerRingLimit || i == upperRingLimit
                || j == lowerRingLimit || j == upperRingLimit;

        boolean isNotOnInnerRing = !(i <= innerLowerRingLimit || i >= innerUpperRingLimit
                || j <= innerLowerRingLimit || j >= innerUpperRingLimit);

        return isOnOuterRing && isNotOnInnerRing;
    }

    /**
     * Replaces values that are not part of the ring.
     *
     * @param modifiedMatrix as an Array of ints.
     * @param originalMatrix as an Array of ints.
     * @param ring           as int.
     * @return an Array with replaced values.
     */
    private int[][] replaceNoRingValues(final int[][] modifiedMatrix, final int[][] originalMatrix, final int ring) {
        int[][] replacedMatrix = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                replacedMatrix[i][j] = isInRing(ring, i, j) ? modifiedMatrix[i][j] : originalMatrix[i][j];
            }
        }
        return replacedMatrix;
    }

    /**
     * Transpose a matrix.
     *
     * @param matrix as Array on ints.
     * @return a transposed matrix.
     */
    private int[][] transposeMatrix(final int[][] matrix) {
        int[][] transposedMatrix = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                transposedMatrix[i][j] = matrix[j][i];
            }
        }
        return transposedMatrix;
    }

    /**
     * Upside down matrix values.
     *
     * @param originalMatrix as an Array of ints.
     * @return a modified matrix.
     */
    private int[][] upsideDown(final int[][] originalMatrix) {
        int[][] modifiedMatrix = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = size - 1; j >= 0; j--) {
                modifiedMatrix[originalMatrix.length - 1 - j][i] = originalMatrix[j][i];
            }
        }

        return modifiedMatrix;
    }

    /**
     * Rotates matrix in anticlockwise.
     *
     * @param numberOfRotations as int.
     */
    private void rotateAntiClockwise(final int numberOfRotations) {
        int rotations = numberOfRotations;
        int[][] matrix = new int[size][size];
        while (rotations++ < 0) {
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    matrix[size - 1 - i][j] = squarelotronMatrix[j][i];
                }
            }
            squarelotronMatrix = matrix;
            matrix = new int[size][size];
        }
    }

    /**
     * Rotates matrix in clockwise.
     *
     * @param numberOfRotations as int.
     */
    private void rotateClockwise(final int numberOfRotations) {
        int rotations = numberOfRotations;
        int[][] matrix = rotations == 0 ? getSquarelotronMatrix() : new int[size][size];
        while (rotations-- > 0) {
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    matrix[j][size - 1 - i] = squarelotronMatrix[i][j];
                }
            }
            squarelotronMatrix = matrix;
            matrix = new int[size][size];
        }
    }
}
