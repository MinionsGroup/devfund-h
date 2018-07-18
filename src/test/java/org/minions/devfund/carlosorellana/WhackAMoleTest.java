package org.minions.devfund.carlosorellana;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


/**
 * The goal is test the WhackAMole.
 *
 * @author Carlos Orellana.
 * @since 07/10/2018.
 */
public class WhackAMoleTest {

    private static final int NUM_ATTEMPTS = 50;
    private static final int GRID_DIMENSION = 10;
    private WhackAMole whackAMole;
    private static final String MESSAGE_ERROR = "The Position send to grid are correct";
    private static final String MESSAGE_PRINT_ERROR = "The Print Grid method does not return the expected String";

    /**
     * Set ups method.
     */
    @Before
    public void setUp() {
        whackAMole = new WhackAMole(NUM_ATTEMPTS, GRID_DIMENSION);
    }

    /**
     * Validate Score Before Game.
     */
    @Test
    public void validateScoreBeforeGame() {
        final int expectedScore = 0;
        assertEquals(expectedScore, whackAMole.getScore());
    }

    /**
     * Validate Attempts Assigned.
     */
    @Test
    public void validateAttemptsAssigned() {
        assertEquals(NUM_ATTEMPTS, whackAMole.getAttemptsLeft());
    }

    /**
     * Validate Moles positions pending to play.
     */
    @Test
    public void validateMolesLeft() {
        final int xPos = 7;
        final int yPos = 9;
        final int expectedResult = 49;
        whackAMole.whack(xPos, yPos);
        assertEquals(expectedResult, whackAMole.getAttemptsLeft());
    }

    /**
     * Validate Score when One mole is found in Maximum Position.
     */
    @Test
    public void validateGetScoreWhenOneMoleIsFoundMaximum() {
        final int xPos = 10;
        final int yPos = 10;
        final int expectedResult = 1;
        whackAMole.place(xPos, yPos);
        whackAMole.whack(xPos, yPos);
        assertEquals(expectedResult, whackAMole.getScore());
    }

    /**
     * Validate Score when One mole is found in Minimum Position.
     */
    @Test
    public void validateGetScoreWhenOneMoleIsFoundMinimum() {
        final int xPos = 1;
        final int yPos = 1;
        final int expectedResult = 1;
        whackAMole.place(xPos, yPos);
        whackAMole.whack(xPos, yPos);
        assertEquals(expectedResult, whackAMole.getScore());
    }

    /**
     * Validate Score when one Moles is found.
     */
    @Test
    public void validateGetScoreWhenOneMoleIsFound() {
        final int xPos = 7;
        final int yPos = 9;
        final int expectedResult = 1;
        whackAMole.place(xPos, yPos);
        whackAMole.whack(xPos, yPos);
        assertEquals(expectedResult, whackAMole.getScore());
    }

    /**
     * Validate Score when Four Mole is found.
     */
    @Test
    public void validateGetScoreWhenFourMoleIsFound() {
        final  int xPosMole1 = 7;
        final int yPosMole1 = 9;

        final int xPosMole2 = 8;
        final int yPosMole2 = 1;

        final int xPosMole3 = 1;
        final int yPosMole3 = 10;

        final int xPosMole4 = 10;
        final int yPosMole4 = 1;

        final int expectedResult = 4;

        whackAMole.place(xPosMole1, yPosMole1);
        whackAMole.place(xPosMole2, yPosMole2);
        whackAMole.place(xPosMole3, yPosMole3);
        whackAMole.place(xPosMole4, yPosMole4);

        whackAMole.whack(xPosMole1, yPosMole1);
        whackAMole.whack(xPosMole2, yPosMole2);
        whackAMole.whack(xPosMole3, yPosMole3);
        whackAMole.whack(xPosMole4, yPosMole4);

        assertEquals(expectedResult, whackAMole.getScore());
    }

    /**
     * Validate score when Two moles was found and One mole is incorrect.
     */
    @Test
    public void validateGetScoreWhenTwoCorrectMolesFoundAndOneIncorrect() {
        final int xPosMole1 = 7;
        final int yPosMole1 = 9;

        final int xPosMole2 = 5;
        final int yPosMole2 = 5;

        final int xPosMole3 = 9;
        final int yPosMole3 = 1;

        final int xPosMole3Failed = 1;
        final int yPosMole3Failed = 9;

        final int expectedResult = 2;
        whackAMole.place(xPosMole1, yPosMole1);
        whackAMole.place(xPosMole2, yPosMole2);
        whackAMole.place(xPosMole3, yPosMole3);

        whackAMole.whack(xPosMole1, yPosMole1);
        whackAMole.whack(xPosMole2, yPosMole2);
        whackAMole.whack(xPosMole3Failed, yPosMole3Failed);

        assertEquals(expectedResult, whackAMole.getScore());
    }

    /**
     * Validate the Moles Left found.
     */
    @Test
    public void validateGetScoreWhenOneCorrectMolesFoundAndOneIncorrectResult() {
        final int xPosMole1 = 7;
        final int yPosMole1 = 9;

        final int xPosMole2 = 9;
        final int yPosMole2 = 1;

        final int xPosMole2Failed = 1;
        final int yPosMole2Failed = 9;

        final int expectedResult = 1;
        whackAMole.place(xPosMole1, yPosMole1);
        whackAMole.place(xPosMole2, yPosMole2);

        whackAMole.whack(xPosMole1, yPosMole1);
        whackAMole.whack(xPosMole2Failed, yPosMole2Failed);

        assertEquals(expectedResult, whackAMole.getMolesLeft());
    }

    /**
     * Validate the message if the number of attempts is greater than 50.
     */
    @Test
    public void validateGetAttemptsMessage() {
        String  messageAttempts = "The number of attempts exceeds the allowed";

        final int xPosMole1 = 7;
        final int yPosMole1 = 9;

        int attempts = NUM_ATTEMPTS;

        while (attempts > 0) {
            whackAMole.place(xPosMole1, yPosMole1);
            whackAMole.whack(xPosMole1, yPosMole1);
            attempts--;
        }

        whackAMole.whack(xPosMole1, yPosMole1);

        assertEquals(messageAttempts, whackAMole.getMessageAttempts());
    }

    /**
     * validate Place Result is True when the positions are correct.
     */
    @Test
    public void validatePlaceResultIsTrueWhenPositionsAreCorrect() {
        final int xPos = 10;
        final int yPos = 10;

        assertTrue("The Position send to grid are incorrect", whackAMole.place(xPos, yPos));
    }

    /**
     * validate Place Result is False when the mole was already placed.
     */
    @Test
    public void validatePlaceResultIsFalseWhenMolesWasAlreadyPlaced() {
        final int xPos = 5;
        final int yPos = 5;
        whackAMole.place(xPos, yPos);

        assertFalse(MESSAGE_ERROR, whackAMole.place(xPos, yPos));
    }

    /**
     * validate Place Result is False when the positions on X are negative.
     */
    @Test
    public void validatePlaceResultIsFalseWhenPositionsOnXAreNegative() {
        final int xPos = -10;
        final int yPos = 1;

        assertFalse(MESSAGE_ERROR, whackAMole.place(xPos, yPos));
    }

    /**
     * validate Place Result is False when the positions on X are incorrect.
     */
    @Test
    public void validatePlaceResultIsFalseWhenPositionsOnXAreIncorrect() {
        final int xPos = 20;
        final int yPos = 1;

        assertFalse(MESSAGE_ERROR, whackAMole.place(xPos, yPos));
    }

    /**
     * validate Place Result is False when the positions on Y are negative.
     */
    @Test
    public void validatePlaceResultIsFalseWhenPositionsOnYAreNegative() {
        final int xPos = 1;
        final int yPos = -10;

        assertFalse(MESSAGE_ERROR, whackAMole.place(xPos, yPos));
    }

    /**
     * validate Place Result is False when the positions on Y are incorrect.
     */
    @Test
    public void validatePlaceResultIsFalseWhenPositionsOnYAreIncorrect() {
        final int xPos = 1;
        final int yPos = 20;

        assertFalse(MESSAGE_ERROR, whackAMole.place(xPos, yPos));
    }

    /**
     * validate that PrintGrid method return the string with the value M..
     */
    @Test
    public void validatePrintGridStringWithInvalidPosition() {
        final int xPos = 0;
        final int yPos = 0;
        whackAMole.place(xPos, yPos);

        assertFalse(MESSAGE_PRINT_ERROR,
                whackAMole.printGrid().contains("M"));
    }

    /**
     * validate that PrintGrid method return the string with the value M..
     */
    @Test
    public void validatePrintGridStringWithValidPostion() {
        final int xPos = 5;
        final int yPos = 5;
        whackAMole.place(xPos, yPos);

        assertTrue(MESSAGE_PRINT_ERROR,
                whackAMole.printGrid().contains("M"));
    }

    /**
     * validate that PrintGrid method return the string with the value W..
     */
    @Test
    public void validatePrintGridUserStringWithInvalidPosition() {
        final int xPos = 0;
        final int yPos = 0;
        whackAMole.place(xPos, yPos);
        whackAMole.whack(xPos, yPos);

        assertFalse(MESSAGE_PRINT_ERROR,
                whackAMole.printGridToUser().contains("W"));
    }

    /**
     * validate that PrintGrid method return the string with the value W..
     */
    @Test
    public void validatePrintGridUserStringWithValidPosition() {
        final int xPos = 3;
        final int yPos = 7;
        whackAMole.place(xPos, yPos);
        whackAMole.whack(xPos, yPos);

        assertTrue(MESSAGE_PRINT_ERROR,
                whackAMole.printGridToUser().contains("W"));
    }
}
