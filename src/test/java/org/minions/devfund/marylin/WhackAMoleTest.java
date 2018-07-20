package org.minions.devfund.marylin;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Class to run unit test against WhackAMole.java class.
 */
public class WhackAMoleTest {
    private WhackAMole whackAMole;
    private char[][] expectedMoleGrid;

    /**
     * Before method to create the expected initial grid and an instance of the whackAMole class.
     */
    @Before
    public void setUp() {
        final int numAttempts = 3;
        final int gridDimension = 3;
        expectedMoleGrid = new char[][]{{'*', '*', '*'}, {'*', '*', '*'}, {'*', '*', '*'}};
        whackAMole = new WhackAMole(numAttempts, gridDimension);
    }


    /**
     * Method to compare the expected with the actual grid.
     *
     * @param actualGrid actualGrid.
     * @return true if the grids are equal or false otherwise.
     */
    public boolean isGridEquals(final char[][] actualGrid) {
        boolean gridsAreEguals = true;
        for (int i = 0; i < expectedMoleGrid.length; i++) {
            for (int j = 0; j < expectedMoleGrid.length; j++) {
                if (expectedMoleGrid[i][j] != actualGrid[i][j]) {
                    gridsAreEguals = false;
                }
            }
        }
        return gridsAreEguals;
    }

    /**
     * Method to .
     */
    @Test
    public void testConstructorGrid() {
        assertTrue(isGridEquals(whackAMole.getMoleGrid()));
    }

    /**
     * Method to.
     */
    @Test
    public void testConstructorNumOfAttempts() {
        final int expectedNumOfAddemps = 3;
        assertEquals(expectedNumOfAddemps, whackAMole.getAttemptsLeft());
    }

    /**
     * Method to .
     */
    @Test
    public void testPlaceSucceed() {
        assertTrue(whackAMole.place(1, 1));
    }

    /**
     * Method to .
     */
    @Test
    public void testPlaceFail() {
        whackAMole.place(2, 2);
        assertFalse(whackAMole.place(2, 2));
    }

    /**
     * Method to .
     */
    @Test
    public void testWhackSucceedAttempts() {
        int originalAttempsLeft = whackAMole.getAttemptsLeft();
        whackAMole.place(1, 2);
        whackAMole.whack(1, 2);

        assertEquals(originalAttempsLeft - 1, whackAMole.getAttemptsLeft());
    }

    /**
     * Method to .
     */
    @Test
    public void testWhackFailAttempts() {
        int originalAttempsLeft = whackAMole.getAttemptsLeft();
        whackAMole.whack(0, 2);

        assertEquals(originalAttempsLeft - 1, whackAMole.getAttemptsLeft());
    }

    /**
     * Method to .
     */
    @Test
    public void testMolesLefts() {
        whackAMole.place(1, 1);
        whackAMole.place(1, 2);
        whackAMole.whack(1, 2);
        assertEquals(1, whackAMole.getMolesLeft());
    }

    /**
     * Method to .
     */
    @Test
    public void testScore() {
        whackAMole.place(1, 1);
        whackAMole.place(1, 2);
        whackAMole.whack(1, 2);
        assertEquals(1, whackAMole.getScore());
    }

    /**
     * Method to .
     */
    @Test
    public void testprintGridToUser() {
        final String expectedGrid = "* * * * W * * * *";
        whackAMole.place(1, 1);
        whackAMole.place(2, 2);
        whackAMole.whack(1, 1);
        assertEquals(expectedGrid, whackAMole.printGridToUser().toString().trim());
    }

    /**
     * Method to .
     */
    @Test
    public void testprintGrid() {
        final String expectedGrid = "* * * * W * * * M";
        whackAMole.place(1, 1);
        whackAMole.place(2, 2);
        whackAMole.whack(1, 1);
        assertEquals(expectedGrid, whackAMole.printGrid().toString().trim());
    }
}
