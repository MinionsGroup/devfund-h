package org.minions.devfund.richard.whackamole;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Class.
 */
public class WhackAMoleTest {

    private WhackAMole myWhackAMole;
    private static final String GRID = "* * * * * ";

    /**
     * Before.
     */
    @Before
    public void setUp() {
        final int five = 5;
        myWhackAMole = new WhackAMole(five, five);
    }

    /**
     *
     */
    @Test
    public void testPrintGridMethod() {
        final String expectedResult = GRID
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
        final int three = 3;
        final String expectedResult = GRID
                + GRID
                + GRID
                + "* * * M * "
                + GRID;
        myWhackAMole.place(three, three);
        assertEquals(expectedResult, myWhackAMole.printGrid());
    }

    /**
     *
     */
    @Test
    public void testNegativePlaceMethod() {
        final int five = 5;
        final int one = 1;
        final int oneNe = -1;
        myWhackAMole.place(five, five);
        myWhackAMole.place(five, one);
        myWhackAMole.place(one, five);
        myWhackAMole.place(oneNe, one);
        myWhackAMole.place(one, oneNe);
        myWhackAMole.place(oneNe, oneNe);
        final String expectedResult = GRID
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
        final int three = 3;
        myWhackAMole.place(three, three);
        myWhackAMole.whack(three, three);
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
        final int three = 3;
        final int one = 1;
        myWhackAMole.place(three, three);
        myWhackAMole.whack(one, one);
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
        final int five = 5;
        final int one = 1;
        final int oneNe = -1;
        myWhackAMole.whack(five, five);
        myWhackAMole.whack(five, one);
        myWhackAMole.whack(one, five);
        myWhackAMole.whack(oneNe, five);
        myWhackAMole.whack(oneNe, oneNe);
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
        final int three = 3;
        myWhackAMole.place(three, three);
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
        final int three = 3;
        final int expectedResult = 1;
        myWhackAMole.place(three, three);
        assertEquals(expectedResult, myWhackAMole.getMolesLeft());
    }

    /**
     *
     */
    @Test
    public void testGetAttemptsLeftMethod() {
        final int expectedResult = 5;
        assertEquals(expectedResult, myWhackAMole.getAttemptsLeft());
    }

    /**
     *
     */
    @Test
    public void testGetScoreMethod() {
        final int three = 3;
        final int expectedResult = 1;
        myWhackAMole.place(three, three);
        myWhackAMole.whack(three, three);
        assertEquals(expectedResult, myWhackAMole.getScore());
    }
}
