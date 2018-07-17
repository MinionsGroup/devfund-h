package org.minions.devfund.royrodriguez;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;


/**
 * Tests for whack a mole game.
 */
public class WhackAMoleTest {

    /**
     * Tests constructor for whack a mole game.
     */
    @Test
    public void whackAMoleConstructorTest() {
        final int numAttempts = 5;
        final int gridDimension = 10;
        WhackAMole whackAMole = new WhackAMole(numAttempts, gridDimension);
        assertNotNull(whackAMole);
    }

    /**
     * Tests place method.
     */
    @Test
    public void placeTestDone() {
        final int xLocation = 1;
        final int yLocation = 2;
        final int numAttempts = 5;
        final int gridDimension = 10;
        WhackAMole whackAMole = new WhackAMole(numAttempts, gridDimension);
        assertTrue(whackAMole.place(xLocation, yLocation));
    }

    /**
     * Tests place failed.
     */
    @Test
    public void placeTestFailed() {
        final int xLocation = 1;
        final int yLocation = 2;
        final int numAttempts = 5;
        final int gridDimension = 10;
        WhackAMole whackAMole = new WhackAMole(numAttempts, gridDimension);
        whackAMole.place(xLocation, yLocation);
        assertFalse(whackAMole.place(xLocation, yLocation));
    }

    /**
     * Tests whack method for a single position.
     */
    @Test
    public void whackTestInAMole() {
        final int xLocation = 0;
        final int yLocation = 0;
        final int numAttempts = 1;
        final int gridDimension = 1;

        WhackAMole whackAMole = new WhackAMole(numAttempts, gridDimension);
        whackAMole.place(xLocation, yLocation);

        int actualScore = whackAMole.getScore();
        int actualAttempts = whackAMole.getAttemptsLeft();
        int actualMolesLeft = whackAMole.getMolesLeft();

        whackAMole.whack(xLocation, yLocation);
        assertEquals(actualScore + 1, whackAMole.getScore());
        assertEquals(actualAttempts - 1, whackAMole.getAttemptsLeft());
        assertEquals(actualMolesLeft - 1, whackAMole.getMolesLeft());
    }

    /**
     * Tests whack method for an empty place.
     */
    @Test
    public void whackTestInEmptyPlace() {
        final int xLocation = 0;
        final int yLocation = 0;
        final int numAttempts = 1;
        final int gridDimension = 10;

        WhackAMole whackAMole = new WhackAMole(numAttempts, gridDimension);

        int actualScore = whackAMole.getScore();
        int actualAttempts = whackAMole.getAttemptsLeft();
        int actualMolesLeft = whackAMole.getMolesLeft();

        whackAMole.whack(xLocation, yLocation);

        assertEquals(actualScore, whackAMole.getScore());
        assertEquals(actualAttempts - 1, whackAMole.getAttemptsLeft());
        assertEquals(actualMolesLeft, whackAMole.getMolesLeft());
    }

    /**
     * Tests whack method with an invalid x position.
     */
    @Test
    public void whackInvalidPositionXTest() {
        final int xLocation = -1;
        final int yLocation = 0;
        final int numAttempts = 1;
        final int gridDimension = 10;

        WhackAMole whackAMole = new WhackAMole(numAttempts, gridDimension);

        int actualScore = whackAMole.getScore();
        int actualAttempts = whackAMole.getAttemptsLeft();
        int actualMolesLeft = whackAMole.getMolesLeft();

        whackAMole.whack(xLocation, yLocation);

        assertEquals(actualScore, whackAMole.getScore());
        assertEquals(actualAttempts - 1, whackAMole.getAttemptsLeft());
        assertEquals(actualMolesLeft, whackAMole.getMolesLeft());
    }

    /**
     * Tests whack method with an invalid y position.
     */
    @Test
    public void whackInvalidPositionYTest() {
        final int xLocation = 0;
        final int yLocation = -1;
        final int numAttempts = 1;
        final int gridDimension = 10;

        WhackAMole whackAMole = new WhackAMole(numAttempts, gridDimension);

        int actualScore = whackAMole.getScore();
        int actualAttempts = whackAMole.getAttemptsLeft();
        int actualMolesLeft = whackAMole.getMolesLeft();

        whackAMole.whack(xLocation, yLocation);

        assertEquals(actualScore, whackAMole.getScore());
        assertEquals(actualAttempts - 1, whackAMole.getAttemptsLeft());
        assertEquals(actualMolesLeft, whackAMole.getMolesLeft());
    }

    /**
     * Tests print grid for user.
     */
    @Test
    public void testPrint() {
        final int numAttempts = 1;
        final int gridDimension = 10;
        WhackAMole whackAMole = new WhackAMole(numAttempts, gridDimension);
        assertEquals(whackAMole.printGridToUser().getClass(), StringBuilder.class);
    }

    /**
     * Tests print grid with moles for user.
     */
    @Test
    public void testPrintWithMoles() {
        final int numAttempts = 1;
        final int gridDimension = 10;
        WhackAMole whackAMole = new WhackAMole(numAttempts, gridDimension);
        whackAMole.place(1, 1);
        assertEquals(whackAMole.printGridToUser().getClass(), StringBuilder.class);
    }

    /**
     * Tests rules for the game.
     */
    @Test
    public void rulesTest() {
        final int numAttempts = 1;
        final int gridDimension = 10;
        WhackAMole whackAMole = new WhackAMole(numAttempts, gridDimension);
        whackAMole.whack(0, 0);
        assertFalse(whackAMole.rules());
    }

    /**
     * Tests rules for the game.
     */
    @Test
    public void rulesTestMolesLeft() {
        final int numAttempts = 10;
        final int gridDimension = 10;
        WhackAMole whackAMole = new WhackAMole(numAttempts, gridDimension);
        whackAMole.place(0, 0);
        whackAMole.place(1, 1);
        whackAMole.whack(0, 0);
        assertTrue(whackAMole.rules());
    }

    /**
     * Tests rules without moles.
     */
    @Test
    public void rulesTestNoMolesLeft() {
        final int numAttempts = 10;
        final int gridDimension = 1;
        WhackAMole whackAMole = new WhackAMole(numAttempts, gridDimension);
        whackAMole.place(0, 0);
        whackAMole.whack(0, 0);
        assertFalse(whackAMole.rules());
    }

    /**
     * Tests place method in an invalid position.
     */
    @Test
    public void placeInInvalidPositionTest() {
        final int numAttempts = 1;
        final int gridDimension = 1;
        WhackAMole whackAMole = new WhackAMole(numAttempts, gridDimension);
        assertFalse(whackAMole.place(1, 1));
    }

    /**
     * Tests place method in an invalid position out of the grid.
     */
    @Test
    public void placeInInvalidPositionGridTest() {
        final int numAttempts = 1;
        final int gridDimension = 1;
        final int xPos = 0;
        final int yPos = 3;
        WhackAMole whackAMole = new WhackAMole(numAttempts, gridDimension);
        assertFalse(whackAMole.place(xPos, yPos));
    }
}
