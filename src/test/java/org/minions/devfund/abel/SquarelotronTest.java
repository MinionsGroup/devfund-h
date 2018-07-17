package org.minions.devfund.abel;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

/**
 * Class for Squarelotron tests.
 */
public class SquarelotronTest {

    /**
     * Squarelotron Constructor initialize.
     */
    @Test
    public void testConstructorFillsArray() {
        final int two = 2;
        Squarelotron squarelotron = new Squarelotron(two);
        final int[][] expected = new int[][]{{1, 2}, {3, 4}};
        assertArrayEquals(expected, squarelotron.getSquarelotronMatrix());
    }

    /**
     * Squarelotron Constructor initialize.
     */
    @Test
    public void testConstructorFillsArrayNull() {
        final int[][] new2dArray = null;
        final int[][] expected = {};
        Squarelotron squarelotron = new Squarelotron(new2dArray);
        assertArrayEquals(expected, squarelotron.getSquarelotronMatrix());
    }

    /**
     * Squarelotron Upside Down Flip.
     */
    @Test
    public void testUpsideDownFlipSizeTwoRingOne() {
        final int two = 2;
        Squarelotron squarelotron = new Squarelotron(two);
        final int[][] expected = {{3, 4}, {1, 2}};
        assertArrayEquals(expected, squarelotron.upsideDownFlip(1).getSquarelotronMatrix());
    }

    /**
     * Squarelotron Upside Down Flip.
     */
    @Test
    public void testUpsideDownFlipSizeThreeRingOne() {
        final int three = 3;
        Squarelotron squarelotron = new Squarelotron(three);
        final int[][] expected = {{7, 8, 9}, {4, 5, 6}, {1, 2, 3}};
        assertArrayEquals(expected, squarelotron.upsideDownFlip(1).getSquarelotronMatrix());
    }

    /**
     * Squarelotron Upside Down Flip.
     */
    @Test
    public void testUpsideDownFlipFourSizeRingOne() {
        final int four = 4;
        Squarelotron squarelotron = new Squarelotron(four);
        final int[][] expected = {{13, 14, 15, 16}, {9, 6, 7, 12}, {5, 10, 11, 8}, {1, 2, 3, 4}};
        assertArrayEquals(expected, squarelotron.upsideDownFlip(1).getSquarelotronMatrix());
    }

    /**
     * Squarelotron Upside Down Flip.
     */
    @Test
    public void testUpsideDownFlipFiveSizeRingOne() {
        final int five = 5;
        Squarelotron squarelotron = new Squarelotron(five);
        final int[][] expected = {
                {21, 22, 23, 24, 25},
                {16, 7, 8, 9, 20},
                {11, 12, 13, 14, 15},
                {6, 17, 18, 19, 10},
                {1, 2, 3, 4, 5}};
        assertArrayEquals(expected, squarelotron.upsideDownFlip(1).getSquarelotronMatrix());
    }

    /**
     * Squarelotron Upside Down Flip.
     */
    @Test
    public void testUpsideDownFlipSizeThreeRingTwo() {
        final int two = 2;
        final int three = 3;
        Squarelotron squarelotron = new Squarelotron(three);
        final int[][] expected = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        assertArrayEquals(expected, squarelotron.upsideDownFlip(two).getSquarelotronMatrix());
    }

    /**
     * Squarelotron Upside Down Flip.
     */
    @Test
    public void testUpsideDownFlipFourSizeRingTwo() {
        final int two = 2;
        final int four = 4;
        Squarelotron squarelotron = new Squarelotron(four);
        final int[][] expected = {{1, 2, 3, 4}, {5, 10, 11, 8}, {9, 6, 7, 12}, {13, 14, 15, 16}};
        assertArrayEquals(expected, squarelotron.upsideDownFlip(two).getSquarelotronMatrix());
    }

    /**
     * Squarelotron Upside Down Flip.
     */
    @Test
    public void testUpsideDownFlipFiveSizeRingTwo() {
        final int two = 2;
        final int five = 5;
        Squarelotron squarelotron = new Squarelotron(five);
        final int[][] expected = {
                {1, 2, 3, 4, 5},
                {6, 17, 18, 19, 10},
                {11, 12, 13, 14, 15},
                {16, 7, 8, 9, 20},
                {21, 22, 23, 24, 25}};
        assertArrayEquals(expected, squarelotron.upsideDownFlip(two).getSquarelotronMatrix());
    }

    /**
     * Squarelotron Main Diagonal Flip.
     */
    @Test
    public void testMainDiagonalFlipSizeThreeRingOne() {
        final int three = 3;
        Squarelotron squarelotron = new Squarelotron(three);
        final int[][] expected = {{1, 4, 7}, {2, 5, 8}, {3, 6, 9}};
        assertArrayEquals(expected, squarelotron.mainDiagonalFlip(1).getSquarelotronMatrix());
    }

    /**
     * Squarelotron Main Diagonal Flip.
     */
    @Test
    public void testMainDiagonalFlipFourSizeRingOne() {
        final int four = 4;
        Squarelotron squarelotron = new Squarelotron(four);
        final int[][] expected = {{1, 5, 9, 13}, {2, 6, 7, 14}, {3, 10, 11, 15}, {4, 8, 12, 16}};
        assertArrayEquals(expected, squarelotron.mainDiagonalFlip(1).getSquarelotronMatrix());
    }

    /**
     * Squarelotron Main Diagonal Flip.
     */
    @Test
    public void testMainDiagonalFlipFiveSizeRingOne() {
        final int five = 5;
        Squarelotron squarelotron = new Squarelotron(five);
        final int[][] expected = {
                {1, 6, 11, 16, 21},
                {2, 7, 8, 9, 22},
                {3, 12, 13, 14, 23},
                {4, 17, 18, 19, 24},
                {5, 10, 15, 20, 25}};
        assertArrayEquals(expected, squarelotron.mainDiagonalFlip(1).getSquarelotronMatrix());
    }

    /**
     * Squarelotron Main Diagonal Flip.
     */
    @Test
    public void testMainDiagonalFlipSizeThreeRingTwo() {
        final int two = 2;
        final int three = 3;
        Squarelotron squarelotron = new Squarelotron(three);
        final int[][] expected = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        assertArrayEquals(expected, squarelotron.mainDiagonalFlip(two).getSquarelotronMatrix());
    }

    /**
     * Squarelotron Main Diagonal Flip.
     */
    @Test
    public void testMainDiagonalFlipFourSizeRingTwo() {
        final int two = 2;
        final int four = 4;
        Squarelotron squarelotron = new Squarelotron(four);
        final int[][] expected = {{1, 2, 3, 4}, {5, 6, 10, 8}, {9, 7, 11, 12}, {13, 14, 15, 16}};
        assertArrayEquals(expected, squarelotron.mainDiagonalFlip(two).getSquarelotronMatrix());
    }

    /**
     * Squarelotron Main Diagonal Flip.
     */
    @Test
    public void testMainDiagonalFlipFiveSizeRingTwo() {
        final int two = 2;
        final int five = 5;
        Squarelotron squarelotron = new Squarelotron(five);
        final int[][] expected = {
                {1, 2, 3, 4, 5},
                {6, 7, 12, 17, 10},
                {11, 8, 13, 18, 15},
                {16, 9, 14, 19, 20},
                {21, 22, 23, 24, 25}};
        assertArrayEquals(expected, squarelotron.mainDiagonalFlip(two).getSquarelotronMatrix());
    }

    /**
     * Squarelotron Rotate 90 degrees.
     */
    @Test
    public void testRotateRightSizeTwoOneTurn() {
        final int two = 2;
        Squarelotron squarelotron = new Squarelotron(two);
        final int[][] expected = {{3, 1}, {4, 2}};
        squarelotron.rotateRight(1);
        assertArrayEquals(expected, squarelotron.getSquarelotronMatrix());
    }

    /**
     * Squarelotron Rotate 90 degrees.
     */
    @Test
    public void testRotateRightSizeTwoTwoTurns() {
        final int two = 2;
        Squarelotron squarelotron = new Squarelotron(two);
        final int[][] expected = {{4, 3}, {2, 1}};
        squarelotron.rotateRight(two);
        assertArrayEquals(expected, squarelotron.getSquarelotronMatrix());
    }

    /**
     * Squarelotron Rotate 90 degrees.
     */
    @Test
    public void testRotateRightSizeTwoMinusOneTurn() {
        final int two = 2;
        final int minusOne = -1;
        Squarelotron squarelotron = new Squarelotron(two);
        final int[][] expected = {{2, 4}, {1, 3}};
        squarelotron.rotateRight(minusOne);
        assertArrayEquals(expected, squarelotron.getSquarelotronMatrix());
    }

    /**
     * Squarelotron Rotate 90 degrees.
     */
    @Test
    public void testRotateRightSizeTwoMinusTwoTurns() {
        final int two = 2;
        final int minusTwo = -2;
        Squarelotron squarelotron = new Squarelotron(two);
        final int[][] expected = {{4, 3}, {2, 1}};
        squarelotron.rotateRight(minusTwo);
        assertArrayEquals(expected, squarelotron.getSquarelotronMatrix());
    }

    /**
     * Squarelotron Rotate 90 degrees.
     */
    @Test
    public void testRotateRightSizeTwoMinusFiveTurns() {
        final int two = 2;
        final int minusFive = -5;
        Squarelotron squarelotron = new Squarelotron(two);
        final int[][] expected = {{2, 4}, {1, 3}};
        squarelotron.rotateRight(minusFive);
        assertArrayEquals(expected, squarelotron.getSquarelotronMatrix());
    }

    /**
     * Squarelotron Rotate 90 degrees.
     */
    @Test
    public void testRotateRightSizeTwoEightTurns() {
        final int two = 2;
        final int eight = 8;
        Squarelotron squarelotron = new Squarelotron(two);
        final int[][] expected = {{1, 2}, {3, 4}};
        squarelotron.rotateRight(eight);
        assertArrayEquals(expected, squarelotron.getSquarelotronMatrix());
    }
}
