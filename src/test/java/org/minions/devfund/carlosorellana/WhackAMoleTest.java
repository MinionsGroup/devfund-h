package org.minions.devfund.carlosorellana;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

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

    /**
     * Set ups method.
     */
    @Before
    public void setUp() {
        whackAMole = new WhackAMole(NUM_ATTEMPTS,GRID_DIMENSION);
    }

    /**
     * Validate Score Before Game.
     */
    @Test
    public void validateScoreBeforeGame() {
        int expectedScore = 0;
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
        int xPos = 7;
        int yPos = 9;
        int expectedResult = 49;
        whackAMole.whack(xPos, yPos);
        assertEquals(expectedResult, whackAMole.getAttemptsLeft());
    }

    /**
     * Validate Score when One mole is found in Maximum Position
     */
    @Test
    public void validateGetScoreWhenOneMoleIsFoundMaximum() {
        int xPos = 10;
        int yPos = 10;
        int expectedResult = 1;
        whackAMole.place(xPos, yPos);
        whackAMole.printGrid();
        whackAMole.whack(xPos, yPos);
        whackAMole.printGridToUser();
        assertEquals(expectedResult, whackAMole.getScore());
    }

    /**
     * Validate Score when One mole is found in Minimum Position
     */
    @Test
    public void validateGetScoreWhenOneMoleIsFoundMinimum() {
        int xPos = 1;
        int yPos = 1;
        int expectedResult = 1;
        whackAMole.place(xPos, yPos);
        whackAMole.printGrid();
        whackAMole.whack(xPos, yPos);
        whackAMole.printGridToUser();
        assertEquals(expectedResult, whackAMole.getScore());
    }

    /**
     * Validate Score when one Moles is found.
     */
    @Test
    public void validateGetScoreWhenOneMoleIsFound() {
        int xPos = 7;
        int yPos = 9;
        int expectedResult = 1;
        whackAMole.place(xPos, yPos);
        whackAMole.printGrid();
        whackAMole.whack(xPos, yPos);
        whackAMole.printGridToUser();
        assertEquals(expectedResult, whackAMole.getScore());
    }

    /**
     * Validate Score when Four Mole is found.
     */
    @Test
    public void validateGetScoreWhenFourMoleIsFound() {
        int xPosMole1 = 7;
        int yPosMole1 = 9;

        int xPosMole2 = 8;
        int yPosMole2 = 1;

        int xPosMole3 = 1;
        int yPosMole3 = 10;

        int xPosMole4 = 10;
        int yPosMole4 = 1;

        int expectedResult = 4;

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
        int xPosMole1 = 7;
        int yPosMole1 = 9;

        int xPosMole2 = 5;
        int yPosMole2 = 5;

        int xPosMole3 = 9;
        int yPosMole3 = 1;

        int xPosMole3Failed = 1;
        int yPosMole3Failed = 9;

        int expectedResult = 2;
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
        int xPosMole1 = 7;
        int yPosMole1 = 9;

        int xPosMole2 = 9;
        int yPosMole2 = 1;

        int xPosMole2Failed = 1;
        int yPosMole2Failed = 9;

        int expectedResult = 1;
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
        int xPosMole1 = 7;
        int yPosMole1 = 9;

        int attempts = 50;

        while(attempts > 0) {
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
        int xPos = 10;
        int yPos = 10;

        assertTrue("The Position send to grid are incorrect", whackAMole.place(xPos, yPos));
    }

    /**
     * validate Place Result is False when the positions are incorrect.
     */
    @Test
    public void validatePlaceResultIsFalseWhenPositionsAreIncorrect() {
        int xPos = 0;
        int yPos = 0;

        assertFalse("The Position send to grid are correct", whackAMole.place(xPos, yPos) );
    }
}