package org.minions.devfund.benjamin;
import java.util.Arrays;
/**
 * Class Squarelotron refers to a matrix.
 */
public class Squarelotron {
    private int[][] squarelotron;
    private int size;
    private static final int MAX_ROTATIONS = 4;

    /**
     * Squarelotron constructor, fill the object.
     * @param size squarelotron dimension.
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
        this.squarelotron = copyMatrix(squarelotron);
        this.size = this.squarelotron.length;
    }

    /**
     * Horizontal flip of ring elements.
     * @param ring number of ring to be flipped.
     * @return squarelotron object.
     */
    public Squarelotron upsideDownFlip(int ring) {
        return new Squarelotron(verticalFlip(copyMatrix(squarelotron), ring));
    }

    /**
     * Transpone ring elements.
     * @param ring number of ring to be modified.
     * @return squarelotron object.
     */
    public Squarelotron mainDiagonalFlip(int ring) {
        return new Squarelotron(getTransponedMatrix(ring));
    }

    /**
     * Rotate original squarelotron.
     * @param numberOfTurns number of 90 degrees rotation.
     */
    public void rotateRight(int numberOfTurns) {
        if (numberOfTurns >= 0) {
            for (int x = 0; x < numberOfTurns % MAX_ROTATIONS; x++) {
                int[][] transponedMatrix = getTransponedMatrix();
                squarelotron = horizontalFlip(transponedMatrix);
            }
        } else {
            for (int x = 0; x < Math.abs(numberOfTurns) % MAX_ROTATIONS; x++) {
                int[][] transponedMatrix = getTransponedMatrix();
                squarelotron = verticalFlip(transponedMatrix);
            }
        }
    }

    /**
     * Get current status of the squarelotron object.
     * @return 2D array.
     */
    public int[][] currentStatus() {
        return copyMatrix(squarelotron);
    }

    /**
     * Copy of original squarelotron.
     * @param origin object to be copied.
     * @return 2D array.
     */
    public int[][] copyMatrix(final int[][] origin) {
        if (origin == null) {
            return new int[][]{};
        } else {
            final int[][] copyMat = new int[origin.length][];
            for (int i = 0; i < origin.length; i++) {
                copyMat[i] = Arrays.copyOf(origin[i], origin[i].length);
            }
            return copyMat;
        }
    }

    /**
     * Verify if an element belongs to an specific ring.
     * @param ring specific ring.
     * @param row line number.
     * @param col column number.
     * @return false if the element does not belog to the ring, eoc true.
     */
    private boolean isRingElement(int ring, int row, int col) {
        int min = ring - 1;
        int max = size - ring;
        boolean inRow = row == min || row == max;
        boolean inCol = col == min || col == max;
        boolean rowInRange = min <= row && row <= max;
        boolean colInRange = min <= col && col <= max;
        return inRow && colInRange || inCol && rowInRange;
    }

    /**
     * Horizontal flip within a 2D array.
     * @param matrix object to be flipped.
     * @return 2D array.
     */
    private int[][] horizontalFlip(final int[][] matrix) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][size - j - 1];
                matrix[i][size - j - 1] = temp;
            }
        }
        return matrix;
    }

    /**
     * Vertical flip.
     * @param matrix object to be flipped.
     * @return 2D array.
     */
    private int[][] verticalFlip(final int[][] matrix) {
        for (int j = 0; j < size; j++) {
            for (int i = 0; i <= size / 2; i++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[size - i - 1][j];
                matrix[size - i - 1][j] = temp;
            }
        }
        return matrix;
    }

    /**
     * Vertical flip of an specific ring.
     * @param matrix object to be modified.
     * @param ring an specific ring.
     * @return 2D Array.
     */
    private int[][] verticalFlip(final int[][] matrix, int ring) {
        for (int j = 0; j < size; j++) {
            for (int i = 0; i <= (size - 1) / 2; i++) {
                if (isRingElement(ring, i, j)) {
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[size - i - 1][j];
                    matrix[size - i - 1][j] = temp;
                }
            }
        }
        return matrix;
    }

    /**
     * Transpone a 2D array.
     * @return 2D array.
     */
    private int[][] getTransponedMatrix() {
        int[][] copy = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                copy[i][j] = squarelotron[j][i];
            }
        }
        return copy;
    }

    /**
     * Traspone only elements in an specific ring.
     * @param ring an specific ring.
     * @return 2D Array.
     */
    private int[][] getTransponedMatrix(int ring) {
        int[][] copy = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
               copy[i][j] = isRingElement(ring, i, j) ? squarelotron[j][i] : squarelotron[i][j];
            }
        }
        return copy;
    }
}
