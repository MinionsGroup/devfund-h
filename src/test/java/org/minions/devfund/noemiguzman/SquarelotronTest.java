package org.minions.devfund.noemiguzman;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

/**
 * class to test Squarelotron.
 */

public class SquarelotronTest {

    private Squarelotron s;
    private Squarelotron s4;
    private Squarelotron s5;
    // different Size
    static final int SIZE3 = 3;
    static final int SIZE4 = 4;
    static final int SIZE5 = 5;

    /**
     * Method to test Squarelotron with Size3.
     */

    @Test
    public void testSquarelotronOfSize3() {
        s = new Squarelotron(SIZE3);
        final int[] temp = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        Squarelotron sArray = new Squarelotron(temp);
        assertEquals(SIZE3, s.getSize());
        final int[][] test = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        assertArrayEquals(test, s.getSquarelotron());
        assertArrayEquals(test, sArray.getSquarelotron());
    }

    /**
     * Method to test Squarelotron with Size4.
     */
    @Test
    public void testSquarelotronOfSize4() {
        s4 = new Squarelotron(SIZE4);
        final int[] temp4 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16};
        Squarelotron sArray4 = new Squarelotron(temp4);
        final int[][] test4 = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        assertArrayEquals(test4, s4.getSquarelotron());
        assertArrayEquals(test4, sArray4.getSquarelotron());

    }

    /**
     * Method to test Squarelotron with Size5.
     */
    @Test
    public void testSquarelotronSize5() {
        s5 = new Squarelotron(SIZE5);
        final int[] temp5 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25};
        Squarelotron sArray5 = new Squarelotron(temp5);
        final int[][] test6 = {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15}, {16, 17, 18, 19, 20},
                {21, 22, 23, 24, 25}};
        assertArrayEquals(test6, s5.getSquarelotron());
        assertArrayEquals(test6, sArray5.getSquarelotron());
    }

    /**
     * Method to test UpsideDownFlip.
     */
    @Test
    public void testUpsideDownFlip() {
        s = new Squarelotron(SIZE3);
        s4 = new Squarelotron(SIZE4);
        s5 = new Squarelotron(SIZE5);
        final int ring3 = 3;
        final int ring2 = 2;
        // simple 3 by 3 case
        Squarelotron temp = s.upsideDownFlip(1);
        final int[][] test = {{7, 8, 9}, {4, 5, 6}, {1, 2, 3}};
        assertArrayEquals(test, temp.getSquarelotron());
        // 4 by 4, but flip inner ring
        final int[][] test4 = {{1, 2, 3, 4}, {5, 10, 11, 8}, {9, 6, 7, 12}, {13, 14, 15, 16}};
        Squarelotron temp4 = s4.upsideDownFlip(ring2);
        assertArrayEquals(test4, temp4.getSquarelotron());
        // 4 by 4, but flip outer ring
        final int[][] test5 = {{13, 14, 15, 16}, {9, 6, 7, 12}, {5, 10, 11, 8}, {1, 2, 3, 4}};
        Squarelotron temp5 = s4.upsideDownFlip(1);
        assertArrayEquals(test5, temp5.getSquarelotron());
        // 5 by 5, flip the center, nothing will change
        final int[][] test6 = {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15}, {16, 17, 18, 19, 20},
                {21, 22, 23, 24, 25}};
        Squarelotron temp6 = s5.upsideDownFlip(ring3);
        assertArrayEquals(test6, temp6.getSquarelotron());
    }

    /**
     * Method to test MainDiagonalFlip.
     */

    @Test
    public void testMainDiagonalFlip() {
        s = new Squarelotron(SIZE3);
        s4 = new Squarelotron(SIZE4);
        s5 = new Squarelotron(SIZE5);
        final int ring3 = 3;
        final int ring2 = 2;
        // simple 3 by 3 case
        Squarelotron temp = s.mainDiagonalFlip(1);
        final int[][] test = {{1, 4, 7}, {2, 5, 8}, {3, 6, 9}};
        assertArrayEquals(test, temp.getSquarelotron());
        // 4 by 4, but inverse inner ring
        final int[][] test5 = {{1, 2, 3, 4}, {5, 6, 10, 8}, {9, 7, 11, 12}, {13, 14, 15, 16}};
        Squarelotron temp5 = s4.mainDiagonalFlip(ring2);
        assertArrayEquals(test5, temp5.getSquarelotron());
        // 4 by 4, but inverse outer ring
        final int[][] test4 = {{1, 5, 9, 13}, {2, 6, 7, 14}, {3, 10, 11, 15}, {4, 8, 12, 16}};
        Squarelotron temp4 = s4.mainDiagonalFlip(1);
        assertArrayEquals(test4, temp4.getSquarelotron());
        // 5 by 5, flip the center, nothing will change
        final int[][] test6 = {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15}, {16, 17, 18, 19, 20},
                {21, 22, 23, 24, 25}};
        Squarelotron temp6 = s5.mainDiagonalFlip(ring3);
        assertArrayEquals(test6, temp6.getSquarelotron());
    }

    /**
     * Method to test RotateRight.
     */
    @Test
    public void testRotateRight() {
        s = new Squarelotron(SIZE3);
        s4 = new Squarelotron(SIZE4);
        s5 = new Squarelotron(SIZE5);
        final int numberOfTurns8 = 8;
        final int numberOfTurns3 = 3;
        final int numberOfTurns2 = 2;
        final int numberOfTurns5 = 5;
        // test 4 by 4 case
        final int[][] test4 = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        final int[][] test5 = {{13, 9, 5, 1}, {14, 10, 6, 2}, {15, 11, 7, 3}, {16, 12, 8, 4}};
        final int[][] test6 = {{16, 15, 14, 13}, {12, 11, 10, 9}, {8, 7, 6, 5}, {4, 3, 2, 1}};
        final int[][] test7 = {{4, 8, 12, 16}, {3, 7, 11, 15}, {2, 6, 10, 14}, {1, 5, 9, 13}};
        // rotate 0 degrees and 720 degrees
        // should stay the same
        s4.rotateRight(0);
        assertArrayEquals(test4, s4.getSquarelotron());
        s4.rotateRight(numberOfTurns8);
        assertArrayEquals(test4, s4.getSquarelotron());
        // rotate to the right 90 degrees
        s4.rotateRight(1);
        assertArrayEquals(test5, s4.getSquarelotron());
        // rotate to the left 90 degrees
        // back to original
        s4.rotateRight(-1);
        assertArrayEquals(test4, s4.getSquarelotron());
        // rotate to the right 180 degrees
        s4.rotateRight(numberOfTurns2);
        assertArrayEquals(test6, s4.getSquarelotron());
        // rotate to the left 180 degrees
        // back to original
        s4.rotateRight(-numberOfTurns2);
        assertArrayEquals(test4, s4.getSquarelotron());
        // rotate to the right 270 degrees
        s4.rotateRight(numberOfTurns3);
        assertArrayEquals(test7, s4.getSquarelotron());
        s4.rotateRight(-numberOfTurns5);
        assertArrayEquals(test6, s4.getSquarelotron());
    }

    /**
     *  test negative no squarelotron.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testThrowsIllegalArgumentExceptionForNoSquarelotron() {
        s = new Squarelotron(SIZE3);
        final int[] temp = {1, 2, 3, 4, 5, 6, 7, 8, 9, 9};
        s = new Squarelotron(temp);
    }

    /**
     *  test negative with values more than 99.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testThrowsIllegalArgumentExceptionForInvalidSquarelotron() {
        s = new Squarelotron(SIZE3);
        final int[] temp = {1, 2, 3, 4, 125, 6, 17, 18, 9};
        s = new Squarelotron(temp);
    }
    /**
     *  test negative with values less than 0.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testThrowsIllegalArgumentExceptionNegativeSquarelotron() {
        s = new Squarelotron(SIZE3);
        final int[] temp = {1, 2, 3, -1, 125, 6, 17, 18, 9};
        s = new Squarelotron(temp);
    }
}
