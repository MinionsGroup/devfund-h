package org.minions.devfund.richard;

import org.junit.Test;
import org.minions.devfund.richard.square.Squarelotron;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

/**
 * Class.
 */
public class SquarelotronTest {

    private static final int ONE = 1;
    private static final int FOUR = 4;

    /**
     *
     */
    @Test
    public void testPrintMethod() {
        Squarelotron mySquarelotron = new Squarelotron(FOUR);
        final String expectedValue = "1 2 3 4 "
                + "5 6 7 8 "
                + "9 10 11 12 "
                + "13 14 15 16 ";
        assertEquals(expectedValue, mySquarelotron.print());
    }

    /**
     *
     */
    @Test
    public void testUpsideDownFlipMethod() {
        Squarelotron mySquarelotron = new Squarelotron(FOUR);
        final String expectedValue = "13 14 15 16 "
                + "9 6 7 12 "
                + "5 10 11 8 "
                + "1 2 3 4 ";
        assertEquals(expectedValue, mySquarelotron.upsideDownFlip(ONE).print());
    }

    /**
     *
     */
    @Test
    public void testMainDiagonalFlipMethod() {
        Squarelotron mySquarelotron = new Squarelotron(FOUR);
        final String expectedValue = "1 5 9 13 "
                + "2 6 7 14 "
                + "3 10 11 15 "
                + "4 8 12 16 ";
        assertEquals(expectedValue, mySquarelotron.mainDiagonalFlip(ONE).print());
    }

    /**
     *
     */
    @Test
    public void testRotateRightMethod() {
        Squarelotron mySquarelotron = new Squarelotron(FOUR);
        final String expectedValue = "13 9 5 1 "
                + "14 10 6 2 "
                + "15 11 7 3 "
                + "16 12 8 4 ";
        assertEquals(expectedValue, mySquarelotron.rotateRight(ONE).print());
    }

    /**
     *
     */
    @Test
    public void testUpsideDownFlipSizeThreeRingOne() {
        final int three = 3;
        final int[][] expected = {{7, 8, 9}, {4, 5, 6}, {1, 2, 3}};
        final int[][] expect = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        Squarelotron squarelotron = new Squarelotron(three);
        assertArrayEquals(expected, squarelotron.upsideDownFlip(1).getSquarelotron());
        assertArrayEquals(expect, squarelotron.getSquarelotron());
    }

    /**
     *
     */
    @Test
    public void testMainDiagonalFlipSizeThreeRingOne() {
        final int three = 3;
        final int[][] expected = {{1, 4, 7}, {2, 5, 8}, {3, 6, 9}};
        final int[][] expect = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        Squarelotron squarelotron = new Squarelotron(three);
        assertArrayEquals(expected, squarelotron.mainDiagonalFlip(1).getSquarelotron());
        assertArrayEquals(expect, squarelotron.getSquarelotron());
    }
}
