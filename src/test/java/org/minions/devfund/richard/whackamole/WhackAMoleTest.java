package org.minions.devfund.richard.whackamole;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Class.
 */
public class WhackAMoleTest {

    private static final int ONE = 1;
    private static final int THREE = 3;
    private static final int FIVE = 5;
    private static final String GRID = "* * * * * ";

    /**
     *
     */
    @Test
    public void testPrintGridMethod() {
        WhackAMole myWhackAMole = new WhackAMole(FIVE, FIVE);
        String expectedResult = GRID
                + GRID
                + GRID
                + GRID
                + GRID;
        assertEquals(expectedResult, myWhackAMole.printGrid());
    }

    /**
     *
     */
    @Test
    public void testPlaceMethod() {
        WhackAMole myWhackAMole = new WhackAMole(FIVE, FIVE);
        myWhackAMole.place(THREE, THREE);
        String expectedResult = GRID
                + GRID
                + GRID
                + "* * * M * "
                + GRID;
        assertEquals(expectedResult, myWhackAMole.printGrid());
    }

    /**
     *
     */
    @Test
    public void testWhackMethod() {
        WhackAMole myWhackAMole = new WhackAMole(FIVE, FIVE);
        myWhackAMole.place(THREE, THREE);
        myWhackAMole.whack(THREE, THREE);
        String expectedResult = GRID
                + GRID
                + GRID
                + "* * * W * "
                + GRID;
        assertEquals(expectedResult, myWhackAMole.printGrid());
    }

    /**
     *
     */
    @Test
    public void testPrintGridToUserMethod() {
        WhackAMole myWhackAMole = new WhackAMole(FIVE, FIVE);
        myWhackAMole.place(THREE, THREE);
        String expectedResult = GRID
                + GRID
                + GRID
                + GRID
                + GRID;
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
