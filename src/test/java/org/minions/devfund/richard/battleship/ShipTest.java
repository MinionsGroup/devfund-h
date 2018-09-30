package org.minions.devfund.richard.battleship;

import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

/**
 * Test Class.
 */
public class ShipTest {

    /**
     * Test.
     */
    @Test
    public void testShipToStringNotSunk() {
        final String expectedToString = "S";
        final Ship ship = new Submarine();
        assertEquals(expectedToString, ship.toString());
    }

    /**
     * Test.
     */
    @Test
    public void testShipToStringSunk() {
        final int row = 0;
        final int column = 0;
        final int columnSubmarineZero = 0;
        final int columnSubmarineOne = 1;
        final int columnSubmarineTwo = 2;
        final Ocean ocean = new Ocean();
        final Ship ship = new Submarine();
        final String expectedToString = "x";
        ship.placeShipAt(row, column, true, ocean);
        ocean.shootAt(row, columnSubmarineZero);
        ocean.shootAt(row, columnSubmarineOne);
        ocean.shootAt(row, columnSubmarineTwo);
        assertEquals(expectedToString, ship.toString());
    }

    /**
     * Test.
     */
    @Test
    public void testShipIsHorizontal() {
        final int row = 0;
        final int column = 0;
        final Ocean ocean = new Ocean();
        final Ship ship = new Submarine();
        final boolean expectedHorizontalValue = true;
        ship.placeShipAt(row, column, true, ocean);
        assertEquals(expectedHorizontalValue, ship.isHorizontal());
    }

    /**
     * Test.
     */
    @Test
    public void testShipSetHorizontal() {
        final Ocean ocean = new Ocean();
        final Ship ship = new Submarine();
        final boolean expectedHorizontalValue = true;
        ship.placeShipAt(0, 0, true, ocean);
        assertEquals(expectedHorizontalValue, ship.isHorizontal());
    }

    /**
     * Test.
     */
    @Test
    public void testShipSetVertical() {
        final Ocean ocean = new Ocean();
        final Ship ship = new Submarine();
        final boolean expectedHorizontalValue = false;
        ship.placeShipAt(0, 0, false, ocean);
        assertEquals(expectedHorizontalValue, ship.isHorizontal());
    }

    /**
     * Test.
     */
    @Test
    public void testShootAtEmptyPlace() {
        final int row = 0;
        final int column = 0;
        final int rowLimit = 19;
        final int columnLimit = 19;
        final Ocean ocean = new Ocean();
        final Ship ship = new Submarine();
        ship.placeShipAt(row, column, true, ocean);
        assertFalse(ship.shootAt(rowLimit, columnLimit));
    }

    /**
     * Test.
     */
    @Test
    public void testShootAfterSunk() {
        final int row = 0;
        final int column = 0;
        final int columnSubmarineZero = 0;
        final int columnSubmarineOne = 1;
        final int columnSubmarineTwo = 2;
        final Ocean ocean = new Ocean();
        final Ship ship = new Submarine();
        ship.placeShipAt(row, column, true, ocean);
        ship.shootAt(row, columnSubmarineZero);
        ship.shootAt(row, columnSubmarineOne);
        ship.shootAt(row, columnSubmarineTwo);
        ship.shootAt(row, columnSubmarineZero);
        assertTrue(ship.isSunk());
    }

    /**
     * Test.
     */
    @Test
    public void testSetShipHead() {
        final int expectedRow = 0;
        final int expectedColumn = 0;
        final Ocean ocean = new Ocean();
        final Ship ship = new Submarine();
        ship.placeShipAt(0, 0, true, ocean);
        assertEquals(expectedRow, ship.getBowRow());
        assertEquals(expectedColumn, ship.getBowColumn());
    }

    /**
     * Test.
     */
    @Test
    public void testGetHits() {
        final boolean defaultHitStatus = false;
        final Ship ship = new Submarine();
        final boolean[] expectedHits = {defaultHitStatus, defaultHitStatus, defaultHitStatus};
        assertArrayEquals(expectedHits, ship.getHit());
    }

    /**
     * Test.
     */
    @Test
    public void testEmptySeaToStringNotFired() {
        final String expectedToStringValue = ".";
        final EmptySea ship = new EmptySea();
        assertEquals(expectedToStringValue, ship.toString());
    }

    /**
     * Test.
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
     * Test.
     */
    @Test
    public void testEmptySeaGetShipType() {
        final String expectedShipType = "empty";
        final EmptySea ship = new EmptySea();
        assertEquals(expectedShipType, ship.getShipType());
    }

    /**
     * Test.
     */
    @Test
    public void testEmptySeaIsSunk() {
        final EmptySea ship = new EmptySea();
        assertFalse(ship.isSunk());
    }

    /**
     * Test.
     */
    @Test
    public void testBattleshipGetShipType() {
        final String expectedShipType = "battleship";
        final Ship ship = new BattleShip();
        assertEquals(expectedShipType, ship.getShipType());
    }

    /**
     * Test.
     */
    @Test
    public void testBattleCruiserGetShipType() {
        final String expectedShipType = "battlecruiser";
        final Ship ship = new BattleCruiser();
        assertEquals(expectedShipType, ship.getShipType());
    }

    /**
     * Test.
     */
    @Test
    public void testCruiserGetShipType() {
        final String expectedShipType = "cruiser";
        final Ship ship = new Cruiser();
        assertEquals(expectedShipType, ship.getShipType());
    }

    /**
     * Test.
     */
    @Test
    public void testDestroyerGetShipType() {
        final String expectedShipType = "destroyer";
        final Ship ship = new Destroyer();
        assertEquals(expectedShipType, ship.getShipType());
    }

    /**
     * Test.
     */
    @Test
    public void testLightCruiserGetShipType() {
        final String expectedShipType = "lightcruiser";
        final Ship ship = new LightCruiser();
        assertEquals(expectedShipType, ship.getShipType());
    }

    /**
     * Test.
     */
    @Test
    public void testSubmarineGetShipType() {
        final String expectedShipType = "submarine";
        final Ship ship = new Submarine();
        assertEquals(expectedShipType, ship.getShipType());
    }

    /**
     * Test.
     */
    @Test
    public void testOkToPlaceShipAt() {
        Ocean ocean = new Ocean();
        Ship ship = new Submarine();
        final int nineTeen = 19;
        assertTrue(ship.okToPlaceShipAt(0, 0, true, ocean));
        assertTrue(ship.okToPlaceShipAt(0, 0, false, ocean));
        assertFalse(ship.okToPlaceShipAt(nineTeen, nineTeen, true, ocean));
        assertFalse(ship.okToPlaceShipAt(nineTeen, nineTeen, false, ocean));
    }

    /**
     * Test.
     */
    @Test
    public void testGetNumber() {
        final int expectResultSubmarineShip = 4;
        final int expectResultLightCruiserShip = 2;
        final int expectResultBattleShip = 1;
        final Ship battleShip = new BattleShip();
        final Ship submarineShip = new Submarine();
        final Ship lightCruiserShip = new LightCruiser();
        assertEquals(expectResultSubmarineShip, submarineShip.getNumber());
        assertEquals(expectResultLightCruiserShip, lightCruiserShip.getNumber());
        assertEquals(expectResultBattleShip, battleShip.getNumber());
    }

    /**
     * Test.
     */
    @Test
    public void testShootAtHorizontalShip() {
        final int zero = 0;
        final int one = 1;
        final int oneNegative = -1;
        final int two = 2;
        final int seven = 7;
        final int eight = 8;
        final int teen = 10;
        final int nineTeen = 19;
        final Ocean ocean = new Ocean();
        final Ship battleShip = new BattleShip();
        battleShip.placeShipAt(zero, zero, true, ocean);
        assertTrue(battleShip.shootAt(zero, zero));
        assertTrue(battleShip.shootAt(zero, one));
        assertTrue(battleShip.shootAt(zero, two));
        assertTrue(battleShip.shootAt(zero, seven));
        assertFalse(battleShip.shootAt(zero, eight));
        assertFalse(battleShip.shootAt(zero, teen));
        assertFalse(battleShip.shootAt(zero, nineTeen));
        assertFalse(battleShip.shootAt(teen, teen));
        assertFalse(battleShip.shootAt(nineTeen, nineTeen));
        assertFalse(battleShip.shootAt(one, zero));
        assertFalse(battleShip.shootAt(two, zero));
        assertFalse(battleShip.shootAt(seven, zero));
        assertFalse(battleShip.shootAt(eight, zero));
        assertFalse(battleShip.shootAt(teen, zero));
        assertFalse(battleShip.shootAt(nineTeen, zero));
        assertFalse(battleShip.shootAt(teen, teen));
        assertFalse(battleShip.shootAt(zero, oneNegative));
        assertFalse(battleShip.shootAt(oneNegative, zero));
        assertFalse(battleShip.shootAt(oneNegative, oneNegative));
    }

    /**
     * Test.
     */
    @Test
    public void testShootAtVerticalShip() {
        final int zero = 0;
        final int one = 1;
        final int oneNegative = -1;
        final int two = 2;
        final int seven = 7;
        final int eight = 8;
        final int teen = 10;
        final int nineTeen = 19;
        final Ocean ocean = new Ocean();
        final Ship battleShip = new BattleShip();
        battleShip.placeShipAt(zero, zero, false, ocean);
        assertTrue(battleShip.shootAt(zero, zero));
        assertTrue(battleShip.shootAt(one, zero));
        assertTrue(battleShip.shootAt(two, zero));
        assertTrue(battleShip.shootAt(seven, zero));
        assertFalse(battleShip.shootAt(eight, zero));
        assertFalse(battleShip.shootAt(teen, zero));
        assertFalse(battleShip.shootAt(nineTeen, zero));
        assertFalse(battleShip.shootAt(teen, teen));
        assertFalse(battleShip.shootAt(nineTeen, nineTeen));
        assertFalse(battleShip.shootAt(zero, one));
        assertFalse(battleShip.shootAt(zero, two));
        assertFalse(battleShip.shootAt(zero, seven));
        assertFalse(battleShip.shootAt(zero, eight));
        assertFalse(battleShip.shootAt(zero, teen));
        assertFalse(battleShip.shootAt(zero, nineTeen));
        assertFalse(battleShip.shootAt(oneNegative, zero));
        assertFalse(battleShip.shootAt(zero, oneNegative));
        assertFalse(battleShip.shootAt(oneNegative, oneNegative));
    }

}
