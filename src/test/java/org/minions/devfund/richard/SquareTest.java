package org.minions.devfund.richard;

import org.junit.Test;
import org.minions.devfund.richard.square.Square;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

/**
 * Class.
 */
public class SquareTest {

    private static final int ONE = 1;
    private static final int TWO = 2;
    private static final int THREE = 3;
    private static final int FOUR = 4;
    private static final int FIVE = 5;

    /**
     *
     */
    @Test
    public void testPrintMethod() {
        Square mySquare = new Square(FOUR);
        final String expectedValue = "1 2 3 4 "
                + "5 6 7 8 "
                + "9 10 11 12 "
                + "13 14 15 16 ";
        assertEquals(expectedValue, mySquare.print());
    }

    /**
     *
     */
    @Test
    public void testUpsideDownFlipMethod() {
        Square mySquare = new Square(FOUR);
        final String expectedValue = "13 14 15 16 "
                + "9 6 7 12 "
                + "5 10 11 8 "
                + "1 2 3 4 ";
        assertEquals(expectedValue, mySquare.upsideDownFlip(ONE).print());
    }

    /**
     *
     */
    @Test
    public void testMainDiagonalFlipMethod() {
        Square mySquare = new Square(FOUR);
        final String expectedValue = "1 5 9 13 "
                + "2 6 7 14 "
                + "3 10 11 15 "
                + "4 8 12 16 ";
        assertEquals(expectedValue, mySquare.mainDiagonalFlip(ONE).print());
    }

    /**
     *
     */
    @Test
    public void testRotateRightMethod() {
        Square mySquare = new Square(FOUR);
        final String expectedValue = "13 9 5 1 "
                + "14 10 6 2 "
                + "15 11 7 3 "
                + "16 12 8 4 ";
        assertEquals(expectedValue, mySquare.rotateRight(ONE).print());
    }

    /**
     *
     */
    @Test
    public void testConstructorFillsArray() {
        Square square = new Square(TWO);
        final int[][] expected = new int[][]{{1, 2}, {3, 4}};
        assertArrayEquals(expected, square.getMatrix());
    }

    /**
     *
     */
    @Test
    public void testUpsideDownFlipSizeTwoRingOne() {
        Square square = new Square(TWO);
        final int[][] expected = {{3, 4}, {1, 2}};
        assertArrayEquals(expected, square.upsideDownFlip(1).getMatrix());
    }

    /**
     *
     */
    @Test
    public void testUpsideDownFlipSizeThreeRingOne() {
        Square square = new Square(THREE);
        final int[][] expected = {{7, 8, 9}, {4, 5, 6}, {1, 2, 3}};
        assertArrayEquals(expected, square.upsideDownFlip(1).getMatrix());
    }

    /**
     *
     */
    @Test
    public void testUpsideDownFlipFourSizeRingOne() {
        Square square = new Square(FOUR);
        final int[][] expected = {{13, 14, 15, 16}, {9, 6, 7, 12}, {5, 10, 11, 8}, {1, 2, 3, 4}};
        assertArrayEquals(expected, square.upsideDownFlip(1).getMatrix());
    }

    /**
     *
     */
    @Test
    public void testUpsideDownFlipFiveSizeRingOne() {
        Square square = new Square(FIVE);
        final int[][] expected = {
                {21, 22, 23, 24, 25},
                {16, 7, 8, 9, 20},
                {11, 12, 13, 14, 15},
                {6, 17, 18, 19, 10},
                {1, 2, 3, 4, 5}};
        assertArrayEquals(expected, square.upsideDownFlip(1).getMatrix());
    }

    /**
     *
     */
    @Test
    public void testUpsideDownFlipSizeThreeRingTwo() {
        Square square = new Square(THREE);
        final int[][] expected = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        assertArrayEquals(expected, square.upsideDownFlip(TWO).getMatrix());
    }

    /**
     *
     */
    @Test
    public void testUpsideDownFlipFourSizeRingTwo() {
        Square square = new Square(FOUR);
        final int[][] expected = {{1, 2, 3, 4}, {5, 10, 11, 8}, {9, 6, 7, 12}, {13, 14, 15, 16}};
        assertArrayEquals(expected, square.upsideDownFlip(TWO).getMatrix());
    }

    /**
     *
     */
    @Test
    public void testUpsideDownFlipFiveSizeRingTwo() {
        Square square = new Square(FIVE);
        final int[][] expected = {
                {1, 2, 3, 4, 5},
                {6, 17, 18, 19, 10},
                {11, 12, 13, 14, 15},
                {16, 7, 8, 9, 20},
                {21, 22, 23, 24, 25}};
        assertArrayEquals(expected, square.upsideDownFlip(TWO).getMatrix());
    }

    /**
     *
     */
    @Test
    public void testMainDiagonalFlipSizeThreeRingOne() {
        Square square = new Square(THREE);
        final int[][] expected = {{1, 4, 7}, {2, 5, 8}, {3, 6, 9}};
        assertArrayEquals(expected, square.mainDiagonalFlip(ONE).getMatrix());
    }

    /**
     *
     */
    @Test
    public void testMainDiagonalFlipFourSizeRingOne() {
        Square square = new Square(FOUR);
        final int[][] expected = {{1, 5, 9, 13}, {2, 6, 7, 14}, {3, 10, 11, 15}, {4, 8, 12, 16}};
        assertArrayEquals(expected, square.mainDiagonalFlip(ONE).getMatrix());
    }

    /**
     *
     */
    @Test
    public void testMainDiagonalFlipFiveSizeRingOne() {
        Square square = new Square(FIVE);
        final int[][] expected = {
                {1, 6, 11, 16, 21},
                {2, 7, 8, 9, 22},
                {3, 12, 13, 14, 23},
                {4, 17, 18, 19, 24},
                {5, 10, 15, 20, 25}};
        assertArrayEquals(expected, square.mainDiagonalFlip(1).getMatrix());
    }

    /**
     *
     */
    @Test
    public void testMainDiagonalFlipSizeThreeRingTwo() {
        Square square = new Square(THREE);
        final int[][] expected = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        assertArrayEquals(expected, square.mainDiagonalFlip(TWO).getMatrix());
    }

    /**
     *
     */
    @Test
    public void testMainDiagonalFlipFourSizeRingTwo() {
        Square square = new Square(FOUR);
        final int[][] expected = {{1, 2, 3, 4}, {5, 6, 10, 8}, {9, 7, 11, 12}, {13, 14, 15, 16}};
        assertArrayEquals(expected, square.mainDiagonalFlip(TWO).getMatrix());
    }

    /**
     *
     */
    @Test
    public void testMainDiagonalFlipFiveSizeRingTwo() {
        Square square = new Square(FIVE);
        final int[][] expected = {
                {1, 2, 3, 4, 5},
                {6, 7, 12, 17, 10},
                {11, 8, 13, 18, 15},
                {16, 9, 14, 19, 20},
                {21, 22, 23, 24, 25}};
        assertArrayEquals(expected, square.mainDiagonalFlip(TWO).getMatrix());
    }

    /**
     *
     */
    @Test
    public void testRotateRightSizeTwoOneTurn() {
        Square square = new Square(TWO);
        final int[][] expected = {{3, 1}, {4, 2}};
        assertArrayEquals(expected, square.rotateRight(ONE).getMatrix());
    }

    /**
     *
     */
    @Test
    public void testRotateRightSizeTwoTwoTurns() {
        final int[][] expected = {{4, 3}, {2, 1}};
        Square square = new Square(TWO);
        assertArrayEquals(expected, square.rotateRight(TWO).getMatrix());
    }

    /**
     *
     */
    @Test
    public void testRotateRightSizeTwoMinusOneTurn() {
        Square square = new Square(TWO);
        final int minusOne = -1;
        final int[][] expected = {{2, 4}, {1, 3}};
        assertArrayEquals(expected, square.rotateRight(minusOne).getMatrix());
    }

    /**
     *
     */
    @Test
    public void testRotateRightSizeTwoMinusTwoTurns() {
        Square square = new Square(TWO);
        final int minusTwo = -2;
        final int[][] expected = {{4, 3}, {2, 1}};
        assertArrayEquals(expected, square.rotateRight(minusTwo).getMatrix());
    }

    /**
     *
     */
    @Test
    public void testRotateRightSizeTwoMinusFiveTurns() {
        Square square = new Square(TWO);
        final int minusFive = -5;
        final int[][] expected = {{2, 4}, {1, 3}};
        assertArrayEquals(expected, square.rotateRight(minusFive).getMatrix());
    }

    /**
     *
     */
    @Test
    public void testRotateRightSizeTwoEightTurns() {
        Square square = new Square(TWO);
        final int eight = 8;
        final int[][] expected = {{1, 2}, {3, 4}};
        assertArrayEquals(expected, square.rotateRight(eight).getMatrix());
    }
}
