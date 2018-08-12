package org.minions.devfund.marylin;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

/**
 * SquarelotronTest class.
 */
public class SquarelotronTest {

    private static final String GRID_IS_NOT_THE_EXPECTED_MSG = "Grid is not the expected.";

    /**********************************************************
     **********************upsideDownFlip**********************
     *********************************************************/

    /**
     * {{1, 2}, {3, 4}}.
     */
    @Test
    public void testUpsideDownFlipTwoByTwoGridFirstRing() {
        final int one = 1;
        final int two = 2;
        final int[][] expectedGrid = {{3, 4}, {1, 2}};
        Squarelotron initialSquarelotronTwoByTwo = new Squarelotron(two);
        Squarelotron actualSquarelotron = initialSquarelotronTwoByTwo.upsideDownFlip(one);
        assertArrayEquals(GRID_IS_NOT_THE_EXPECTED_MSG, expectedGrid, actualSquarelotron.getSquarelotron());
    }

    /**
     * {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}.
     */
    @Test
    public void testUpsideDownFlipThreeByThreeGridFirstRing() {
        final int one = 1;
        final int three = 3;
        final int[][] expectedGrid = {{7, 8, 9}, {4, 5, 6}, {1, 2, 3}};
        Squarelotron initialSquarelotronThreeByThree = new Squarelotron(three);
        Squarelotron actualSquarelotron = initialSquarelotronThreeByThree.upsideDownFlip(one);
        assertArrayEquals(GRID_IS_NOT_THE_EXPECTED_MSG, expectedGrid, actualSquarelotron.getSquarelotron());
    }

    /**
     * {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}.
     */
    @Test
    public void testUpsideDownFlipThreeByThreeGridSecondRing() {
        final int two = 2;
        final int three = 3;
        final int[][] expectedGrid = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        Squarelotron initialSquarelotronThreeByThree = new Squarelotron(three);
        Squarelotron actualSquarelotron = initialSquarelotronThreeByThree.upsideDownFlip(two);
        assertArrayEquals(GRID_IS_NOT_THE_EXPECTED_MSG, expectedGrid, actualSquarelotron.getSquarelotron());
    }

    /**
     * {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}}.
     */
    @Test
    public void testUpsideDownFlipFourByFourGridFirstRing() {
        final int one = 1;
        final int four = 4;
        final int[][] expectedGrid = {{13, 14, 15, 16}, {9, 6, 7, 12}, {5, 10, 11, 8}, {1, 2, 3, 4}};
        Squarelotron initialSquarelotronFourByFour = new Squarelotron(four);
        Squarelotron actualSquarelotron = initialSquarelotronFourByFour.upsideDownFlip(one);
        assertArrayEquals(GRID_IS_NOT_THE_EXPECTED_MSG, expectedGrid, actualSquarelotron.getSquarelotron());
    }


    /**
     * {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}}.
     */
    @Test
    public void testUpsideDownFlipFourByFourGridSecondRing() {
        final int two = 2;
        final int four = 4;
        final int[][] expectedGrid = {{1, 2, 3, 4}, {5, 10, 11, 8}, {9, 6, 7, 12}, {13, 14, 15, 16}};
        Squarelotron initialSquarelotronFourByFour = new Squarelotron(four);
        Squarelotron actualSquarelotron = initialSquarelotronFourByFour.upsideDownFlip(two);
        assertArrayEquals(GRID_IS_NOT_THE_EXPECTED_MSG, expectedGrid, actualSquarelotron.getSquarelotron());
    }

    /**
     * {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15}, {16, 17, 18, 19, 20}, {21, 22, 23, 24, 25}}.
     */
    @Test
    public void testUpsideDownFlipFiveByFiveGridFirstRing() {
        final int one = 1;
        final int five = 5;
        final int[][] expectedGrid = {{21, 22, 23, 24, 25}, {16, 7, 8, 9, 20},
                {11, 12, 13, 14, 15}, {6, 17, 18, 19, 10}, {1, 2, 3, 4, 5}};
        Squarelotron initialSquarelotronFiveByFive = new Squarelotron(five);
        Squarelotron actualSquarelotron = initialSquarelotronFiveByFive.upsideDownFlip(one);
        assertArrayEquals(GRID_IS_NOT_THE_EXPECTED_MSG, expectedGrid, actualSquarelotron.getSquarelotron());
    }

    /**
     * {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15}, {16, 17, 18, 19, 20}, {21, 22, 23, 24, 25}}.
     */
    @Test
    public void testUpsideDownFlipFiveByFiveGridSecondRing() {
        final int two = 2;
        final int five = 5;
        final int[][] expectedGrid = {{1, 2, 3, 4, 5}, {6, 17, 18, 19, 10},
                {11, 12, 13, 14, 15}, {16, 7, 8, 9, 20}, {21, 22, 23, 24, 25}};
        Squarelotron initialSquarelotronFiveByFive = new Squarelotron(five);
        Squarelotron actualSquarelotron = initialSquarelotronFiveByFive.upsideDownFlip(two);
        assertArrayEquals(GRID_IS_NOT_THE_EXPECTED_MSG, expectedGrid, actualSquarelotron.getSquarelotron());

    }

    /**
     * {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15}, {16, 17, 18, 19, 20}, {21, 22, 23, 24, 25}}.
     */
    @Test
    public void testUpsideDownFlipFiveByFiveGridThirdRing() {
        final int three = 3;
        final int five = 5;
        final int[][] expectedGrid = {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15}, {16, 17, 18, 19, 20}, {21, 22, 23, 24, 25}};
        Squarelotron initialSquarelotronFiveByFive = new Squarelotron(five);
        Squarelotron actualSquarelotron = initialSquarelotronFiveByFive.upsideDownFlip(three);
        assertArrayEquals(GRID_IS_NOT_THE_EXPECTED_MSG, expectedGrid, actualSquarelotron.getSquarelotron());
    }

    /**********************************************************
     *********************mainDiagonalFlip*********************
     *********************************************************/

    /**
     * {{1, 2}, {3, 4}}.
     */
    @Test
    public void testMainDiagonalFlipTwoByTwoGridFirstRing() {
        final int one = 1;
        final int two = 2;
        final int[][] expectedGrid = {{1, 3}, {2, 4}};
        Squarelotron initialSquarelotronTwoByTwo = new Squarelotron(two);
        Squarelotron actualSquarelotron = initialSquarelotronTwoByTwo.mainDiagonalFlip(one);
        assertArrayEquals(GRID_IS_NOT_THE_EXPECTED_MSG, expectedGrid, actualSquarelotron.getSquarelotron());
    }

    /**
     * {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}.
     */
    @Test
    public void testMainDiagonalFlipThreeByThreeGridFirstRing() {
        final int one = 1;
        final int three = 3;
        final int[][] expectedGrid = {{1, 4, 7}, {2, 5, 8}, {3, 6, 9}};
        Squarelotron initialSquarelotronThreeByThree = new Squarelotron(three);
        Squarelotron actualSquarelotron = initialSquarelotronThreeByThree.mainDiagonalFlip(one);
        assertArrayEquals(GRID_IS_NOT_THE_EXPECTED_MSG, expectedGrid, actualSquarelotron.getSquarelotron());
    }

    /**
     * {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}.
     */
    @Test
    public void testMainDiagonalFlipThreeByThreeGridSecondRing() {
        final int two = 2;
        final int three = 3;
        final int[][] expectedGrid = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        Squarelotron initialSquarelotronThreeByThree = new Squarelotron(three);
        Squarelotron actualSquarelotron = initialSquarelotronThreeByThree.mainDiagonalFlip(two);
        assertArrayEquals(GRID_IS_NOT_THE_EXPECTED_MSG, expectedGrid, actualSquarelotron.getSquarelotron());
    }

    /**
     * {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}}.
     */
    @Test
    public void testMainDiagonalFlipFourByFourGridFirstRing() {
        final int one = 1;
        final int four = 4;
        final int[][] expectedGrid = {{1, 5, 9, 13}, {2, 6, 7, 14}, {3, 10, 11, 15}, {4, 8, 12, 16}};
        Squarelotron initialSquarelotronFourByFour = new Squarelotron(four);
        Squarelotron actualSquarelotron = initialSquarelotronFourByFour.mainDiagonalFlip(one);
        assertArrayEquals(GRID_IS_NOT_THE_EXPECTED_MSG, expectedGrid, actualSquarelotron.getSquarelotron());
    }


    /**
     * {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}}.
     */
    @Test
    public void testMainDiagonalFlipFourByFourGridSecondRing() {
        final int two = 2;
        final int four = 4;
        final int[][] expectedGrid = {{1, 2, 3, 4}, {5, 6, 10, 8}, {9, 7, 11, 12}, {13, 14, 15, 16}};
        Squarelotron initialSquarelotronFourByFour = new Squarelotron(four);
        Squarelotron actualSquarelotron = initialSquarelotronFourByFour.mainDiagonalFlip(two);
        assertArrayEquals(GRID_IS_NOT_THE_EXPECTED_MSG, expectedGrid, actualSquarelotron.getSquarelotron());
    }

    /**
     * {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15}, {16, 17, 18, 19, 20}, {21, 22, 23, 24, 25}}.
     */
    @Test
    public void testMainDiagonalFlipFiveByFiveGridFirstRing() {
        final int one = 1;
        final int five = 5;
        final int[][] expectedGrid = {{1, 6, 11, 16, 21}, {2, 7, 8, 9, 22},
                {3, 12, 13, 14, 23}, {4, 17, 18, 19, 24}, {5, 10, 15, 20, 25}};
        Squarelotron initialSquarelotronFiveByFive = new Squarelotron(five);
        Squarelotron actualSquarelotron = initialSquarelotronFiveByFive.mainDiagonalFlip(one);
        assertArrayEquals(GRID_IS_NOT_THE_EXPECTED_MSG, expectedGrid, actualSquarelotron.getSquarelotron());
    }

    /**
     * {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15}, {16, 17, 18, 19, 20}, {21, 22, 23, 24, 25}}.
     */
    @Test
    public void testMainDiagonalFlipFiveByFiveGridSecondRing() {
        final int two = 2;
        final int five = 5;
        final int[][] expectedGrid = {{1, 2, 3, 4, 5}, {6, 7, 12, 17, 10},
                {11, 8, 13, 18, 15}, {16, 9, 14, 19, 20}, {21, 22, 23, 24, 25}};
        Squarelotron initialSquarelotronFiveByFive = new Squarelotron(five);
        Squarelotron actualSquarelotron = initialSquarelotronFiveByFive.mainDiagonalFlip(two);
        assertArrayEquals(GRID_IS_NOT_THE_EXPECTED_MSG, expectedGrid, actualSquarelotron.getSquarelotron());

    }

    /**
     * {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15}, {16, 17, 18, 19, 20}, {21, 22, 23, 24, 25}}.
     */
    @Test
    public void testMainDiagonalFlipFiveByFiveGridThirdRing() {
        final int three = 3;
        final int five = 5;
        final int[][] expectedGrid = {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15}, {16, 17, 18, 19, 20}, {21, 22, 23, 24, 25}};
        Squarelotron initialSquarelotronFiveByFive = new Squarelotron(five);
        Squarelotron actualSquarelotron = initialSquarelotronFiveByFive.mainDiagonalFlip(three);
        assertArrayEquals(GRID_IS_NOT_THE_EXPECTED_MSG,
                expectedGrid, actualSquarelotron.getSquarelotron());
    }

    /*********************************************************
     ************************rotateRight***********************
     *********************************************************/

    /**
     * {{1, 2}, {3, 4}}.
     */
    @Test
    public void testRotateRightTwoByTwoGridFirstRotate() {
        final int two = 2;
        final int one = 1;
        final int[][] expectedGrid = {{3, 1}, {4, 2}};
        Squarelotron initialSquarelotronTwoByTwo = new Squarelotron(two);
        initialSquarelotronTwoByTwo.rotateRight(one);
        assertArrayEquals(GRID_IS_NOT_THE_EXPECTED_MSG,
                expectedGrid, initialSquarelotronTwoByTwo.getSquarelotron());
    }

    /**
     * {{1, 2}, {3, 4}}.
     */
    @Test
    public void testRotateRightTwoByTwoGridSecondRotate() {
        final int two = 2;
        final int[][] expectedGrid = {{4, 3}, {2, 1}};
        Squarelotron initialSquarelotronTwoByTwo = new Squarelotron(two);
        initialSquarelotronTwoByTwo.rotateRight(two);
        assertArrayEquals(GRID_IS_NOT_THE_EXPECTED_MSG,
                expectedGrid, initialSquarelotronTwoByTwo.getSquarelotron());
    }

    /**
     * {{1, 2}, {3, 4}}.
     */
    @Test
    public void testRotateRightTwoByTwoGridThirdRotate() {
        final int two = 2;
        final int three = 3;
        final int[][] expectedGrid = {{2, 4}, {1, 3}};
        Squarelotron initialSquarelotronTwoByTwo = new Squarelotron(two);
        initialSquarelotronTwoByTwo.rotateRight(three);
        assertArrayEquals(GRID_IS_NOT_THE_EXPECTED_MSG,
                expectedGrid, initialSquarelotronTwoByTwo.getSquarelotron());
    }

    /**
     * {{1, 2}, {3, 4}}.
     */
    @Test
    public void testRotateRightTwoByTwoGridFourthRotate() {
        final int two = 2;
        final int four = 4;
        final int[][] expectedGrid = {{1, 2}, {3, 4}};
        Squarelotron initialSquarelotronTwoByTwo = new Squarelotron(two);
        initialSquarelotronTwoByTwo.rotateRight(four);
        assertArrayEquals(GRID_IS_NOT_THE_EXPECTED_MSG,
                expectedGrid, initialSquarelotronTwoByTwo.getSquarelotron());
    }

    /**
     * {{1, 2}, {3, 4}}.
     */
    @Test
    public void testRotateRightTwoByTwoGridZerothRotate() {
        final int two = 2;
        final int zero = 0;
        final int[][] expectedGrid = {{1, 2}, {3, 4}};
        Squarelotron initialSquarelotronTwoByTwo = new Squarelotron(two);
        initialSquarelotronTwoByTwo.rotateRight(zero);
        assertArrayEquals(GRID_IS_NOT_THE_EXPECTED_MSG,
                expectedGrid, initialSquarelotronTwoByTwo.getSquarelotron());
    }

    /**
     * {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}.
     */
    @Test
    public void testRotateRightThreeByThreeGridFirstRotate() {
        final int one = 1;
        final int three = 3;
        final int[][] expectedGrid = {{7, 4, 1}, {8, 5, 2}, {9, 6, 3}};
        Squarelotron initialSquarelotronThreeByThree = new Squarelotron(three);
        initialSquarelotronThreeByThree.rotateRight(one);
        assertArrayEquals(GRID_IS_NOT_THE_EXPECTED_MSG,
                expectedGrid, initialSquarelotronThreeByThree.getSquarelotron());
    }

    /**
     * {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}.
     */
    @Test
    public void testRotateRightThreeByThreeGridSecondRotate() {
        final int two = 2;
        final int three = 3;
        final int[][] expectedGrid = {{9, 8, 7}, {6, 5, 4}, {3, 2, 1}};
        Squarelotron initialSquarelotronThreeByThree = new Squarelotron(three);
        initialSquarelotronThreeByThree.rotateRight(two);
        assertArrayEquals(GRID_IS_NOT_THE_EXPECTED_MSG,
                expectedGrid, initialSquarelotronThreeByThree.getSquarelotron());
    }

    /**
     * {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}.
     */
    @Test
    public void testRotateRightThreeByThreeGridThirdRotate() {
        final int three = 3;
        final int[][] expectedGrid = {{3, 6, 9}, {2, 5, 8}, {1, 4, 7}};
        Squarelotron initialSquarelotronThreeByThree = new Squarelotron(three);
        initialSquarelotronThreeByThree.rotateRight(three);
        assertArrayEquals(GRID_IS_NOT_THE_EXPECTED_MSG,
                expectedGrid, initialSquarelotronThreeByThree.getSquarelotron());
    }

    /**
     * {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}.
     */
    @Test
    public void testRotateRightThreeByThreeGridFourthRotate() {
        final int three = 3;
        final int four = 4;
        final int[][] expectedGrid = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        Squarelotron initialSquarelotronThreeByThree = new Squarelotron(three);
        initialSquarelotronThreeByThree.rotateRight(four);
        assertArrayEquals(GRID_IS_NOT_THE_EXPECTED_MSG,
                expectedGrid, initialSquarelotronThreeByThree.getSquarelotron());
    }

    /**
     * {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}.
     */
    @Test
    public void testRotateRightThreeByThreeGridZeroRotate() {
        final int zero = 0;
        final int three = 3;
        final int[][] expectedGrid = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        Squarelotron initialSquarelotronThreeByThree = new Squarelotron(three);
        initialSquarelotronThreeByThree.rotateRight(zero);
        assertArrayEquals(GRID_IS_NOT_THE_EXPECTED_MSG,
                expectedGrid, initialSquarelotronThreeByThree.getSquarelotron());
    }

    /**
     * {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}}.
     */
    @Test
    public void testRotateRightFourByFourGridFirstRotate() {
        final int one = 1;
        final int four = 4;
        final int[][] expectedGrid = {{13, 9, 5, 1}, {14, 10, 6, 2}, {15, 11, 7, 3}, {16, 12, 8, 4}};
        Squarelotron initialSquarelotronFourByFour = new Squarelotron(four);
        initialSquarelotronFourByFour.rotateRight(one);
        assertArrayEquals(GRID_IS_NOT_THE_EXPECTED_MSG,
                expectedGrid, initialSquarelotronFourByFour.getSquarelotron());
    }

    /**
     * {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}}.
     */
    @Test
    public void testRotateRightFourByFourGridSecondRotate() {
        final int two = 2;
        final int four = 4;
        final int[][] expectedGrid = {{16, 15, 14, 13}, {12, 11, 10, 9}, {8, 7, 6, 5}, {4, 3, 2, 1}};
        Squarelotron initialSquarelotronFourByFour = new Squarelotron(four);
        initialSquarelotronFourByFour.rotateRight(two);
        assertArrayEquals(GRID_IS_NOT_THE_EXPECTED_MSG,
                expectedGrid, initialSquarelotronFourByFour.getSquarelotron());
    }

    /**
     * {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}}.
     */
    @Test
    public void testRotateRightFourByFourGridThirdRotate() {
        final int three = 3;
        final int four = 4;
        final int[][] expectedGrid = {{4, 8, 12, 16}, {3, 7, 11, 15}, {2, 6, 10, 14}, {1, 5, 9, 13}};
        Squarelotron initialSquarelotronFourByFour = new Squarelotron(four);
        initialSquarelotronFourByFour.rotateRight(three);
        assertArrayEquals(GRID_IS_NOT_THE_EXPECTED_MSG,
                expectedGrid, initialSquarelotronFourByFour.getSquarelotron());
    }

    /**
     * {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}}.
     */
    @Test
    public void testRotateRightFourByFourGridFourthRotate() {
        final int four = 4;
        final int[][] expectedGrid = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        Squarelotron initialSquarelotronFourByFour = new Squarelotron(four);
        initialSquarelotronFourByFour.rotateRight(four);
        assertArrayEquals(GRID_IS_NOT_THE_EXPECTED_MSG,
                expectedGrid, initialSquarelotronFourByFour.getSquarelotron());
    }

    /**
     * {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}}.
     */
    @Test
    public void testRotateRightFourByFourGridZeroRotate() {
        final int zero = 0;
        final int four = 4;
        final int[][] expectedGrid = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        Squarelotron initialSquarelotronFourByFour = new Squarelotron(four);
        initialSquarelotronFourByFour.rotateRight(zero);
        assertArrayEquals(GRID_IS_NOT_THE_EXPECTED_MSG,
                expectedGrid, initialSquarelotronFourByFour.getSquarelotron());
    }

    /**
     * {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15}, {16, 17, 18, 19, 20}, {21, 22, 23, 24, 25}}.
     */
    @Test
    public void testRotateRightFiveByFiveGridFirstRotate() {
        final int one = 1;
        final int five = 5;
        final int[][] expectedGrid = {{21, 16, 11, 6, 1}, {22, 17, 12, 7, 2},
                {23, 18, 13, 8, 3}, {24, 19, 14, 9, 4}, {25, 20, 15, 10, 5}};
        Squarelotron initialSquarelotronFiveByFive = new Squarelotron(five);
        initialSquarelotronFiveByFive.rotateRight(one);
        assertArrayEquals(GRID_IS_NOT_THE_EXPECTED_MSG,
                expectedGrid, initialSquarelotronFiveByFive.getSquarelotron());
    }

    /**
     * {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15}, {16, 17, 18, 19, 20}, {21, 22, 23, 24, 25}}.
     */
    @Test
    public void testRotateRightFiveByFiveGridSecondRotate() {
        final int two = 2;
        final int five = 5;
        final int[][] expectedGrid = {{25, 24, 23, 22, 21}, {20, 19, 18, 17, 16},
                {15, 14, 13, 12, 11}, {10, 9, 8, 7, 6}, {5, 4, 3, 2, 1}};
        Squarelotron initialSquarelotronFiveByFive = new Squarelotron(five);
        initialSquarelotronFiveByFive.rotateRight(two);
        assertArrayEquals(GRID_IS_NOT_THE_EXPECTED_MSG,
                expectedGrid, initialSquarelotronFiveByFive.getSquarelotron());
    }

    /**
     * {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15}, {16, 17, 18, 19, 20}, {21, 22, 23, 24, 25}}.
     */
    @Test
    public void testRotateRightFiveByFiveGridThirdRotate() {
        final int three = 3;
        final int five = 5;
        final int[][] expectedGrid = {{5, 10, 15, 20, 25}, {4, 9, 14, 19, 24},
                {3, 8, 13, 18, 23}, {2, 7, 12, 17, 22}, {1, 6, 11, 16, 21}};
        Squarelotron initialSquarelotronFiveByFive = new Squarelotron(five);
        initialSquarelotronFiveByFive.rotateRight(three);
        assertArrayEquals(GRID_IS_NOT_THE_EXPECTED_MSG,
                expectedGrid, initialSquarelotronFiveByFive.getSquarelotron());
    }

    /**
     * {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15}, {16, 17, 18, 19, 20}, {21, 22, 23, 24, 25}}.
     */
    @Test
    public void testRotateRightFiveByFiveGridFourRotate() {
        final int four = 4;
        final int five = 5;
        final int[][] expectedGrid = {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15}, {16, 17, 18, 19, 20}, {21, 22, 23, 24, 25}};
        Squarelotron initialSquarelotronFiveByFive = new Squarelotron(five);
        initialSquarelotronFiveByFive.rotateRight(four);
        assertArrayEquals(GRID_IS_NOT_THE_EXPECTED_MSG,
                expectedGrid, initialSquarelotronFiveByFive.getSquarelotron());
    }

    /**
     * {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15}, {16, 17, 18, 19, 20}, {21, 22, 23, 24, 25}}.
     */
    @Test
    public void testRotateRightFiveByFiveGridZeroRotate() {
        final int zero = 0;
        final int five = 5;
        final int[][] expectedGrid = {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15}, {16, 17, 18, 19, 20}, {21, 22, 23, 24, 25}};
        Squarelotron initialSquarelotronFiveByFive = new Squarelotron(five);
        initialSquarelotronFiveByFive.rotateRight(zero);
        assertArrayEquals(GRID_IS_NOT_THE_EXPECTED_MSG,
                expectedGrid, initialSquarelotronFiveByFive.getSquarelotron());
    }

    /**
     * {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15}, {16, 17, 18, 19, 20}, {21, 22, 23, 24, 25}}.
     */
    @Test
    public void testRotateLeftFiveByFiveGridFirstRotate() {
        final int five = 5;
        final int negativeOne = -1;
        final int[][] expectedGrid = {{5, 10, 15, 20, 25}, {4, 9, 14, 19, 24},
                {3, 8, 13, 18, 23}, {2, 7, 12, 17, 22}, {1, 6, 11, 16, 21}};
        Squarelotron initialSquarelotronFiveByFive = new Squarelotron(five);
        initialSquarelotronFiveByFive.rotateRight(negativeOne);
        assertArrayEquals(GRID_IS_NOT_THE_EXPECTED_MSG,
                expectedGrid, initialSquarelotronFiveByFive.getSquarelotron());
    }

    /**
     * {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15}, {16, 17, 18, 19, 20}, {21, 22, 23, 24, 25}}.
     */
    @Test
    public void testRotateLeftFiveByFiveGridSecondRotate() {
        final int five = 5;
        final int negativeTwo = -2;
        final int[][] expectedGrid = {{25, 24, 23, 22, 21}, {20, 19, 18, 17, 16},
                {15, 14, 13, 12, 11}, {10, 9, 8, 7, 6}, {5, 4, 3, 2, 1}};
        Squarelotron initialSquarelotronFiveByFive = new Squarelotron(five);
        initialSquarelotronFiveByFive.rotateRight(negativeTwo);
        assertArrayEquals(GRID_IS_NOT_THE_EXPECTED_MSG,
                expectedGrid, initialSquarelotronFiveByFive.getSquarelotron());
    }

    /**
     * {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15}, {16, 17, 18, 19, 20}, {21, 22, 23, 24, 25}}.
     */
    @Test
    public void testRotateLeftFiveByFiveGridThirdRotate() {
        final int five = 5;
        final int negativeThree = -3;
        final int[][] expectedGrid = {{21, 16, 11, 6, 1}, {22, 17, 12, 7, 2},
                {23, 18, 13, 8, 3}, {24, 19, 14, 9, 4}, {25, 20, 15, 10, 5}};
        Squarelotron initialSquarelotronFiveByFive = new Squarelotron(five);
        initialSquarelotronFiveByFive.rotateRight(negativeThree);
        assertArrayEquals(GRID_IS_NOT_THE_EXPECTED_MSG,
                expectedGrid, initialSquarelotronFiveByFive.getSquarelotron());
    }

    /**
     * {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15}, {16, 17, 18, 19, 20}, {21, 22, 23, 24, 25}}.
     */
    @Test
    public void testRotateLeftFiveByFiveGridFourRotate() {
        final int five = 5;
        final int negativeFour = -4;
        final int[][] expectedGrid = {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15}, {16, 17, 18, 19, 20}, {21, 22, 23, 24, 25}};
        Squarelotron initialSquarelotronFiveByFive = new Squarelotron(five);
        initialSquarelotronFiveByFive.rotateRight(negativeFour);
        assertArrayEquals(GRID_IS_NOT_THE_EXPECTED_MSG,
                expectedGrid, initialSquarelotronFiveByFive.getSquarelotron());
    }
}
