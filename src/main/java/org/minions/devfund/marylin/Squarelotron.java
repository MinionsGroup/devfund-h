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
     * Constructor of Squarelotron given a grid.
     *
     * @param squarelotron returns a Squarelotron.
     */
    public Squarelotron(final int[][] squarelotron) {
        this.size = squarelotron.length;
        this.numberOfRings = this.size - (this.size / 2);
        this.squarelotron = new int[this.size][this.size];
        for (int i = 0; i < this.size; i++) {
            for (int j = 0; j < this.size; j++) {
                this.squarelotron[i][j] = squarelotron[i][j];
                this.squarelotron[i][j] = squarelotron[i][j];
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
     * Upside down flip the complete matrix.
     *
     * @param matrix grid to be upsideDownFlipCompleteMatrix.
     * @return return the upsideDownFlipCompleteMatrix grid.
     */
    int[][] upsideDownFlipCompleteMatrix(final int[][] matrix) {
        int[][] resultGrid = duplicateGrid(matrix);
        int temp = 0;
        for (int i = size - 1; i >= size / 2; i--) {
            for (int j = 0; j < size; j++) {
                resultGrid[i][j] = matrix[temp][j];
                resultGrid[temp][j] = matrix[i][j];
            }
            temp++;
        }
        return resultGrid;
    }

    /**
     * Upside down flip the internal matrix.
     *
     * @param matrix grid to be upsideDownFlipInternalMatrix.
     * @return return the upsideDownFlipInternalMatrix grid.
     */
    int[][] upsideDownFlipInternalMatrix(final int[][] matrix) {
        int[][] resultGrid = duplicateGrid(matrix);
        int temp = 1;
        for (int i = size - 2; i >= size / 2; i--) {
            for (int j = 1; j < size - 1; j++) {
                resultGrid[i][j] = matrix[temp][j];
                resultGrid[temp][j] = matrix[i][j];
            }
            temp++;
        }
        return resultGrid;
    }


    /**
     * Upside Down Flip given a ring.
     *
     * @param ring ring of the grid.
     * @return the Squarelotron Upside Down Flip.
     */
    Squarelotron upsideDownFlip(int ring) {

        //Returns the same squarelotron if the ring number is equal to the number of rings of a matrix n x n.
        if (Math.abs(size) % 2 == 1 && ring == this.numberOfRings) {
            return this;
        }

        int[][] resultGrid = upsideDownFlipHelper(ring);
        return new Squarelotron(resultGrid);
    }

    /**
     * upsideDownFlipHelper.
     *
     * @param ring ring number.
     * @return a grid.
     */
    private int[][] upsideDownFlipHelper(int ring) {
        int[][] resultGrid;
        //If the ring is the internal rings.
        if (ring != 1) {
            resultGrid = upsideDownFlipInternalMatrix(this.squarelotron);
        } else {
            //complete Upside Down Flip.
            resultGrid = upsideDownFlipCompleteMatrix(this.squarelotron);

            // Restore values of the internal rings if there are.
            for (int i = 1; i < size - 1; i++) {
                for (int j = 1; j < size - 1; j++) {
                    resultGrid[i][j] = this.squarelotron[i][j];
                }
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
        for (int i = 1; i < size; i++) {
            resultGrid[i][tempJ] = matrix[tempJ][i];
            resultGrid[tempJ][i] = matrix[i][tempJ];
        }

        int tempI = size - 1;
        for (int j = 1; j < size - 1; j++) {
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
        for (int i = 1; i < size - 1; i++) {
            resultGrid[i][tempJ] = matrix[tempJ][i];
            resultGrid[tempJ][i] = matrix[i][tempJ];
        }

        int tempI = size - 2;
        for (int j = 1; j < size - 2; j++) {
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
        if (Math.abs(this.size) % 2 == 1 && ring == this.numberOfRings) {
            return this; // returns the same squarelotron if the ring number is equal to the number of rings.
        }
        int[][] resultGrid = mainDiagonalFlipHelper(ring);
        return new Squarelotron(resultGrid);
    }

    /**
     * mainDiagonalFlipHelper.
     *
     * @param ring ring number.
     * @return a grid.
     */
    private int[][] mainDiagonalFlipHelper(int ring) {
        int[][] resultGrid;
        if (ring != 1) {
            resultGrid = flipInternalRing(this.squarelotron);
        } else {
            resultGrid = flipExternalRing(this.squarelotron);
        }
        return resultGrid;
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

    /**
     * rotateEast.
     *
     * @param numberOfTurns number of turns.
     */
    private void rotateEast(int numberOfTurns) {
        while (numberOfTurns > 0) {
            for (int i = 1; i <= numberOfRings; i++) {
                squarelotron = upsideDownFlipHelper(i);
            }
            for (int i = 1; i <= numberOfRings; i++) {
                squarelotron = mainDiagonalFlipHelper(i);
            }
            numberOfTurns--;
        }
    }

    /**
     * rotateWest.
     *
     * @param numberOfTurns number of turns.
     */
    private void rotateWest(int numberOfTurns) {
        while (numberOfTurns < 0) {
            for (int i = 1; i <= numberOfRings; i++) {
                squarelotron = mainDiagonalFlipHelper(i);
            }
            for (int i = 1; i <= numberOfRings; i++) {
                squarelotron = upsideDownFlipHelper(i);
            }
            numberOfTurns++;
        }
    }
}
