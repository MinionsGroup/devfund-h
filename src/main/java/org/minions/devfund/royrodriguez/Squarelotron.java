package org.minions.devfund.royrodriguez;

import java.util.Arrays;

/**
 * Squarelotron class.
 */
public class Squarelotron {
    private final int[][] squarelotron;
    private int size;

    /**
     * Squarelotron constructor.
     *
     * @param n matrix's size.
     */
    public Squarelotron(int n) {
        this.size = n;
        this.squarelotron = new int[n][n];
        initialize(squarelotron);
    }

    /**
     * Gets squarelotron matrix.
     *
     * @return matrix.
     */
    public int[][] getSquarelotron() {
        return deepCopy(squarelotron);
    }

    /**
     * Squarelotron constructor to replace matrix.
     *
     * @param matrix new matrix.
     * @param size   size of the new matrix.
     */
    public Squarelotron(final int[][] matrix, int size) {
        this.size = size;
        this.squarelotron = deepCopy(matrix);
    }

    /**
     * Deep copy of the matrix.
     *
     * @param original original matrix.
     * @return new matrix.
     */
    private int[][] deepCopy(final int[][] original) {
        final int[][] result = new int[original.length][];
        for (int i = 0; i < original.length; i++) {
            result[i] = Arrays.copyOf(original[i], original[i].length);
        }
        return result;
    }

    /**
     * Initializes the squarelotron matrix.
     *
     * @param matrix matrix to initialize.
     */
    private void initialize(final int[][] matrix) {
        int value = 1;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                matrix[row][col] = value;
                value++;
            }
        }
    }

    /**
     * Determines if the position belongs to the ring.
     *
     * @param ring number of the ring.
     * @param x    position.
     * @param y    position.
     * @return true if the position belongs to the ring, false otherwise.
     */
    public boolean belongsToTheRing(int ring, int x, int y) {
        if (belongsToTheMatrix(ring, x, y)
                && !belongsToTheRing(ring - 1, x, y)
                && (x == ring
                || y == ring
                || y == ring + size - odd(ring))) {
            return true;
        }
        return false;
    }

    /**
     * Verifies if the values belongs the matrix.
     * @param ring number.
     * @param x position.
     * @param y position.
     * @return true if belongs the matrix.
     */
    public boolean belongsToTheMatrix(int ring, int x, int y) {
        return x < size + 1 && y < size + 1 && ring > 0;
    }

    /**
     * Determines the n odd.
     *
     * @param n number of odd.
     * @return the n-odd.
     */
    public int odd(int n) {
        return 2 * n - 1;
    }

    /**
     * Flips rows of a ring.
     *
     * @param ring number of the ring
     * @return new Squarelotron with the result as a matrix.
     */
    public Squarelotron upsideDownFlip(int ring) {
        int[][] matrix = deepCopy(squarelotron);
        for (int row = 0; row < matrix.length / 2; row++) {
            for (int col = 0; col < matrix.length; col++) {
                if (belongsToTheRing(ring, row + 1, col + 1)) {
                    flip(row, col, matrix, matrix.length);
                }
            }
        }
        return new Squarelotron(matrix, matrix.length);
    }

    /**
     * Flips values.
     *
     * @param row        number of row.
     * @param col        number of column.
     * @param matrix     matrix to flip.
     * @param matrixSize size of the matrix.
     */
    private void flip(int row, int col, final int[][] matrix, int matrixSize) {
        int fRow = row + matrixSize - odd(row) - 2;
        int aux = matrix[row][col];
        matrix[row][col] = matrix[fRow][col];
        matrix[fRow][col] = aux;
    }

    /**
     * Flips around a main diagonal.
     *
     * @param ring number of the ring.
     * @return Squarelotron with the result as its matrix.
     */
    public Squarelotron mainDiagonalFlip(int ring) {
        int[][] matrix = deepCopy(squarelotron);
        int aux;
        for (int col = ring - 1; col <= matrix.length - ring; col++) {
            aux = matrix[ring - 1][col];
            matrix[ring - 1][col] = matrix[col][ring - 1];
            matrix[col][ring - 1] = aux;
        }
        if (ring < maxRings(size)) {
            int rowLimit = matrix.length % 2 == 1 ? matrix.length - 1 : matrix.length - ring;
            for (int row = ring; row < rowLimit; row++) {
                aux = matrix[row][matrix.length - ring];
                matrix[row][matrix.length - ring] = matrix[matrix.length - ring][row];
                matrix[matrix.length - ring][row] = aux;
            }
        }
        return new Squarelotron(matrix, matrix.length);
    }

    /**
     * Rotates the matrix to the right.
     *
     * @param numberOfTurns number of rotations.
     */
    public void rotateRight(int numberOfTurns) {
        final int sides = 4;
        if (numberOfTurns < 0) {
            numberOfTurns = (numberOfTurns / sides) < -1 ? numberOfTurns % sides + sides : numberOfTurns + sides;
        }
        while (numberOfTurns > 0) {
            int[][] copy = deepCopy(squarelotron);
            int rowIndex = squarelotron.length - 1;
            int indexAux = 0;
            while (rowIndex >= 0) {
                int[] aux = copy[rowIndex];

                for (int index = 0; index < copy.length; index++) {
                    squarelotron[index][indexAux] = aux[index];
                }
                indexAux++;
                rowIndex--;
            }
            numberOfTurns--;
        }
    }

    /**
     * Returns the max rings for a matrix.
     *
     * @param size of the matrix.
     * @return max possible rings.
     */
    private int maxRings(int size) {
        return size % 2 == 0 ? size / 2 : (size / 2) + 1;
    }
}
