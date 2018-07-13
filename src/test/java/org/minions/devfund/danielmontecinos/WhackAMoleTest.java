package org.minions.devfund.danielmontecinos;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Class in charge to test WhackAMole class.
 */
public class WhackAMoleTest {
    private static final int ATTEMPTS = 50;
    private static final int GRID_DIMENSION = 10;

    private WhackAMole whackAMole;

    /**
     * Instantiates whackAMole object before tests begin.
     */
    @Before
    public void setUp() {
        whackAMole = new WhackAMole(ATTEMPTS, GRID_DIMENSION);
    }

    /**
     * Tests getScore method.
     */
    @Test
    public void testGetScoreMethod() {
        final int actualResult = whackAMole.getScore();
        final int expectedResult = 0;
        assertEquals(expectedResult, actualResult);
    }

    /**
     * Tests getMolesLeft method.
     */
    @Test
    public void testGetMolesLeftMethod() {
        final int actualResult = whackAMole.getMolesLeft();
        final int expectedResult = 0;
        assertEquals(expectedResult, actualResult);
    }

    /**
     * Tests getAttemptsLeft method.
     */
    @Test
    public void testGetAttemptsLeftMethod() {
        final int actualResult = whackAMole.getAttemptsLeft();
        final int expectedResult = 50;
        assertEquals(expectedResult, actualResult);
    }

    /**
     * Tests that place method adds a mole in a valid location.
     */
    @Test
    public void testPlaceMoleInAValidLocation() {
        final int xPosition = 0;
        final int yPosition = 9;
        assertTrue(whackAMole.place(xPosition, yPosition));
    }

    /**
     * Tests that place method adds a mole in an invalid location.
     */
    @Test
    public void testPlaceMoleInAnInvalidLocation() {
        final int xPosition = -1;
        final int yPosition = -1;
        assertFalse(whackAMole.place(xPosition, yPosition));
    }

    /**
     * Tests that place method doesn't add a mole in an invalid location.
     */
    @Test
    public void testPlaceMoleInAnAlreadyTakenLocation() {
        final int xPosition = 0;
        final int yPosition = 0;
        whackAMole.place(xPosition, yPosition);
        assertFalse(whackAMole.place(xPosition, yPosition));
    }

    /**
     * Tests whack method given an invalid location.
     */
    @Test
    public void testWhackInAnInvalidLocation() {
        final int xPosition = 10;
        final int yPosition = 10;
        final int expectedResult = 49;
        whackAMole.whack(xPosition, yPosition);
        assertEquals(expectedResult, whackAMole.getAttemptsLeft());
    }

    /**
     * Tests whack method in an invalid location where y is greater or equal than 0 and greater than array size.
     */
    @Test
    public void testWhackMethodGivenOneInvalidLocation() {
        final int xPosition = 0;
        final int yPosition = 10;
        final int expectedResult = 49;
        whackAMole.whack(xPosition, yPosition);
        assertEquals(expectedResult, whackAMole.getAttemptsLeft());
    }

    /**
     * Tests whack method in an invalid location where y is less than 0 and less than array size.
     */
    @Test
    public void testWhackMethodGivenAnotherInvalidLocation() {
        final int xPosition = 0;
        final int yPosition = -15;
        final int expectedResult = 49;
        whackAMole.whack(xPosition, yPosition);
        assertEquals(expectedResult, whackAMole.getAttemptsLeft());
    }

    /**
     * Tests that when a mole is whacked, score increments by one.
     */
    @Test
    public void testWhackALocationThatContainsAMoleIncrementsScore() {
        final int xPosition = 0;
        final int yPosition = 0;
        final int expectedResult = 1;
        whackAMole.place(xPosition, yPosition);
        whackAMole.whack(xPosition, yPosition);
        final int actualResult = whackAMole.getScore();
        assertEquals(expectedResult, actualResult);
    }

    /**
     * Tests that when a mole is whacked, attempts decrement by one.
     */
    @Test
    public void testWhackALocationThatContainsAMoleDecrementAttempts() {
        final int xPosition = 5;
        final int yPosition = 2;
        final int expectedResult = 49;
        whackAMole.place(xPosition, yPosition);
        whackAMole.whack(xPosition, yPosition);
        final int actualResult = whackAMole.getAttemptsLeft();
        assertEquals(expectedResult, actualResult);
    }

    /**
     * Tests that when a mole is whacked, moles left decrements by one.
     */
    @Test
    public void testWhackALocationThatContainsAMoleDecrementMoles() {
        final int xPosition = 5;
        final int yPosition = 2;
        final int expectedResult = 0;
        whackAMole.place(xPosition, yPosition);
        whackAMole.whack(xPosition, yPosition);
        final int actualResult = whackAMole.getMolesLeft();
        assertEquals(expectedResult, actualResult);
    }

    /**
     * Tests that when a mole is not whacked, attempts decrement by one.
     */
    @Test
    public void testWhackALocationThatDoesNotContainsAMoleDecrementAttempts() {
        final int xPosition = 3;
        final int yPosition = 0;
        final int noMoleXPosition = 9;
        final int noMoleYPosition = 9;
        final int expectedResult = 49;
        whackAMole.place(xPosition, yPosition);
        whackAMole.whack(noMoleXPosition, noMoleYPosition);
        final int actualResult = whackAMole.getAttemptsLeft();
        assertEquals(expectedResult, actualResult);
    }

    /**
     * Tests that when a mole is not whacked, score does not increment by one.
     */
    @Test
    public void testWhackALocationThatDoesNotContainsAMoleDoesNotIncrementScore() {
        final int xPosition = 6;
        final int yPosition = 3;
        final int noMoleXPosition = 0;
        final int noMoleYPosition = 3;
        final int expectedResult = 0;
        whackAMole.place(xPosition, yPosition);
        whackAMole.whack(noMoleXPosition, noMoleYPosition);
        final int actualResult = whackAMole.getScore();
        assertEquals(expectedResult, actualResult);
    }

    /**
     * Tests that when a mole is not whacked, moles left does not decrement by one.
     */
    @Test
    public void testWhackALocationThatDoesNotContainsAMoleDoesNotDecrementMolesLeft() {
        final int xPosition = 2;
        final int yPosition = 8;
        final int noMoleXPosition = 8;
        final int noMoleYPosition = 2;
        final int expectedResult = 1;
        whackAMole.place(xPosition, yPosition);
        whackAMole.whack(noMoleXPosition, noMoleYPosition);
        final int actualResult = whackAMole.getMolesLeft();
        assertEquals(expectedResult, actualResult);
    }

    /**
     * Tests printGridToUser method when no moles are placed on grid.
     */
    @Test
    public void testPrintGridToUserMethodWithNoMoles() {
        final int gridDimension = 4;
        final String expectedResult = "* * * * \n* * * * \n* * * * \n* * * * \n";
        whackAMole = new WhackAMole(ATTEMPTS, gridDimension);
        assertEquals(expectedResult, whackAMole.printGridToUser());
    }

    /**
     * Tests printGridToUser method when one mole is placed on grid.
     */
    @Test
    public void testPrintGridToUserMethodWithOneExistingMole() {
        final int gridDimension = 3;
        final int xPosition = 1;
        final int yPosition = 0;
        final String expectedResult = "* * * \n* * * \n* * * \n";
        whackAMole = new WhackAMole(ATTEMPTS, gridDimension);
        assertTrue(whackAMole.place(xPosition, yPosition));
        assertEquals(expectedResult, whackAMole.printGridToUser());
    }

    /**
     * Tests printGridToUser method when one mole gets whacked.
     */
    @Test
    public void testPrintGridToUserMethodWithAWhackedMole() {
        final int gridDimension = 5;
        final int xPosition = 0;
        final int yPosition = 1;
        final String expectedResult = "* W * * * \n* * * * * \n* * * * * \n* * * * * \n* * * * * \n";
        whackAMole = new WhackAMole(ATTEMPTS, gridDimension);
        assertTrue(whackAMole.place(xPosition, yPosition));
        whackAMole.whack(xPosition, yPosition);
        assertEquals(expectedResult, whackAMole.printGridToUser());
    }

    /**
     * Tests printGridToUser method when all moles get whacked.
     */
    @Test
    public void testPrintToGridUserWithAllMolesWhacked() {
        final int gridDimension = 2;
        final String expectedResult = "W W \nW W \n";
        int xPosition = 0;
        int yPosition = 0;
        whackAMole = new WhackAMole(ATTEMPTS, gridDimension);
        assertTrue(whackAMole.place(xPosition, yPosition));
        whackAMole.whack(xPosition, yPosition);
        xPosition = 0;
        yPosition = 1;
        assertTrue(whackAMole.place(xPosition, yPosition));
        whackAMole.whack(xPosition, yPosition);
        xPosition = 1;
        yPosition = 0;
        assertTrue(whackAMole.place(xPosition, yPosition));
        whackAMole.whack(xPosition, yPosition);
        xPosition = 1;
        yPosition = 1;
        assertTrue(whackAMole.place(xPosition, yPosition));
        whackAMole.whack(xPosition, yPosition);
        assertEquals(expectedResult, whackAMole.printGridToUser());
    }

    /**
     * Tests printGrid method when no moles are placed on grid.
     */
    @Test
    public void testPrintGridWithNoMoles() {
        final int gridDimension = 2;
        final String expectedResult = "* * \n* * \n";
        whackAMole = new WhackAMole(ATTEMPTS, gridDimension);
        assertEquals(expectedResult, whackAMole.printGrid());
    }

    /**
     * Tests printGrid method when one mole is placed on grid.
     */
    @Test
    public void testPrintGridMethodWithOneExistingMole() {
        final int gridDimension = 3;
        final int xPosition = 0;
        final int yPosition = 0;
        final String expectedResult = "M * * \n* * * \n* * * \n";
        whackAMole = new WhackAMole(ATTEMPTS, gridDimension);
        assertTrue(whackAMole.place(xPosition, yPosition));
        assertEquals(expectedResult, whackAMole.printGrid());
    }

    /**
     * Tests printGrid method when one mole gets whacked.
     */
    @Test
    public void testPrintGridMethodWithAWhackedMoleAndANoWhackedMole() {
        final int gridDimension = 2;
        final int xPosition = 0;
        final int yPosition = 1;
        final int anotherXPosition = 1;
        final int anotherYPosition = 1;
        final String expectedResult = "* W \n* M \n";
        whackAMole = new WhackAMole(ATTEMPTS, gridDimension);
        assertTrue(whackAMole.place(xPosition, yPosition));
        whackAMole.whack(xPosition, yPosition);
        assertTrue(whackAMole.place(anotherXPosition, anotherYPosition));
        assertEquals(expectedResult, whackAMole.printGrid());
    }
}
