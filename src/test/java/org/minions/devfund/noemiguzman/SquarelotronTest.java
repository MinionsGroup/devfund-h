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
     * Method to test size.
     */
    @Test
    public void testSquarelotronConstructorSize() {
        s4 = new Squarelotron(SIZE4);
        assertEquals(SIZE4, s4.getSize());
    }
    /**
     * Method to test Constructor Element.
     */
    @Test
    public void testSquarelotronConstructorElement() {
        s4 = new Squarelotron(1);
        final int[][] expected = {{1}};
        assertArrayEquals(expected, s4.getSquarelotron());
    }
    /**
     * Method to test Constructor Elements.
     */
    @Test
    public void testSquarelotronConstructorElements() {
        s4 = new Squarelotron(SIZE4);
        final int[][] expected = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        assertArrayEquals(expected, s4.getSquarelotron());
    }
    /**
     * Method to test Rotate Right1.
     */
    @Test
    public  void testRotateRight1() {
        s4 = new Squarelotron(SIZE4);
        s4.rotateRight(1);
        final int[][] expected = {{13, 9, 5, 1}, {14, 10, 6, 2}, {15, 11, 7, 3}, {16, 12, 8, 4}};
        assertArrayEquals(expected, s4.getSquarelotron());
    }
    /**
     * Method to test Rotate Right-1.
     */
    @Test
    public  void testRotateRightNegative1() {
        s4 = new Squarelotron(SIZE4);
        s4.rotateRight(-1);
        final int[][] expected = {{4, 8, 12, 16}, {3, 7, 11, 15}, {2, 6, 10, 14}, {1, 5, 9, 13}};
        assertArrayEquals(expected, s4.getSquarelotron());
    }

    /**
     * Method to test Rotate Right 2.
     */
    @Test
    public void testRotateRight2() {
        final int numberOfTurns2 = 2;
        s4 = new Squarelotron(SIZE4);
        s4.rotateRight(numberOfTurns2);
        final int[][] expected = {{16, 15, 14, 13}, {12, 11, 10, 9}, {8, 7, 6, 5}, {4, 3, 2, 1}};
        assertArrayEquals(expected, s4.getSquarelotron());
    }

    /**
     * Method to test Rotate Right -2.
     */
    @Test
    public void testRotateRightNegative2() {
        final int numberOfTurns2 = 2;
        s4 = new Squarelotron(SIZE4);
        s4.rotateRight(-numberOfTurns2);
        final int[][] expected = {{16, 15, 14, 13}, {12, 11, 10, 9}, {8, 7, 6, 5}, {4, 3, 2, 1}};
        assertArrayEquals(expected, s4.getSquarelotron());
    }
    /**
     * Method to test Rotate Right 3.
     */
    @Test
    public void testRotateRight3() {
        final int numberOfTurns3 = 3;
        s4 = new Squarelotron(SIZE4);
        s4.rotateRight(numberOfTurns3);
        final int[][] expected = {{4, 8, 12, 16}, {3, 7, 11, 15}, {2, 6, 10, 14}, {1, 5, 9, 13}};
        assertArrayEquals(expected, s4.getSquarelotron());
    }
    /**
     * Method to test Rotate Right -3.
     */
    @Test
    public void testRotateRightNegative3() {
        final int numberOfTurns3 = 3;
        s4 = new Squarelotron(SIZE4);
        s4.rotateRight(-numberOfTurns3);
        final int[][] expected = {{13, 9, 5, 1}, {14, 10, 6, 2}, {15, 11, 7, 3}, {16, 12, 8, 4}};
        assertArrayEquals(expected, s4.getSquarelotron());
    }
    /**
     * Method to test Rotate Right 4.
     */
    @Test
    public void testRotateRight4() {
        s4 = new Squarelotron(SIZE4);
        s4.rotateRight(SIZE4);
        final int[][] expected = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        assertArrayEquals(expected, s4.getSquarelotron());
    }
    /**
     * Method to test Rotate Right 5.
     */
    @Test
    public void testRotateRight5() {
        s4 = new Squarelotron(SIZE4);
        s4.rotateRight(SIZE5);
        final int[][] expected = {{13, 9, 5, 1}, {14, 10, 6, 2}, {15, 11, 7, 3}, {16, 12, 8, 4}};
        assertArrayEquals(expected, s4.getSquarelotron());
    }
    /**
     * Method to test Rotate Right 6.
     */
    @Test
    public void testRotateRight6() {
        final int numberOfTurns6 = 6;
        s4 = new Squarelotron(SIZE4);
        s4.rotateRight(numberOfTurns6);
        final int[][] expected = {{16, 15, 14, 13}, {12, 11, 10, 9}, {8, 7, 6, 5}, {4, 3, 2, 1}};
        assertArrayEquals(expected, s4.getSquarelotron());
    }
    /**
     * Method to test MainDiagonalFlip Dimension Two.
     */
    @Test
    public void testMainDiagonalFlipDimensionTwo() {
        s4 = new Squarelotron(SIZE4);
        final int ring2 = 2;
        final int[][] expected = {{1, 2, 3, 4}, {5, 6, 10, 8}, {9, 7, 11, 12}, {13, 14, 15, 16}};
        Squarelotron temp5 = s4.mainDiagonalFlip(ring2);
        assertArrayEquals(expected, temp5.getSquarelotron());
    }
    /**
     * Method to test MainDiagonalFlip Dimension FiveRingThree.
     */
    @Test
    public void testMainDiagonalFlipDimensionFiveRingThree() {
        s4 = new Squarelotron(SIZE5);
        final int ring3 = 3;
        final int[][] expected = {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15}, {16, 17, 18, 19, 20},
                {21, 22, 23, 24, 25}};
        Squarelotron temp5 = s4.mainDiagonalFlip(ring3);
        assertArrayEquals(expected, temp5.getSquarelotron());
    }
    /**
     * Method to test UpsideDownFlip dimension four.
     */
    @Test
    public void testUpsideDownFlipDimensionFour() {
        s4 = new Squarelotron(SIZE4);
        final int ring2 = 2;
        // 4 by 4, but flip inner ring
        final int[][] test4 = {{1, 2, 3, 4}, {5, 10, 11, 8}, {9, 6, 7, 12}, {13, 14, 15, 16}};
        Squarelotron temp4 = s4.upsideDownFlip(ring2);
        assertArrayEquals(test4, temp4.getSquarelotron());
        // 4 by 4, but flip outer ring
        final int[][] test5 = {{13, 14, 15, 16}, {9, 6, 7, 12}, {5, 10, 11, 8}, {1, 2, 3, 4}};
        Squarelotron temp5 = s4.upsideDownFlip(1);
        assertArrayEquals(test5, temp5.getSquarelotron());
    }
    /**
     * Method to test UpsideDownFlip dimension one new object.
     */
    @Test
    public void testUpsideDownFlipDimensionOneNewObject() {
        s = new Squarelotron(1);
        Squarelotron temp = s.upsideDownFlip(1);
        final int[][] test = {{1}};
        assertArrayEquals(test, temp.getSquarelotron());
    }
    /**
     * Method to test UpsideDownFlip new object.
     */
    @Test
    public void testUpsideDownFlipNewObject() {
        s = new Squarelotron(SIZE4);
        Squarelotron temp = s.upsideDownFlip(1);
        final int[][] test = {{13, 14, 15, 16}, {9, 6, 7, 12}, {5, 10, 11, 8}, {1, 2, 3, 4}};
        assertArrayEquals(test, temp.getSquarelotron());
    }
    /**
     * Method to test UpsideDownFlip dimension three.
     */
    @Test
    public void testUpsideDownFlipDimensionThree() {
        s = new Squarelotron(SIZE3);
        Squarelotron temp = s.upsideDownFlip(1);
        final int[][] test = {{7, 8, 9}, {4, 5, 6}, {1, 2, 3}};
        assertArrayEquals(test, temp.getSquarelotron());
    }
    /**
     * Method to test UpsideDownFlip dimension one.
     */
    @Test
    public void testUpsideDownFlipDimensionOne() {
        s = new Squarelotron(1);
        Squarelotron temp = s.upsideDownFlip(2);
        assertArrayEquals(temp.getSquarelotron(), s.getSquarelotron());
    }
    /**
     * Method to test MainDiagonalFlip new object.
     */
    @Test
    public void testMainDiagonalFlipNewObject() {
        s = new Squarelotron(SIZE3);
        Squarelotron temp = s.mainDiagonalFlip(1);
        final int[][] test = {{1, 4, 7}, {2, 5, 8}, {3, 6, 9}};
        assertArrayEquals(test, temp.getSquarelotron());
    }
    /**
     * Method to test MainDiagonalFlip Dimension Five Ring One.
     */
    @Test
    public void testMainDiagonalFlipDimensionFiveRingOne() {
        s5 = new Squarelotron(SIZE5);
        Squarelotron temp = s5.mainDiagonalFlip(1);
        final int[][] test = {{1, 6, 11, 16, 21}, {2, 7, 8, 9, 22}, {3, 12, 13, 14, 23}, {4, 17, 18, 19, 24},
                {5, 10, 15, 20, 25}};
        assertArrayEquals(test, temp.getSquarelotron());
    }
    /**
     * Method to test MainDiagonalFlip Dimension Five Ring two.
     */
    @Test
    public void testMainDiagonalFlipDimensionFiveRingTwo() {
        s5 = new Squarelotron(SIZE5);
        Squarelotron temp = s5.mainDiagonalFlip(2);
        final int[][] test = {{1, 2, 3, 4, 5}, {6, 7, 12, 17, 10}, {11, 8, 13, 18, 15}, {16, 9, 14, 19, 20},
                {21, 22, 23, 24, 25}};
        assertArrayEquals(test, temp.getSquarelotron());
    }
}
