package org.minions.devfund.david;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

/**
 * Unit tests for Whack a Mole class.
 */
public class WhackAMoleTest {
    public static final int ATTEMPTS = 50;
    public static final int GRID_DIMENSION = 10;

    private WhackAMole whackAMole;


    /**
     * Setup Whack-A-Mole class.
     */
    @Before
    public void initGame() {
        whackAMole = new WhackAMole(ATTEMPTS, GRID_DIMENSION);
    }

    /**
     * Test invalid location -1.
     */
    @Test
    public void testPlaceInAnInvalidLocation() {
        final int xPosition = -1;
        final int yPosition = -1;
        assertFalse(whackAMole.place(xPosition, yPosition));
    }

    /**
     * Test Grid dimension location +1.
     */
    @Test
    public void testPlaceMoleInTheLastLocation() {
        final int xPosition = GRID_DIMENSION;
        final int yPosition = GRID_DIMENSION;
        assertFalse(whackAMole.place(xPosition, yPosition));
    }

    /**
     * Test place mole in middle Grid location.
     */
    @Test
    public void testPlaceMoleInMiddleLocation() {
        final int xPosition = 4;
        final int yPosition = 4;
        assertTrue(whackAMole.place(xPosition, yPosition));
    }

    /**
     * Test does not possible place a mole in the same position.
     */
    @Test
    public void testPlaceMoleInATakenLocation() {
        final int xPosition = 0;
        final int yPosition = 0;
        whackAMole.place(xPosition, yPosition);
        assertFalse(whackAMole.place(xPosition, yPosition));
    }

    /**
     * Test does not possible place mole in invalid Y position.
     */
    @Test
    public void testWhackMoleInvalidYPosition() {
        final int xPosition = 4;
        final int yPosition = -1;
        assertFalse(whackAMole.place(xPosition, yPosition));
    }

    /**
     * Test does not possible place mole in invalid X position.
     */
    @Test
    public void testWhackMoleInvalidXPosition() {
        final int xPosition = -1;
        final int yPosition = 4;
        assertFalse(whackAMole.place(xPosition, yPosition));
    }

    /**
     * Test place mole in first position.
     */
    @Test
    public void testPlaceMoleOnFirstPosition() {
        final int xPosition = 0;
        final int yPosition = 0;
        assertTrue(whackAMole.place(xPosition, yPosition));
    }

    /**
     * Test X position more than length.
     */
    @Test
    public void testPlaceMoleInXInvalidPosition() {
        final int xPosition = GRID_DIMENSION;
        final int yPosition = 1;
        assertFalse(whackAMole.place(xPosition, yPosition));
    }

    /**
     * Test Y position more than length.
     */
    @Test
    public void testPlaceMoleInYInvalidPosition() {
        final int xPosition = 1;
        final int yPosition = GRID_DIMENSION;
        assertFalse(whackAMole.place(xPosition, yPosition));
    }

    /**
     * Test place mole in last position.
     */
    @Test
    public void testPlaceMoleOnLastPosition() {
        final int xPosition = GRID_DIMENSION - 1;
        final int yPosition = GRID_DIMENSION - 1;
        assertTrue(whackAMole.place(xPosition, yPosition));
    }

    /**
     * Test getScore method.
     */
    @Test
    public void testGetScore() {
        final int actualResult = whackAMole.getScore();
        final int expectedResult = 0;
        assertEquals(actualResult, expectedResult);
    }

    /**
     * Test getMolesLeft method.
     */
    @Test
    public void testGetMolesLeft() {
        final int actualResult = whackAMole.getMolesLeft();
        final int expectedResult = 0;
        assertEquals(actualResult, expectedResult);
    }

    /**
     * Test getAttemptsLeft method.
     */
    @Test
    public void testGetAttemptsLeft() {
        final int actualResult = whackAMole.getAttemptsLeft();
        final int expectedResult = ATTEMPTS;
        assertEquals(actualResult, expectedResult);
    }

    /**
     * Test PrintToUser method is not null.
     */
    @Test
    public void testPrintToUserMethodIsNotNull() {
        final StringBuilder actualResult = whackAMole.printGridToUser();
        assertNotNull(actualResult);
    }

    /**
     * Test whack a mole in valid position.
     */
    @Test
    public void testWhackAMole() {
        final int x = 2;
        final int y = 2;
        whackAMole.place(x, y);
        whackAMole.whack(x, y);
        final int actualResult = whackAMole.getScore();
        final int expectedResult = 1;
        assertEquals(actualResult, expectedResult);
    }

    /**
     * Test whack a mole on invalid X position.
     */
    @Test
    public void testWhackAMoleOnInvalidXPosition() {
        final int x = 5;
        final int y = 5;
        whackAMole.place(x, y);
        final int whackX = -1;
        final int whackY = 3;
        whackAMole.whack(whackX, whackY);
        final int actualResult = whackAMole.getScore();
        final int expectedResult = 0;
        assertEquals(actualResult, expectedResult);
    }

    /**
     * Test failed whack a mole.
     */
    @Test
    public void testFailedWhackAMole() {
        final int x = 5;
        final int y = 5;
        whackAMole.place(x, y);
        final int whackX = 4;
        final int whackY = 3;
        whackAMole.whack(whackX, whackY);
        final int actualResult = whackAMole.getScore();
        final int expectedResult = 0;
        assertEquals(actualResult, expectedResult);
    }

    /**
     * Test whack a mole on invalid Y position.
     */
    @Test
    public void testWhackAMoleOnInvalidYPosition() {
        final int x = 5;
        final int y = 5;
        whackAMole.place(x, y);
        final int whackX = 3;
        final int whackY = -1;
        whackAMole.whack(whackX, whackY);
        final int actualResult = whackAMole.getScore();
        final int expectedResult = 0;
        assertEquals(actualResult, expectedResult);
    }

    /**
     * Test PrintGrid method is not null.
     */
    @Test
    public void testPrintGridMethodIsNotNull() {
        final StringBuilder actualResult = whackAMole.printGrid();
        assertNotNull(actualResult);
    }

    /**
     * Test PrintGridToUser method is not print mole.
     */
    @Test
    public void testPrintGridToUserMethodIsPrintingMole() {
        final StringBuilder actualResult = whackAMole.printGrid();
        final int x = 2;
        final int y = 2;
        whackAMole.place(x, y);
        final StringBuilder expectedResult = whackAMole.printGridToUser();
        assertEquals(actualResult.toString(), expectedResult.toString());
    }

    /**
     * Test PrintGridToUser method is printing whacked mole.
     */
    @Test
    public void testPrintGridToUserMethodIsPrintingWhackedMole() {
        final int x = 2;
        final int y = 2;
        whackAMole.place(x, y);
        whackAMole.whack(x, y);
        final StringBuilder actualResult = whackAMole.printGrid();
        final StringBuilder expectedResult = whackAMole.printGridToUser();
        assertEquals(actualResult.toString(), expectedResult.toString());
    }
}
