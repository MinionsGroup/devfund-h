package org.minions.devfund.reinaldo;

import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

/**
 * Created by reinaldo on 19-07-18.
 */
public class SquarelotronTest {

    private Squarelotron squarelotron;
    private static final int SIZEMATRIX = 4;
    private static final int SIZEMATRIXTHREE = 3;
    private static final int SIZEMATRIXFIVE = 5;
    private static final int SIZEMATRIXTWO = 2;

    /**
     * Test for upside down flip dimension four ring one.
     */
    @Test
    public void testUpsideDownFlipDimensionFourRingOne() {

        squarelotron = new Squarelotron(SIZEMATRIX);
        final int[][] expectedResult = {{13, 14, 15, 16}, {9, 6, 7, 12}, {5, 10, 11, 8}, {1, 2, 3, 4}};
        int[][] actualResult = squarelotron.upsideDownFlip(1).getSquarelotron();
        assertArrayEquals(expectedResult, actualResult);
    }

    /**
     * Test for Upside Down Flip Three Ring two.
     */
    @Test
    public void testUpsideDownFlipThreeRingTwo() {
        squarelotron = new Squarelotron(SIZEMATRIXTHREE);
        final int ring = 2;
        final int[][] expectedResult = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] actualResult = squarelotron.upsideDownFlip(ring).getSquarelotron();
        assertArrayEquals(expectedResult, actualResult);
    }

    /**
     * Test for Upside Down Flip five Ring two.
     */
    @Test
    public void testUpsideDownFlipfiveRingtwo() {
        squarelotron = new Squarelotron(SIZEMATRIXFIVE);
        final int ring = 2;
        final int[][] expectedResult = {{1, 2, 3, 4, 5}, {6, 17, 18, 19, 10},
                {11, 12, 13, 14, 15}, {16, 7, 8, 9, 20}, {21, 22, 23, 24, 25}};
        int[][] actualResult = squarelotron.upsideDownFlip(ring).getSquarelotron();
        assertArrayEquals(expectedResult, actualResult);
    }

    /**
     * Test for upside down flip two ring one.
     */
    @Test
    public void testDiagonalFlipTwoRingOne() {
        squarelotron = new Squarelotron(SIZEMATRIXTWO);
        final int ring = 1;
        final int[][] expectedResult = {{1, 3}, {2, 4}};
        int[][] actualResult = squarelotron.mainDiagonalFlip(ring).getSquarelotron();
        assertArrayEquals(expectedResult, actualResult);
    }

    /**
     * Test for Diagonal Flip Dimension Five Ring Two.
     */
    @Test
    public void testDiagonalFlipDimensionFiveRingTwo() {

        squarelotron = new Squarelotron(SIZEMATRIXFIVE);
        final int ring = 2;
        final int[][] expectedResult = {{1, 2, 3, 4, 5}, {6, 7, 12, 17, 10},
                {11, 8, 13, 18, 15}, {16, 9, 14, 19, 20}, {21, 22, 23, 24, 25}};
        int[][] actualResult = squarelotron.mainDiagonalFlip(ring).getSquarelotron();
        assertArrayEquals(expectedResult, actualResult);
    }

    /**
     * Test for Diagonal Flip Dimension Five Ring Three.
     */
    @Test
    public void testDiagonalFlipDimensionFiveRingThree() {

        squarelotron = new Squarelotron(SIZEMATRIXFIVE);
        final int ring = 3;
        final int[][] expectedResult = {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15}, {16, 17, 18, 19, 20}, {21, 22, 23, 24, 25}};
        int[][] actualResult = squarelotron.mainDiagonalFlip(ring).getSquarelotron();
        assertArrayEquals(expectedResult, actualResult);
    }

    /**
     * Test for Diagonal Flip Dimension three Ring two.
     */
    @Test
    public void testDiagonalFlipDimensionthreeRingTwo() {

        squarelotron = new Squarelotron(SIZEMATRIXTHREE);
        final int ring = 2;
        final int[][] expectedResult = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] actualResult = squarelotron.mainDiagonalFlip(ring).getSquarelotron();
        assertArrayEquals(expectedResult, actualResult);
    }

    /**
     * Test for Diagonal Flip Two Ring one.
     */
    @Test
    public void testDiagonalFlipThreeRingOne() {
        squarelotron = new Squarelotron(SIZEMATRIXTHREE);
        final int ring = 1;
        final int[][] expectedResult = {{1, 4, 7}, {2, 5, 8}, {3, 6, 9}};
        int[][] actualResult = squarelotron.mainDiagonalFlip(ring).getSquarelotron();
        assertArrayEquals(expectedResult, actualResult);
    }

    /**
     * Test for Diagonal Flip Four Ring one.
     */
    @Test
    public void testWhenmainDiagonalFlipFourRingOne() {

        squarelotron = new Squarelotron(SIZEMATRIX);
        final int ring = 1;
        final int[][] expectedResult = {{1, 5, 9, 13}, {2, 6, 7, 14}, {3, 10, 11, 15}, {4, 8, 12, 16}};
        int[][] actualResult = squarelotron.mainDiagonalFlip(ring).getSquarelotron();
        assertArrayEquals(expectedResult, actualResult);
    }

    /**
     * Test for Route Right With Turn One.
     */
    @Test
    public void testRouteRightWithTurnOne() {

        squarelotron = new Squarelotron(SIZEMATRIXTWO);
        final int[][] expectedResult = {{3, 1}, {4, 2}};
        squarelotron.rotateRight(1);
        int[][] actualResult = squarelotron.getSquarelotron();
        assertArrayEquals(expectedResult, actualResult);
    }

    /**
     * Test for Route Right With Turn Two.
     */
    @Test
    public void testRouteRightWithTurnTwo() {

        squarelotron = new Squarelotron(SIZEMATRIXTHREE);
        final int[][] expectedResult = {{9, 8, 7}, {6, 5, 4}, {3, 2, 1}};
        squarelotron.rotateRight(2);
        int[][] actualResult = squarelotron.getSquarelotron();
        assertArrayEquals(expectedResult, actualResult);
    }

    /**
     * Test for Route Left With Turn One.
     */
    @Test
    public void testRouteLeftWithTurnOne() {

        squarelotron = new Squarelotron(SIZEMATRIXTHREE);
        final int[][] expectedResult = {{3, 6, 9}, {2, 5, 8}, {1, 4, 7}};
        squarelotron.rotateRight(-1);
        int[][] actualResult = squarelotron.getSquarelotron();
        assertArrayEquals(expectedResult, actualResult);
    }
}
