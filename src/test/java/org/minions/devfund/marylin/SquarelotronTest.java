package org.minions.devfund.marylin;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

/**
 * SquarelotronTest class.
 */
public class SquarelotronTest {
    private static final int ZERO = 0;
    private static final int ONE = 1;
    private static final int TWO = 2;
    private static final int THREE = 3;
    private static final int FOUR = 4;
    private static final int FIVE = 5;
    private static final int NEGATIVEONE = -1;
    private static final int NEGATIVETWO = -2;
    private static final int NEGATIVETHREE = -3;
    private static final int NEGATIVEFOUR = -4;
    private static final String ASSERTIONMESSAGE = "Grid is not the expected.";

    //Initialize squarelotrons with different sizes
    private Squarelotron initialSquarelotronTwoByTwo = new Squarelotron(TWO);
    private Squarelotron initialSquarelotronThreeByThree = new Squarelotron(THREE);
    private Squarelotron initialSquarelotronFourByFour = new Squarelotron(FOUR);
    private Squarelotron initialSquarelotronFiveByFive = new Squarelotron(FIVE);

    /**********************************************************
     **********************upsideDownFlip**********************
     *********************************************************/

    /**
     * {{1, 2}, {3, 4}}.
     */
    @Test
    public void testUpsideDownFlipTwoByTwoGridFirstRing() {
        final int[][] expectedGrid = {{3, 4}, {1, 2}};
        Squarelotron actualSquarelotron = initialSquarelotronTwoByTwo.upsideDownFlip(ONE);
        assertArrayEquals(ASSERTIONMESSAGE, expectedGrid, actualSquarelotron.getSquarelotron());
    }

    /**
     * {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}.
     */
    @Test
    public void testUpsideDownFlipThreeByThreeGridFirstRing() {
        final int[][] expectedGrid = {{7, 8, 9}, {4, 5, 6}, {1, 2, 3}};
        Squarelotron actualSquarelotron = initialSquarelotronThreeByThree.upsideDownFlip(ONE);
        assertArrayEquals(ASSERTIONMESSAGE, expectedGrid, actualSquarelotron.getSquarelotron());
    }

    /**
     * {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}.
     */
    @Test
    public void testUpsideDownFlipThreeByThreeGridSecondRing() {
        final int[][] expectedGrid = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        Squarelotron actualSquarelotron = initialSquarelotronThreeByThree.upsideDownFlip(TWO);
        assertArrayEquals(ASSERTIONMESSAGE, expectedGrid, actualSquarelotron.getSquarelotron());
    }

    /**
     * {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}}.
     */
    @Test
    public void testUpsideDownFlipFourByFourGridFirstRing() {
        final int[][] expectedGrid = {{13, 14, 15, 16}, {9, 6, 7, 12}, {5, 10, 11, 8}, {1, 2, 3, 4}};
        Squarelotron actualSquarelotron = initialSquarelotronFourByFour.upsideDownFlip(ONE);
        assertArrayEquals(ASSERTIONMESSAGE, expectedGrid, actualSquarelotron.getSquarelotron());
    }


    /**
     * {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}}.
     */
    @Test
    public void testUpsideDownFlipFourByFourGridSecondRing() {
        final int[][] expectedGrid = {{1, 2, 3, 4}, {5, 10, 11, 8}, {9, 6, 7, 12}, {13, 14, 15, 16}};
        Squarelotron actualSquarelotron = initialSquarelotronFourByFour.upsideDownFlip(TWO);
        assertArrayEquals(ASSERTIONMESSAGE, expectedGrid, actualSquarelotron.getSquarelotron());
    }

    /**
     * {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15}, {16, 17, 18, 19, 20}, {21, 22, 23, 24, 25}}.
     */
    @Test
    public void testUpsideDownFlipFiveByFiveGridFirstRing() {
        final int[][] expectedGrid = {{21, 22, 23, 24, 25}, {16, 7, 8, 9, 20},
                {11, 12, 13, 14, 15}, {6, 17, 18, 19, 10}, {1, 2, 3, 4, 5}};
        Squarelotron actualSquarelotron = initialSquarelotronFiveByFive.upsideDownFlip(ONE);
        assertArrayEquals(ASSERTIONMESSAGE, expectedGrid, actualSquarelotron.getSquarelotron());
    }

    /**
     * {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15}, {16, 17, 18, 19, 20}, {21, 22, 23, 24, 25}}.
     */
    @Test
    public void testUpsideDownFlipFiveByFiveGridSecondRing() {
        final int[][] expectedGrid = {{1, 2, 3, 4, 5}, {6, 17, 18, 19, 10},
                {11, 12, 13, 14, 15}, {16, 7, 8, 9, 20}, {21, 22, 23, 24, 25}};
        Squarelotron actualSquarelotron = initialSquarelotronFiveByFive.upsideDownFlip(TWO);
        assertArrayEquals(ASSERTIONMESSAGE, expectedGrid, actualSquarelotron.getSquarelotron());

    }

    /**
     * {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15}, {16, 17, 18, 19, 20}, {21, 22, 23, 24, 25}}.
     */
    @Test
    public void testUpsideDownFlipFiveByFiveGridThirdRing() {
        final int[][] expectedGrid = {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15}, {16, 17, 18, 19, 20}, {21, 22, 23, 24, 25}};
        Squarelotron actualSquarelotron = initialSquarelotronFiveByFive.upsideDownFlip(THREE);
        assertArrayEquals(ASSERTIONMESSAGE, expectedGrid, actualSquarelotron.getSquarelotron());
    }

    /**********************************************************
     *********************mainDiagonalFlip*********************
     *********************************************************/

    /**
     * {{1, 2}, {3, 4}}.
     */
    @Test
    public void testMainDiagonalFlipTwoByTwoGridFirstRing() {
        final int[][] expectedGrid = {{1, 3}, {2, 4}};
        Squarelotron actualSquarelotron = initialSquarelotronTwoByTwo.mainDiagonalFlip(ONE);
        assertArrayEquals(ASSERTIONMESSAGE, expectedGrid, actualSquarelotron.getSquarelotron());
    }

    /**
     * {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}.
     */
    @Test
    public void testMainDiagonalFlipThreeByThreeGridFirstRing() {
        final int[][] expectedGrid = {{1, 4, 7}, {2, 5, 8}, {3, 6, 9}};
        Squarelotron actualSquarelotron = initialSquarelotronThreeByThree.mainDiagonalFlip(ONE);
        assertArrayEquals(ASSERTIONMESSAGE, expectedGrid, actualSquarelotron.getSquarelotron());
    }

    /**
     * {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}.
     */
    @Test
    public void testMainDiagonalFlipThreeByThreeGridSecondRing() {
        final int[][] expectedGrid = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        Squarelotron actualSquarelotron = initialSquarelotronThreeByThree.mainDiagonalFlip(TWO);
        assertArrayEquals(ASSERTIONMESSAGE, expectedGrid, actualSquarelotron.getSquarelotron());
    }

    /**
     * {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}}.
     */
    @Test
    public void testMainDiagonalFlipFourByFourGridFirstRing() {
        final int[][] expectedGrid = {{1, 5, 9, 13}, {2, 6, 7, 14}, {3, 10, 11, 15}, {4, 8, 12, 16}};
        Squarelotron actualSquarelotron = initialSquarelotronFourByFour.mainDiagonalFlip(ONE);
        assertArrayEquals(ASSERTIONMESSAGE, expectedGrid, actualSquarelotron.getSquarelotron());
    }


    /**
     * {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}}.
     */
    @Test
    public void testMainDiagonalFlipFourByFourGridSecondRing() {
        final int[][] expectedGrid = {{1, 2, 3, 4}, {5, 6, 10, 8}, {9, 7, 11, 12}, {13, 14, 15, 16}};
        Squarelotron actualSquarelotron = initialSquarelotronFourByFour.mainDiagonalFlip(TWO);
        assertArrayEquals(ASSERTIONMESSAGE, expectedGrid, actualSquarelotron.getSquarelotron());
    }

    /**
     * {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15}, {16, 17, 18, 19, 20}, {21, 22, 23, 24, 25}}.
     */
    @Test
    public void testMainDiagonalFlipFiveByFiveGridFirstRing() {
        final int[][] expectedGrid = {{1, 6, 11, 16, 21}, {2, 7, 8, 9, 22},
                {3, 12, 13, 14, 23}, {4, 17, 18, 19, 24}, {5, 10, 15, 20, 25}};
        Squarelotron actualSquarelotron = initialSquarelotronFiveByFive.mainDiagonalFlip(ONE);
        assertArrayEquals(ASSERTIONMESSAGE, expectedGrid, actualSquarelotron.getSquarelotron());
    }

    /**
     * {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15}, {16, 17, 18, 19, 20}, {21, 22, 23, 24, 25}}.
     */
    @Test
    public void testMainDiagonalFlipFiveByFiveGridSecondRing() {
        final int[][] expectedGrid = {{1, 2, 3, 4, 5}, {6, 7, 12, 17, 10},
                {11, 8, 13, 18, 15}, {16, 9, 14, 19, 20}, {21, 22, 23, 24, 25}};
        Squarelotron actualSquarelotron = initialSquarelotronFiveByFive.mainDiagonalFlip(TWO);
        assertArrayEquals(ASSERTIONMESSAGE, expectedGrid, actualSquarelotron.getSquarelotron());

    }

    /**
     * {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15}, {16, 17, 18, 19, 20}, {21, 22, 23, 24, 25}}.
     */
    @Test
    public void testMainDiagonalFlipFiveByFiveGridThirdRing() {
        final int[][] expectedGrid = {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15}, {16, 17, 18, 19, 20}, {21, 22, 23, 24, 25}};
        Squarelotron actualSquarelotron = initialSquarelotronFiveByFive.mainDiagonalFlip(THREE);
        assertArrayEquals(ASSERTIONMESSAGE,
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
        final int[][] expectedGrid = {{3, 1}, {4, 2}};
        initialSquarelotronTwoByTwo.rotateRight(ONE);
        assertArrayEquals(ASSERTIONMESSAGE,
                expectedGrid, initialSquarelotronTwoByTwo.getSquarelotron());
    }

    /**
     * {{1, 2}, {3, 4}}.
     */
    @Test
    public void testRotateRightTwoByTwoGridSecondRotate() {
        final int[][] expectedGrid = {{4, 3}, {2, 1}};
        initialSquarelotronTwoByTwo.rotateRight(TWO);
        assertArrayEquals(ASSERTIONMESSAGE,
                expectedGrid, initialSquarelotronTwoByTwo.getSquarelotron());
    }

    /**
     * {{1, 2}, {3, 4}}.
     */
    @Test
    public void testRotateRightTwoByTwoGridThirdRotate() {
        final int[][] expectedGrid = {{2, 4}, {1, 3}};
        initialSquarelotronTwoByTwo.rotateRight(THREE);
        assertArrayEquals(ASSERTIONMESSAGE,
                expectedGrid, initialSquarelotronTwoByTwo.getSquarelotron());
    }

    /**
     * {{1, 2}, {3, 4}}.
     */
    @Test
    public void testRotateRightTwoByTwoGridFourthRotate() {
        final int[][] expectedGrid = {{1, 2}, {3, 4}};
        initialSquarelotronTwoByTwo.rotateRight(FOUR);
        assertArrayEquals(ASSERTIONMESSAGE,
                expectedGrid, initialSquarelotronTwoByTwo.getSquarelotron());
    }

    /**
     * {{1, 2}, {3, 4}}.
     */
    @Test
    public void testRotateRightTwoByTwoGridZerothRotate() {
        final int[][] expectedGrid = {{1, 2}, {3, 4}};
        initialSquarelotronTwoByTwo.rotateRight(ZERO);
        assertArrayEquals(ASSERTIONMESSAGE,
                expectedGrid, initialSquarelotronTwoByTwo.getSquarelotron());
    }

    /**
     * {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}.
     */
    @Test
    public void testRotateRightThreeByThreeGridFirstRotate() {
        final int[][] expectedGrid = {{7, 4, 1}, {8, 5, 2}, {9, 6, 3}};
        initialSquarelotronThreeByThree.rotateRight(ONE);
        assertArrayEquals(ASSERTIONMESSAGE,
                expectedGrid, initialSquarelotronThreeByThree.getSquarelotron());
    }

    /**
     * {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}.
     */
    @Test
    public void testRotateRightThreeByThreeGridSecondRotate() {
        final int[][] expectedGrid = {{9, 8, 7}, {6, 5, 4}, {3, 2, 1}};
        initialSquarelotronThreeByThree.rotateRight(TWO);
        assertArrayEquals(ASSERTIONMESSAGE,
                expectedGrid, initialSquarelotronThreeByThree.getSquarelotron());
    }

    /**
     * {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}.
     */
    @Test
    public void testRotateRightThreeByThreeGridThirdRotate() {
        final int[][] expectedGrid = {{3, 6, 9}, {2, 5, 8}, {1, 4, 7}};
        initialSquarelotronThreeByThree.rotateRight(THREE);
        assertArrayEquals(ASSERTIONMESSAGE,
                expectedGrid, initialSquarelotronThreeByThree.getSquarelotron());
    }

    /**
     * {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}.
     */
    @Test
    public void testRotateRightThreeByThreeGridFourthRotate() {
        final int[][] expectedGrid = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        initialSquarelotronThreeByThree.rotateRight(FOUR);
        assertArrayEquals(ASSERTIONMESSAGE,
                expectedGrid, initialSquarelotronThreeByThree.getSquarelotron());
    }

    /**
     * {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}.
     */
    @Test
    public void testRotateRightThreeByThreeGridZeroRotate() {
        final int[][] expectedGrid = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        initialSquarelotronThreeByThree.rotateRight(ZERO);
        assertArrayEquals(ASSERTIONMESSAGE,
                expectedGrid, initialSquarelotronThreeByThree.getSquarelotron());
    }

    /**
     * {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}}.
     */
    @Test
    public void testRotateRightFourByFourGridFirstRotate() {
        final int[][] expectedGrid = {{13, 9, 5, 1}, {14, 10, 6, 2}, {15, 11, 7, 3}, {16, 12, 8, 4}};
        initialSquarelotronFourByFour.rotateRight(ONE);
        assertArrayEquals(ASSERTIONMESSAGE,
                expectedGrid, initialSquarelotronFourByFour.getSquarelotron());
    }

    /**
     * {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}}.
     */
    @Test
    public void testRotateRightFourByFourGridSecondRotate() {
        final int[][] expectedGrid = {{16, 15, 14, 13}, {12, 11, 10, 9}, {8, 7, 6, 5}, {4, 3, 2, 1}};
        initialSquarelotronFourByFour.rotateRight(TWO);
        assertArrayEquals(ASSERTIONMESSAGE,
                expectedGrid, initialSquarelotronFourByFour.getSquarelotron());
    }

    /**
     * {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}}.
     */
    @Test
    public void testRotateRightFourByFourGridThirdRotate() {
        final int[][] expectedGrid = {{4, 8, 12, 16}, {3, 7, 11, 15}, {2, 6, 10, 14}, {1, 5, 9, 13}};
        initialSquarelotronFourByFour.rotateRight(THREE);
        assertArrayEquals(ASSERTIONMESSAGE,
                expectedGrid, initialSquarelotronFourByFour.getSquarelotron());
    }

    /**
     * {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}}.
     */
    @Test
    public void testRotateRightFourByFourGridFourthRotate() {
        final int[][] expectedGrid = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        initialSquarelotronFourByFour.rotateRight(FOUR);
        assertArrayEquals(ASSERTIONMESSAGE,
                expectedGrid, initialSquarelotronFourByFour.getSquarelotron());
    }

    /**
     * {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}}.
     */
    @Test
    public void testRotateRightFourByFourGridZeroRotate() {
        final int[][] expectedGrid = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        initialSquarelotronFourByFour.rotateRight(ZERO);
        assertArrayEquals(ASSERTIONMESSAGE,
                expectedGrid, initialSquarelotronFourByFour.getSquarelotron());
    }

    /**
     * {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15}, {16, 17, 18, 19, 20}, {21, 22, 23, 24, 25}}.
     */
    @Test
    public void testRotateRightFiveByFiveGridFirstRotate() {
        final int[][] expectedGrid = {{21, 16, 11, 6, 1}, {22, 17, 12, 7, 2},
                {23, 18, 13, 8, 3}, {24, 19, 14, 9, 4}, {25, 20, 15, 10, 5}};
        initialSquarelotronFiveByFive.rotateRight(ONE);
        assertArrayEquals(ASSERTIONMESSAGE,
                expectedGrid, initialSquarelotronFiveByFive.getSquarelotron());
    }

    /**
     * {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15}, {16, 17, 18, 19, 20}, {21, 22, 23, 24, 25}}.
     */
    @Test
    public void testRotateRightFiveByFiveGridSecondRotate() {
        final int[][] expectedGrid = {{25, 24, 23, 22, 21}, {20, 19, 18, 17, 16},
                {15, 14, 13, 12, 11}, {10, 9, 8, 7, 6}, {5, 4, 3, 2, 1}};
        initialSquarelotronFiveByFive.rotateRight(TWO);
        assertArrayEquals(ASSERTIONMESSAGE,
                expectedGrid, initialSquarelotronFiveByFive.getSquarelotron());
    }

    /**
     * {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15}, {16, 17, 18, 19, 20}, {21, 22, 23, 24, 25}}.
     */
    @Test
    public void testRotateRightFiveByFiveGridThirdRotate() {
        final int[][] expectedGrid = {{5, 10, 15, 20, 25}, {4, 9, 14, 19, 24},
                {3, 8, 13, 18, 23}, {2, 7, 12, 17, 22}, {1, 6, 11, 16, 21}};
        initialSquarelotronFiveByFive.rotateRight(THREE);
        assertArrayEquals(ASSERTIONMESSAGE,
                expectedGrid, initialSquarelotronFiveByFive.getSquarelotron());
    }

    /**
     * {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15}, {16, 17, 18, 19, 20}, {21, 22, 23, 24, 25}}.
     */
    @Test
    public void testRotateRightFiveByFiveGridFourRotate() {
        final int[][] expectedGrid = {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15}, {16, 17, 18, 19, 20}, {21, 22, 23, 24, 25}};
        initialSquarelotronFiveByFive.rotateRight(FOUR);
        assertArrayEquals(ASSERTIONMESSAGE,
                expectedGrid, initialSquarelotronFiveByFive.getSquarelotron());
    }

    /**
     * {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15}, {16, 17, 18, 19, 20}, {21, 22, 23, 24, 25}}.
     */
    @Test
    public void testRotateRightFiveByFiveGridZeroRotate() {
        final int[][] expectedGrid = {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15}, {16, 17, 18, 19, 20}, {21, 22, 23, 24, 25}};
        initialSquarelotronFiveByFive.rotateRight(ZERO);
        assertArrayEquals(ASSERTIONMESSAGE,
                expectedGrid, initialSquarelotronFiveByFive.getSquarelotron());
    }

    /**
     * {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15}, {16, 17, 18, 19, 20}, {21, 22, 23, 24, 25}}.
     */
    @Test
    public void testRotateLeftFiveByFiveGridFirstRotate() {
        final int[][] expectedGrid = {{5, 10, 15, 20, 25}, {4, 9, 14, 19, 24},
                {3, 8, 13, 18, 23}, {2, 7, 12, 17, 22}, {1, 6, 11, 16, 21}};
        initialSquarelotronFiveByFive.rotateRight(NEGATIVEONE);
        assertArrayEquals(ASSERTIONMESSAGE,
                expectedGrid, initialSquarelotronFiveByFive.getSquarelotron());
    }

    /**
     * {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15}, {16, 17, 18, 19, 20}, {21, 22, 23, 24, 25}}.
     */
    @Test
    public void testRotateLeftFiveByFiveGridSecondRotate() {
        final int[][] expectedGrid = {{25, 24, 23, 22, 21}, {20, 19, 18, 17, 16},
                {15, 14, 13, 12, 11}, {10, 9, 8, 7, 6}, {5, 4, 3, 2, 1}};
        initialSquarelotronFiveByFive.rotateRight(NEGATIVETWO);
        assertArrayEquals(ASSERTIONMESSAGE,
                expectedGrid, initialSquarelotronFiveByFive.getSquarelotron());
    }

    /**
     * {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15}, {16, 17, 18, 19, 20}, {21, 22, 23, 24, 25}}.
     */
    @Test
    public void testRotateLeftFiveByFiveGridThirdRotate() {
        final int[][] expectedGrid = {{21, 16, 11, 6, 1}, {22, 17, 12, 7, 2},
                {23, 18, 13, 8, 3}, {24, 19, 14, 9, 4}, {25, 20, 15, 10, 5}};
        initialSquarelotronFiveByFive.rotateRight(NEGATIVETHREE);
        assertArrayEquals(ASSERTIONMESSAGE,
                expectedGrid, initialSquarelotronFiveByFive.getSquarelotron());
    }

    /**
     * {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15}, {16, 17, 18, 19, 20}, {21, 22, 23, 24, 25}}.
     */
    @Test
    public void testRotateLeftFiveByFiveGridFourRotate() {
        final int[][] expectedGrid = {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15}, {16, 17, 18, 19, 20}, {21, 22, 23, 24, 25}};
        initialSquarelotronFiveByFive.rotateRight(NEGATIVEFOUR);
        assertArrayEquals(ASSERTIONMESSAGE,
                expectedGrid, initialSquarelotronFiveByFive.getSquarelotron());
    }
}
