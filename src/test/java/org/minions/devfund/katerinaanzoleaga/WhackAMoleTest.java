package org.minions.devfund.katerinaanzoleaga;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * The test cases.
 */
public class WhackAMoleTest {

    private static final int ATTEMPTS_NUMBER = 10;

    private WhackAMole whackAMole;

    /**
     * Method that setup initial values.
     */
    @Before
    public void setup() {
        final int gridDimension = 10;
        whackAMole = new WhackAMole(ATTEMPTS_NUMBER, gridDimension);
    }

    /**
     * Method that verify the Grid dimension initial value defined in the constructor.
     */
    @Test
    public void testConstructorGrid() {
        final int numAttempts = 3;
        final int gridDimension = 5;
        whackAMole = new WhackAMole(numAttempts, gridDimension);
        assertEquals(gridDimension, whackAMole.getMoleGrid().length);
    }

    /**
     * Method that verify the initial value for number of attempts that is defined in the constructor.
     */
    @Test
    public void testConstructorNumOfAttempts() {
        final int numAttempts = 2;
        final int gridDimension = 3;
        whackAMole = new WhackAMole(numAttempts, gridDimension);
        assertEquals(numAttempts, whackAMole.getAttemptsLeft());
    }

    /**
     * Verify that a Mole is placed in the given position.
     */
    @Test
    public void testPlaceSucceed() {
        final int positionX = 6;
        final int positionY = 5;
        assertTrue(whackAMole.place(positionX, positionY));
    }

    /**
     * Verify that a Mole is not assigned in a position that has been already assigned.
     */
    @Test
    public void testPlaceFail() {
        final int positionX = 1;
        final int positionY = 2;
        whackAMole.place(positionX, positionY);
        assertFalse(whackAMole.place(positionX, positionY));
    }

    /**
     * Verify a whack is done in the given position.
     */
    @Test
    public void testWhackSucceedAttempts() {
        final int positionX = 4;
        final int positionY = 3;
        whackAMole.place(positionX, positionY);
        whackAMole.whack(positionX, positionY);
        char[][] grid = whackAMole.getMoleGrid();
        assertEquals(WhackAMole.WACKED, grid[positionX][positionY]);
    }

    /**
     * Method that verify a whack is not done in wrong position.
     */
    @Test
    public void testWhackFailAttempts() {
        final int positionX = 4;
        final int positionY = 3;
        final int positionToWhackX = 1;
        final int positionToWhackY = 2;
        whackAMole.place(positionX, positionY);
        whackAMole.whack(positionToWhackX, positionToWhackY);
        char[][] grid = whackAMole.getMoleGrid();
        assertEquals(WhackAMole.MOLE, grid[positionX][positionY]);
    }


    /**
     * Verify the moles left is not modified when a whack is not done in the right position.
     */
    @Test
    public void testWhackFailMolesLeft() {
        final int positionX = 4;
        final int positionY = 3;
        final int positionToWhackX = 1;
        final int positionToWhackY = 2;
        final int molesLeft = whackAMole.getMolesLeft();
        whackAMole.place(positionX, positionY);
        whackAMole.whack(positionToWhackX, positionToWhackY);
        assertEquals(molesLeft + 1, whackAMole.getMolesLeft());
    }

    /**
     * Verify the moles left is decremented when a whack is successful.
     */
    @Test
    public void testWhackSucceedMolesLeft() {
        final int positionX = 4;
        final int positionY = 3;
        final int molesLeft = whackAMole.getMolesLeft();
        whackAMole.place(positionX, positionY);
        whackAMole.whack(positionX, positionY);
        assertEquals(molesLeft, whackAMole.getMolesLeft());
    }

    /**
     * Verify the score is incremented when a whack is successful.
     */
    @Test
    public void testWhackScoreSucceed() {
        final int positionX = 2;
        final int positionY = 3;
        int score = whackAMole.getScore();
        whackAMole.place(positionX, positionY);
        whackAMole.whack(positionX, positionY);
        assertEquals(score + 1, whackAMole.getScore());
    }

    /**
     * Verify the score is not modified when a whack is not right.
     */
    @Test
    public void testWhackScoreFail() {
        final int positionX = 2;
        final int positionY = 3;
        final int positionToWhackX = 1;
        final int positionToWhackY = 2;
        int score = whackAMole.getScore();
        whackAMole.place(positionX, positionY);
        whackAMole.whack(positionToWhackX, positionToWhackY);
        assertEquals(score, whackAMole.getScore());
    }

    /**
     * Verify the attempts are decreased when a whack is made.
     */
    @Test
    public void testAttempts() {
        final int positionX = 3;
        final int positionY = 3;
        final int expectedAttempts = ATTEMPTS_NUMBER - 1;
        whackAMole.place(positionX, positionY);
        whackAMole.whack(positionX, positionY);
        assertEquals(expectedAttempts, whackAMole.getAttemptsLeft());
    }

    /**
     * Method that validate how a Grid should be displayed to an User.
     */
    @Test
    public void testPrintGridToUser() {
        final int gridDimension = 3;
        final String expectedGrid = "***\n*W*\n***\n";
        whackAMole = new WhackAMole(ATTEMPTS_NUMBER, gridDimension);
        whackAMole.place(1, 1);
        whackAMole.place(2, 2);
        whackAMole.whack(1, 1);
        assertEquals(expectedGrid, whackAMole.printGridToUser());
    }

    /**
     * Method that validate how a Grid should be displayed when game ends.
     */
    @Test
    public void testPrintGrid() {
        final int gridDimension = 3;
        final String expectedGrid = "***\n*W*\n**M\n";
        whackAMole = new WhackAMole(ATTEMPTS_NUMBER, gridDimension);
        whackAMole.place(1, 1);
        whackAMole.place(2, 2);
        whackAMole.whack(1, 1);
        assertEquals(expectedGrid, whackAMole.printGrid());
    }
}
