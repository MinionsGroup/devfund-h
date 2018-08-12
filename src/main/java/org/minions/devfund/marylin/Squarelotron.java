package org.minions.devfund.marylin;

/**
 * Squarelotron class.
 */
public class Squarelotron {
    private int[][] squarelotron;
    private int size;
    private int numberOfRings;

    /**
     * Squarelotron constructor.
     *
     * @param n size of the Squarelotron.
     */
    public Squarelotron(int n) {
        this.size = n;
        this.numberOfRings = this.size - (this.size / 2);
        this.squarelotron = new int[n][n];
        int number = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                this.squarelotron[i][j] = number;
                number++;
            }
        }
    }

    /**
     * Gets the Squarelotron grid.
     *
     * @return the Squarelotron grid.
     */
    public int[][] getSquarelotron() {
        return squarelotron.clone();
    }

    /**
     * Method to duplicate a grid.
     *
     * @param original original grid.
     * @return returns the new grid.
     */
    private int[][] duplicateGrid(final int[][] original) {
        int[][] backupGrid = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                backupGrid[i][j] = original[i][j];
            }
        }
        return backupGrid;
    }

    /**
     * upsideDownFlipCompleteMatrix without check rings.
     *
     * @param matrix array.
     * @return the matrix that is upside down flip completely.
     */
    int[][] upsideDownFlipCompleteMatrix(final int[][] matrix) {
        int[][] resultGrid = duplicateGrid(matrix);
        int temp = 0;
        for (int i = this.size - 1; i >= this.size / 2; i--) {
            for (int j = 0; j < this.size; j++) {
                resultGrid[i][j] = matrix[temp][j];
                resultGrid[temp][j] = matrix[i][j];
            }
            temp++;
        }
        return resultGrid;
    }

    /**
     * upsideDownFlipInternalMatrix of rings different to ring #1.
     *
     * @param matrix to be upside down flip the internal matrix.
     * @return the matrix result-
     */
    int[][] upsideDownFlipInternalMatrix(final int[][] matrix) {
        int[][] resultGrid = duplicateGrid(matrix);
        int temp = 1;
        for (int i = this.size - 2; i >= this.size / 2; i--) {
            for (int j = 1; j < this.size - 1; j++) {
                resultGrid[i][j] = matrix[temp][j];
                resultGrid[temp][j] = matrix[i][j];
            }
            temp++;
        }
        return resultGrid;
    }


    /**
     * Upside Down Flip.
     *
     * @param ring number.
     * @return an instance of Squarelotron.
     */
    Squarelotron upsideDownFlip(int ring) {
        Squarelotron squarelotronResult = new Squarelotron(this.size);
        squarelotronResult.squarelotron = upsideDownFlipHelper(ring, squarelotronResult.squarelotron);
        return squarelotronResult;
    }

    /**
     * upsideDownFlipHelper.
     *
     * @param ring ring number.
     * @param squarelotron matrix.
     * @return a grid.
     */
    private int[][] upsideDownFlipHelper(int ring, final int[][] squarelotron) {

        //Returns the same squarelotron if the ring number is equal to the number of rings of a matrix n x n.
        if (Math.abs(this.size) % 2 == 1 && ring == this.numberOfRings) {
            return squarelotron;
        }
        //If the ring is the internal rings.
        if (ring != 1) {
            return upsideDownFlipInternalMatrix(squarelotron);
        }
        //complete Upside Down Flip.
        int[][] resultGrid = upsideDownFlipCompleteMatrix(squarelotron);

        // Restore values of the internal rings if there are.
        for (int i = 1; i < size - 1; i++) {
            for (int j = 1; j < size - 1; j++) {
                resultGrid[i][j] = squarelotron[i][j];
            }
        }
        return resultGrid;
    }


    /**
     * flipExternalRing grid.
     *
     * @param matrix grid.
     * @return a grid.
     */
    private int[][] flipExternalRing(final int[][] matrix) {
        int[][] resultGrid = duplicateGrid(matrix);
        int tempJ = 0;
        for (int i = 1; i < this.size; i++) {
            resultGrid[i][tempJ] = matrix[tempJ][i];
            resultGrid[tempJ][i] = matrix[i][tempJ];
        }

        int tempI = this.size - 1;
        for (int j = 1; j < this.size - 1; j++) {
            resultGrid[tempI][j] = matrix[j][tempI];
            resultGrid[j][tempI] = matrix[tempI][j];
        }
        return resultGrid;
    }

    /**
     * flipInternalRing a grid.
     *
     * @param matrix grid.
     * @return a grid.
     */
    private int[][] flipInternalRing(final int[][] matrix) {
        int[][] resultGrid = duplicateGrid(matrix);
        int tempJ = 1;
        for (int i = 2; i < size - 1; i++) {
            resultGrid[i][tempJ] = matrix[tempJ][i];
            resultGrid[tempJ][i] = matrix[i][tempJ];
        }

        int tempI = size - 2;
        for (int j = 2; j <= size - 2; j++) {
            resultGrid[tempI][j] = matrix[j][tempI];
            resultGrid[j][tempI] = matrix[tempI][j];
        }
        return resultGrid;
    }

    /**
     * mainDiagonalFlip.
     *
     * @param ring ring number.
     * @return a Squarelotron.
     */
    Squarelotron mainDiagonalFlip(int ring) {
        Squarelotron squarelotronResult = new Squarelotron(this.size);
        squarelotronResult.squarelotron = mainDiagonalFlipHelper(ring, squarelotronResult.squarelotron);
        return squarelotronResult;
    }

    /**
     * mainDiagonalFlipHelper.
     *
     * @param ring ring number.
     * @param squarelotron matrix.
     * @return a grid.
     */
    private int[][] mainDiagonalFlipHelper(int ring, final int[][] squarelotron) {
        // returns the same squarelotron if the ring number is equal to the number of rings.
        if (Math.abs(this.size) % 2 == 1 && ring == this.numberOfRings) {
            return squarelotron;
        }
        return ring != 1 ? flipInternalRing(squarelotron) : flipExternalRing(squarelotron);
    }

    /**
     * rotateEast.
     *
     * @param numberOfTurns number of turns.
     */
    private void rotateEast(int numberOfTurns) {
        while (numberOfTurns-- > 0) {
            for (int i = 1; i <= numberOfRings; i++) {
                squarelotron = upsideDownFlipHelper(i, squarelotron);
                squarelotron = mainDiagonalFlipHelper(i, squarelotron);
            }
        }
    }

    /**
     * rotateWest.
     *
     * @param numberOfTurns number of turns.
     */
    private void rotateWest(int numberOfTurns) {
        while (numberOfTurns++ < 0) {
            for (int i = 1; i <= numberOfRings; i++) {
                squarelotron = mainDiagonalFlipHelper(i, squarelotron);
                squarelotron = upsideDownFlipHelper(i, squarelotron);
            }
        }
    }

    /**
     * rotateRight.
     *
     * @param numberOfTurns number of turns.
     */
    void rotateRight(int numberOfTurns) {
        final int maxNumberOfTurns = 4;
        int totalTurns = numberOfTurns % maxNumberOfTurns;
        if (totalTurns >= 0) {
            rotateEast(numberOfTurns);
            return;
        }
        rotateWest(numberOfTurns);
    }
}
