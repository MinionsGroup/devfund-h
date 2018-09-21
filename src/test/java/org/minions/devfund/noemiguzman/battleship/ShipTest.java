package org.minions.devfund.noemiguzman.battleship;


import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * class to test ship methods.
 */
public class ShipTest {
    /**
     * test get ship type.
     */
    @Test
    public void testGetShipType() {
        Ship ship = new BattleShip();
        assertEquals("battleship", ship.getShipType());

    }

    /**
     * method to test ok to place ship.
     */
    @Test
    public void testOkToPlaceShipAt() {
        final int column17 = 17;
        final int row12 = 12;
        final int row15 = 15;
        final int column10 = 10;
        Ship ship = new BattleShip();
        Ocean ocean = new Ocean();
        assertFalse(ship.okToPlaceShipAt(0, column17, true, ocean));
        assertTrue(ship.okToPlaceShipAt(0, column10, true, ocean));
        assertFalse(ship.okToPlaceShipAt(row15, column17, false, ocean));
        assertTrue(ship.okToPlaceShipAt(row12, column10, false, ocean));
    }

    /**
     * method to test ok place ship.
     */
    @Test
    public void testOkToPlaceShipAt2() {
        final int column10 = 10;
        final int column13 = 13;
        final int column4 = 4;

        Ship ship1 = new BattleShip();
        Ship ship2 = new BattleShip();
        Ocean ocean = new Ocean();
        assertTrue(ship1.okToPlaceShipAt(0, column10, true, ocean));
        ship1.placeShipAt(0, column10, true, ocean);
        assertTrue(ship2.okToPlaceShipAt(1, 0, false, ocean));
        assertTrue(ship2.okToPlaceShipAt(1, 0, true, ocean));
        assertFalse(ship2.okToPlaceShipAt(1, column4, true, ocean));
        assertFalse(ship2.okToPlaceShipAt(1, column13, false, ocean));
    }

    /**
     * method to test is sunk.
     */
    @Test
    public void testIsSunk() {
        final int place8 = 8;
        Ocean ocean = new Ocean();
        BattleShip ship = new BattleShip();
        ship.placeShipAt(0, 0, true, ocean);
        for (int j = 0; j < place8; j++) {
            ocean.shootAt(0, j);
        }

        assertTrue(ship.isSunk());

    }

    /**
     * method to test sunk.
     */
    @Test
    public void testIsSunk2() {
        final int place7 = 7;
        Ocean ocean = new Ocean();
        BattleShip ship = new BattleShip();
        ship.placeShipAt(0, 0, true, ocean);
        for (int j = 0; j < place7; j++) {
            ocean.shootAt(0, j);
        }

        assertFalse(ship.isSunk());

    }

    /**
     * method to test to string.
     */
    @Test
    public void testToString() {
        final int place8 = 8;
        Ocean ocean = new Ocean();
        BattleShip ship = new BattleShip();
        ship.placeShipAt(0, 0, true, ocean);
        for (int j = 0; j < place8; j++) {
            ocean.shootAt(0, j);
        }

        assertEquals("x", ship.toString());

    }

    /**
     * method to test to string with battleship.
     */
    @Test
    public void testToStringWithShip() {
        Ocean ocean = new Ocean();
        final int place7 = 7;
        BattleShip ship = new BattleShip();
        ship.placeShipAt(0, 0, true, ocean);
        for (int j = 0; j < place7; j++) {
            ocean.shootAt(0, j);
        }

        assertEquals("S", ship.toString());

    }

    /**
     * method to test shootat.
     */
    @Test
    public void testShootAt() {
        Ocean ocean = new Ocean();
        BattleShip ship = new BattleShip();
        final int column3 = 3;
        final int column4 = 4;
        final int column8 = 8;
        final int column10 = 10;

        ship.placeShipAt(0, 0, true, ocean);
        assertTrue(ship.shootAt(0, 0));
        assertTrue(ship.shootAt(0, column3));
        assertTrue(ship.shootAt(0, column4));
        assertFalse(ship.shootAt(1, column4));
        assertFalse(ship.shootAt(2, column4));
        assertFalse(ship.shootAt(column3, column4));
        assertFalse(ship.shootAt(0, column8));
        assertFalse(ship.shootAt(column8, column10));


        ship.placeShipAt(column3, 1, false, ocean);
        assertFalse(ship.shootAt(0, column4));
        assertFalse(ship.shootAt(1, column4));
        assertFalse(ship.shootAt(2, 2));
        assertTrue(ship.shootAt(column3, 1));
        assertFalse(ship.shootAt(1, column8));
        assertFalse(ship.shootAt(1, column10));

        ship.placeShipAt(1, column3, false, ocean);
        assertFalse(ship.shootAt(1, 0));
        assertFalse(ship.shootAt(1, 1));
        assertFalse(ship.shootAt(2, 0));
        assertTrue(ship.shootAt(column4, column3));
        assertTrue(ship.shootAt(column8, column3));
        assertFalse(ship.shootAt(column10, column3));

    }

    /**
     * method to test shoot at with battleship.
     */
    @Test
    public void testShootAtWithShip() {
        Ocean ocean = new Ocean();
        BattleShip ship = new BattleShip();
        final int column8 = 8;
        final int column4 = 4;
        final int column3 = 3;
        ship.placeShipAt(0, 0, true, ocean);
        for (int j = 0; j < column8; j++) {
            ocean.shootAt(0, j);
        }

        assertFalse(ship.shootAt(0, column3));
        assertFalse(ship.shootAt(0, column4));
        assertFalse(ship.shootAt(1, column4));

    }

    /**
     * test get ship type EmptySea.
     */
    @Test
    public void testGetShipTypeEmptySea() {
        Ship ship = new EmptySea();
        assertEquals("empty", ship.getShipType());
    }

    /**
     * method to test shoot at EmptySea.
     */
    @Test
    public void testShootAtEmptySea() {
        Ship ship = new EmptySea();
        final int column4 = 4;

        assertFalse(ship.shootAt(1, column4));

    }

    /**
     * method to test IsSunk EmptySea.
     */
    @Test
    public void testIsSunkEmptySea() {
        Ship ship = new EmptySea();
        assertFalse(ship.isSunk());
    }

    /**
     * method to test ToStrinG EmptySea.
     */
    @Test
    public void testToStringEmptySea() {
        Ship ship = new EmptySea();
        assertEquals(".", ship.toString());
    }

    /**
     * Empty sea hit toString test.
     */
    @Test
    public void testEmptySeaToStringFired() {
        final int row = 0;
        final int column = 0;
        final String expectedToStringValue = "-";
        final EmptySea ship = new EmptySea();
        ship.shootAt(row, column);
        assertEquals(expectedToStringValue, ship.toString());
    }

}
