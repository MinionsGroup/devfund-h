package org.minions.devfund.david;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

/**
 * Class to perform test of Squarelotron class.
 */
public class SquarelotronTest {

    /**
     * Test Upside-Down Flip method with Two dimension and one ring.
     */
    @Test
    public void upsideDownFlipTwoDimensionAndRingOne() {
        final int ring = 1;
        final int dimension = 2;
        final Squarelotron squarelotron = new Squarelotron(dimension);
        final int[][] expectedResult = new int[][]{
                {3, 4},
                {1, 2}
        };
        Squarelotron actualResult = squarelotron.upsideDownFlip(ring);
        assertArrayEquals(expectedResult, actualResult.getSquarelotron());
    }

    /**
     * Test Upside-Down Flip method with four dimension and one ring.
     */
    @Test
    public void upsideDownFlipFourDimensionAndRingOne() {
        final int ring = 1;
        final int dimension = 4;
        final Squarelotron squarelotron = new Squarelotron(dimension);
        final int[][] expectedResult = new int[][]{
                {13, 14, 15, 16},
                {9, 6, 7, 12},
                {5, 10, 11, 8},
                {1, 2, 3, 4}
        };

        Squarelotron actualResult = squarelotron.upsideDownFlip(ring);
        assertArrayEquals(expectedResult, actualResult.getSquarelotron());
    }

    /**
     * Test Upside-Down Flip method with five dimension and one ring.
     */
    @Test
    public void upsideDownFlipFiveDimensionAndRingOne() {
        final int ring = 1;
        final int dimension = 5;
        final Squarelotron squarelotron = new Squarelotron(dimension);
        final int[][] expectedResult = new int[][]{
                {21, 22, 23, 24, 25},
                {16, 7, 8, 9, 20},
                {11, 12, 13, 14, 15},
                {6, 17, 18, 19, 10},
                {1, 2, 3, 4, 5}
        };

        Squarelotron actualResult = squarelotron.upsideDownFlip(ring);
        assertArrayEquals(expectedResult, actualResult.getSquarelotron());
    }

    /**
     * Test Upside-Down Flip method with four dimension and two rings.
     */
    @Test
    public void upsideDownFlipFourDimensionAndTwoRings() {
        final int ring = 2;
        final int dimension = 4;
        final Squarelotron squarelotron = new Squarelotron(dimension);
        final int[][] expectedResult = new int[][]{
                {13, 14, 15, 16},
                {9, 10, 11, 12},
                {5, 6, 7, 8},
                {1, 2, 3, 4}
        };

        Squarelotron actualResult = squarelotron.upsideDownFlip(ring);
        assertArrayEquals(expectedResult, actualResult.getSquarelotron());
    }
}
