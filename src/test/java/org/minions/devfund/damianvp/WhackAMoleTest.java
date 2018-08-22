package org.minions.devfund.damianvp;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

/**
 * Class to test the WhackAMole Class.
 */
public class WhackAMoleTest {

    public static final int ATTEMPTS = 50;
    public static final int GRID_DIMENSION = 10;
    private WhackAMole whackAMoleGame;

    /**
     * Instance WhackAMole class in order to start a new Game.
     */
    @Before
    public void startNewGame() {
        whackAMoleGame = new WhackAMole(ATTEMPTS, GRID_DIMENSION);
    }

    /**
     * Test to verify the molegrid construction.
     */
    @Test
    public void testConstructorGrid() {
        char[][] expectedGrid = {
                {'*', '*', '*', '*', '*', '*', '*', '*', '*', '*'},
                {'*', '*', '*', '*', '*', '*', '*', '*', '*', '*'},
                {'*', '*', '*', '*', '*', '*', '*', '*', '*', '*'},
                {'*', '*', '*', '*', '*', '*', '*', '*', '*', '*'},
                {'*', '*', '*', '*', '*', '*', '*', '*', '*', '*'},
                {'*', '*', '*', '*', '*', '*', '*', '*', '*', '*'},
                {'*', '*', '*', '*', '*', '*', '*', '*', '*', '*'},
                {'*', '*', '*', '*', '*', '*', '*', '*', '*', '*'},
                {'*', '*', '*', '*', '*', '*', '*', '*', '*', '*'},
                {'*', '*', '*', '*', '*', '*', '*', '*', '*', '*'}
        };
        assertArrayEquals(expectedGrid, whackAMoleGame.getMoleGrid());
    }

    /**
     * Test to Verify the Num of Attempts.
     */
    @Test
    public void testConstructorNumOfAttempts() {
        assertEquals(ATTEMPTS, whackAMoleGame.getAttemptsLeft());
    }

    /**
     * Test place Mole using valid locations.
     */
    @Test
    public void testPlaceMoleValidPositions() {

        final int xLocation = 0;
        final int yLocation = 0;
        int expectedMolesLeft = 1;
        assertTrue(whackAMoleGame.place(xLocation, yLocation));
        assertEquals(expectedMolesLeft, whackAMoleGame.getMolesLeft());
    }

    /**
     * Test place Mole using negative locations.
     */
    @Test
    public void testPlaceMoleUsingNegativeLocations() {
        final int xLocation = -1;
        final int yLocation = -1;
        int expectedMolesLeft = 0;
        assertFalse(whackAMoleGame.place(xLocation, yLocation));
        assertEquals(expectedMolesLeft, whackAMoleGame.getMolesLeft());
    }

    /**
     * Test place Mole using locations greater than Grid dimension.
     */
    @Test
    public void testPlaceMoleUsingGreaterLocations() {
        final int xLocation = GRID_DIMENSION + 1;
        final int yLocation = GRID_DIMENSION + 2;
        int expectedMolesLeft = 0;
        assertFalse(whackAMoleGame.place(xLocation, yLocation));
        assertEquals(expectedMolesLeft, whackAMoleGame.getMolesLeft());
    }

    /**
     * Test place Mole in already located Mole.
     */
    @Test
    public void testPlaceMoleAlreadyUsedLocation() {
        final int xLocation = 1;
        final int yLocation = 1;
        int expectedMolesLeft = 1;
        assertTrue(whackAMoleGame.place(xLocation, yLocation));
        assertFalse(whackAMoleGame.place(xLocation, yLocation));
        assertEquals(expectedMolesLeft, whackAMoleGame.getMolesLeft());
    }

    /**
     * Test place Mole using only one invalid location.
     */
    @Test
    public void testPlaceMoleUsingOneInvalidLocation() {
        final int xValidLocation = 3;
        final int yValidLocation = 5;
        final int xInvalidLocation = -3;
        final int yInvalidLocation = 15;
        int expectedMolesLeft = 0;
        assertFalse(whackAMoleGame.place(xValidLocation, yInvalidLocation));
        assertFalse(whackAMoleGame.place(xInvalidLocation, yValidLocation));
        assertEquals(expectedMolesLeft, whackAMoleGame.getMolesLeft());
    }

    /**
     * Test whack Mole whit empty grid.
     */
    @Test
    public void testWhackMoleWithEmptyGrid() {
        final int xLocation = 5;
        final int yLocation = 7;
        int expectedMolesLeft = 0;
        whackAMoleGame.whack(xLocation, yLocation);
        assertEquals(expectedMolesLeft, whackAMoleGame.getMolesLeft());
    }

    /**
     * Test whack Mole, not found mole.
     */
    @Test
    public void testWhackMoleNotFound() {
        final int xPlaceLocation = 5;
        final int yPlaceLocation = 7;
        final int xWhackLocation = 8;
        final int yWhackLocation = 0;
        int expectedMolesLeft = 1;
        whackAMoleGame.place(xPlaceLocation, yPlaceLocation);
        whackAMoleGame.whack(xWhackLocation, yWhackLocation);
        assertEquals(expectedMolesLeft, whackAMoleGame.getMolesLeft());
    }

    /**
     * Test whack Mole, found mole.
     */
    @Test
    public void testWhackMoleFound() {
        final int xLocation = 5;
        final int yLocation = 7;
        int expectedMolesLeft = 0;
        whackAMoleGame.place(xLocation, yLocation);
        whackAMoleGame.whack(xLocation, yLocation);
        assertEquals(expectedMolesLeft, whackAMoleGame.getMolesLeft());
    }

    /**
     * Test whack Mole, using negative locations.
     */
    @Test
    public void testWhackMoleNegativeLocation() {
        final int xPlaceLocation = 5;
        final int yPlaceLocation = 7;
        final int xWhackLocation = -5;
        final int yWhackLocation = -4;
        int expectedMolesLeft = 1;
        whackAMoleGame.place(xPlaceLocation, yPlaceLocation);
        whackAMoleGame.whack(xWhackLocation, yWhackLocation);
        assertEquals(expectedMolesLeft, whackAMoleGame.getMolesLeft());
    }

    /**
     * Test whack Mole, locations greater than Grid dimension.
     */
    @Test
    public void testWhackMoleUsingLocationGreaterGridDimension() {
        final int xPlaceLocation = 5;
        final int yPlaceLocation = 7;
        final int xWhackLocation = 15;
        final int yWhackLocation = 14;
        int expectedMolesLeft = 1;
        whackAMoleGame.place(xPlaceLocation, yPlaceLocation);
        whackAMoleGame.whack(xWhackLocation, yWhackLocation);
        assertEquals(expectedMolesLeft, whackAMoleGame.getMolesLeft());
    }

}
