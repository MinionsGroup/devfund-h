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
     * Builds new array in base a Squarelotron.
     *
     * @return New array with Squarelotron values.
     */
    public int[] buildArray() {
        int[] newArray = new int[this.size * this.size];

        for (int x = 0; x < this.size; x++) {

            for (int y = 0; y < this.size; y++) {
                newArray[this.size * x + y] = squarelotron[x][y];
            }
        }

        return newArray;
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
