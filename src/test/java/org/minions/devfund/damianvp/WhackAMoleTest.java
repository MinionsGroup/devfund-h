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
        assertTrue(whackAMoleGame.place(0, 0));
        assertEquals(1, whackAMoleGame.getMolesLeft());
    }

    /**
     * Test place Mole using negative locations.
     */
    @Test
    public void testPlaceMoleUsingNegativeLocations() {
        int expectedMolesLeft = 0;
        assertFalse(whackAMoleGame.place(-1, -1));
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
        assertTrue(whackAMoleGame.place(1, 1));
        assertFalse(whackAMoleGame.place(1, 1));
        assertEquals(1, whackAMoleGame.getMolesLeft());
    }

    /**
     * Test place Mole using only one invalid location. (greater than size)
     */
    @Test
    public void testPlaceMoleUsingOneInvalidLocation() {
        final int xValidLocation = 3;
        final int yValidLocation = 5;
        final int xInvalidLocation = 15;
        final int yInvalidLocation = 15;
        assertFalse(whackAMoleGame.place(xValidLocation, yInvalidLocation));
        assertFalse(whackAMoleGame.place(xInvalidLocation, yValidLocation));
        assertEquals(0, whackAMoleGame.getMolesLeft());
    }

    /**
     * Test place Mole using only one invalid location. (negative values)
     */
    @Test
    public void testPlaceMoleUsingOneInvalidLocationNegativeValues() {
        final int xValidLocation = 3;
        final int yValidLocation = 5;
        final int xInvalidLocation = -3;
        final int yInvalidLocation = -3;
        assertFalse(whackAMoleGame.place(xValidLocation, yInvalidLocation));
        assertFalse(whackAMoleGame.place(xInvalidLocation, yValidLocation));
        assertEquals(0, whackAMoleGame.getMolesLeft());
    }

    /**
     * Test whack Mole whit empty grid.
     */
    @Test
    public void testWhackMoleWithEmptyGrid() {
        final int xLocation = 5;
        final int yLocation = 7;
        whackAMoleGame.whack(xLocation, yLocation);
        assertEquals(0, whackAMoleGame.getMolesLeft());
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
        whackAMoleGame.place(xPlaceLocation, yPlaceLocation);
        whackAMoleGame.whack(xWhackLocation, yWhackLocation);
        assertEquals(1, whackAMoleGame.getMolesLeft());
    }

    /**
     * Test whack Mole, found mole.
     */
    @Test
    public void testWhackMoleFound() {
        final int xLocation = 5;
        final int yLocation = 7;
        whackAMoleGame.place(xLocation, yLocation);
        whackAMoleGame.whack(xLocation, yLocation);
        assertEquals(0, whackAMoleGame.getMolesLeft());
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
        whackAMoleGame.place(xPlaceLocation, yPlaceLocation);
        whackAMoleGame.whack(xWhackLocation, yWhackLocation);
        assertEquals(1, whackAMoleGame.getMolesLeft());
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
        whackAMoleGame.place(xPlaceLocation, yPlaceLocation);
        whackAMoleGame.whack(xWhackLocation, yWhackLocation);
        assertEquals(1, whackAMoleGame.getMolesLeft());
    }

    /**
     * Test get score method.
     */
    @Test
    public void testGetScoreMethod() {
        final int xLocation = 5;
        final int yLocation = 7;
        whackAMoleGame.place(xLocation, yLocation);
        whackAMoleGame.whack(xLocation, yLocation);
        assertEquals(1, whackAMoleGame.getScore());
    }

    /**
     * Test getTrackerMethod.
     */
    @Test
    public void testGetTrackedMoleGrid() {
        char[][] expectedGrid = {
                {'W', '*', '*', '*', '*', '*', '*', '*', '*', '*'},
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
        whackAMoleGame.place(0, 0);
        whackAMoleGame.whack(0, 0);
        whackAMoleGame.whack(1, 1);
        assertArrayEquals(expectedGrid, whackAMoleGame.getTrackerMoleGrid());

    }

}
