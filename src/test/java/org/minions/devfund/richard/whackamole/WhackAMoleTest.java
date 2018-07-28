package org.minions.devfund.richard.whackamole;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Class.
 */
public class WhackAMoleTest {

    private WhackAMole myWhackAMole;
    private static final int ONE_NE = -1;
    private static final int ONE = 1;
    private static final int THREE = 3;
    private static final int FIVE = 5;
    private static final String GRID = "* * * * * ";

    /**
     * Before.
     */
    @Before
    public void setUp() {
        myWhackAMole = new WhackAMole(FIVE, FIVE);
    }

    /**
     *
     */
    @Test
    public void testPrintGridMethod() {
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
    public void testNegativePlaceMethod() {
        myWhackAMole.place(FIVE, FIVE);
        myWhackAMole.place(FIVE, ONE);
        myWhackAMole.place(ONE, FIVE);
        myWhackAMole.place(ONE_NE, ONE);
        myWhackAMole.place(ONE, ONE_NE);
        myWhackAMole.place(ONE_NE, ONE_NE);
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
    public void testWhackMethodOne() {
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
    public void testWhackMethodTwo() {
        myWhackAMole.place(THREE, THREE);
        myWhackAMole.whack(ONE, ONE);
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
    public void testNegativeWhackMethod() {
        myWhackAMole.whack(FIVE, FIVE);
        myWhackAMole.whack(FIVE, ONE);
        myWhackAMole.whack(ONE, FIVE);
        myWhackAMole.whack(ONE_NE, FIVE);
        myWhackAMole.whack(ONE_NE, ONE_NE);
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
    public void testPrintGridToUserMethod() {
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
        myWhackAMole.place(THREE, THREE);
        assertEquals(ONE, myWhackAMole.getMolesLeft());
    }

    /**
     *
     */
    @Test
    public void testGetAttemptsLeftMethod() {
        assertEquals(FIVE, myWhackAMole.getAttemptsLeft());
    }

    /**
     *
     */
    @Test
    public void testGetScoreMethod() {
        myWhackAMole.place(THREE, THREE);
        myWhackAMole.whack(THREE, THREE);
        assertEquals(ONE, myWhackAMole.getScore());
    }
}
