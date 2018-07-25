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
     * Finds the Maximum Rings number.
     *
     * @return Numbers maximum of rings.
     */
    public int findMaxRings() {
        return (this.size % 2 == 0)
                ? size / 2
                : size / 2 + 1;
    }
    /**
      * Modifies A Upside-Down Flip of the outer ring of Squarelotron.
      *
      * @param ring - Number of ring.
      * @return Instance new Squarelotron.
      */
    public Squarelotron upsideDownFlip(int ring) {

        if (ring > this.findMaxRings() || ring < 1) {
            throw new NumberFormatException();
        }

        Squarelotron squarelotron = new Squarelotron(this.size);

        int first = ring - 1;
        int last = size - ring;

        for (int i = 0; i <= size - 1; i++) {
            for (int j = 0; j <= size - 1; j++) {
                if (i == first || i == last) {
                    if (j >= first && j <= last) {
                        squarelotron.squarelotron[i][j] = this.squarelotron[size - 1 - i][j];
                    }
                }

                if (i > first && i < last) {
                    if (j == first || j == last) {
                        squarelotron.squarelotron[i][j] = this.squarelotron[size - 1 - i][j];
                    }
                }
            }
        }
        return squarelotron;
    }

    public Squarelotron mainDiagonarlFlip(int ring) {

        if (ring > this.findMaxRings() || ring < 1) {
            throw new NumberFormatException();
        }

        Squarelotron squarelotron = new Squarelotron(this.size);

        int first = ring - 1; // 0
        int last = size - ring; // 3

        for (int i = 0; i <= size - 1; i++) {
            for (int j = 0; j <= size - 1; j++) {

                if (i == first || i == last) {
                    if (j >= first && j <= last) {
                        squarelotron.squarelotron[j][i] = this.squarelotron[i][j];
                    }
                }

                if (i > first && i < last) {
                    if (j == first || j == last) {
                        squarelotron.squarelotron[j][i] = this.squarelotron[i][j];
                    }
                }
            }
        }
        return squarelotron;
    }

    /**
     * Rotates Matrix 90 grades positive or negative position.
     *
     * @param numberOfTurns Number or rotations.
     */
    public void rotateRight(int numberOfTurns) {

        int ring;
        boolean right = true;
        int maxRing = findMaxRings();

        // Temporal Squarelotron
        int[][] temporalSquarelotron = new int[size][size];

        // Duplicate the squarelotron matrix.
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                temporalSquarelotron[i][j] = this.squarelotron[i][j];
            }
        }
        if (numberOfTurns < 0) {
            right = false;
            numberOfTurns = numberOfTurns * (-1);
        }

        for (int x = 0; x < numberOfTurns; x++) { // Move the ring in base the number of turns.
            for (int l = 1; l <= maxRing; l++) { // Mode on the ring selected
                ring = l;
                int first = ring - 1;
                int last = size - ring;
                for (int i = 0; i < size; i++) {
                    for (int j = 0; j < size; j++) {
                        if (i == first) {
                            if (j >= first && j <= last) {
                                this.squarelotron[i][j] = (right) ? temporalSquarelotron[size - 1 - j][first] : temporalSquarelotron[j][last];
                            }
                        } else if (i == last) {
                            if (j >= first && j <= last) {
                                this.squarelotron[i][j] = (right) ? temporalSquarelotron[size - 1 - j][last] : temporalSquarelotron[j][first];
                            }
                        } else if (i > first && i < last) {
                            if (j == last) {

                                this.squarelotron[i][j] = (right) ? temporalSquarelotron[first][i] :
                                        temporalSquarelotron[last][size - 1 - i];
                            } else if (j == first) {
                                this.squarelotron[i][j] = (right) ? temporalSquarelotron[last][i] :
                                        temporalSquarelotron[first][size - 1 - i];
                            }
                        }
                    }
                }
            }
            // replace array to temporal array
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    temporalSquarelotron[i][j] = this.squarelotron[i][j];
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
        StringBuffer sqString = new StringBuffer();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                sqString.append(squarelotron[i][j] + "\t");
            }

            sqString.append("\n");
        }
        return sqString.toString();
    }
}
