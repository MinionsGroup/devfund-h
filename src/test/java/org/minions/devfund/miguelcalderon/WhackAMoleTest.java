package org.minions.devfund.miguelcalderon;

import org.junit.Assert;
import org.junit.Test;


/**
 * Test for WhackAMole class.
 */
public class WhackAMoleTest {
    private WhackAMole whackAMole;

    /**
     * Test place a mole in a valid position.
     */
    @Test
    public void testPlaceValidPosition() {
        final int numAttempts = 3;
        final int gridDimension = 6;
        final int x = 4;
        final int y = 4;
        whackAMole = new WhackAMole(numAttempts, gridDimension);
        whackAMole.createEmptyGrid();
        boolean result = whackAMole.place(x, y);
        Assert.assertTrue(result);
    }

    /**
     * Test place a mole in a invalid position.
     */
    @Test
    public void testPlaceInvalidPosition() {
        final int numAttempts = 3;
        final int gridDimension = 6;
        final int x = 2;
        final int y = 7;
        whackAMole = new WhackAMole(numAttempts, gridDimension);
        boolean result = whackAMole.place(x, y);
        Assert.assertFalse(result);
    }

    /**
     * Test whack a position with a mole.
     */
    @Test
    public void testWhackSuceedPosition() {
        final int numAttempts = 2;
        final int gridDimension = 1;
        final int x = 0;
        final int y = 0;
        whackAMole = new WhackAMole(numAttempts, gridDimension);
        whackAMole.whack(x, y);
        Assert.assertTrue(whackAMole.getScore() > 0);
    }

    /**
     * Test whack an empty position.
     */
    @Test
    public void testWhackEmptyPosition() {
        final int numAttempts = 3;
        final int gridDimension = 3;
        whackAMole = new WhackAMole(numAttempts, gridDimension);
        char expectedValue = '*';
        char calculatedValue = 'x';
        for (int i = 0; i < whackAMole.getMoleGrid().length; i++) {
            for (int j = 0; j < whackAMole.getMoleGrid().length; j++) {
                if (whackAMole.getMoleGrid()[i][j] == '*') {
                    whackAMole.whack(i, j);
                    calculatedValue = whackAMole.getMoleGrid()[i][j];
                }
            }
        }


        Assert.assertEquals(expectedValue, calculatedValue);

    }

    /**
     * Test when a player give up.
     */
    @Test
    public void testGiveUpWithValidValues() {
        final int numAttempts = 2;
        final int gridDimension = 1;
        final int x = -1;
        final int y = -1;
        whackAMole = new WhackAMole(numAttempts, gridDimension);
        Assert.assertTrue(whackAMole.giveUp(x, y));
    }

    /**
     * Test enter values to don´t give up and continue playing.
     */
    @Test
    public void testGiveUpWithInvalidValues() {
        final int numAttempts = 2;
        final int gridDimension = 10;
        final int x = 5;
        final int y = 3;
        whackAMole = new WhackAMole(numAttempts, gridDimension);
        Assert.assertFalse(whackAMole.giveUp(x, y));
    }

    /**
     * Test print grid to user without the moles.
     */
    @Test
    public void testPrintGridToUserWithoutMoles() {
        final int numAttempts = 2;
        final int gridDimension = 4;
        whackAMole = new WhackAMole(numAttempts, gridDimension);
        String expectedResult = "****\n****\n****\n****\n";
        String calculatedResult = whackAMole.printGridToUser().toString();
        Assert.assertEquals(expectedResult, calculatedResult);

    }

    /**
     * Test print grid to user with the moles.
     */
    @Test
    public void testPrintGridToUserWithMoles() {
        final int numAttempts = 2;
        final int gridDimension = 4;
        final int x = 0;
        final int y = 0;
        whackAMole = new WhackAMole(numAttempts, gridDimension);
        whackAMole.createEmptyGrid();
        whackAMole.place(x, y);
        String expectedResult = "M***\n****\n****\n****\n";
        String calculatedResult = whackAMole.printGrid().toString();
        Assert.assertEquals(expectedResult, calculatedResult);

    }

    /**
     * Test create an empty grid with no moles.
     */
    @Test
    public void testCreateEmptyGrid() {
        final int numAttempts = 2;
        final int gridDimension = 4;
        whackAMole = new WhackAMole(numAttempts, gridDimension);
        whackAMole.createEmptyGrid();
        String expectedResult = "****\n****\n****\n****\n";
        String calculatedResult = whackAMole.printGrid().toString();
        Assert.assertEquals(expectedResult, calculatedResult);

    }

    /**
     * Test method that verifies a cell is empty.
     */
    @Test
    public void testIsEmptyCell() {
        final int numAttempts = 2;
        final int gridDimension = 4;
        whackAMole = new WhackAMole(numAttempts, gridDimension);
        char expectedValue = '*';
        char calculatedValue = 'x';
        for (int i = 0; i < whackAMole.getMoleGrid().length; i++) {
            for (int j = 0; j < whackAMole.getMoleGrid().length; j++) {
                if (whackAMole.getMoleGrid()[i][j] == '*') {
                    calculatedValue = whackAMole.getMoleGrid()[i][j];
                }
            }
        }
        Assert.assertEquals(expectedValue, calculatedValue);

    }


}
