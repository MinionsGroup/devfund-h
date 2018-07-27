package org.minions.devfund.royrodriguez;

import org.junit.Assert;
import org.junit.Test;

public class SquarelotronTest {
    @Test
    public void upsideDownFlipTest() {
        final int[][] expectedResult = {
                {13, 14, 15, 16},
                {9, 6, 7, 12},
                {5, 10, 11, 8},
                {1, 2, 3, 4}
        };
        Squarelotron squarelotron = new Squarelotron(4);
        Assert.assertEquals(expectedResult, squarelotron.upsideDownFlip(1).squarelotron);
    }

    @Test
    public void testUpsideDownFlipDimensionFour() {
        final int[][] expectedResult = {
                {1, 2, 3, 4},
                {5, 10, 11, 8},
                {9, 6, 7, 12},
                {13, 14, 15, 16}
        };
        Squarelotron squarelotron = new Squarelotron(4);
        Assert.assertEquals(expectedResult, squarelotron.upsideDownFlip(2).squarelotron);
    }

    @Test
    public void testUpsideDownFlipDimensionThreeRingOne() {
        final int[][] expectedResult = {
                {7, 8, 9},
                {4, 5, 6},
                {1, 2, 3}
        };
        Squarelotron squarelotron = new Squarelotron(3);
        Assert.assertEquals(expectedResult, squarelotron.upsideDownFlip(1).squarelotron);
    }

    @Test
    public void testUpsideDownFlipDimensionThreeRingTwo() {
        final int[][] expectedResult = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        Squarelotron squarelotron = new Squarelotron(3);
        Assert.assertEquals(expectedResult, squarelotron.upsideDownFlip(2).squarelotron);
    }

    @Test
    public void mainDiagonalFlipTest() {
        final int[][] expectedResult = {
                {1, 5, 9, 13},
                {2, 6, 7, 14},
                {3, 10, 11, 15},
                {4, 8, 12, 16}
        };

        Squarelotron squarelotron = new Squarelotron(4);
        Assert.assertEquals(expectedResult, squarelotron.mainDiagonalFlip(1).squarelotron);
    }

    @Test
    public void mainDiagonalFlipTestSecondRing() {
        final int[][] expectedResult = {
                {1, 2, 3, 4},
                {5, 6, 10, 8},
                {9, 7, 11, 12},
                {13, 14, 15, 16}
        };

        Squarelotron squarelotron = new Squarelotron(4);
        Assert.assertEquals(expectedResult, squarelotron.mainDiagonalFlip(2).squarelotron);
    }

    @Test
    public void testMainDiagonalFlipDimensionFiveRingThree() {
        final int[][] expectedResult = {
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15},
                {16, 17, 18, 19, 20},
                {21, 22, 23, 24, 25}
        };

        Squarelotron squarelotron = new Squarelotron(5);
        Assert.assertEquals(expectedResult, squarelotron.mainDiagonalFlip(3).squarelotron);
    }

    @Test
    public void rotateRingTest() {
        int[][] expectedResult = {
                {13, 9, 5, 1},
                {14, 10, 6, 2},
                {15, 11, 7, 3},
                {16, 12, 8, 4}
        };
        Squarelotron squarelotron = new Squarelotron(4);
        squarelotron.rotateRight(1);
        Assert.assertEquals(expectedResult, squarelotron.squarelotron);
    }

    @Test
    public void testRotateRight3() {
        int[][] expectedResult = {
                {4, 8, 12, 16},
                {3, 7, 11, 15},
                {2, 6, 10, 14},
                {1, 5, 9, 13}
        };
        Squarelotron squarelotron = new Squarelotron(4);
        squarelotron.rotateRight(3);
        Assert.assertEquals(expectedResult, squarelotron.squarelotron);
    }

    @Test
    public void testRotateRight3Dimension3() {
        int[][] expectedResult = {
                {3, 6, 9},
                {2, 5, 8},
                {1, 4, 7}
        };
        Squarelotron squarelotron = new Squarelotron(3);
        squarelotron.rotateRight(-1);
        Assert.assertEquals(expectedResult, squarelotron.squarelotron);
    }

    @Test
    public void testRotate4() {
        final int[][] expectedResult = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        Squarelotron squarelotron = new Squarelotron(3);
        squarelotron.rotateRight(4);
        Assert.assertEquals(expectedResult, squarelotron.squarelotron);
    }

    @Test
    public void oddNTest() {
    }

    @Test
    public void testMainDiagonalFlipDimensionFiveRingTwo() {
        final int[][] expectedResult = {
                {1, 2, 3, 4, 5},
                {6, 7, 12, 17, 10},
                {11, 8, 13, 18, 15},
                {16, 9, 14, 19, 20},
                {21, 22, 23, 24, 25}
        };
        Squarelotron squarelotron = new Squarelotron(5);
//        squarelotron.mainDiagonalFlip(2).printSquarelotron();
        Assert.assertEquals(expectedResult, squarelotron.mainDiagonalFlip(2).squarelotron);
    }
}