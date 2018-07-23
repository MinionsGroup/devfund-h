package org.minions.devfund.david;

import java.util.Arrays;

/**
 * Homework Assignment 2: Squarelotron.
 */
public class Squarelotron {
    private int[][] squarelotron;
    private int size;

    /**
     * Squarelotron constructor.
     *
     * @param size of 2D array.
     */
    public Squarelotron(int size) {
        this.size = size;
        squarelotron = new int[size][size];
        initSquarelotron();
    }

    /**
     * Initializes 2D squarelotron matrix.
     */
    private void initSquarelotron() {
        int number = 1;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                squarelotron[i][j] = number;
                number++;
            }
        }
    }

    /**
     * Finds max square rings.
     *
     * @return Number of square rings.
     */
    private int findMaxRings() {
        return this.size % 2 == 0 ? this.size / 2 : this.size / 2 + 1;

    }

    /**
     * Swaps origin squarelotron into new one.
     *
     * @param newSquare that was swapped.
     */
    private void swap(final Squarelotron newSquare) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                newSquare.squarelotron[i][j] = this.squarelotron[i][j];
            }
        }
    }

    /**
     * Gets copy of Squarelotron 2D array.
     *
     * @return 2D array copied.
     */
    public int[][] getSquarelotron() {
        return Arrays.copyOf(squarelotron, size);
    }

    /**
     * Upside-Down Flip of the squarelotron.
     *
     * @param ring - integer.
     * @return {@link Squarelotron}.
     * @throws NumberFormatException ring value is not correct.
     */
    public Squarelotron upsideDownFlip(int ring) throws NumberFormatException {
        if (ring > this.findMaxRings() || ring < 1) {
            throw new NumberFormatException();
        }
        Squarelotron s = new Squarelotron(size);
        this.swap(s);

        int first = ring - 1;
        int last = size - ring;
        for (int i = 0; i <= size - 1; i++) {
            for (int j = 0; j <= size - 1; j++) {
                if (i == first || i == last) {
                    if (j >= first && j <= last) {
                        s.squarelotron[i][j] = this.squarelotron[size - 1 - i][j];
                    }
                } else if (i > first && i < last && j == first || j == last) {
                    s.squarelotron[i][j] = this.squarelotron[size - 1 - i][j];
                }
            }
        }
        return s;
    }

    /**
     * Flips Square top to bottom.
     *
     * @param ring - integer
     * @return {@link Squarelotron}.
     * @throws NumberFormatException ring value is not correct.
     */
    public Squarelotron mainDiagonalFlip(int ring) throws NumberFormatException {
        if (ring > this.findMaxRings() || ring < 1) {
            throw new NumberFormatException();
        }
        int first = ring - 1;
        int last = size - ring;
        Squarelotron s = new Squarelotron(size);
        this.swap(s);

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (i == first || i == last) {
                    if (j >= first && j <= last) {
                        s.squarelotron[i][j] = this.squarelotron[j][i];
                    }
                } else if (i > first && i < last && j == first || j == last) {
                    s.squarelotron[i][j] = this.squarelotron[j][i];
                }
            }
        }
        return s;
    }

    /**
     * Rotates 90° clockwise.
     *
     * @param numberOfTurns number of times the entire squarelotron should be rotated 90° clockwise.
     */
    public void rotateRight(int numberOfTurns) {

        int ring;
        boolean right = true;
        int maxRing = findMaxRings();

        int[][] tmpArr = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                tmpArr[i][j] = this.squarelotron[i][j];
            }
        }

        if (numberOfTurns < 0) {
            right = false;
            numberOfTurns *= -1;
        }

        for (int k = 0; k < numberOfTurns; k++) {

            for (int l = 1; l <= maxRing; l++) {
                ring = l;
                int first = ring - 1;
                int last = size - ring;

                for (int i = 0; i < size; i++) {
                    for (int j = 0; j < size; j++) {

                        if (i == first) {
                            if (j >= first && j <= last) {

                                this.squarelotron[i][j] = right ? tmpArr[size - 1 - j][first] : tmpArr[j][last];
                            }

                        } else if (i == last) {

                            if (j >= first && j <= last) {
                                this.squarelotron[i][j] = right ? tmpArr[size - 1 - j][last] : tmpArr[j][first];
                            }
                        } else if (i > first && i < last) {

                            if (j == last) {
                                this.squarelotron[i][j] = right ? tmpArr[first][i] : tmpArr[last][size - 1 - i];
                            } else if (j == first) {
                                this.squarelotron[i][j] = right ? tmpArr[last][i] : tmpArr[first][size - 1 - i];
                            }
                        }
                    }
                }
            }

            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    tmpArr[i][j] = this.squarelotron[i][j];
                }
            }
        }
    }
}
