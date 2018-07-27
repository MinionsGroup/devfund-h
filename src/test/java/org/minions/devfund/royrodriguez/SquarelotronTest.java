package org.minions.devfund.royrodriguez;

import org.junit.Assert;
import org.junit.Test;

/**
 * Squearelotron tests.
 */
public class SquarelotronTest {
    private static final int FOUR = 4;
    private static final int THREE = 3;
    private static final int FIVE = 5;
    private static final int EIGHT = 8;

    /**
     * Test upside down flip dimension 4 ring 1.
     */
    @Test
    public void upsideDownFlipTest() {
        final int[][] expectedResult = {
                {13, 14, 15, 16},
                {9, 6, 7, 12},
                {5, 10, 11, 8},
                {1, 2, 3, 4}
        };
        Squarelotron squarelotron = new Squarelotron(FOUR);
        Assert.assertEquals(expectedResult, squarelotron.upsideDownFlip(1).getSquarelotron());
    }

    /**
     * Tests upSideDownFlip method dimension 4 ring 2.
     */
    @Test
    public void testUpsideDownFlipDimensionFour() {
        final int[][] expectedResult = {
                {1, 2, 3, 4},
                {5, 10, 11, 8},
                {9, 6, 7, 12},
                {13, 14, 15, 16}
        };
        Squarelotron squarelotron = new Squarelotron(FOUR);
        Assert.assertEquals(expectedResult, squarelotron.upsideDownFlip(2).getSquarelotron());
    }

    /**
     * Tests upSideDownFlipMethod dimension three ring 1.
     */
    @Test
    public void testUpsideDownFlipDimensionThreeRingOne() {
        final int[][] expectedResult = {
                {7, 8, 9},
                {4, 5, 6},
                {1, 2, 3}
        };
        Squarelotron squarelotron = new Squarelotron(THREE);
        Assert.assertEquals(expectedResult, squarelotron.upsideDownFlip(1).getSquarelotron());
    }

    /**
     * Tests upSideDownFlip method dimension three ring two.
     */
    @Test
    public void testUpsideDownFlipDimensionThreeRingTwo() {
        final int[][] expectedResult = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        Squarelotron squarelotron = new Squarelotron(THREE);
        Assert.assertEquals(expectedResult, squarelotron.upsideDownFlip(2).getSquarelotron());
    }

    /**
     * Tests mainDiagonalFlip method dimension 4 ring 1.
     */
    @Test
    public void mainDiagonalFlipTest() {
        final int[][] expectedResult = {
                {1, 5, 9, 13},
                {2, 6, 7, 14},
                {3, 10, 11, 15},
                {4, 8, 12, 16}
        };

        Squarelotron squarelotron = new Squarelotron(FOUR);
        Assert.assertEquals(expectedResult, squarelotron.mainDiagonalFlip(1).getSquarelotron());
    }

    /**
     * Tests mainDiagonalFlip method dimension 4 ring 2.
     */
    @Test
    public void mainDiagonalFlipTestSecondRing() {
        final int[][] expectedResult = {
                {1, 2, 3, 4},
                {5, 6, 10, 8},
                {9, 7, 11, 12},
                {13, 14, 15, 16}
        };

        Squarelotron squarelotron = new Squarelotron(FOUR);
        Assert.assertEquals(expectedResult, squarelotron.mainDiagonalFlip(2).getSquarelotron());
    }

    /**
     * Tests mainDiagonalFlip method dimension 5 ring 3.
     */
    @Test
    public void testMainDiagonalFlipDimensionFiveRingThree() {
        final int[][] expectedResult = {
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15},
                {16, 17, 18, 19, 20},
                {21, 22, 23, 24, 25}
        };

        Squarelotron squarelotron = new Squarelotron(FIVE);
        Assert.assertEquals(expectedResult, squarelotron.mainDiagonalFlip(THREE).getSquarelotron());
    }

    /**
     * Tests rotateRing method dimension 4 rotates 1.
     */
    @Test
    public void rotateRingTest() {
        final int[][] expectedResult = {
                {13, 9, 5, 1},
                {14, 10, 6, 2},
                {15, 11, 7, 3},
                {16, 12, 8, 4}
        };
        Squarelotron squarelotron = new Squarelotron(FOUR);
        squarelotron.rotateRight(1);
        Assert.assertEquals(expectedResult, squarelotron.getSquarelotron());
    }

    /**
     * Tests rotateRing method dimension 4 rotates 3.
     */
    @Test
    public void testRotateRight3() {
        final int[][] expectedResult = {
                {4, 8, 12, 16},
                {3, 7, 11, 15},
                {2, 6, 10, 14},
                {1, 5, 9, 13}
        };
        Squarelotron squarelotron = new Squarelotron(FOUR);
        squarelotron.rotateRight(THREE);
        Assert.assertEquals(expectedResult, squarelotron.getSquarelotron());
    }

    /**
     * Tests rotateRing method dimension 3 rotates -1.
     */
    @Test
    public void testRotateRight3Dimension3() {
        final int[][] expectedResult = {
                {3, 6, 9},
                {2, 5, 8},
                {1, 4, 7}
        };
        Squarelotron squarelotron = new Squarelotron(THREE);
        squarelotron.rotateRight(-1);
        Assert.assertEquals(expectedResult, squarelotron.getSquarelotron());
    }

    /**
     * Tests rotateRing method dimension 3 rotates 4.
     */
    @Test
    public void testRotate4() {
        final int[][] expectedResult = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        Squarelotron squarelotron = new Squarelotron(THREE);
        squarelotron.rotateRight(FOUR);
        Assert.assertEquals(expectedResult, squarelotron.getSquarelotron());
    }

    /**
     * Tests rotateRing method dimension 3 rotates -4.
     */
    @Test
    public void testRotate4Negative() {
        final int[][] expectedResult = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        Squarelotron squarelotron = new Squarelotron(THREE);
        squarelotron.rotateRight(-EIGHT);
        Assert.assertEquals(expectedResult, squarelotron.getSquarelotron());
    }

    /**
     * Tests MainDiagonalFlip method dimension 5 ring 2.
     */
    @Test
    public void testMainDiagonalFlipDimensionFiveRingTwo() {
        final int[][] expectedResult = {
                {1, 2, 3, 4, 5},
                {6, 7, 12, 17, 10},
                {11, 8, 13, 18, 15},
                {16, 9, 14, 19, 20},
                {21, 22, 23, 24, 25}
        };
        Squarelotron squarelotron = new Squarelotron(FIVE);
        Assert.assertEquals(expectedResult, squarelotron.mainDiagonalFlip(2).getSquarelotron());
    }

    /**
     * Tests belongs to ring out of borders.
     */
    @Test
    public void testBelongsToTheRingOutOfBorders() {
        Squarelotron squarelotron = new Squarelotron(1);
        Assert.assertFalse(squarelotron.belongsToTheRing(-1, 1, 2));
    }

    /**
     * Tests belongs to ring out of borders.
     */
    @Test
    public void testBelongsToTheRingOutOfBordersX() {
        Squarelotron squarelotron = new Squarelotron(FIVE);
        Assert.assertFalse(squarelotron.belongsToTheRing(THREE, THREE, 2));
    }

    /**
     * Tests belongs to matrix method.
     */
    @Test
    public void testBelongsToTheMatrix() {
        Squarelotron squarelotron = new Squarelotron(FIVE);
        Assert.assertFalse(squarelotron.belongsToTheMatrix(FIVE, EIGHT, 2));
    }
}
