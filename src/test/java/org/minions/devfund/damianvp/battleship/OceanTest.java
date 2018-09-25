package org.minions.devfund.damianvp.battleship;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * OceanTest class.
 */
public class OceanTest {
    private Ocean ocean;
    static final int LENGTH = 20;
    /**
     * Method to initialize each test.
     */
    @Before
    public void setOceanClassTest() {
        ocean = new Ocean();
    }

    /**
     * Method to test the Ocean constructor.
     */
    @Test
    public void testConstructor() {
        assertEquals(0, ocean.getHitCount());
        assertEquals(0, ocean.getShipsSunk());
        assertEquals(0, ocean.getShotsFired());
        for (int i = 0; i < LENGTH; i++) {
            for (int j = 0; j < LENGTH; j++) {
                assertEquals("empty", ocean.getShipArray()[i][j].getShipType());
            }
        }
    }

    /**
     * Method to test placeAllShipsRandomly.
     */
    @Test
    public void testPlaceAllShipsRandomly() {
        ocean.placeAllShipsRandomly();
        final int expectedCount = 61;
        assertEquals(0, ocean.getHitCount());
        assertEquals(0, ocean.getShipsSunk());
        assertEquals(0, ocean.getShotsFired());
        int shipCount = 0;
        for (int i = 0; i < LENGTH; i++) {
            for (int j = 0; j < LENGTH; j++) {
                if (!ocean.getShipArray()[i][j].getShipType().equals("empty")) {
                    shipCount++;
                }
            }
        }
        assertEquals(expectedCount, shipCount);
    }

    /**
     * Method to test isOccupied method in empty ocean.
     */
    @Test
    public void testIsOccupiedInEmptyOcean() {
        for (int i = 0; i < LENGTH; i++) {
            for (int j = 0; j < LENGTH; j++) {
                assertFalse(ocean.isOccupied(i, j));
                assertFalse(ocean.getShipArray()[i][j].isSunk());
            }
        }
    }

    /**
     * Method to test isOccupied method in already placed ship in ocean.
     */
    @Test
    public void testIsOccupiedInOccupiedOcean() {
        BattleShip ship = new BattleShip();
        ship.placeShipAt(0, 0, true, ocean);
        for (int j = 0; j < ship.getLength(); j++) {
            assertTrue(ocean.isOccupied(0, j));
        }
        assertFalse(ocean.isOccupied(0, ship.getLength()));
    }

    /**
     * Method to test shootAt method.
     */
    @Test
    public void testShootAt1() {
        final int expectedSHotsFired = 3;
        BattleShip ship = new BattleShip();
        ship.placeShipAt(0, 0, true, ocean);
        ocean.shootAt(0, 0);
        ocean.shootAt(0, 0);
        ocean.shootAt(1, 0);
        assertEquals(2, ocean.getHitCount());
        assertEquals(0, ocean.getShipsSunk());
        assertEquals(expectedSHotsFired, ocean.getShotsFired());
    }

    /**
     * Method to test shootAt method.
     */
    @Test
    public void testShootAt2() {
        BattleShip ship = new BattleShip();
        ship.placeShipAt(0, 0, true, ocean);
        for (int j = 0; j < ship.getLength(); j++) {
            ocean.shootAt(0, j);
        }
        ocean.shootAt(0, 1);
        ocean.shootAt(0, 2);

        assertEquals(ship.getLength(), ocean.getHitCount());
        assertEquals(1, ocean.getShipsSunk());
        assertEquals(ship.getLength() + 2, ocean.getShotsFired());
    }

    /**
     * Method to test shootAt method.
     */
    @Test
    public void testShootAt3() {
        BattleShip ship = new BattleShip();
        ship.placeShipAt(0, 0, false, ocean);
        for (int j = 0; j < ship.getLength(); j++) {
            ocean.shootAt(0, j);
        }
        ocean.shootAt(0, 1);
        ocean.shootAt(0, 2);

        assertEquals(1, ocean.getHitCount());
        assertEquals(0, ocean.getShipsSunk());
        assertEquals(ship.getLength() + 2, ocean.getShotsFired());
    }

    /**
     * Method to test isGameOver method.
     */
    @Test
    public void testIsGameOver() {
        assertFalse(ocean.isGameOver());
        ocean.placeAllShipsRandomly();
        Ship[][] ships = ocean.getShipArray();
        for (int row = 0; row < ships.length; row++) {
            for (int col = 0; col < ships[row].length; col++) {
                if (!(ships[row][col] instanceof EmptySea)) {
                    ocean.shootAt(row, col);
                }
            }
        }
        assertTrue(ocean.isGameOver());
    }
}
