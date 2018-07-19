package org.minions.devfund.noemiguzman;

/**
 * Created by Noemi on 18-07-18.
 */
public class Squarelotron {

    /*
     * instance variables
     */
    private int[][] squarelotron;
    private int size;
    private static final int MAX_SIZE = 99;
    private static final int NUM_SIDES = 4;
    private static final int DIMENSION = 2;

    /**
     *
     * @return size of squarelotron
     */

    public int getSize() {
        return size;
    }

    /**
     *
     * @return current squarelotron
     */
    public int[][] getSquarelotron() {
        return squarelotron.clone();
    }
    /**
     * constructor It fills the 2-dimensional array with the numbers 1 to n squared.
     *
     * @param n - the dimension of the squarelotron
     */
    public Squarelotron(int n) {
        this.squarelotron = new int[n][n];
        size = n;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                this.squarelotron[i][j] = i * n + j + 1;
            }
        }
    }

    /**
     * additional constructor.
     *
     * @param array - 1d array convert to a squarelotron
     */
    public Squarelotron(final int[] array) {
        Squarelotron newSquare = Squarelotron.makeSquarelotron(array);
        this.squarelotron = new int[newSquare.size][newSquare.size];
        this.size = newSquare.size;

        for (int i = 0; i < newSquare.size; i++) {
            for (int j = 0; j < newSquare.size; j++) {
                this.squarelotron[i][j] = newSquare.squarelotron[i][j];
            }
        }
    }

    /**
     * method to construct a Squarelotron using an array.
     *
     * @param array - pass in array
     * @return - a new Squarelotron class
     */
    public static Squarelotron makeSquarelotron(final int[] array) {
        // test square length
        int sqrt = (int) Math.sqrt(array.length);
        if (sqrt * sqrt != array.length) {
            throw new IllegalArgumentException("bad array provided");
        }
        // test the length is between 0 to MAX_SIZE
        for (int i = 0; i < array.length; i++) {
            if (array[i] < 0 || array[i] > MAX_SIZE || array[i] != array[i]) {
                throw new IllegalArgumentException("bad array provided");
            }
        }
        // if pass the previous test, we need to construct squarelotron
        Squarelotron s = new Squarelotron(sqrt);
        for (int i = 0; i < sqrt; i++) {
            for (int j = 0; j < sqrt; j++) {
                s.squarelotron[i][j] = array[i * sqrt + j];
            }
        }
        s.size = sqrt;
        return s;
    }

    /**
     * flip the squarelotron with the indicated ring number.
     * flip direction - upsideDown
     *
     * @param ring - ring number
     * @return NewSquarelotron
     */

    public Squarelotron upsideDownFlip(int ring) {
        // deep copy the board out
        int[][] deepCopy1 = new int[this.size][this.size];
        int[][] deepCopy2 = new int[this.size][this.size];
        deepCopy1 = copySquarelotron(deepCopy1);
        deepCopy2 = copySquarelotron(deepCopy2);

        // manipulating on deepCopy2, upsideDownFlip on deepCopy2
        for (int i = 0; i < this.size / DIMENSION; i++) {
            int[] temp = deepCopy2[i];
            deepCopy2[i] = deepCopy2[deepCopy2.length - i - 1];
            deepCopy2[deepCopy2.length - i - 1] = temp;
        }
        // get the wanted ring on deepCopy2, and copy those numbers onto deepCopy1
        // upper bound
        deepCopy1 = rotateSquarelotron(ring, deepCopy1, deepCopy2);
        return copyToNewSquarelotron(deepCopy1);
    }

    /**
     * Copy from int[][] to new squareloton.
     * @param deepCopy1  data to copy on new squareletorn
     * @return Squarelotron
     */
    private Squarelotron copyToNewSquarelotron(final int[][] deepCopy1) {
        Squarelotron s = new Squarelotron(this.size);
        for (int i = 0; i < s.size; i++) {
            for (int j = 0; j < s.size; j++) {
                s.squarelotron[i][j] = deepCopy1[i][j];
            }
        }
        return s;
    }

    /**
     * inverse the squarelotron with the indicated ring number.
     * inverse direction - transpose
     * @param ring - ring number
     * @return New Squarelotron
     */
    public Squarelotron mainDiagonalFlip(int ring) {
        // deep copy the board out
        int[][] deepCopy1 = new int[this.size][this.size];
        int[][] deepCopy2 = new int[this.size][this.size];
        deepCopy1 = copySquarelotron(deepCopy1);
        deepCopy2 = copyReverseSquarelotron(deepCopy2);
        deepCopy1 = rotateSquarelotron(ring, deepCopy1, deepCopy2);
        // get the wanted ring on deepCopy2, and copy those numbers onto deepCopy1
        // upper bound
        // use deepCopy1 to get a new squarelotron

        return copyToNewSquarelotron(deepCopy1);
    }


    /**
     * rotate the squarelotron.
     *
     * @param numberOfTurns - indicating how it will turn
     */

    public void rotateRight(int numberOfTurns) {
        // three different situation
        // -3 or 1
        // 1. diagonal flip (transpose) 2.upside down flip
        // -2 or 2
        // 1. left to right flip 2.upside down flip
        // -1 or 3
        // 1. main inverse diagonal flip 2.left to right flip
        // 0 is no change at all
        int ind = numberOfTurns % NUM_SIDES;
        if (ind == -1 || ind == NUM_SIDES - 1) {
            // transpose
            int[][] temp = new int[this.size][this.size];
            temp = copyReverseSquarelotron(temp);
            copyToSquarelotron(temp);
            rotateRightUpperCorner();

        } else if (ind == 2 || ind == -DIMENSION) {
            // flip upside down
            rotateRightUpperCorner();
            rotateRightLowerCorner();

        } else if (ind == 1 || ind == -NUM_SIDES - 1) {
            // inverse transpose
            int[][] temp4 = new int[this.size][this.size];
            for (int i = 0; i < this.size; i++) {
                for (int j = 0; j < this.size; j++) {
                    temp4[i][j] = this.squarelotron[this.size - j - 1][this.size - i - 1];
                }
            }
            copyToSquarelotron(temp4);

            rotateRightUpperCorner();

        } else {
            System.out.println("Nothing Changed !!!");
        }
    }

    /**
     * copy squarelotron to int array.
     *
     * @param copyS int[][] from copy squareloton
     * @return copyS int[][]
     */
    private int[][] copySquarelotron(final int[][] copyS) {
        for (int i = 0; i < this.size; i++) {
            for (int j = 0; j < this.size; j++) {
                copyS[i][j] = this.squarelotron[i][j];
            }
        }
        return copyS;
    }

    /**
     * copy reverse squarelotron to int array.
     *
     * @param copyS int[][] where copy squarelotron info
     * @return copys int[][]
     */
    private int[][] copyReverseSquarelotron(final int[][] copyS) {
        for (int i = 0; i < this.size; i++) {
            for (int j = 0; j < this.size; j++) {
                copyS[i][j] = this.squarelotron[j][i];
            }
        }
        return copyS;
    }

    /**
     * copy from int array to squarelotron.
     *
     * @param temp info to copy to squareloton
     */
    private void copyToSquarelotron(final int[][] temp) {
        for (int i = 0; i < this.size; i++) {
            for (int j = 0; j < this.size; j++) {
                this.squarelotron[i][j] = temp[i][j];
            }
        }
    }

    /**
     * Rotate the upper corner of squarelaton.
     */
    private void rotateRightUpperCorner() {
        for (int i = 0; i < this.size / 2; i++) {
            int[] temp = this.squarelotron[i];
            this.squarelotron[i] = this.squarelotron[this.size - i - 1];
            this.squarelotron[this.size - i - 1] = temp;
        }
    }

    /**
     * Rotate the lower corner of squarelaton.
     */
    private void rotateRightLowerCorner() {
        for (int i = 0; i < this.size; i++) {
            for (int j = 0; j < (this.size + 1) / 2; j++) {
                int temp = this.squarelotron[i][j];
                this.squarelotron[i][j] = this.squarelotron[i][this.size - 1 - j];
                this.squarelotron[i][this.size - 1 - j] = temp;
            }
        }
    }


    /**
     *
     * @param ring num ring
     * @param deepCopy1 base int[][]
     * @param deepCopy2 help int[][]
     * @return rotated Squarelotron
     */
    private int[][] rotateSquarelotron(int ring, final int[][] deepCopy1, final int[][] deepCopy2) {
        // get the wanted ring on deepCopy2, and copy those numbers onto deepCopy1
        // upper bound
        for (int j = ring - 1; j < this.size - ring; j++) {
            deepCopy1[ring - 1][j] = deepCopy2[ring - 1][j];
        }
        // right bound
        for (int i = ring - 1; i < this.size - ring; i++) {
            deepCopy1[i][this.size - ring] = deepCopy2[i][this.size - ring];
        }
        // lower bound
        for (int j = this.size - ring; j > ring - 1; j--) {
            deepCopy1[this.size - ring][j] = deepCopy2[this.size - ring][j];
        }
        // left bound
        for (int i = this.size - ring; i > ring - 1; i--) {
            deepCopy1[i][ring - 1] = deepCopy2[i][ring - 1];
        }
        return deepCopy1;
    }
}
