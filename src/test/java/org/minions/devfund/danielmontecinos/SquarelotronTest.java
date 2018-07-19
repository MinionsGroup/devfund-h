package org.minions.devfund.danielmontecinos;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

/**
 * Class in charge to test Squarelotron class.
 */
public class SquarelotronTest {

    /**
     * Tests upsideDownFlip method using two dimension matrix and ring equal to one.
     */
    @Test
    public void testUpsideDownFlipWithATwoDimensionMatrixWithRingOne() {
        final int ring = 1;
        final int dimension = 2;
        final Squarelotron squarelotron = new Squarelotron(dimension);
        final int[][] expectedResult = new int[][]{
                {3, 4},
                {1, 2}
        };
        Squarelotron actualResult = squarelotron.upsideDownFlip(ring);
        assertArrayEquals(expectedResult, actualResult.getSquarelotronMatrix());
    }

    /**
     * Tests upsideDownFlip method using four dimension matrix and ring equal to two.
     */
    @Test
    public void testUpsideDownFlipWithAFourDimensionMatrixWithRingOne() {
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
        assertArrayEquals(expectedResult, actualResult.getSquarelotronMatrix());
    }

    /**
     * Tests upsideDownFlip method using five dimension array and ring equal to two.
     */
    @Test
    public void testUpsideDownFlipWithAFiveDimensionMatrixWithRingTwo() {
        final int ring = 2;
        final int dimension = 5;
        final Squarelotron squarelotron = new Squarelotron(dimension);
        final int[][] expectedResult = new int[][]{
                {1, 2, 3, 4, 5},
                {6, 17, 18, 19, 10},
                {11, 12, 13, 14, 15},
                {16, 7, 8, 9, 20},
                {21, 22, 23, 24, 25}
        };
        Squarelotron actualResult = squarelotron.upsideDownFlip(ring);
        assertArrayEquals(expectedResult, actualResult.getSquarelotronMatrix());
    }

    /**
     * Tests upsideDownFlip method using five dimension array and ring equal to three.
     */
    @Test
    public void testUpsideDownFlipWithAFiveDimensionMatrixWithRingThree() {
        final int ring = 3;
        final int dimension = 5;
        final Squarelotron squarelotron = new Squarelotron(dimension);
        final int[][] expectedResult = new int[][]{
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15},
                {16, 17, 18, 19, 20},
                {21, 22, 23, 24, 25}
        };
        Squarelotron actualResult = squarelotron.upsideDownFlip(ring);
        assertArrayEquals(expectedResult, actualResult.getSquarelotronMatrix());
    }

    /**
     * Tests mainDiagonalFlip method using five dimension array and ring equal to one.
     */
    @Test
    public void testMainDiagonalFlipWithFourMatrixWithRingOne() {
        final int ring = 1;
        final int dimension = 4;
        final Squarelotron squarelotron = new Squarelotron(dimension);
        final int[][] expectedResult = new int[][]{
                {1, 5, 9, 13},
                {2, 6, 7, 14},
                {3, 10, 11, 15},
                {4, 8, 12, 16}
        };
        Squarelotron actualResult = squarelotron.mainDiagonalFlip(ring);
        assertArrayEquals(expectedResult, actualResult.getSquarelotronMatrix());
    }

    /**
     * Tests mainDiagonalFlip method using six dimension array and ring equal to one.
     */
    @Test
    public void testMainDiagonalFlipWithSixMatrixWithRingTwo() {
        final int ring = 2;
        final int dimension = 6;
        final Squarelotron squarelotron = new Squarelotron(dimension);
        final int[][] expectedResult = new int[][]{
                {1, 2, 3, 4, 5, 6},
                {7, 8, 14, 20, 26, 12},
                {13, 9, 15, 16, 27, 18},
                {19, 10, 21, 22, 28, 24},
                {25, 11, 17, 23, 29, 30},
                {31, 32, 33, 34, 35, 36}
        };
        Squarelotron actualResult = squarelotron.mainDiagonalFlip(ring);
        assertArrayEquals(expectedResult, actualResult.getSquarelotronMatrix());
    }

    /**
     * Tests rotateClockwise method using four dimension array and turns equal to one.
     */
    @Test
    public void testRotateClockwiseFourDimensionMatrixOnce() {
        final int dimension = 4;
        final int turns = 1;
        final Squarelotron squarelotron = new Squarelotron(dimension);
        final int[][] expectedResult = new int[][]{
                {13, 9, 5, 1},
                {14, 10, 6, 2},
                {15, 11, 7, 3},
                {16, 12, 8, 4}};
        squarelotron.rotateRight(turns);
        assertArrayEquals(expectedResult, squarelotron.getSquarelotronMatrix());
    }

    /**
     * Tests rotateClockwise method using two dimension array and turns equal to two.
     */
    @Test
    public void testRotateAntiClockwiseTwoDimensionMatrixTwice() {
        final int dimension = 2;
        final int turns = -2;
        final Squarelotron squarelotron = new Squarelotron(dimension);
        final int[][] expectedResult = new int[][]{
                {4, 3},
                {2, 1}
        };
        squarelotron.rotateRight(turns);
        assertArrayEquals(expectedResult, squarelotron.getSquarelotronMatrix());
    }

    /**
     * Tests rotateClockwise method using three dimension array and turns equal to zero.
     */
    @Test
    public void testRotateClockwiseWithThreeDimensionMatrixWithZeroTurns() {
        final int dimension = 3;
        final int turns = 0;
        final Squarelotron squarelotron = new Squarelotron(dimension);
        final int[][] expectedResult = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        squarelotron.rotateRight(turns);
        assertArrayEquals(expectedResult, squarelotron.getSquarelotronMatrix());
    }

    /**
     * Tests rotateClockwise method using four dimension array and turns equal to four.
     */
    @Test
    public void testRotateClockwiseWithFourDimensionMatrixWithAFourTurns() {
        final int dimension = 4;
        final int turns = 0;
        final Squarelotron squarelotron = new Squarelotron(dimension);
        final int[][] expectedResult = new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };
        squarelotron.rotateRight(turns);
        assertArrayEquals(expectedResult, squarelotron.getSquarelotronMatrix());
    }

    /**
     * Tests rotateClockwise method using three dimension array and turns equal to four.
     */
    @Test
    public void testRotateClockwiseWithThreeDimensionMatrixWithAThreeTurns() {
        final int dimension = 3;
        final int turns = 3;
        final Squarelotron squarelotron = new Squarelotron(dimension);
        final int[][] expectedResult = new int[][]{
                {3, 6, 9},
                {2, 5, 8},
                {1, 4, 7}
        };
        squarelotron.rotateRight(turns);
        assertArrayEquals(expectedResult, squarelotron.getSquarelotronMatrix());
    }

    /**
     * Tests rotateClockwise method using three dimension array and turns equal to four.
     */
    @Test
    public void testRotateAntiClockwiseWithThreeDimensionMatrixWithAThreeTurns() {
        final int dimension = 3;
        final int turns = -3;
        final Squarelotron squarelotron = new Squarelotron(dimension);
        final int[][] expectedResult = new int[][]{
                {7, 4, 1},
                {8, 5, 2},
                {9, 6, 3}
        };
        squarelotron.rotateRight(turns);
        assertArrayEquals(expectedResult, squarelotron.getSquarelotronMatrix());
    }
}
