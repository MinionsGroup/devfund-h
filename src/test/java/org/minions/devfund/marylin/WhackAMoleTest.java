package org.minions.devfund.marylin;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

/**
 * Class to run unit test against WhackAMole.java class.
 */
public class WhackAMoleTest {
    WhackAMole whackAMole;
    char[][] expectedMoleGrid;
    char[][] expectedMoleGridPlacedMole;

    @Before
    public void setUp() {
        expectedMoleGrid = new char[][]{{'*', '*', '*'}, {'*', '*', '*'}, {'*', '*', '*'}};
        whackAMole = new WhackAMole(3, 3);
    }


    public boolean isGridEquals(char[][] actualGrid) {
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
        int expectedNumOfAddemps = 3;
        assertEquals(expectedNumOfAddemps, whackAMole.getAttemptsLeft());
    }

    /**
     * Method to .
     */
    @Test
    public void testPlaceSucceed() {
    assertTrue(whackAMole.place(1,1));
    }

    /**
     * Method to .
     */
    @Test
    public void testPlaceFail() {
        whackAMole.place(2,2);
        assertFalse(whackAMole.place(2,2));
    }

    /**
     * Method to .
     */
    @Test
    public void testWhackSucceedAttempts() {
        int originalAttempsLeft = whackAMole.getAttemptsLeft();
        whackAMole.place(1,2);
        whackAMole.whack(1, 2);

        assertEquals(originalAttempsLeft - 1,whackAMole.getAttemptsLeft());
    }

    /**
     * Method to .
     */
    @Test
    public void testWhackFailAttempts() {
        int originalAttempsLeft = whackAMole.getAttemptsLeft();
        whackAMole.whack(0, 2);

        assertEquals(originalAttempsLeft - 1,whackAMole.getAttemptsLeft());
    }
}
