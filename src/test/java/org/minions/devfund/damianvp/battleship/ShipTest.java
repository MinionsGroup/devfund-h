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
}
