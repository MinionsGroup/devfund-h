package org.minions.devfund.abel;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertNull;

/**
 * Class for Squarelotron tests.
 */
public class SquarelotronTest {

    private static final int ONE = 1;
    private static final int MINUS_ONE = -1;
    private static final int MINUS_TWO = -2;
    private static final int TWO = 2;
    private static final int THREE = 3;
    private static final int FOUR = 4;
    private static final int FIVE = 5;

    /**
     * Squarelotron Constructor initialize.
     */
    @Test
    public void testConstructorFillsArray() {
        Squarelotron squarelotron = new Squarelotron(TWO);
        final int[][] expected = new int[][]{{1, 2}, {3, 4}};
        assertArrayEquals(expected, squarelotron.getSquarelotron());
    }

    /**
     * Squarelotron Constructor initialize.
     */
    @Test
    public void testConstructorFillsArrayNull() {
        final int[][] new2dArray = null;
        Squarelotron squarelotron = new Squarelotron(new2dArray);
        assertNull(squarelotron.getSquarelotron());
    }

    /**
     * Squarelotron Upside Down Flip.
     */
    @Test
    public void testUpsideDownFlipSizeTwoRingOne() {
        Squarelotron squarelotron = new Squarelotron(TWO);
        final int[][] expected = new int[][]{{3, 4}, {1, 2}};
        assertArrayEquals(expected, squarelotron.upsideDownFlip(ONE).getSquarelotron());
    }

    /**
     * Squarelotron Upside Down Flip.
     */
    @Test
    public void testUpsideDownFlipSizeThreeRingOne() {
        Squarelotron squarelotron = new Squarelotron(THREE);
        final int[][] expected = new int[][]{{7, 8, 9}, {4, 5, 6}, {1, 2, 3}};
        assertArrayEquals(expected, squarelotron.upsideDownFlip(ONE).getSquarelotron());
    }

    /**
     * Squarelotron Upside Down Flip.
     */
    @Test
    public void testUpsideDownFlipFourSizeRingOne() {
        Squarelotron squarelotron = new Squarelotron(FOUR);
        final int[][] expected = new int[][]{{13, 14, 15, 16}, {9, 6, 7, 12}, {5, 10, 11, 8}, {1, 2, 3, 4}};
        assertArrayEquals(expected, squarelotron.upsideDownFlip(ONE).getSquarelotron());
    }

    /**
     * Squarelotron Upside Down Flip.
     */
    @Test
    public void testUpsideDownFlipFiveSizeRingOne() {
        Squarelotron squarelotron = new Squarelotron(FIVE);
        final int[][] expected = new int[][]{
                {21, 22, 23, 24, 25},
                {16, 7, 8, 9, 20},
                {11, 12, 13, 14, 15},
                {6, 17, 18, 19, 10},
                {1, 2, 3, 4, 5}};
        assertArrayEquals(expected, squarelotron.upsideDownFlip(ONE).getSquarelotron());
    }

    /**
     * Squarelotron Upside Down Flip.
     */
    @Test
    public void testUpsideDownFlipSizeThreeRingTwo() {
        Squarelotron squarelotron = new Squarelotron(THREE);
        final int[][] expected = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        assertArrayEquals(expected, squarelotron.upsideDownFlip(TWO).getSquarelotron());
    }

    /**
     * Squarelotron Upside Down Flip.
     */
    @Test
    public void testUpsideDownFlipFourSizeRingTwo() {
        Squarelotron squarelotron = new Squarelotron(FOUR);
        final int[][] expected = new int[][]{{1, 2, 3, 4}, {5, 10, 11, 8}, {9, 6, 7, 12}, {13, 14, 15, 16}};
        assertArrayEquals(expected, squarelotron.upsideDownFlip(TWO).getSquarelotron());
    }

    /**
     * Squarelotron Upside Down Flip.
     */
    @Test
    public void testUpsideDownFlipFiveSizeRingTwo() {
        Squarelotron squarelotron = new Squarelotron(FIVE);
        final int[][] expected = new int[][]{
                {1, 2, 3, 4, 5},
                {6, 17, 18, 19, 10},
                {11, 12, 13, 14, 15},
                {16, 7, 8, 9, 20},
                {21, 22, 23, 24, 25}};
        assertArrayEquals(expected, squarelotron.upsideDownFlip(TWO).getSquarelotron());
    }

    /**
     * Squarelotron Main Diagonal Flip.
     */
    @Test
    public void testMainDiagonalFlipSizeThreeRingOne() {
        Squarelotron squarelotron = new Squarelotron(THREE);
        final int[][] expected = new int[][]{{1, 4, 7}, {2, 5, 8}, {3, 6, 9}};
        assertArrayEquals(expected, squarelotron.mainDiagonalFlip(ONE).getSquarelotron());
    }

    /**
     * Squarelotron Main Diagonal Flip.
     */
    @Test
    public void testMainDiagonalFlipFourSizeRingOne() {
        Squarelotron squarelotron = new Squarelotron(FOUR);
        final int[][] expected = new int[][]{{1, 5, 9, 13}, {2, 6, 7, 14}, {3, 10, 11, 15}, {4, 8, 12, 16}};
        assertArrayEquals(expected, squarelotron.mainDiagonalFlip(ONE).getSquarelotron());
    }

    /**
     * Squarelotron Main Diagonal Flip.
     */
    @Test
    public void testMainDiagonalFlipFiveSizeRingOne() {
        Squarelotron squarelotron = new Squarelotron(FIVE);
        final int[][] expected = new int[][]{
                {1, 6, 11, 16, 21},
                {2, 7, 8, 9, 22},
                {3, 12, 13, 14, 23},
                {4, 17, 18, 19, 24},
                {5, 10, 15, 20, 25}};
        assertArrayEquals(expected, squarelotron.mainDiagonalFlip(ONE).getSquarelotron());
    }

    /**
     * Squarelotron Main Diagonal Flip.
     */
    @Test
    public void testMainDiagonalFlipSizeThreeRingTwo() {
        Squarelotron squarelotron = new Squarelotron(THREE);
        final int[][] expected = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        assertArrayEquals(expected, squarelotron.mainDiagonalFlip(TWO).getSquarelotron());
    }

    /**
     * Squarelotron Main Diagonal Flip.
     */
    @Test
    public void testMainDiagonalFlipFourSizeRingTwo() {
        Squarelotron squarelotron = new Squarelotron(FOUR);
        final int[][] expected = new int[][]{{1, 2, 3, 4}, {5, 6, 10, 8}, {9, 7, 11, 12}, {13, 14, 15, 16}};
        assertArrayEquals(expected, squarelotron.mainDiagonalFlip(TWO).getSquarelotron());
    }

    /**
     * Squarelotron Main Diagonal Flip.
     */
    @Test
    public void testMainDiagonalFlipFiveSizeRingTwo() {
        Squarelotron squarelotron = new Squarelotron(FIVE);
        final int[][] expected = new int[][]{
                {1, 2, 3, 4, 5},
                {6, 7, 12, 17, 10},
                {11, 8, 13, 18, 15},
                {16, 9, 14, 19, 20},
                {21, 22, 23, 24, 25}};
        assertArrayEquals(expected, squarelotron.mainDiagonalFlip(TWO).getSquarelotron());
    }

    /**
     * Squarelotron Rotate 90 degrees.
     */
    @Test
    public void testRotateRightSizeTwoOneTurn() {
        Squarelotron squarelotron = new Squarelotron(TWO);
        final int[][] expected = new int[][]{{3, 1}, {4, 2}};
        squarelotron.rotateRight(ONE);
        assertArrayEquals(expected, squarelotron.getSquarelotron());
    }

    /**
     * Squarelotron Rotate 90 degrees.
     */
    @Test
    public void testRotateRightSizeTwoTwoTurns() {
        Squarelotron squarelotron = new Squarelotron(TWO);
        final int[][] expected = new int[][]{{4, 3}, {2, 1}};
        squarelotron.rotateRight(TWO);
        assertArrayEquals(expected, squarelotron.getSquarelotron());
    }

    /**
     * Squarelotron Rotate 90 degrees.
     */
    @Test
    public void testRotateRightSizeTwoMinusOneTurn() {
        Squarelotron squarelotron = new Squarelotron(TWO);
        final int[][] expected = new int[][]{{2, 4}, {1, 3}};
        squarelotron.rotateRight(MINUS_ONE);
        assertArrayEquals(expected, squarelotron.getSquarelotron());
    }

    /**
     * Squarelotron Rotate 90 degrees.
     */
    @Test
    public void testRotateRightSizeTwoMinusTwoTurns() {
        Squarelotron squarelotron = new Squarelotron(TWO);
        final int[][] expected = new int[][]{{4, 3}, {2, 1}};
        squarelotron.rotateRight(MINUS_TWO);
        assertArrayEquals(expected, squarelotron.getSquarelotron());
    }
}
