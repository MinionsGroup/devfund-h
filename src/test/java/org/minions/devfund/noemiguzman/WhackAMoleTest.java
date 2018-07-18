package org.minions.devfund.noemiguzman;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * It is in charged to define the unit tests for WhackAMole class.
 */
public class WhackAMoleTest {
    private static final int NUM_ATTEMPTS =  10;
    private static final int GRID_DIMENSION = 10;
    private WhackAMole whackAMole;

    /**
     *Before tests setup.
     */
    @Before
    public void setUp() {
        whackAMole = new WhackAMole(NUM_ATTEMPTS, GRID_DIMENSION);
    }

    /**
     * This test get the wack a moles in the game.
     *
     */
    @Test
    public void testWhenIsFillingTheMoleGridWithDefaultCharacter() {

        char[][] actualResult = whackAMole.getMoleGrid();
        char expectedResult = '*';

        assertEquals(expectedResult, actualResult[0][0]);
        assertEquals(expectedResult, actualResult[1][1]);
        assertEquals(expectedResult, actualResult[2][2]);
        assertEquals(expectedResult, actualResult[GRID_DIMENSION - 1][GRID_DIMENSION - 1]);
    }
    /**
     * When a Whack is no contains a mole in the place.
     */
    @Test
    public void testWhenTheplaceNotContainsTheWhackAMole() {
        final int postX = 3;
        final int postY = 3;
        final int expectedMolesLeft = 1;

        whackAMole.place(postX, postY);
        whackAMole.whack(postX + 1, postY + 1);

        assertEquals(expectedMolesLeft, whackAMole.getMolesLeft());
    }

    /**
     * Whack a place that contains a mole test.
     */
    @Test
    public void testWhenContainsTheWhackAMole() {
        final int postX = 3;
        final int postY = 3;
        final int expectedMolesLeft = 0;

        whackAMole.place(postX, postY);
        whackAMole.whack(postX, postY);

        assertEquals(expectedMolesLeft, whackAMole.getMolesLeft());
    }

    /**
     * Place mole in row and column that is already taken test.
     */
    @Test
    public void testWhenThePlaceMoleInPlaceWithCharacterDefault() {
        final int postX = 1;
        final int postY = 1;

        whackAMole.place(postX, postY);

        assertFalse(whackAMole.place(postX, postY));
    }

    /**
     * This test for update the mole .
     *
     */
    @Test
    public void testForiIsUpdateTheMoleGrid() {
        final int postX = 1;
        final int postY = 1;

        assertTrue(whackAMole.place(postX, postY));
    }



    /**
     * Print the grid with M and W.
     */
    @Test
    public void testPrintGrid() {
        final int gridDimension = 3;
        final int attempts = 2;
        final int placementX = 0;
        final int placementY = 1;
        final int whackRow = 0;
        final int whackColumn = 0;
        final String expectedGrid = "W  M  *  \n*  *  *  \n*  *  *  \n";

        whackAMole = new WhackAMole(attempts, gridDimension);

        whackAMole.whack(whackRow, whackColumn);
        whackAMole.place(placementX, placementY);
        assertEquals(expectedGrid, whackAMole.printGrid());
    }

    /**
     * Print grid to user .
     */
    @Test
    public void testChangeMbyCharacterGridWhackToUser() {
        final int gridDimension = 3;
        final int attempts = 2;
        final int placementX = 0;
        final int placementY = 1;
        final int whackRow = 0;
        final int whackColumn = 0;
        final String expectedGrid = "W  *  *  \n*  *  *  \n*  *  *  \n";
        whackAMole = new WhackAMole(attempts, gridDimension);

        whackAMole.whack(whackRow, whackColumn);
        whackAMole.place(placementX, placementY);
        assertEquals(expectedGrid, whackAMole.printGridToUser());
    }

    /**
     * Get score test.
     */
    @Test
    public void getScoreTest() {
        final int expectedScore = 0;
        assertEquals(expectedScore, whackAMole.getScore());
    }

    /**
     * Get attempts test.
     */
    @Test
    public void getAttemptsLeftTest() {
        assertEquals(NUM_ATTEMPTS, whackAMole.getAttemptsLeft());
    }
}
