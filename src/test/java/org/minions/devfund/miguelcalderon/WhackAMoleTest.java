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

        whackAMole = new WhackAMole(3, 3);
        boolean result = whackAMole.place(1, 1);
        Assert.assertTrue(result);
    }

    /**
     * Test place a mole in a invalid position.
     */
    @Test
    public void testPlaceInvalidPosition() {

        whackAMole = new WhackAMole(3, 3);
        boolean result = whackAMole.place(77, 9);
        Assert.assertFalse(result);
    }

    /**
     * Test whack a position with a mole.
     */
    @Test
    public void testWhackSuceedPosition() {

        whackAMole = new WhackAMole(2, 1);
        whackAMole.whack(0, 0);
        Assert.assertTrue(whackAMole.getScore() > 0);
    }

    /**
     * Test whack an empty position.
     */
    @Test
    public void testWhackEmptyPosition() {

        whackAMole = new WhackAMole(3, 4);
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
     * Test when a player give up
     */
    @Test
    public void testGiveUpWithValidValues() {

        whackAMole = new WhackAMole(2, 1);
        Assert.assertTrue(whackAMole.giveUp(-1, -1));
    }

    /**
     * Test enter values to don´t give up and continue playing.
     */
    @Test
    public void testGiveUpWithInvalidValues() {

        whackAMole = new WhackAMole(2, 10);
        Assert.assertFalse(whackAMole.giveUp(5, 3));
    }

    /**
     * Test print grid to user without the moles.
     */
    @Test
    public void testPrintGridToUserWithoutMoles() {

        whackAMole = new WhackAMole(2, 4);
        String expectedResult = "****\n****\n****\n****\n";
        String calculatedResult = whackAMole.printGridToUser().toString();
        Assert.assertEquals(expectedResult, calculatedResult);

    }

    /**
     * Test print grid to user with the moles.
     */
    @Test
    public void testPrintGridToUserWithMoles() {

        whackAMole = new WhackAMole(2, 4);
        whackAMole.createEmptyGrid();
        whackAMole.place(0, 0);
        String expectedResult = "M***\n****\n****\n****\n";
        String calculatedResult = whackAMole.printGrid().toString();
        Assert.assertEquals(expectedResult, calculatedResult);

    }

    /**
     * Test create an empty grid with no moles-
     */
    @Test
    public void testCreateEmptyGrid() {

        whackAMole = new WhackAMole(2, 4);
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

        whackAMole = new WhackAMole(2, 4);
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