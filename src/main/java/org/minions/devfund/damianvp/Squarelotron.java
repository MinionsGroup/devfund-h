package org.minions.devfund.damianvp;

/**
 * Squalerotron class.
 */
public class Squarelotron {
    private int[][] squarelotron;
    private int size;
    private static final int MODULE_NUMBER = 4;

    /**
     * Squalerotron constructor.
     * @param n size of the squarelotron matrix.
     */
    Squarelotron(int n) {
        this.size = n;
        this.squarelotron = loadIntegerMatrix();
    }

    /**
     * Method to return the squarelotron size.
     * @return size of squarelotron.
     */
    int getSize() {
        return this.size;
    }

    /**
     * Method to get the squarelotron matrix.
     * @return squarelotron matrix.
     */
    int[][] getSquarelotron() {
        return this.squarelotron;
    }

    /**
     * Method to load with consecutives numbers (1,2,3,4...) the squarelotron matrix of class.
     * @return a matrix loadod with consecutives numbers.
     */
    int[][] loadIntegerMatrix() {
        int[][] matrix = new  int[this.size][this.size];
        for (int i = 0; i < this.size; i++) {
            for (int j = 0; j < this.size; j++) {
                matrix[i][j] = this.size * i + j + 1;
            }
        }
        return matrix;
    }

    /**
     * This method performs the Upside-Down Flip of the squarelotron.
     * @param ring  squarelotron ring number to perform the Upside-Down Flip.
     * @return  a new squarelotron with Upside-Down Flip performed.
     */
    Squarelotron upsideDownFlip(int ring) {
        Squarelotron newSquarelotron = new  Squarelotron(this.size);
        int horizontalLimit = ring - 1;
        int verticalLimit = this.size - ring;
        for (int x = horizontalLimit; x <= verticalLimit; x++) {
            for (int y = horizontalLimit; y <= verticalLimit; y++) {
                if (isInRing(horizontalLimit, verticalLimit, x, y)) {
                    newSquarelotron.squarelotron[(this.size - 1) - x][y] = this.squarelotron[x][y];
                }
            }
        }
        return newSquarelotron;
    }

    /**
     * Is in ring.
     * @param horizontalLimit horizontalLimit
     * @param verticalLimit verticalLimit
     * @param x current x position.
     * @param y current y position.
     * @return if the position is in a ring.
     */
    private boolean isInRing(int horizontalLimit, int verticalLimit, int x, int y) {
        return x == horizontalLimit || y == horizontalLimit || x == verticalLimit || y == verticalLimit;
    }

    /**
     * This method performs the Main Diagonal Flip of the squarelotron.
     * @param ring  squarelotron ring number to perform the Main Diagonal Flip.
     * @return  a new squarelotron with Main Diagonal Flip performed.
     */
    Squarelotron mainDiagonalFlip(int ring) {
        Squarelotron newSquarelotron = new  Squarelotron(this.size);
        int horizontalLimit = ring - 1;
        int verticalLimit = this.size - ring;
        for (int x = horizontalLimit; x <= verticalLimit; x++) {
            for (int y = horizontalLimit; y <= verticalLimit; y++) {
                if (isInRing(horizontalLimit, verticalLimit, x, y)) {
                    newSquarelotron.squarelotron[x][y] = this.squarelotron[y][x];
                }
            }
        }
        return newSquarelotron;
    }

    /**
     * This method performs the rotate 90° clockwise.
     * @param numberOfTurns   indicates the number of times the entire squarelotron should be rotate.
     */
    void rotateRight(int numberOfTurns) {
        numberOfTurns = (numberOfTurns % MODULE_NUMBER + MODULE_NUMBER) % MODULE_NUMBER;

        while (numberOfTurns > 0) {
            int[][] matrixHelper = copyCurrentSquareletron();
            for (int x = 0; x < size; x++) {
                for (int y = 0; y < size; y++) {
                    matrixHelper[y][(size - 1) - x] = this.squarelotron[x][y];
                }
            }
            this.squarelotron = matrixHelper;
            numberOfTurns--;
        }
    }

    /**
     * This method copies the current squarelotron of class to anoter matrix.
     * @return  a new matrix exactly to squarelotron of class
     */

    int[][] copyCurrentSquareletron() {
        int[][] newSquarelotron = new int[this.size][this.size];
        for (int i = 0; i < this.squarelotron.length; i++) {
            for (int j = 0; j < this.squarelotron.length; j++) {
                newSquarelotron[i][j] = this.squarelotron[i][j];
            }
        }
        return newSquarelotron;
    }
}
