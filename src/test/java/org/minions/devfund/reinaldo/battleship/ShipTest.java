package org.minions.devfund.reinaldo.battleship;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

/**
 * Test for {@link Ship}.
 */
public class ShipTest {

    private static final String MESSAGE = "There is a ship in that position";
    private Ship ship;

    /**
     * Test empty sea never sunks.
     */
    @Test
    public void testEmptySeaNeverSunks() {
        ship = new EmptySea();
        ship.setBowColumn(0);
        ship.setBowRow(0);
        assertFalse(MESSAGE, ship.shootAt(0, 0));
        assertFalse("The empty sea was sunk", ship.isSunk());
    }

    /**
     * Test the length to Cruiser.
     */
    @Test
    public void testCruiser() {
        ship = new Cruiser();
        final int cruiserLength = 6;
        assertEquals(cruiserLength, ship.getLength());
    }

    /**
     * Test is not possible to shoot a sunk ship.
     */
    @Test
    public void testShootToSunkShip() {
        final int posRow = 3;
        ship = new Submarine();
        ship.setHorizontal(false);
        ship.setBowColumn(1);
        ship.setBowRow(1);

        ship.shootAt(1, 1);
        ship.shootAt(2, 1);
        ship.shootAt(posRow, 1);

        assertEquals("x", ship.toString());
        assertFalse("The ship isn't sunk", ship.shootAt(1, 1));
    }

    /**
     * Test shoot an horizontal ship.
     */
    @Test
    public void testShootAHorizontalShip() {
        ship = new Submarine();
        ship.setHorizontal(true);
        ship.setBowColumn(1);
        ship.setBowRow(1);
        ship.shootAt(1, 1);
        ship.shootAt(1, 2);
        assertEquals("S", ship.toString());

        final int thirdColumn = 3;
        ship.shootAt(1, thirdColumn);
        assertEquals("x", ship.toString());
        assertFalse("The ship isn't sunk", ship.shootAt(1, 1));

    }

    /**
     * Test a shoot was missed in a vertical ship.
     */
    @Test
    public void testVerticalMissingShoot() {
        ship = new Submarine();
        ship.setHorizontal(false);
        ship.setBowColumn(1);
        ship.setBowRow(1);
        final int forthRow = 4;

        assertFalse(MESSAGE, ship.shootAt(0, 1));
        assertFalse(MESSAGE, ship.shootAt(forthRow, 1));
        assertFalse(MESSAGE, ship.shootAt(1, 0));
        assertFalse(MESSAGE, ship.shootAt(2, 2));
    }

    /**
     * Test a shoot was missed in a horizontal ship.
     */
    @Test
    public void testHorizontalMissingShoot() {
        ship = new Submarine();
        ship.setHorizontal(true);
        ship.setBowColumn(1);
        ship.setBowRow(1);
        final int forthColumn = 4;

        assertFalse(MESSAGE, ship.shootAt(1, 0));
        assertFalse(MESSAGE, ship.shootAt(1, forthColumn));
        assertFalse(MESSAGE, ship.shootAt(0, 1));
        assertFalse(MESSAGE, ship.shootAt(2, 1));
    }

    /**
     * Test if values of a positioned ship are set correctly.
     */
    @Test
    public void testGetBowPositionAndHorizontalValueForAPositionedShip() {
        ship = new Submarine();
        ship.setHorizontal(false);
        ship.setBowColumn(0);
        ship.setBowRow(0);
        assertFalse("The ship is horizontal", ship.isHorizontal());
        assertEquals(0, ship.getBowColumn());
        assertEquals(0, ship.getBowRow());
    }
}
