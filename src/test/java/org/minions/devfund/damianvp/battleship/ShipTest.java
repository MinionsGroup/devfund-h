package org.minions.devfund.damianvp.battleship;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * ShipTest class.
 */
public class ShipTest {

    /**
     * Method to test getShipType method.
     */
    @Test
    public void testGetShipType() {
        Ship battleShip = new BattleShip();
        Ship cruiser = new BattleCruiser();
        final int expBattleShipLength = 8;
        final int expCruiserLength = 7;
        assertEquals("battleship", battleShip.getShipType());
        assertEquals(expBattleShipLength, battleShip.getLength());
        assertEquals("battlecruiser", cruiser.getShipType());
        assertEquals(expCruiserLength, cruiser.getLength());
    }

    /**
     * Method to test okToPlaceSHipMethod.
     */
    @Test
    public void testOkToPlaceShipAt() {
        final int ten = 10;
        final int twelve = 12;
        final int fifteen = 15;
        final int seventeen = 17;
        Ship ship = new BattleShip();
        Ocean ocean = new Ocean();
        assertFalse(ship.okToPlaceShipAt(0, seventeen, true, ocean));
        assertTrue(ship.okToPlaceShipAt(0, ten, true, ocean));
        assertFalse(ship.okToPlaceShipAt(fifteen, seventeen, false, ocean));
        assertTrue(ship.okToPlaceShipAt(twelve, ten, false, ocean));
    }

    /**
     * Method to test okToPlaceShipMethod including adjacency position.
     */
    @Test
    public void testOkToPlaceShipAt2() {
        final int four = 4;
        final int six = 6;
        final int ten = 10;
        final int thirteen = 13;
        Ship ship1 = new BattleShip();
        Ship ship2 = new BattleShip();
        Ocean ocean = new Ocean();
        assertTrue(ship1.okToPlaceShipAt(0, ten, true, ocean));
        ship1.placeShipAt(0, ten, true, ocean);
        assertTrue(ship2.okToPlaceShipAt(1, 0, false, ocean));
        assertTrue(ship2.okToPlaceShipAt(1, 0, true, ocean));
        ship1.placeShipAt(1, six, true, ocean);
        assertFalse(ship2.okToPlaceShipAt(1, four, true, ocean));
        assertFalse(ship2.okToPlaceShipAt(1, thirteen, false, ocean));
    }

    /**
     * Method to test isSunk method.
     */
    @Test
    public void testIsSunk() {
        final int length = 8;
        Ocean ocean = new Ocean();
        BattleShip ship = new BattleShip();
        ship.placeShipAt(0, 0, true, ocean);
        for (int j = 0; j < length; j++) {
            ocean.shootAt(0, j);
        }
        assertTrue(ship.isSunk());
    }

    /**
     * method to test isSunk method.
     */
    @Test
    public void testIsSunk2() {
        final int length = 7;
        Ocean ocean = new Ocean();
        BattleShip ship = new BattleShip();
        ship.placeShipAt(0, 0, true, ocean);
        for (int j = 0; j < length; j++) {
            ocean.shootAt(0, j);
        }
        assertFalse(ship.isSunk());
    }

    /**
     * Method to test toString method.
     */
    @Test
    public void testToString2() {
        final int length = 7;
        Ocean ocean = new Ocean();
        BattleShip ship = new BattleShip();
        ship.placeShipAt(0, 0, true, ocean);
        for (int j = 0; j < length; j++) {
            ocean.shootAt(0, j);
        }
        assertEquals("S", ship.toString());
        ocean.shootAt(0, length);
        assertEquals("x", ship.toString());
    }

    /**
     * Method to test shootAt method.
     */
    @Test
    public void testShootAt() {
        final int three = 3;
        final int four = 4;
        Ocean ocean = new Ocean();
        BattleShip ship = new BattleShip();
        ship.placeShipAt(0, 0, true, ocean);
        assertTrue(ship.shootAt(0, 0));
        assertTrue(ship.shootAt(0, three));
        assertTrue(ship.shootAt(0, four));
        assertFalse(ship.shootAt(1, four));
    }

    /**
     * Method to test shootAt method.
     */
    @Test
    public void testShootAt2() {
        final int length = 8;
        final int three = 3;
        final int four = 4;
        Ocean ocean = new Ocean();
        BattleShip ship = new BattleShip();
        ship.placeShipAt(0, 0, true, ocean);

        for (int j = 0; j < length; j++) {
            ocean.shootAt(0, j);
        }

        assertFalse(ship.shootAt(0, three));
        assertFalse(ship.shootAt(0, four));
        assertFalse(ship.shootAt(1, four));

    }

    /**
     * Tests getBowRow method.
     */
    @Test
    public void testGetBowRow() {
        Ship ship = new BattleShip();
        ship.setBowRow(1);
        assertEquals(1, ship.getBowRow());
    }

    /**
     * Tests getBowColumn method.
     */
    @Test
    public void testGetBowColumn() {
        Ship ship = new BattleShip();
        ship.setBowColumn(1);
        assertEquals(1, ship.getBowColumn());
    }

    /**
     * Tests isHorizontal method.
     */
    @Test
    public void testIsHorizontal() {
        Ship ship = new BattleShip();
        ship.setHorizontal(true);
        assertTrue(ship.isHorizontal());
        ship.setHorizontal(false);
        assertFalse(ship.isHorizontal());
    }

    /**
     * Empty sea not hit toString test.
     */
    @Test
    public void testEmptySeaToStringNotFired() {
        final String expectedToStringValue = ".";
        final EmptySea ship = new EmptySea();
        assertEquals(expectedToStringValue, ship.toString());
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

    /**
     * method to test shootAt method.
     */
    @Test
    public void testShootAt3() {
        Ocean ocean = new Ocean();
        BattleShip ship = new BattleShip();
        final int column3 = 3;
        final int column4 = 4;
        final int column8 = 8;
        final int column10 = 10;
        final int twentyone = 21;

        ship.placeShipAt(0, 0, true, ocean);
        assertTrue(ship.shootAt(0, 0));
        assertTrue(ship.shootAt(0, column3));
        assertTrue(ship.shootAt(0, column4));
        assertFalse(ship.shootAt(1, column4));
        assertFalse(ship.shootAt(2, column4));
        assertFalse(ship.shootAt(column3, column4));
        assertFalse(ship.shootAt(-1, 0));
        assertFalse(ship.shootAt(column10, 1));
        assertFalse(ship.shootAt(column8, -1));
        assertFalse(ship.shootAt(twentyone, 1));
        assertFalse(ship.shootAt(1, twentyone));


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
        final int eight = 8;
        final int four = 4;
        final int three = 3;
        ship.placeShipAt(0, 0, true, ocean);
        for (int j = 0; j < eight; j++) {
            ship.shootAt(0, j);
        }

        assertFalse(ship.shootAt(0, three));
        assertFalse(ship.shootAt(0, four));
        assertFalse(ship.shootAt(1, four));
        assertFalse(ship.shootAt(2, four));
        assertFalse(ship.shootAt(three, four));
        assertFalse(ship.shootAt(four, three));
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
     * method to test ToString EmptySea.
     */
    @Test
    public void testToStringEmptySea() {
        Ship ship = new EmptySea();
        assertEquals(".", ship.toString());
    }

    /**
     * method to Test a complete area around a ship.
     */
    @Test
    public void testShotAtAroundShip() {
        Ocean ocean = new Ocean();
        BattleShip ship = new BattleShip();
        final int length = 8;
        final int three = 3;

        ship.placeShipAt(1, 1, true, ocean);
        for (int i = 0; i < length + 1; i++) {
            for (int j = 0; j < three; j++) {
                ocean.shootAt(i, j);
            }
        }
        assertFalse(ship.isSunk());
    }

}
