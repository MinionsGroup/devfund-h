package org.minions.devfund.noemiguzman;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

/**
 * class to test Squarelotron.
 */

public class SquarelotronTest {

    /**
     * Method to test size.
     */
    @Test
    public void testSquarelotronConstructorSize() {
        final int dimension = 4;
        assertEquals(dimension, new Squarelotron(dimension).getSize());
    }

    /**
     * Method to test Constructor Element.
     */
    @Test
    public void testSquarelotronConstructorElement() {
        final int dimension = 1;
        final int[][] expected = {{1}};
        assertArrayEquals(expected, new Squarelotron(dimension).getSquarelotron());
    }

    /**
     * Method to test Constructor Elements.
     */
    @Test
    public void testSquarelotronConstructorElements() {
        final int dimension = 4;
        final int[][] expected = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        assertArrayEquals(expected, new Squarelotron(dimension).getSquarelotron());
    }

    /**
     * Method to test Rotate Right1.
     */
    @Test
    public void testRotateRight1() {
        final int dimension = 4;
        final int numberOfTurn = 1;
        Squarelotron squarelotron = new Squarelotron(dimension);
        squarelotron.rotateRight(numberOfTurn);
        final int[][] expected = {{13, 9, 5, 1}, {14, 10, 6, 2}, {15, 11, 7, 3}, {16, 12, 8, 4}};
        assertArrayEquals(expected, squarelotron.getSquarelotron());
    }

    /**
     * Method to test Rotate Right-1.
     */
    @Test
    public void testRotateRightNegative1() {
        final int dimension = 4;
        Squarelotron squarelotron = new Squarelotron(dimension);
        squarelotron.rotateRight(-1);
        final int[][] expected = {{4, 8, 12, 16}, {3, 7, 11, 15}, {2, 6, 10, 14}, {1, 5, 9, 13}};
        assertArrayEquals(expected, squarelotron.getSquarelotron());
    }

    /**
     * Method to test Rotate Right 2.
     */
    @Test
    public void testRotateRight2() {
        final int numberOfTurns2 = 2;
        final int dimension = 4;
        Squarelotron squarelotron = new Squarelotron(dimension);
        squarelotron.rotateRight(numberOfTurns2);
        final int[][] expected = {{16, 15, 14, 13}, {12, 11, 10, 9}, {8, 7, 6, 5}, {4, 3, 2, 1}};
        assertArrayEquals(expected, squarelotron.getSquarelotron());
    }

    /**
     * Method to test Rotate Right -2.
     */
    @Test
    public void testRotateRightNegative2() {
        final int numberOfTurns2 = 2;
        final int dimension = 4;
        Squarelotron squarelotron = new Squarelotron(dimension);
        squarelotron.rotateRight(-numberOfTurns2);
        final int[][] expected = {{16, 15, 14, 13}, {12, 11, 10, 9}, {8, 7, 6, 5}, {4, 3, 2, 1}};
        assertArrayEquals(expected, squarelotron.getSquarelotron());
    }

    /**
     * Method to test Rotate Right 3.
     */
    @Test
    public void testRotateRight3() {
        final int numberOfTurns3 = 3;
        final int dimension = 4;
        Squarelotron squarelotron = new Squarelotron(dimension);
        squarelotron.rotateRight(numberOfTurns3);
        final int[][] expected = {{4, 8, 12, 16}, {3, 7, 11, 15}, {2, 6, 10, 14}, {1, 5, 9, 13}};
        assertArrayEquals(expected, squarelotron.getSquarelotron());
    }

    /**
     * Method to test Rotate Right -3.
     */
    @Test
    public void testRotateRightNegative3() {
        final int numberOfTurns3 = 3;
        final int dimension = 4;
        Squarelotron squarelotron = new Squarelotron(dimension);

        squarelotron.rotateRight(-numberOfTurns3);
        final int[][] expected = {{13, 9, 5, 1}, {14, 10, 6, 2}, {15, 11, 7, 3}, {16, 12, 8, 4}};
        assertArrayEquals(expected, squarelotron.getSquarelotron());
    }

    /**
     * Method to test Rotate Right 4.
     */
    @Test
    public void testRotateRight4() {
        final int dimension = 4;
        Squarelotron squarelotron = new Squarelotron(dimension);
        squarelotron.rotateRight(dimension);
        final int[][] expected = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        assertArrayEquals(expected, squarelotron.getSquarelotron());
    }

    /**
     * Method to test Rotate Right 5.
     */
    @Test
    public void testRotateRight5() {
        final int dimension = 4;
        final int size5 = 5;
        Squarelotron squarelotron = new Squarelotron(dimension);
        squarelotron.rotateRight(size5);
        final int[][] expected = {{13, 9, 5, 1}, {14, 10, 6, 2}, {15, 11, 7, 3}, {16, 12, 8, 4}};
        assertArrayEquals(expected, squarelotron.getSquarelotron());
    }

    /**
     * Method to test Rotate Right 6.
     */
    @Test
    public void testRotateRight6() {
        final int dimension = 4;
        final int numberOfTurns6 = 6;
        Squarelotron squarelotron = new Squarelotron(dimension);
        squarelotron.rotateRight(numberOfTurns6);
        final int[][] expected = {{16, 15, 14, 13}, {12, 11, 10, 9}, {8, 7, 6, 5}, {4, 3, 2, 1}};
        assertArrayEquals(expected, squarelotron.getSquarelotron());
    }

    /**
     * Method to test MainDiagonalFlip Dimension Two.
     */
    @Test
    public void testMainDiagonalFlipDimensionTwo() {
        final int dimension = 4;
        final int ring = 2;
        Squarelotron squarelotron = new Squarelotron(dimension);
        final int[][] expected = {{1, 2, 3, 4}, {5, 6, 10, 8}, {9, 7, 11, 12}, {13, 14, 15, 16}};
        assertArrayEquals(expected, squarelotron.mainDiagonalFlip(ring).getSquarelotron());
    }

    /**
     * Method to test MainDiagonalFlip Dimension FiveRingThree.
     */
    @Test
    public void testMainDiagonalFlipDimensionFiveRingThree() {
        final int dimension = 5;
        final int ring = 3;
        Squarelotron squarelotron = new Squarelotron(dimension);
        final int[][] expected = {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15}, {16, 17, 18, 19, 20},
                {21, 22, 23, 24, 25}};
        assertArrayEquals(expected, squarelotron.mainDiagonalFlip(ring).getSquarelotron());
    }

    /**
     * Method to test UpsideDownFlip dimension four.
     */
    @Test
    public void testUpsideDownFlipDimensionFour() {
        final int dimension = 4;
        Squarelotron squarelotron = new Squarelotron(dimension);
        final int ring2 = 2;
        // 4 by 4, but flip inner ring
        final int[][] test4 = {{1, 2, 3, 4}, {5, 10, 11, 8}, {9, 6, 7, 12}, {13, 14, 15, 16}};
        assertArrayEquals(test4, squarelotron.upsideDownFlip(ring2).getSquarelotron());
        // 4 by 4, but flip outer ring
        final int[][] test5 = {{13, 14, 15, 16}, {9, 6, 7, 12}, {5, 10, 11, 8}, {1, 2, 3, 4}};
        final int ring1 = 1;
        assertArrayEquals(test5, squarelotron.upsideDownFlip(ring1).getSquarelotron());
    }

    /**
     * Method to test UpsideDownFlip new object.
     */
    @Test
    public void testUpsideDownFlipNewObject() {
        final int dimension = 4;
        final int ring = 1;
        Squarelotron squarelotron = new Squarelotron(dimension);
        final int[][] expectedValue = {{13, 14, 15, 16}, {9, 6, 7, 12}, {5, 10, 11, 8}, {1, 2, 3, 4}};
        assertArrayEquals(expectedValue, squarelotron.upsideDownFlip(ring).getSquarelotron());
    }

    /**
     * Method to test UpsideDownFlip dimension three.
     */
    @Test
    public void testUpsideDownFlipDimensionThree() {
        final int dimension = 3;
        final int ring = 1;
        Squarelotron squarelotron = new Squarelotron(dimension);
        final int[][] expectedValue = {{7, 8, 9}, {4, 5, 6}, {1, 2, 3}};
        assertArrayEquals(expectedValue, squarelotron.upsideDownFlip(ring).getSquarelotron());
    }

    /**
     * Method to test UpsideDownFlip dimension one.
     */
    @Test
    public void testUpsideDownFlipDimensionOne() {
        final int dimension = 1;
        final int ring = 1;
        Squarelotron squarelotron = new Squarelotron(dimension);
        final int[][] expectedValue = {{1}};
        assertArrayEquals(expectedValue, squarelotron.upsideDownFlip(ring).getSquarelotron());
    }

    /**
     * Method to test MainDiagonalFlip new object.
     */
    @Test
    public void testMainDiagonalFlipNewObject() {
        final int dimension = 3;
        final int ring = 1;
        Squarelotron squarelotron = new Squarelotron(dimension);
        final int[][] expectedValue = {{1, 4, 7}, {2, 5, 8}, {3, 6, 9}};
        assertArrayEquals(expectedValue, squarelotron.mainDiagonalFlip(ring).getSquarelotron());
    }

    /**
     * Method to test MainDiagonalFlip Dimension Five Ring One.
     */
    @Test
    public void testMainDiagonalFlipDimensionFiveRingOne() {
        final int dimension = 5;
        final int ring = 1;
        Squarelotron squarelotron = new Squarelotron(dimension);
        final int[][] expectedValue = {{1, 6, 11, 16, 21}, {2, 7, 8, 9, 22}, {3, 12, 13, 14, 23}, {4, 17, 18, 19, 24},
                {5, 10, 15, 20, 25}};
        assertArrayEquals(expectedValue, squarelotron.mainDiagonalFlip(ring).getSquarelotron());
    }

    /**
     * Method to test MainDiagonalFlip Dimension Five Ring two.
     */
    @Test
    public void testMainDiagonalFlipDimensionFiveRingTwo() {
        final int dimension = 5;
        final int ring = 2;
        Squarelotron squarelotron = new Squarelotron(dimension);
        final int[][] expectedValue = {{1, 2, 3, 4, 5}, {6, 7, 12, 17, 10}, {11, 8, 13, 18, 15}, {16, 9, 14, 19, 20},
                {21, 22, 23, 24, 25}};
        assertArrayEquals(expectedValue, squarelotron.mainDiagonalFlip(ring).getSquarelotron());
    }
}
