package org.minions.devfund.marylin;

import org.junit.Test;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

import static org.junit.Assert.assertTrue;

/**
 * SquarelotronTest class.
 */
public class SquarelotronTest {
    private static final Logger LOGGER = Logger.getLogger(WhackAMole.class.getName());
    private static final int ZERO = 0;
    private static final int ONE = 1;
    private static final int TWO = 2;
    private static final int THREE = 3;
    private static final int FOUR = 4;
    private static final int FIVE = 5;
    private static final String EMPTYSPACE = " ";
    private static final String INITIALWORD = "INITIAL";
    private static final String ACTUALWORD = "ACTUAL";
    private static final String EXPECTEDWORD = "EXPECTED";
    private static final String ASSERTIONMESSAGE = "Grid is not the expected.";

    //Initialize squarelotrons with different sizes
    private Squarelotron initialSquarelotronTwoByTwo = new Squarelotron(TWO);
    private Squarelotron initialSquarelotronThreeByThree = new Squarelotron(THREE);
    private Squarelotron initialSquarelotronFourByFour = new Squarelotron(FOUR);
    private Squarelotron initialSquarelotronFiveByFive = new Squarelotron(FIVE);

    /**
     * Method to print a grid.
     *
     * @param grid  grid to print.
     * @param title title to show.
     */
    void printGrid(final int[][] grid, final String title) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(title).append(" - ");
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                stringBuilder.append(EMPTYSPACE).append(grid[i][j]).append(EMPTYSPACE);
            }
        }
        LOGGER.log(Level.INFO, stringBuilder.toString());
    }

    /**********************************************************
     **********************upsideDownFlip**********************
     *********************************************************/

    /**
     * {{1, 2}, {3, 4}}.
     */
    @Test
    public void testUpsideDownFlipTwoByTwoGridFirstRing() {
        final int[][] expectedGrid = {{3, 4}, {1, 2}};
        printGrid(initialSquarelotronTwoByTwo.getSquarelotron(), INITIALWORD);
        printGrid(expectedGrid, EXPECTEDWORD);
        Squarelotron actualSquarelotron = initialSquarelotronTwoByTwo.upsideDownFlip(ONE);
        printGrid(actualSquarelotron.getSquarelotron(), ACTUALWORD);
        assertTrue(ASSERTIONMESSAGE, Arrays.deepEquals(expectedGrid, actualSquarelotron.getSquarelotron()));
    }

    /**
     * {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}.
     */
    @Test
    public void testUpsideDownFlipThreeByThreeGridFirstRing() {
        final int[][] expectedGrid = {{7, 8, 9}, {4, 5, 6}, {1, 2, 3}};
        printGrid(initialSquarelotronThreeByThree.getSquarelotron(), INITIALWORD);
        printGrid(expectedGrid, EXPECTEDWORD);
        Squarelotron actualSquarelotron = initialSquarelotronThreeByThree.upsideDownFlip(ONE);
        printGrid(actualSquarelotron.getSquarelotron(), ACTUALWORD);
        assertTrue(ASSERTIONMESSAGE, Arrays.deepEquals(expectedGrid, actualSquarelotron.getSquarelotron()));
    }

    /**
     * {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}.
     */
    @Test
    public void testUpsideDownFlipThreeByThreeGridSecondRing() {
        final int[][] expectedGrid = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        printGrid(initialSquarelotronThreeByThree.getSquarelotron(), INITIALWORD);
        printGrid(expectedGrid, EXPECTEDWORD);
        Squarelotron actualSquarelotron = initialSquarelotronThreeByThree.upsideDownFlip(TWO);
        printGrid(actualSquarelotron.getSquarelotron(), ACTUALWORD);
        assertTrue(ASSERTIONMESSAGE, Arrays.deepEquals(expectedGrid, actualSquarelotron.getSquarelotron()));
    }

    /**
     * {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}}.
     */
    @Test
    public void testUpsideDownFlipFourByFourGridFirstRing() {
        final int[][] expectedGrid = {{13, 14, 15, 16}, {9, 6, 7, 12}, {5, 10, 11, 8}, {1, 2, 3, 4}};
        printGrid(initialSquarelotronFourByFour.getSquarelotron(), INITIALWORD);
        printGrid(expectedGrid, EXPECTEDWORD);
        Squarelotron actualSquarelotron = initialSquarelotronFourByFour.upsideDownFlip(ONE);
        printGrid(actualSquarelotron.getSquarelotron(), ACTUALWORD);
        assertTrue(ASSERTIONMESSAGE, Arrays.deepEquals(expectedGrid, actualSquarelotron.getSquarelotron()));
    }


    /**
     * {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}}.
     */
    @Test
    public void testUpsideDownFlipFourByFourGridSecondRing() {
        final int[][] expectedGrid = {{1, 2, 3, 4}, {5, 10, 11, 8}, {9, 6, 7, 12}, {13, 14, 15, 16}};
        printGrid(initialSquarelotronFourByFour.getSquarelotron(), INITIALWORD);
        printGrid(expectedGrid, EXPECTEDWORD);
        Squarelotron actualSquarelotron = initialSquarelotronFourByFour.upsideDownFlip(TWO);
        printGrid(actualSquarelotron.getSquarelotron(), ACTUALWORD);
        assertTrue(ASSERTIONMESSAGE, Arrays.deepEquals(expectedGrid, actualSquarelotron.getSquarelotron()));
    }

    /**
     * {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15}, {16, 17, 18, 19, 20}, {21, 22, 23, 24, 25}}.
     */
    @Test
    public void testUpsideDownFlipFiveByFiveGridFirstRing() {
        final int[][] expectedGrid = {{21, 22, 23, 24, 25}, {16, 7, 8, 9, 20},
                {11, 12, 13, 14, 15}, {6, 17, 18, 19, 10}, {1, 2, 3, 4, 5}};
        printGrid(initialSquarelotronFiveByFive.getSquarelotron(), INITIALWORD);
        printGrid(expectedGrid, EXPECTEDWORD);
        Squarelotron actualSquarelotron = initialSquarelotronFiveByFive.upsideDownFlip(ONE);
        printGrid(actualSquarelotron.getSquarelotron(), ACTUALWORD);
        assertTrue(ASSERTIONMESSAGE, Arrays.deepEquals(expectedGrid, actualSquarelotron.getSquarelotron()));
    }

    /**
     * {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15}, {16, 17, 18, 19, 20}, {21, 22, 23, 24, 25}}.
     */
    @Test
    public void testUpsideDownFlipFiveByFiveGridSecondRing() {
        final int[][] expectedGrid = {{1, 2, 3, 4, 5}, {6, 17, 18, 19, 10},
                {11, 12, 13, 14, 15}, {16, 7, 8, 9, 20}, {21, 22, 23, 24, 25}};
        printGrid(initialSquarelotronFiveByFive.getSquarelotron(), INITIALWORD);
        printGrid(expectedGrid, EXPECTEDWORD);
        Squarelotron actualSquarelotron = initialSquarelotronFiveByFive.upsideDownFlip(TWO);
        printGrid(actualSquarelotron.getSquarelotron(), ACTUALWORD);
        assertTrue(ASSERTIONMESSAGE, Arrays.deepEquals(expectedGrid, actualSquarelotron.getSquarelotron()));

    }

    /**
     * {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15}, {16, 17, 18, 19, 20}, {21, 22, 23, 24, 25}}.
     */
    @Test
    public void testUpsideDownFlipFiveByFiveGridThirdRing() {
        final int[][] expectedGrid = {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15}, {16, 17, 18, 19, 20}, {21, 22, 23, 24, 25}};
        printGrid(initialSquarelotronFiveByFive.getSquarelotron(), INITIALWORD);
        printGrid(expectedGrid, EXPECTEDWORD);
        Squarelotron actualSquarelotron = initialSquarelotronFiveByFive.upsideDownFlip(THREE);
        printGrid(actualSquarelotron.getSquarelotron(), ACTUALWORD);
        assertTrue(ASSERTIONMESSAGE, Arrays.deepEquals(expectedGrid, actualSquarelotron.getSquarelotron()));
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
        printGrid(initialSquarelotronTwoByTwo.getSquarelotron(), INITIALWORD);
        printGrid(expectedGrid, EXPECTEDWORD);
        Squarelotron actualSquarelotron = initialSquarelotronTwoByTwo.mainDiagonalFlip(ONE);
        printGrid(actualSquarelotron.getSquarelotron(), ACTUALWORD);
        assertTrue(ASSERTIONMESSAGE, Arrays.deepEquals(expectedGrid, actualSquarelotron.getSquarelotron()));
    }

    /**
     * {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}.
     */
    @Test
    public void testMainDiagonalFlipThreeByThreeGridFirstRing() {
        final int[][] expectedGrid = {{1, 4, 7}, {2, 5, 8}, {3, 6, 9}};
        printGrid(initialSquarelotronThreeByThree.getSquarelotron(), INITIALWORD);
        printGrid(expectedGrid, EXPECTEDWORD);
        Squarelotron actualSquarelotron = initialSquarelotronThreeByThree.mainDiagonalFlip(ONE);
        printGrid(actualSquarelotron.getSquarelotron(), ACTUALWORD);
        assertTrue(ASSERTIONMESSAGE, Arrays.deepEquals(expectedGrid, actualSquarelotron.getSquarelotron()));
    }

    /**
     * {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}.
     */
    @Test
    public void testMainDiagonalFlipThreeByThreeGridSecondRing() {
        final int[][] expectedGrid = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        printGrid(initialSquarelotronThreeByThree.getSquarelotron(), INITIALWORD);
        printGrid(expectedGrid, EXPECTEDWORD);
        Squarelotron actualSquarelotron = initialSquarelotronThreeByThree.mainDiagonalFlip(TWO);
        printGrid(actualSquarelotron.getSquarelotron(), ACTUALWORD);
        assertTrue(ASSERTIONMESSAGE, Arrays.deepEquals(expectedGrid, actualSquarelotron.getSquarelotron()));
    }

    /**
     * {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}}.
     */
    @Test
    public void testMainDiagonalFlipFourByFourGridFirstRing() {
        final int[][] expectedGrid = {{1, 5, 9, 13}, {2, 6, 7, 14}, {3, 10, 11, 15}, {4, 8, 12, 16}};
        printGrid(initialSquarelotronFourByFour.getSquarelotron(), INITIALWORD);
        printGrid(expectedGrid, EXPECTEDWORD);
        Squarelotron actualSquarelotron = initialSquarelotronFourByFour.mainDiagonalFlip(ONE);
        printGrid(actualSquarelotron.getSquarelotron(), ACTUALWORD);
        assertTrue(ASSERTIONMESSAGE, Arrays.deepEquals(expectedGrid, actualSquarelotron.getSquarelotron()));
    }


    /**
     * {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}}.
     */
    @Test
    public void testMainDiagonalFlipFourByFourGridSecondRing() {
        final int[][] expectedGrid = {{1, 2, 3, 4}, {5, 6, 10, 8}, {9, 7, 11, 12}, {13, 14, 15, 16}};
        printGrid(initialSquarelotronFourByFour.getSquarelotron(), INITIALWORD);
        printGrid(expectedGrid, EXPECTEDWORD);
        Squarelotron actualSquarelotron = initialSquarelotronFourByFour.mainDiagonalFlip(TWO);
        printGrid(actualSquarelotron.getSquarelotron(), ACTUALWORD);
        assertTrue(ASSERTIONMESSAGE, Arrays.deepEquals(expectedGrid, actualSquarelotron.getSquarelotron()));
    }

    /**
     * {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15}, {16, 17, 18, 19, 20}, {21, 22, 23, 24, 25}}.
     */
    @Test
    public void testMainDiagonalFlipFiveByFiveGridFirstRing() {
        final int[][] expectedGrid = {{1, 6, 11, 16, 21}, {2, 7, 8, 9, 22},
                {3, 12, 13, 14, 23}, {4, 17, 18, 19, 24}, {5, 10, 15, 20, 25}};
        printGrid(initialSquarelotronFiveByFive.getSquarelotron(), INITIALWORD);
        printGrid(expectedGrid, EXPECTEDWORD);
        Squarelotron actualSquarelotron = initialSquarelotronFiveByFive.mainDiagonalFlip(ONE);
        printGrid(actualSquarelotron.getSquarelotron(), ACTUALWORD);
        assertTrue(ASSERTIONMESSAGE, Arrays.deepEquals(expectedGrid, actualSquarelotron.getSquarelotron()));
    }

    /**
     * {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15}, {16, 17, 18, 19, 20}, {21, 22, 23, 24, 25}}.
     */
    @Test
    public void testMainDiagonalFlipFiveByFiveGridSecondRing() {
        final int[][] expectedGrid = {{1, 2, 3, 4, 5}, {6, 7, 12, 17, 10},
                {11, 8, 13, 18, 15}, {16, 9, 14, 19, 20}, {21, 22, 23, 24, 25}};
        printGrid(initialSquarelotronFiveByFive.getSquarelotron(), INITIALWORD);
        printGrid(expectedGrid, EXPECTEDWORD);
        Squarelotron actualSquarelotron = initialSquarelotronFiveByFive.mainDiagonalFlip(TWO);
        printGrid(actualSquarelotron.getSquarelotron(), ACTUALWORD);
        assertTrue(ASSERTIONMESSAGE, Arrays.deepEquals(expectedGrid, actualSquarelotron.getSquarelotron()));

    }

    /**
     * {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15}, {16, 17, 18, 19, 20}, {21, 22, 23, 24, 25}}.
     */
    @Test
    public void testMainDiagonalFlipFiveByFiveGridThirdRing() {
        final int[][] expectedGrid = {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15}, {16, 17, 18, 19, 20}, {21, 22, 23, 24, 25}};
        printGrid(initialSquarelotronFiveByFive.getSquarelotron(), INITIALWORD);
        printGrid(expectedGrid, EXPECTEDWORD);
        Squarelotron actualSquarelotron = initialSquarelotronFiveByFive.mainDiagonalFlip(THREE);
        printGrid(actualSquarelotron.getSquarelotron(), ACTUALWORD);
        assertTrue(ASSERTIONMESSAGE,
                Arrays.deepEquals(expectedGrid, actualSquarelotron.getSquarelotron()));
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
        printGrid(initialSquarelotronTwoByTwo.getSquarelotron(), INITIALWORD);
        printGrid(expectedGrid, EXPECTEDWORD);
        initialSquarelotronTwoByTwo.rotateRight(ONE);
        printGrid(initialSquarelotronTwoByTwo.getSquarelotron(), ACTUALWORD);
        assertTrue(ASSERTIONMESSAGE,
                Arrays.deepEquals(expectedGrid, initialSquarelotronTwoByTwo.getSquarelotron()));
    }

    /**
     * {{1, 2}, {3, 4}}.
     */
    @Test
    public void testRotateRightTwoByTwoGridSecondRotate() {
        final int[][] expectedGrid = {{4, 3}, {2, 1}};
        printGrid(initialSquarelotronTwoByTwo.getSquarelotron(), INITIALWORD);
        printGrid(expectedGrid, EXPECTEDWORD);
        initialSquarelotronTwoByTwo.rotateRight(TWO);
        printGrid(initialSquarelotronTwoByTwo.getSquarelotron(), ACTUALWORD);
        assertTrue(ASSERTIONMESSAGE,
                Arrays.deepEquals(expectedGrid, initialSquarelotronTwoByTwo.getSquarelotron()));
    }

    /**
     * {{1, 2}, {3, 4}}.
     */
    @Test
    public void testRotateRightTwoByTwoGridThirdRotate() {
        final int[][] expectedGrid = {{2, 4}, {1, 3}};
        printGrid(initialSquarelotronTwoByTwo.getSquarelotron(), INITIALWORD);
        printGrid(expectedGrid, EXPECTEDWORD);
        initialSquarelotronTwoByTwo.rotateRight(THREE);
        printGrid(initialSquarelotronTwoByTwo.getSquarelotron(), ACTUALWORD);
        assertTrue(ASSERTIONMESSAGE,
                Arrays.deepEquals(expectedGrid, initialSquarelotronTwoByTwo.getSquarelotron()));
    }

    /**
     * {{1, 2}, {3, 4}}.
     */
    @Test
    public void testRotateRightTwoByTwoGridFourthRotate() {
        final int[][] expectedGrid = {{1, 2}, {3, 4}};
        printGrid(initialSquarelotronTwoByTwo.getSquarelotron(), INITIALWORD);
        printGrid(expectedGrid, EXPECTEDWORD);
        initialSquarelotronTwoByTwo.rotateRight(FOUR);
        printGrid(initialSquarelotronTwoByTwo.getSquarelotron(), ACTUALWORD);
        assertTrue(ASSERTIONMESSAGE,
                Arrays.deepEquals(expectedGrid, initialSquarelotronTwoByTwo.getSquarelotron()));
    }

    /**
     * {{1, 2}, {3, 4}}.
     */
    @Test
    public void testRotateRightTwoByTwoGridZerothRotate() {
        final int[][] expectedGrid = {{1, 2}, {3, 4}};
        printGrid(initialSquarelotronTwoByTwo.getSquarelotron(), INITIALWORD);
        printGrid(expectedGrid, EXPECTEDWORD);
        initialSquarelotronTwoByTwo.rotateRight(ZERO);
        printGrid(initialSquarelotronTwoByTwo.getSquarelotron(), ACTUALWORD);
        assertTrue(ASSERTIONMESSAGE,
                Arrays.deepEquals(expectedGrid, initialSquarelotronTwoByTwo.getSquarelotron()));
    }

    /**
     * {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}.
     */
    @Test
    public void testRotateRightThreeByThreeGridFirstRotate() {
        final int[][] expectedGrid = {{7, 4, 1}, {8, 5, 2}, {9, 6, 3}};
        printGrid(initialSquarelotronThreeByThree.getSquarelotron(), INITIALWORD);
        printGrid(expectedGrid, EXPECTEDWORD);
        initialSquarelotronThreeByThree.rotateRight(ONE);
        printGrid(initialSquarelotronThreeByThree.getSquarelotron(), ACTUALWORD);
        assertTrue(ASSERTIONMESSAGE,
                Arrays.deepEquals(expectedGrid, initialSquarelotronThreeByThree.getSquarelotron()));
    }

    /**
     * {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}.
     */
    @Test
    public void testRotateRightThreeByThreeGridSecondRotate() {
        final int[][] expectedGrid = {{9, 8, 7}, {6, 5, 4}, {3, 2, 1}};
        printGrid(initialSquarelotronThreeByThree.getSquarelotron(), INITIALWORD);
        printGrid(expectedGrid, EXPECTEDWORD);
        initialSquarelotronThreeByThree.rotateRight(TWO);
        printGrid(initialSquarelotronThreeByThree.getSquarelotron(), ACTUALWORD);
        assertTrue(ASSERTIONMESSAGE,
                Arrays.deepEquals(expectedGrid, initialSquarelotronThreeByThree.getSquarelotron()));
    }

    /**
     * {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}.
     */
    @Test
    public void testRotateRightThreeByThreeGridThirdRotate() {
        final int[][] expectedGrid = {{3, 6, 9}, {2, 5, 8}, {1, 4, 7}};
        printGrid(initialSquarelotronThreeByThree.getSquarelotron(), INITIALWORD);
        printGrid(expectedGrid, EXPECTEDWORD);
        initialSquarelotronThreeByThree.rotateRight(THREE);
        printGrid(initialSquarelotronThreeByThree.getSquarelotron(), ACTUALWORD);
        assertTrue(ASSERTIONMESSAGE,
                Arrays.deepEquals(expectedGrid, initialSquarelotronThreeByThree.getSquarelotron()));
    }

    /**
     * {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}.
     */
    @Test
    public void testRotateRightThreeByThreeGridFourthRotate() {
        final int[][] expectedGrid = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        printGrid(initialSquarelotronThreeByThree.getSquarelotron(), INITIALWORD);
        printGrid(expectedGrid, EXPECTEDWORD);
        initialSquarelotronThreeByThree.rotateRight(FOUR);
        printGrid(initialSquarelotronThreeByThree.getSquarelotron(), ACTUALWORD);
        assertTrue(ASSERTIONMESSAGE,
                Arrays.deepEquals(expectedGrid, initialSquarelotronThreeByThree.getSquarelotron()));
    }

    /**
     * {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}.
     */
    @Test
    public void testRotateRightThreeByThreeGridZeroRotate() {
        final int[][] expectedGrid = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        printGrid(initialSquarelotronThreeByThree.getSquarelotron(), INITIALWORD);
        printGrid(expectedGrid, EXPECTEDWORD);
        initialSquarelotronThreeByThree.rotateRight(ZERO);
        printGrid(initialSquarelotronThreeByThree.getSquarelotron(), ACTUALWORD);
        assertTrue(ASSERTIONMESSAGE,
                Arrays.deepEquals(expectedGrid, initialSquarelotronThreeByThree.getSquarelotron()));
    }

    /**
     * {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}}.
     */
    @Test
    public void testRotateRightFourByFourGridFirstRotate() {
        final int[][] expectedGrid = {{13, 9, 5, 1}, {14, 10, 6, 2}, {15, 11, 7, 3}, {16, 12, 8, 4}};
        printGrid(initialSquarelotronFourByFour.getSquarelotron(), INITIALWORD);
        printGrid(expectedGrid, EXPECTEDWORD);
        initialSquarelotronFourByFour.rotateRight(ONE);
        printGrid(initialSquarelotronFourByFour.getSquarelotron(), ACTUALWORD);
        assertTrue(ASSERTIONMESSAGE,
                Arrays.deepEquals(expectedGrid, initialSquarelotronFourByFour.getSquarelotron()));
    }

    /**
     * {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}}.
     */
    @Test
    public void testRotateRightFourByFourGridSecondRotate() {
        final int[][] expectedGrid = {{16, 15, 14, 13}, {12, 11, 10, 9}, {8, 7, 6, 5}, {4, 3, 2, 1}};
        printGrid(initialSquarelotronFourByFour.getSquarelotron(), INITIALWORD);
        printGrid(expectedGrid, EXPECTEDWORD);
        initialSquarelotronFourByFour.rotateRight(TWO);
        printGrid(initialSquarelotronFourByFour.getSquarelotron(), ACTUALWORD);
        assertTrue(ASSERTIONMESSAGE,
                Arrays.deepEquals(expectedGrid, initialSquarelotronFourByFour.getSquarelotron()));
    }

    /**
     * {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}}.
     */
    @Test
    public void testRotateRightFourByFourGridThirdRotate() {
        final int[][] expectedGrid = {{4, 8, 12, 16}, {3, 7, 11, 15}, {2, 6, 10, 14}, {1, 5, 9, 13}};
        printGrid(initialSquarelotronFourByFour.getSquarelotron(), INITIALWORD);
        printGrid(expectedGrid, EXPECTEDWORD);
        initialSquarelotronFourByFour.rotateRight(THREE);
        printGrid(initialSquarelotronFourByFour.getSquarelotron(), ACTUALWORD);
        assertTrue(ASSERTIONMESSAGE,
                Arrays.deepEquals(expectedGrid, initialSquarelotronFourByFour.getSquarelotron()));
    }

    /**
     * {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}}.
     */
    @Test
    public void testRotateRightFourByFourGridFourthRotate() {
        final int[][] expectedGrid = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        printGrid(initialSquarelotronFourByFour.getSquarelotron(), INITIALWORD);
        printGrid(expectedGrid, EXPECTEDWORD);
        initialSquarelotronFourByFour.rotateRight(FOUR);
        printGrid(initialSquarelotronFourByFour.getSquarelotron(), ACTUALWORD);
        assertTrue(ASSERTIONMESSAGE,
                Arrays.deepEquals(expectedGrid, initialSquarelotronFourByFour.getSquarelotron()));
    }

    /**
     * {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}}.
     */
    @Test
    public void testRotateRightFourByFourGridZeroRotate() {
        final int[][] expectedGrid = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        printGrid(initialSquarelotronFourByFour.getSquarelotron(), INITIALWORD);
        printGrid(expectedGrid, EXPECTEDWORD);
        initialSquarelotronFourByFour.rotateRight(ZERO);
        printGrid(initialSquarelotronFourByFour.getSquarelotron(), ACTUALWORD);
        assertTrue(ASSERTIONMESSAGE,
                Arrays.deepEquals(expectedGrid, initialSquarelotronFourByFour.getSquarelotron()));
    }

    /**
     * {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15}, {16, 17, 18, 19, 20}, {21, 22, 23, 24, 25}}.
     */
    @Test
    public void testRotateRightFiveByFiveGridFirstRotate() {
        final int[][] expectedGrid = {{21, 16, 11, 6, 1}, {22, 17, 12, 7, 2},
                {23, 18, 13, 8, 3}, {24, 19, 14, 9, 4}, {25, 20, 15, 10, 5}};
        printGrid(initialSquarelotronFiveByFive.getSquarelotron(), INITIALWORD);
        printGrid(expectedGrid, EXPECTEDWORD);
        initialSquarelotronFiveByFive.rotateRight(ONE);
        printGrid(initialSquarelotronFiveByFive.getSquarelotron(), ACTUALWORD);
        assertTrue(ASSERTIONMESSAGE,
                Arrays.deepEquals(expectedGrid, initialSquarelotronFiveByFive.getSquarelotron()));
    }

    /**
     * {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15}, {16, 17, 18, 19, 20}, {21, 22, 23, 24, 25}}.
     */
    @Test
    public void testRotateRightFiveByFiveGridSecondRotate() {
        final int[][] expectedGrid = {{25, 24, 23, 22, 21}, {20, 19, 18, 17, 16},
                {15, 14, 13, 12, 11}, {10, 9, 8, 7, 6}, {5, 4, 3, 2, 1}};
        printGrid(initialSquarelotronFiveByFive.getSquarelotron(), INITIALWORD);
        printGrid(expectedGrid, EXPECTEDWORD);
        initialSquarelotronFiveByFive.rotateRight(TWO);
        printGrid(initialSquarelotronFiveByFive.getSquarelotron(), ACTUALWORD);
        assertTrue(ASSERTIONMESSAGE,
                Arrays.deepEquals(expectedGrid, initialSquarelotronFiveByFive.getSquarelotron()));
    }

    /**
     * {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15}, {16, 17, 18, 19, 20}, {21, 22, 23, 24, 25}}.
     */
    @Test
    public void testRotateRightFiveByFiveGridThirdRotate() {
        final int[][] expectedGrid = {{5, 10, 15, 20, 25}, {4, 9, 14, 19, 24},
                {3, 8, 13, 18, 23}, {2, 7, 12, 17, 22}, {1, 6, 11, 16, 21}};
        printGrid(initialSquarelotronFiveByFive.getSquarelotron(), INITIALWORD);
        printGrid(expectedGrid, EXPECTEDWORD);
        initialSquarelotronFiveByFive.rotateRight(THREE);
        printGrid(initialSquarelotronFiveByFive.getSquarelotron(), ACTUALWORD);
        assertTrue(ASSERTIONMESSAGE,
                Arrays.deepEquals(expectedGrid, initialSquarelotronFiveByFive.getSquarelotron()));
    }

    /**
     * {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15}, {16, 17, 18, 19, 20}, {21, 22, 23, 24, 25}}.
     */
    @Test
    public void testRotateRightFiveByFiveGridFourRotate() {
        final int[][] expectedGrid = {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15}, {16, 17, 18, 19, 20}, {21, 22, 23, 24, 25}};
        printGrid(initialSquarelotronFourByFour.getSquarelotron(), INITIALWORD);
        printGrid(expectedGrid, EXPECTEDWORD);
        initialSquarelotronFiveByFive.rotateRight(FOUR);
        printGrid(initialSquarelotronFiveByFive.getSquarelotron(), ACTUALWORD);
        assertTrue(ASSERTIONMESSAGE,
                Arrays.deepEquals(expectedGrid, initialSquarelotronFiveByFive.getSquarelotron()));
    }

    /**
     * {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15}, {16, 17, 18, 19, 20}, {21, 22, 23, 24, 25}}.
     */
    @Test
    public void testRotateRightFiveByFiveGridZeroRotate() {
        final int[][] expectedGrid = {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15}, {16, 17, 18, 19, 20}, {21, 22, 23, 24, 25}};
        printGrid(initialSquarelotronFourByFour.getSquarelotron(), INITIALWORD);
        printGrid(expectedGrid, EXPECTEDWORD);
        initialSquarelotronFiveByFive.rotateRight(ZERO);
        printGrid(initialSquarelotronFiveByFive.getSquarelotron(), ACTUALWORD);
        assertTrue(ASSERTIONMESSAGE,
                Arrays.deepEquals(expectedGrid, initialSquarelotronFiveByFive.getSquarelotron()));
    }
}
