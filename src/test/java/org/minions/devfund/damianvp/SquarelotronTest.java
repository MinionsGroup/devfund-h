package org.minions.devfund.damianvp;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 * Test clas for Squarelotron.
 */
public class SquarelotronTest {
    public static final int ZERO = 0;
    public static final int ONE = 1;
    public static final int TWO = 2;
    public static final int THREE = 3;
    public static final int FOUR = 4;
    public static final int FIVE = 5;
    public static final int SIX = 6;
    public static final int SEVEN = 7;
    public static final int EIGHT = 8;
    public static final int NINE = 9;
    public static final int TEN = 10;
    public static final int ELEVEN = 11;
    public static final int TWELVE = 12;
    public static final int THIRTEEN = 13;
    public static final int FOURTEEN = 14;
    public static final int FIFTEEN = 15;
    public static final int SIXTEEN = 16;
    public static final int SEVENTEEN = 17;
    public static final int EIGHTEEN = 18;
    public static final int NINETEEN = 19;
    public static final int TWENTY = 20;
    public static final int TWENTY_ONE = 21;
    public static final int TWENTY_TWO = 22;
    public static final int TWENTY_THREE = 23;
    public static final int TWENTY_FOUR = 24;
    public static final int TWENTY_FIVE = 25;

    /**
     * test of squarelotron constructor.
     */
    @Test
    public void testSquarelotronConstructorSize() {
        Squarelotron se = new Squarelotron(TWO);
        assertEquals(TWO, se.size);
        assertEquals(ONE, se.squarelotron[0][0]);
        assertEquals(TWO, se.squarelotron[0][1]);
        assertEquals(THREE, se.squarelotron[1][0]);
        assertEquals(FOUR, se.squarelotron[1][1]);
    }

    /**
     * squarelotron constructor test size 5.
     */
    @Test
    public void testSquarelotronConstructorSize2() {
        Squarelotron se = new Squarelotron(FIVE);
        assertEquals(FIVE, se.size);
        assertEquals(TWENTY_ONE, se.squarelotron[FOUR][ZERO]);
        assertEquals(NINETEEN, se.squarelotron[THREE][THREE]);
    }

    /**
     * test rotate rigth 1 turn.testMainDiagonalFlipNewObject.
     */
    @Test
    public void testRotateRight1() {
        Squarelotron se = new Squarelotron(TWO);
        se.rotateRight(ONE);
        assertEquals(THREE, se.squarelotron[ZERO][ZERO]);
        assertEquals(ONE, se.squarelotron[ZERO][ONE]);
        assertEquals(FOUR, se.squarelotron[ONE][ZERO]);
        assertEquals(TWO, se.squarelotron[ONE][ONE]);
    }

    /**
     * test rotate rigth 2 turn.
     */
    @Test
    public void testRotateRight2() {
        Squarelotron se = new Squarelotron(TWO);
        se.rotateRight(TWO);
        assertEquals(FOUR, se.squarelotron[ZERO][ZERO]);
        assertEquals(THREE, se.squarelotron[ZERO][ONE]);
        assertEquals(TWO, se.squarelotron[ONE][ZERO]);
        assertEquals(ONE, se.squarelotron[ONE][ONE]);
    }

    /**
     * test rotate rigth 3 turn.
     */
    @Test
    public void testRotateRight3() {
        Squarelotron se = new Squarelotron(TWO);
        se.rotateRight(THREE);
        assertEquals(TWO, se.squarelotron[ZERO][ZERO]);
        assertEquals(FOUR, se.squarelotron[ZERO][ONE]);
        assertEquals(ONE, se.squarelotron[ONE][ZERO]);
        assertEquals(THREE, se.squarelotron[ONE][ONE]);
    }

    /**
     * test rotate rigth 4 turn.
     */
    @Test
    public void testRotateRight4() {
        Squarelotron se = new Squarelotron(THREE);
        se.rotateRight(FOUR);
        assertEquals(THREE, se.squarelotron[ZERO][TWO]);
        assertEquals(SIX, se.squarelotron[ONE][TWO]);
        assertEquals(NINE, se.squarelotron[TWO][TWO]);
        assertEquals(TWO, se.squarelotron[ZERO][ONE]);
        assertEquals(FIVE, se.squarelotron[ONE][ONE]);
    }

    /**
     * test rotate rigth 5 turn.
     */
    @Test
    public void testRotateRight5() {
        Squarelotron se = new Squarelotron(FIVE);
        se.rotateRight(FIVE);
        assertEquals(SEVENTEEN, se.squarelotron[ONE][ONE]);
        assertEquals(THIRTEEN, se.squarelotron[TWO][TWO]);
        assertEquals(NINE, se.squarelotron[THREE][THREE]);
        assertEquals(FIVE, se.squarelotron[FOUR][FOUR]);
    }

    /**
     * test rotate rigth 6 turn.
     */
    @Test
    public void testRotateRight6() {
        Squarelotron se = new Squarelotron(SIX);
        se.rotateRight(SIX);
        assertEquals(TWENTY_TWO, se.squarelotron[TWO][TWO]);
        assertEquals(TWENTY_ONE, se.squarelotron[TWO][THREE]);
        assertEquals(SIXTEEN, se.squarelotron[THREE][TWO]);
        assertEquals(FIFTEEN, se.squarelotron[THREE][THREE]);
    }

    /**
     * test of diagonal flip. original squarelotron not should change.
     */
    @Test
    public void testMainDiagonalFlipNewObject() {
        Squarelotron se = new Squarelotron(FIVE);
        Squarelotron se2 = se.mainDiagonalFlip(ONE);
        assertEquals(ONE, se.squarelotron[ZERO][ZERO]);
        assertEquals(SEVEN, se.squarelotron[ONE][ONE]);
        assertEquals(FIVE, se.squarelotron[ZERO][FOUR]);
        assertEquals(TWENTY_THREE, se.squarelotron[FOUR][TWO]);
        assertEquals(TWENTY_FIVE, se.squarelotron[FOUR][FOUR]);
        assertEquals(FIFTEEN, se.squarelotron[TWO][FOUR]);
        assertEquals(ONE, se2.squarelotron[ZERO][ZERO]);
        assertEquals(SEVEN, se2.squarelotron[ONE][ONE]);
        assertEquals(TWENTY_ONE, se2.squarelotron[ZERO][FOUR]);
        assertEquals(FIFTEEN, se2.squarelotron[FOUR][TWO]);
        assertEquals(TWENTY_FIVE, se2.squarelotron[FOUR][FOUR]);
        assertEquals(TWENTY_THREE, se2.squarelotron[TWO][FOUR]);
    }

    /**
     * test main diagonal flip, dimension 5 and ring 1.
     */
    @Test
    public void testMainDiagonalFlipDimensionFiveRingOne() {
        Squarelotron se = new Squarelotron(FIVE);
        se = se.mainDiagonalFlip(ONE);
        assertEquals(ONE, se.squarelotron[ZERO][ZERO]);
        assertEquals(SEVEN, se.squarelotron[ONE][ONE]);
        assertEquals(TWENTY_ONE, se.squarelotron[ZERO][FOUR]);
        assertEquals(FIFTEEN, se.squarelotron[FOUR][TWO]);
        assertEquals(TWENTY_FIVE, se.squarelotron[FOUR][FOUR]);
        assertEquals(TWENTY_THREE, se.squarelotron[TWO][FOUR]);
    }

    /**
     * test main diagonal flip, dimension 5 and ring 2.
     */
    @Test
    public void testMainDiagonalFlipDimensionFiveRingTwo() {
        Squarelotron se = new Squarelotron(FIVE);
        se = se.mainDiagonalFlip(TWO);
        assertEquals(ONE, se.squarelotron[ZERO][ZERO]);
        assertEquals(SEVEN, se.squarelotron[ONE][ONE]);
        assertEquals(THIRTEEN, se.squarelotron[TWO][TWO]);
        assertEquals(TWELVE, se.squarelotron[ONE][TWO]);
        assertEquals(EIGHT, se.squarelotron[TWO][ONE]);
        assertEquals(FOURTEEN, se.squarelotron[THREE][TWO]);
    }

    /**
     * test main diagonal flip, dimension 5 and ring 3.
     */
    @Test
    public void testMainDiagonalFlipDimensionFiveRingThree() {
        Squarelotron se = new Squarelotron(FIVE);
        se = se.mainDiagonalFlip(THREE);
        assertEquals(ONE, se.squarelotron[ZERO][ZERO]);
        assertEquals(SEVEN, se.squarelotron[ONE][ONE]);
        assertEquals(THIRTEEN, se.squarelotron[TWO][TWO]);
        assertEquals(NINETEEN, se.squarelotron[THREE][THREE]);
        assertEquals(TWENTY_FIVE, se.squarelotron[FOUR][FOUR]);
        assertEquals(EIGHTEEN, se.squarelotron[THREE][TWO]);
    }

    /**
     * test upside down flip, dimension 4 and ring 1.
     */
    @Test
    public void testUpsideDownFlipDimensionOne() {
        Squarelotron se = new Squarelotron(FOUR);
        se = se.upsideDownFlip(ONE);
        assertEquals(THIRTEEN, se.squarelotron[ZERO][ZERO]);
        assertEquals(FIFTEEN, se.squarelotron[ZERO][TWO]);
        assertEquals(NINE, se.squarelotron[ONE][ZERO]);
        assertEquals(SIX, se.squarelotron[ONE][ONE]);
        assertEquals(EIGHT, se.squarelotron[TWO][THREE]);
        assertEquals(FOUR, se.squarelotron[THREE][THREE]);
    }

    /**
     * test upside down flip, dimension 4 and ring 2.
     */
    @Test
    public void testUpsideDownFlipDimensionTwo() {
        Squarelotron se = new Squarelotron(FOUR);
        se = se.upsideDownFlip(TWO);
        assertEquals(THIRTEEN, se.squarelotron[THREE][ZERO]);
        assertEquals(FIFTEEN, se.squarelotron[THREE][TWO]);
        assertEquals(SIX, se.squarelotron[TWO][ONE]);
        assertEquals(SEVEN, se.squarelotron[TWO][TWO]);
        assertEquals(ELEVEN, se.squarelotron[ONE][TWO]);
    }

    /**
     * test upside down flip, dimension 4 and ring 3.
     */
    @Test
    public void testUpsideDownFlipDimensionThree() {
        Squarelotron se = new Squarelotron(FOUR);
        se = se.upsideDownFlip(THREE);
        assertEquals(THIRTEEN, se.squarelotron[THREE][ZERO]);
        assertEquals(FIFTEEN, se.squarelotron[THREE][TWO]);
        assertEquals(ELEVEN, se.squarelotron[TWO][TWO]);
        assertEquals(TEN, se.squarelotron[TWO][ONE]);
        assertEquals(FOURTEEN, se.squarelotron[THREE][ONE]);
        assertEquals(SEVEN, se.squarelotron[ONE][TWO]);
    }
}
