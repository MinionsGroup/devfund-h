package org.minions.devfund.cristhian;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * WhackAMole test.
 */

public class WhackAMoleTest {
    private static final int ONE = 1;
    private static final int THREE = 3;
    private static final int FIVE = 5;
    private static final int TEN = 10;
    private static final String GRID = "*****";

    /**
     *
     */
    @Test
    public void testPrintGridMethod() {
        WhackAMole myWhackAMole = new WhackAMole(FIVE, FIVE);
        String expectedResult = GRID + "\n"
                + GRID + "\n"
                + GRID + "\n"
                + GRID + "\n"
                + GRID + "\n";
        assertEquals(expectedResult, myWhackAMole.printGrid());
    }

    /**
     *
     */
    @Test
    public void testPlaceMethod() {
        WhackAMole myWhackAMole = new WhackAMole(FIVE, FIVE);
        myWhackAMole.place(THREE, THREE);
        myWhackAMole.place(THREE, THREE);
        String expectedResult = GRID + "\n"
                + GRID + "\n"
                + GRID + "\n"
                + "***M*" + "\n"
                + GRID + "\n";
        assertEquals(expectedResult, myWhackAMole.printGrid());
    }

    /**
     *
     */
    @Test
    public void testPlaceMethodNegative() {
        WhackAMole myWhackAMole = new WhackAMole(FIVE, FIVE);
        myWhackAMole.place(TEN, TEN);
        String expectedResult = GRID + "\n"
                + GRID + "\n"
                + GRID + "\n"
                + GRID + "\n"
                + GRID + "\n";
        assertEquals(expectedResult, myWhackAMole.printGrid());
    }

    /**
     *
     */
    @Test
    public void testPlaceMethodNegative2() {
        WhackAMole myWhackAMole = new WhackAMole(FIVE, FIVE);
        myWhackAMole.place(THREE, TEN);
        myWhackAMole.place(TEN, THREE);
        String expectedResult = GRID + "\n"
                + GRID + "\n"
                + GRID + "\n"
                + GRID + "\n"
                + GRID + "\n";
        assertEquals(expectedResult, myWhackAMole.printGrid());
    }

    /**
     *
     */
    @Test
    public void testWhackMethodOne() {
        WhackAMole myWhackAMole = new WhackAMole(FIVE, FIVE);
        myWhackAMole.place(THREE, THREE);
        myWhackAMole.whack(THREE, THREE);
        String expectedResult = GRID + "\n"
                + GRID + "\n"
                + GRID + "\n"
                + "***W*" + "\n"
                + GRID + "\n";
        assertEquals(expectedResult, myWhackAMole.printGrid());
    }

    /**
     *
     */
    @Test
    public void testWhackMethodOneNegative() {
        WhackAMole myWhackAMole = new WhackAMole(FIVE, FIVE);
        myWhackAMole.place(THREE, THREE);
        myWhackAMole.whack(TEN, TEN);
        myWhackAMole.whack(TEN, THREE);
        myWhackAMole.whack(THREE, TEN);
        String expectedResult = GRID + "\n"
                + GRID + "\n"
                + GRID + "\n"
                + "***M*" + "\n"
                + GRID + "\n";
        assertEquals(expectedResult, myWhackAMole.printGrid());
    }

    /**
     *
     */
    @Test
    public void testWhackMethodTwo() {
        WhackAMole myWhackAMole = new WhackAMole(FIVE, FIVE);
        myWhackAMole.place(THREE, THREE);
        myWhackAMole.whack(ONE, ONE);
        String expectedResult = GRID + "\n"
                + GRID + "\n"
                + GRID + "\n"
                + "***M*" + "\n"
                + GRID + "\n";
        assertEquals(expectedResult, myWhackAMole.printGrid());
    }


    /**
     *
     */
    @Test
    public void testPrintGridToUserMethod() {
        WhackAMole myWhackAMole = new WhackAMole(FIVE, FIVE);
        myWhackAMole.place(THREE, THREE);
        String expectedResult = GRID + "\n"
                + GRID + "\n"
                + GRID + "\n"
                + GRID + "\n"
                + GRID + "\n";
        assertEquals(expectedResult, myWhackAMole.printGridToUser());
    }

    /**
     *
     */
    @Test
    public void testGetMolesLeftMethod() {
        WhackAMole myWhackAMole = new WhackAMole(FIVE, FIVE);
        myWhackAMole.place(THREE, THREE);
        assertEquals(ONE, myWhackAMole.getMolesLeft());
    }

    /**
     *
     */
    @Test
    public void testGetAttemptsLeftMethod() {
        WhackAMole myWhackAMole = new WhackAMole(FIVE, FIVE);
        assertEquals(FIVE, myWhackAMole.getAttemptsLeft());
    }

    /**
     *
     */
    @Test
    public void testGetScoreMethod() {
        WhackAMole myWhackAMole = new WhackAMole(FIVE, FIVE);
        myWhackAMole.place(THREE, THREE);
        myWhackAMole.whack(THREE, THREE);
        assertEquals(ONE, myWhackAMole.getScore());
    }
}
