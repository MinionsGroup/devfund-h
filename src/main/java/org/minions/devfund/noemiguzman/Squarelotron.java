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
        this.size = n;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                this.squarelotron[i][j] = i * n + j + 1;
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
            if (array[i] < 0 || array[i] > MAX_SIZE) {
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
        int[][] deepCopy2 = copySquarelotron();

        // manipulating on deepCopy2, upsideDownFlip on deepCopy2
        for (int i = 0; i < this.size / DIMENSION; i++) {
            int[] temp = deepCopy2[i];
            deepCopy2[i] = deepCopy2[deepCopy2.length - i - 1];
            deepCopy2[deepCopy2.length - i - 1] = temp;
        }
        // get the wanted ring on deepCopy2, and copy those numbers onto deepCopy1
        // upper bound
        int[][] deepCopy1 = rotateCorners(ring - 1, this.size - ring, deepCopy2);
        Squarelotron s = new Squarelotron(this.size);
        s.squarelotron = deepCopy1;
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
        int[][] deepCopy2 = copyReverseSquarelotron();
        int[][] deepCopy1 = rotateCorners(ring - 1,this.size - ring, deepCopy2);;
        // get the wanted ring on deepCopy2, and copy those numbers onto deepCopy1
        Squarelotron s = new Squarelotron(this.size);
        s.squarelotron = deepCopy1;
        return s;
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
            int[][] temp = copyReverseSquarelotron();
            copyToSquarelotron(temp);
            rotateRightUpperCorner();

        } else if (ind == 2 || ind == -DIMENSION) {
            // flip upside down
            rotateRightUpperCorner();
            rotateRightLowerCorner();

        } else if (ind == 1 || ind == -NUM_SIDES + 1) {
            // inverse transpose
            int[][] temp4 = new int[this.size][this.size];
            for (int i = 0; i < this.size; i++) {
                for (int j = 0; j < this.size; j++) {
                    temp4[i][j] = this.squarelotron[this.size - j - 1][this.size - i - 1];
                }
            }
            copyToSquarelotron(temp4);
            rotateRightUpperCorner();
        }
    }

    /**
     * copy squarelotron to int array.
     *
     * @return copyS int[][]
     */
    private int[][] copySquarelotron() {
        int[][] copyS = new int[this.size][this.size];
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
     * @return copys int[][]
     */
    private int[][] copyReverseSquarelotron() {
        int[][] copyS = new int[this.size][this.size];
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
     * @param initI
     * @param finalI
     * @param deepCopy2 help int[][]
     * @return rotate corners of Squarelotron
     */
    private int[][] rotateCorners(int initI, int finalI, final int[][] deepCopy2){
        int[][] deepCopy1 = copySquarelotron();
        // upper bound and right bound
        for (int j = initI; j < finalI; j++) {
            deepCopy1[initI][j] = deepCopy2[initI][j];
            deepCopy1[j][finalI] = deepCopy2[j][finalI];
        }
        // lower bound and left bound
        for (int i = finalI; i > initI; i--) {
            deepCopy1[finalI][i] = deepCopy2[finalI][i];
            deepCopy1[i][initI] = deepCopy2[i][initI];
        }
        return deepCopy1;
    }
}
