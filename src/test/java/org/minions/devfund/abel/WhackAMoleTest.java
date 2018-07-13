package org.minions.devfund.abel;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Test class for WhackAMole.
 */
public class WhackAMoleTest {

    private WhackAMole whackAMole;
    private static final int GRID_DIMENSION = 5;
    private static final int NUM_ATTEMPTS = 10;

    /**
     * Set Up method for unit tests.
     */
    @Before
    public void setUp() {
        whackAMole = new WhackAMole(NUM_ATTEMPTS, GRID_DIMENSION);
    }

    /**
     * Test WhackAMole constructor and default values.
     */
    @Test
    public void testWhackAMole() {
        final int expectedScore = 0;
        final int expectedAttemptsLeft = 10;
        assertEquals(expectedScore, whackAMole.getScore());
        assertEquals(expectedAttemptsLeft, whackAMole.getAttemptsLeft());
    }

    /**
     * Test WhackAMole place successful.
     */
    @Test
    public void testWhackAMolePlaceTrue() {
        final int row = 0;
        final int col = 0;
        assertTrue(whackAMole.place(row, col));
    }

    /**
     * Test WhackAMole place is already taken.
     */
    @Test
    public void testWhackAMolePlaceFalse() {
        final int row = 0;
        final int col = 0;
        whackAMole.place(row, col);
        assertFalse(whackAMole.place(row, col));
    }

    /**
     * Test WhackAMole place is out of Index.
     */
    @Test
    public void testWhackAMolePlaceFalseOutOfIndex() {
        final int row = 5;
        final int col = 5;
        whackAMole.place(row, col);
        assertFalse(whackAMole.place(row, col));
    }

    /**
     * Test WhackAMole place is out of Index.
     */
    @Test
    public void testWhackAMolePlaceFalseOutOfIndexLower() {
        final int row = -3;
        final int col = -5;
        whackAMole.place(row, col);
        assertFalse(whackAMole.place(row, col));
    }

    /**
     * Test WhackAMole place update molesLeft.
     */
    @Test
    public void testWhackAMolePlaceTrueGetMolesLeft() {
        final int row = 0;
        final int col = 0;
        whackAMole.place(row, col);
        assertEquals(1, whackAMole.getMolesLeft());
    }

    /**
     * Test WhackAMole place don't update molesLeft if Out of Index.
     */
    @Test
    public void testWhackAMolePlaceFalseGetMolesLeft() {
        final int row = -5;
        final int col = 0;
        whackAMole.place(row, col);
        assertEquals(0, whackAMole.getMolesLeft());
    }

    /**
     * Test WhackAMole place don't update molesLeft if Out of Index.
     */
    @Test
    public void testWhackAMolePlaceFalseGetMolesLeftChange() {
        final int row = 0;
        final int col = -5;
        whackAMole.place(row, col);
        assertEquals(0, whackAMole.getMolesLeft());
    }

    /**
     * Test WhackAMole whack a mole successful.
     */
    @Test
    public void testWhackAMoleNoMole() {
        final int row = 0;
        final int col = 0;
        final int expectedAttemptsLeft = 9;
        whackAMole.whack(row, col);
        assertEquals(expectedAttemptsLeft, whackAMole.getAttemptsLeft());
    }

    /**
     * Test WhackAMole whack a mole successful and update score and molesLeft.
     */
    @Test
    public void testWhackAMoleMoleWhacked() {
        final int row = 0;
        final int col = 0;
        final int expectedAttemptsLeft = 9;
        final int expectedScore = 1;
        final int expectedMolesLeft = 0;

        whackAMole.place(row, col);
        whackAMole.whack(row, col);
        assertEquals(expectedAttemptsLeft, whackAMole.getAttemptsLeft());
        assertEquals(expectedScore, whackAMole.getScore());
        assertEquals(expectedMolesLeft, whackAMole.getMolesLeft());
    }

    /**
     * Test WhackAMole whack a mole out of index.
     */
    @Test
    public void testWhackAMoleMoleOutOfIndex() {
        final int row = 5;
        final int col = 5;
        final int expectedAttemptsLeft = 9;
        whackAMole.whack(row, col);
        assertEquals(expectedAttemptsLeft, whackAMole.getAttemptsLeft());
    }

    /**
     * Test WhackAMole printGridToUser with whacked moles.
     */
    @Test
    public void testWhackAMolePrintGridToUserWithWhackedMoles() {
        String expected = "W****\n*****\n*****\n*****\n*****\n";
        final int row = 0;
        final int col = 0;
        whackAMole.place(row, col);
        whackAMole.whack(row, col);
        assertEquals(expected, whackAMole.printGridToUser());
    }

    /**
     * Test WhackAMole printGridToUser without whacked moles.
     */
    @Test
    public void testWhackAMolePrintGridToUserEmpty() {
        String expected = "*****\n*****\n*****\n*****\n*****\n";
        final int row = 0;
        final int col = 0;
        whackAMole.place(row, col);
        assertEquals(expected, whackAMole.printGridToUser());
    }

    /**
     * Test WhackAMole printGrid with moles and whacked moles.
     */
    @Test
    public void testWhackAMolePrintGrid() {
        String expected = "W****\n*****\n*****\n*****\n****M\n";
        final int rowOne = 0;
        final int colOne = 0;
        whackAMole.place(rowOne, colOne);
        final int rowTwo = 4;
        final int colTwo = 4;
        whackAMole.place(rowTwo, colTwo);
        whackAMole.whack(rowOne, colOne);
        assertEquals(expected, whackAMole.printGrid());
    }
}
