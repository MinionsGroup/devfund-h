package org.minions.devfund.carlosorellana;

/**
 * The goal is execute the Squarelotron methods.
 *
 * @author Carlos Orellana.
 * @since 07/17/2018.
 */
public class Squarelotron {

    private int[][] squarelotron;
    private int size;

    /**
     * Gets Squarelotron Matrix.
     *
     * @return Squarelotron Matrix.
     */
    public int[][] getSquarelotron() {
        return squarelotron.clone();
    }

    /**
     * Constructor Sqarelotron.
     *
     * @param n - Size of squarelotron array.
     */
    public Squarelotron(final int n) {
        this.size = n;
        this.squarelotron = new int[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                squarelotron[i][j] = size * i + j + 1;
            }
        }
    }

    /**
     * Gets the maximum number of ring in the squarelotron.
     *
     * @return Numbers maximum of rings.
     */
    public int getMaxRings() {
        return (this.size % 2 == 0) ? size / 2 : size / 2 + 1;
    }

    /**
     * Modifies A Upside-Down Flip of the outer ring of Squarelotron.
     *
     * @param ring - Number of ring.
     * @return Instance new Squarelotron.
     */
    public Squarelotron upsideDownFlip(final int ring) {

        if (ring > this.getMaxRings() || ring < 1) {
            throw new NumberFormatException();
        }

        Squarelotron squarelotronTemporal = new Squarelotron(this.size);

        int first = ring - 1;
        int last = size - ring;

        for (int i = 0; i <= size - 1; i++) {
            for (int j = 0; j <= size - 1; j++) {

                squarelotronTemporal = createNewMatrixToUpsideDownFlip(i, j, first, last, squarelotronTemporal);
            }
        }

        return squarelotronTemporal;
    }

    /**
     * Creates a new matrix to Upside Down Flip values.
     *
     * @param positionX            - Position X.
     * @param positionY            - Position Y.
     * @param first                - Value get to (ring - 1).
     * @param last                 - Value get to (size - ring).
     * @param squarelotronTemporal - New Squarelotron Object.
     * @return Instance of Squarelotron.
     */
    private Squarelotron createNewMatrixToUpsideDownFlip(final int positionX, final int positionY,
                                                         final int first, final int last,
                                                         final Squarelotron squarelotronTemporal) {

        boolean valA = positionX == first || positionX == last;
        boolean valB = positionY >= first && positionY <= last;
        boolean valC = positionX > first && positionX < last;
        boolean valD = positionY == first || positionY == last;

        if (valA && valB) {
            squarelotronTemporal.squarelotron[positionX][positionY] =
                    this.squarelotron[size - 1 - positionX][positionY];
        }


        if (valC && valD) {
            squarelotronTemporal.squarelotron[positionX][positionY] =
                    this.squarelotron[size - 1 - positionX][positionY];
        }

        return squarelotronTemporal;
    }


        /**
         * Modifies the matrix - move the number diagonally in the Matrix.
         *
         * @param ring - Number the ring affected.
         * @return New instance of Squarelotron
         */

    public Squarelotron mainDiagonalFlip(final int ring) {

        if (ring > this.getMaxRings() || ring < 1) {
            throw new NumberFormatException();
        }

        Squarelotron squarelotronTemporal = new Squarelotron(this.size);

        int first = ring - 1; // 0
        int last = size - ring; // 3


        for (int i = 0; i <= size - 1; i++) {
            for (int j = 0; j <= size - 1; j++) {
                squarelotronTemporal = createNewMatrixToMainDiagonalFlip(i, j, first, last, squarelotronTemporal);
            }
        }
        return squarelotronTemporal;
    }

    /**
     * Creates a new matrix to Main Diagonal Flip values.
     *
     * @param positionX            - Position X.
     * @param positionY            - Position Y.
     * @param first                - Value get to (ring - 1).
     * @param last                 - Value get to (size - ring).
     * @param squarelotronTemporal - New Squarelotron Object.
     * @return Instance of Squarelotron.
     */
    private Squarelotron createNewMatrixToMainDiagonalFlip(final int positionX, final int positionY,
                                                           final int first, final int last,
                                                           final Squarelotron squarelotronTemporal) {
        boolean valA = positionX == first || positionX == last;
        boolean valB = positionY >= first && positionY <= last;
        boolean valC = positionX > first && positionX < last;
        boolean valD = positionY == first || positionY == last;

        if (valA && valB) {
            squarelotronTemporal.squarelotron[positionY][positionX] = this.squarelotron[positionX][positionY];
        }

        if (valC && valD) {
            squarelotronTemporal.squarelotron[positionY][positionX] = this.squarelotron[positionX][positionY];
        }
        return squarelotronTemporal;
    }

    /**
     * Rotates Matrix 90 grades positive or negative position.
     *
     * @param numberOfTurns Number or rotations.
     */
    public void rotateRight(final int numberOfTurns) {

        int turns = numberOfTurns;
        int ring;
        boolean right = true;
        int maxRing = getMaxRings();
        boolean valA;
        boolean valB;
        boolean valC;
        boolean valD;

        // New Temporal Squarelotron
        int[][] temporalSquarelotron = new int[size][size];

        // Duplicates the squarelotron matrix.
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                temporalSquarelotron[i][j] = this.squarelotron[i][j];
            }
        }

        if (numberOfTurns < 0) {
            right = false;
            turns = turns * (-1);
        }

        for (int x = 0; x < turns; x++) { // Move the ring in base the number of turns.
            for (int y = 1; y <= maxRing; y++) { // Mode on the ring selected
                ring = y;
                int first = ring - 1;
                int last = size - ring;

                for (int i = 0; i < size; i++) {
                    for (int j = 0; j < size; j++) {

                        valA = i == first;
                        valB = j >= first && j <= last;
                        valC = i == last;
                        valD = j >= first && j <= last;

                        if (valA && valB) {
                            this.squarelotron[i][j] = right ? temporalSquarelotron[size - 1 - j][first]
                                    : temporalSquarelotron[j][last];
                        }

                        if (valC && valD) {
                            this.squarelotron[i][j] = right ? temporalSquarelotron[size - 1 - j][last]
                                    : temporalSquarelotron[j][first];
                        }

                        if (i > first && i < last) {
                            if (j == last) {

                                this.squarelotron[i][j] = right ? temporalSquarelotron[first][i]
                                        : temporalSquarelotron[last][size - 1 - i];
                            }

                            if (j == first) {
                                this.squarelotron[i][j] = right ? temporalSquarelotron[last][i]
                                        : temporalSquarelotron[first][size - 1 - i];
                            }
                        }
                    }
                }
            }
        }
    }

    /**
     * Prints the Squarelotron matrix.
     *
     * @return String with the Squarelotron matrix.
     */
    @Override
    public String toString() {
        StringBuilder sqString = new StringBuilder();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                sqString.append(this.squarelotron[i][j] + "\t");
            }

            sqString.append("\n");
        }
        return sqString.toString();
    }
}
