package org.minions.devfund.abel.battleship;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Class for Ship Unit Tests.
 */
public class ShipTest {

    private Ship ship;
    private Ocean ocean;

    /**
     * SetUp method.
     */
    @Before
    public void setUp() {
        ship = new BattleShip();
        ocean = new Ocean();
    }

    /**
     * Test.
     */
    @Test
    public void testIsOkToPlaceShipAtValidPlaceHorizontalZeroZero() {
        assertTrue(ship.okToPlaceShipAt(0, 0, true, ocean));
    }

    /**
     * Test.
     */
    @Test
    public void testIsOkToPlaceShipAtValidPlaceZeroTwelve() {
        final int twelve = 12;
        assertTrue(ship.okToPlaceShipAt(0, twelve, true, ocean));
    }

    /**
     * Test.
     */
    @Test
    public void testIsOkToPlaceShipAtValidPlaceHorizontalNineteenZero() {
        final int nineteen = 19;
        assertTrue(ship.okToPlaceShipAt(nineteen, 0, true, ocean));
    }

    /**
     * Test.
     */
    @Test
    public void testIsOkToPlaceShipAtValidPlaceNineteenTwelve() {
        final int nineteen = 19;
        final int twelve = 12;
        assertTrue(ship.okToPlaceShipAt(nineteen, twelve, true, ocean));
    }

    /**
     * Test.
     */
    @Test
    public void testIsOkToPlaceShipAtValidPlaceVerticalZeroZero() {
        assertTrue(ship.okToPlaceShipAt(0, 0, false, ocean));
    }

    /**
     * Test.
     */
    @Test
    public void testIsOkToPlaceShipAtInValidPlaceZeroNineteen() {
        final int nineteen = 19;
        assertFalse(ship.okToPlaceShipAt(0, nineteen, true, ocean));
    }

    /**
     * Test.
     */
    @Test
    public void testIsOkToPlaceShipAtInValidPlace() {
        final int nineteen = 19;
        assertFalse(ship.okToPlaceShipAt(nineteen, nineteen, false, ocean));
    }

    /**
     * Test.
     */
    @Test
    public void testIsOkToPlaceShipAtManyPositions() {
        final int twenty = 20;
        final boolean expected = false;
        boolean actual = false;
        for (int i = -1; i <= twenty; i++) {
            for (int j = -1; j <= twenty; j++) {
                actual = ship.okToPlaceShipAt(i, j, true, ocean);
            }
        }
        for (int i = -1; i < twenty; i++) {
            for (int j = -1; j < twenty; j++) {
                actual = ship.okToPlaceShipAt(i, j, false, ocean);
            }
        }
        assertEquals(expected, actual);
    }

    /**
     * Test.
     */
    @Test
    public void testShootAtTrueZeroZero() {
        boolean[] expected = {true, false, false, false, false, false, false, false};
        ship.placeShipAt(0, 0, true, ocean);
        assertTrue(ship.shootAt(0, 0));
        assertTrue(ship.shootAt(0, 0));
        boolean[] actual = ship.getHit();
        assertArrayEquals(expected, actual);
    }

    /**
     * Test.
     */
    @Test
    public void testShootAtTrueZeroOne() {
        boolean[] expected = {false, true, false, false, false, false, false, false};
        ship.placeShipAt(0, 0, true, ocean);
        assertTrue(ship.shootAt(0, 1));
        boolean[] actual = ship.getHit();
        assertArrayEquals(expected, actual);
    }

    /**
     * Test.
     */
    @Test
    public void testShootAtTrueMany() {
        final int twentyOne = 21;
        ship.placeShipAt(0, 0, true, ocean);
        assertTrue(ship.shootAt(0, 1));
        assertFalse(ship.shootAt(-1, 2));
        assertFalse(ship.shootAt(-1, -1));
        assertFalse(ship.shootAt(twentyOne, twentyOne));
        assertFalse(ship.shootAt(0, twentyOne));
        assertFalse(ship.shootAt(twentyOne, 0));
    }

    /**
     * Test.
     */
    @Test
    public void testShootAtTrueFalseMany() {
        final int twentyOne = 21;
        ship.placeShipAt(0, 0, false, ocean);
        assertFalse(ship.shootAt(0, 1));
        assertFalse(ship.shootAt(-1, 2));
        assertFalse(ship.shootAt(-1, -1));
        assertFalse(ship.shootAt(twentyOne, twentyOne));
        assertFalse(ship.shootAt(0, twentyOne));
        assertFalse(ship.shootAt(twentyOne, 0));
    }

    /**
     * Test.
     */
    @Test
    public void testShootAtAll() {
        final int twentyOne = 21;
        final int seven = 7;
        ship.placeShipAt(0, 0, true, ocean);
        for (int i = 0; i <= seven; i++) {
            assertTrue(ship.shootAt(0, i));
        }
        assertFalse(ship.shootAt(0, 1));
        assertFalse(ship.shootAt(-1, 2));
        assertFalse(ship.shootAt(-1, -1));
        assertFalse(ship.shootAt(twentyOne, twentyOne));
        assertFalse(ship.shootAt(0, twentyOne));
        assertFalse(ship.shootAt(twentyOne, 0));
    }

    /**
     * Test.
     */
    @Test
    public void testShootAtFalseZeroNineteen() {
        boolean[] expected = {false, false, false, false, false, false, false, false};
        ship.placeShipAt(0, 0, true, ocean);
        final int nineteen = 19;
        assertFalse(ship.shootAt(0, nineteen));
        boolean[] actual = ship.getHit();
        assertArrayEquals(expected, actual);
    }

    /**
     * Test.
     */
    @Test
    public void testIsSunkTrue() {
        ship.placeShipAt(0, 0, true, ocean);
        final int seven = 7;
        for (int i = 0; i <= seven; i++) {
            ship.shootAt(0, i);
        }
        assertTrue(ship.isSunk());
    }

    /**
     * Test.
     */
    @Test
    public void testIsSunkFalse() {
        ship.placeShipAt(0, 0, true, ocean);
        ship.shootAt(0, 0);
        ship.shootAt(0, 1);
        assertFalse(ship.isSunk());
    }

    /**
     * Test.
     */
    @Test
    public void testToStringIsNotCompletelySunk() {
        ship.placeShipAt(0, 0, true, ocean);
        ship.shootAt(0, 0);
        ship.shootAt(0, 1);
        String expected = "S";
        String actual = ship.toString();
        assertEquals(expected, actual);
    }

    /**
     * Test.
     */
    @Test
    public void testToStringIsSunk() {
        ship.placeShipAt(0, 0, true, ocean);
        final int seven = 7;
        for (int i = 0; i <= seven; i++) {
            ship.shootAt(0, i);
        }
        String expected = "x";
        String actual = ship.toString();
        assertEquals(expected, actual);
    }

    /**
     * Test.
     */
    @Test
    public void testBattleshipGetShipType() {
        final String expectedShipType = "battleship";
        final Ship anotherShip = new BattleShip();
        final String actualShipType = anotherShip.getShipType();
        assertEquals(expectedShipType, actualShipType);
    }

    /**
     * Test.
     */
    @Test
    public void testEmptySeaGetShipType() {
        final String expectedShipType = "empty";
        final Ship emptySea = new EmptySea();
        final String actualShipType = emptySea.getShipType();
        String expectedDot = ".";
        String expectedDash = "-";
        String actual = emptySea.toString();
        assertEquals(expectedDot, actual);
        assertEquals(expectedShipType, actualShipType);
        assertFalse(emptySea.shootAt(0, 0));
        assertFalse(emptySea.isSunk());
        actual = emptySea.toString();
        assertEquals(expectedDash, actual);
    }

    /**
     * Test.
     */
    @Test
    public void testBattleshipGetterSetter() {
        final Ship anotherShip = new BattleShip();
        final int expected = 0;
        final int expectedLength = 8;
        anotherShip.setBowRow(0);
        anotherShip.setBowColumn(0);
        anotherShip.setHorizontal(false);
        final int actualBowRow = anotherShip.getBowRow();
        final int actualBowColumn = anotherShip.getBowColumn();
        final int actualLength = anotherShip.getLength();
        assertEquals(expected, actualBowRow);
        assertEquals(expected, actualBowColumn);
        assertEquals(expectedLength, actualLength);
        assertFalse(anotherShip.isHorizontal());
    }
}
