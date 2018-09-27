package org.minions.devfund.benjamin;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

/**
 * Class Squarelotron unit tests.
 */
public class SquarelotronTest {
    /**
     * Unit test for UpsideDownFlip function.
     */
    @Test
    public void testUpsideDownFlipDimensionOneNewObject() {
        final int ringOne = 1;
        final int sizeOne = 1;
        Squarelotron squarelotron = new Squarelotron(sizeOne);
        final int[][] expected = {{1}};
        assertArrayEquals(expected, squarelotron.upsideDownFlip(ringOne).currentStatus());
    }
    /**
     * Unit test for MainDiagonalFlip function.
     */
    @Test
    public void testMainDiagonalFlipDimensionFiveRingThree() {
        final int sizeFive = 5;
        final int ringThree = 3;
        Squarelotron squarelotron = new Squarelotron(sizeFive);
        final int[][] expected = {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15}, {16, 17, 18, 19, 20}, {21, 22, 23, 24, 25}};
        assertArrayEquals(expected, squarelotron.mainDiagonalFlip(ringThree).currentStatus());
    }
    /**
     * Unit test for MainDiagonalFlip function.
     */
    @Test
    public void testMainDiagonalFlipNewObject() {
        final int sizeFive = 5;
        final int ringTwo = 2;
        Squarelotron squarelotron = new Squarelotron(sizeFive);
        final int[][] expected = {{1, 2, 3, 4, 5}, {6, 7, 12, 17, 10},
                {11, 8, 13, 18, 15}, {16, 9, 14, 19, 20}, {21, 22, 23, 24, 25}};
        assertArrayEquals(expected, squarelotron.mainDiagonalFlip(ringTwo).currentStatus());
    }
    /**
     * Unit test for rotateRight function.
     */
    @Test
    public void testRotateRight5() {
        final int sizeTwo = 2;
        final int turnsTwo = 2;
        final int[][] expected = {{4, 3}, {2, 1}};
        Squarelotron squarelotron = new Squarelotron(sizeTwo);
        squarelotron.rotateRight(turnsTwo);
        assertArrayEquals(expected, squarelotron.currentStatus());
    }

    /**
     * Unit test for rotateRight function.
     */
    @Test
    public void testRotateRight6() {
        final int sizeThree = 3;
        final int turnsOne = 1;
        final int[][] expected = {{7, 4, 1}, {8, 5, 2}, {9, 6, 3}};
        Squarelotron squarelotron = new Squarelotron(sizeThree);
        squarelotron.rotateRight(turnsOne);
        assertArrayEquals(expected, squarelotron.currentStatus());
    }
    /**
     * Squarelotron constructor.
     */
    @Test
    public void testConstructorFillMatrix() {
        final int two = 2;
        Squarelotron squarelotron = new Squarelotron(two);
        final int[][] expected = new int[][]{{1, 2}, {3, 4}};
        assertArrayEquals(expected, squarelotron.currentStatus());
    }

    /**
     * Unit test for rotateRight function.
     */
    @Test
    public void testRotateRightSizeTwoTurnsTwo() {
        final int sizeTwo = 2;
        final int turnsTwo = 2;
        Squarelotron squarelotron = new Squarelotron(sizeTwo);
        final int[][] expected = {{4, 3}, {2, 1}};
        squarelotron.rotateRight(turnsTwo);
        assertArrayEquals(expected, squarelotron.currentStatus());
    }
    /**
     * Unit test for rotateRight function.
     */
    @Test
    public void testRotateRightSizeFourTurnsTwo() {
        final int sizeFour = 4;
        final int turnsTwo = 2;
        Squarelotron squarelotron = new Squarelotron(sizeFour);
        final int[][] expected = {{16, 15, 14, 13}, {12, 11, 10, 9}, {8, 7, 6, 5}, {4, 3, 2, 1}};
        squarelotron.rotateRight(turnsTwo);
        assertArrayEquals(expected, squarelotron.currentStatus());
    }
    /**
     * Unit test for rotateRight function.
     */
    @Test
    public void testRotateRightSizeThreeTurnsOne() {
        final int sizeThree = 3;
        final int turnsOne = 1;
        Squarelotron squarelotron = new Squarelotron(sizeThree);
        final int[][] expected = {{7, 4, 1}, {8, 5, 2}, {9, 6, 3}};
        squarelotron.rotateRight(turnsOne);
        assertArrayEquals(expected, squarelotron.currentStatus());
    }
    /**
     * Unit test for rotateRight function.
     */
    @Test
    public void testRotateRightSizeThreeTurnsMinusOne() {
        final int sizeThree = 3;
        final int turnsMinusOne = -1;
        Squarelotron squarelotron = new Squarelotron(sizeThree);
        final int[][] expected = {{3, 6, 9}, {2, 5, 8}, {1, 4, 7}};
        squarelotron.rotateRight(turnsMinusOne);
        assertArrayEquals(expected, squarelotron.currentStatus());
    }

    /**
     * Unit test for upsideDownFlip function.
     */
    @Test
    public void testUpsideDownFlipSizeThreeRingOne() {
        final int ringOne = 1;
        final int sizeThree = 3;
        Squarelotron squarelotron = new Squarelotron(sizeThree);
        final int[][] expected = {{7, 8, 9}, {4, 5, 6}, {1, 2, 3}};
        assertArrayEquals(expected, squarelotron.upsideDownFlip(ringOne).currentStatus());
    }
    /**
     * Unit test for upsideDownFlip function.
     */
    @Test
    public void testUpsideDownFlipSizeFourRingOne() {
        final int ringOne = 1;
        final int sizeFour = 4;
        Squarelotron squarelotron = new Squarelotron(sizeFour);
        final int[][] expected = {{13, 14, 15, 16}, {9, 6, 7, 12}, {5, 10, 11, 8}, {1, 2, 3, 4}};
        assertArrayEquals(expected, squarelotron.upsideDownFlip(ringOne).currentStatus());
    }
    /**
     * Unit test for upsideDownFlip function.
     */
    @Test
    public void testUpsideDownFlipFourSizeRingTwo() {
        final int ringTwo = 2;
        final int sizeFour = 4;
        Squarelotron squarelotron = new Squarelotron(sizeFour);
        final int[][] expected = {{1, 2, 3, 4}, {5, 10, 11, 8}, {9, 6, 7, 12}, {13, 14, 15, 16}};
        assertArrayEquals(expected, squarelotron.upsideDownFlip(ringTwo).currentStatus());
    }
    /**
     * Unit test for upsideDownFlip function.
     */
    @Test
    public void testUpsideDownFlipSizeFiveRingTwo() {
        final int ringTwo = 2;
        final int sizeFive = 5;
        Squarelotron squarelotron = new Squarelotron(sizeFive);
        final int[][] expected = {
                {1, 2, 3, 4, 5},
                {6, 17, 18, 19, 10},
                {11, 12, 13, 14, 15},
                {16, 7, 8, 9, 20},
                {21, 22, 23, 24, 25}};
        assertArrayEquals(expected, squarelotron.upsideDownFlip(ringTwo).currentStatus());
    }

    /**
     * Unit test for mainDiagonalFlip function.
     */
    @Test
    public void testMainDiagonalFlipSizeThreeRingOne() {
        final int sizeThree = 3;
        final int ringOne = 1;
        Squarelotron squarelotron = new Squarelotron(sizeThree);
        final int[][] expected = {{1, 4, 7}, {2, 5, 8}, {3, 6, 9}};
        assertArrayEquals(expected, squarelotron.mainDiagonalFlip(ringOne).currentStatus());
    }
    /**
     * Unit test for mainDiagonalFlip function.
     */
    @Test
    public void testMainDiagonalFlipSizeTwoRingOne() {
        final int sizeTwo = 2;
        final int ringOne = 1;
        Squarelotron squarelotron = new Squarelotron(sizeTwo);
        final int[][] expected = {{1, 3}, {2, 4}};
        assertArrayEquals(expected, squarelotron.mainDiagonalFlip(ringOne).currentStatus());
    }
    /**
     *  Unit test for Copy matrix function.
     */
    @Test
    public void testCopyMatrixNull() {
        final int sizeOne = 1;
        Squarelotron squarelotron = new Squarelotron(sizeOne);
        assertArrayEquals(new int[][]{}, squarelotron.copyMatrix(null));
    }
}
