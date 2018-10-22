package org.minions.devfund.abel.battleship;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Class for Ocean Unit Tests.
 */
public class OceanTest {

    private Ocean ocean;

    /**
     * SetUp method.
     */
    @Before
    public void setUp() {
        ocean = new Ocean();
    }

    /**
     * Test.
     */
    @Test
    public void testOceanIsOccupiedFalseInitialEmptyOcean() {
        assertFalse(ocean.isOccupied(0, 0));
    }

    /**
     * Test.
     */
    @Test
    public void testOceanIsOccupiedTruePositionWithShip() {
        ocean.getShipArray()[0][0] = new Submarine();

        assertTrue(ocean.isOccupied(0, 0));
    }

    /**
     * Test.
     */
    @Test
    public void testShootAtIsSunkIsGameOverFalse() {
        final int six = 6;
        Ship ship = new BattleCruiser();
        ship.placeShipAt(0, 0, true, ocean);
        ocean.getShipArray()[0][0] = ship;

        for (int i = 0; i < six; i++) {
            assertTrue(ocean.shootAt(0, i));
        }
        assertFalse(ship.isSunk());
        assertFalse(ocean.isGameOver());
    }

    /**
     * Test.
     */
    @Test
    public void testShootAtIsSunkIs() {
        final int seven = 7;
        final int expected = 12;
        Ship ship = new BattleShip();
        ship.placeShipAt(0, 0, true, ocean);
        ocean.getShipArray()[0][0] = ship;

        for (int i = 0; i <= seven; i++) {
            assertTrue(ocean.shootAt(0, i));
        }
        assertTrue(ship.isSunk());
        assertFalse(ocean.shootAt(0, seven));
        assertFalse(ocean.shootAt(0, 0));
        assertFalse(ocean.shootAt(0, 2));
        assertFalse(ocean.shootAt(1, 2));
        final int actual = ocean.getShotsFired();
        assertEquals(expected, actual);
    }

    /**
     * Test.
     */
    @Test
    public void testIsGameOver() {
        final int twenty = 20;
        ocean.placeAllShipsRandomly();
        for (int i = 0; i < twenty; i++) {
            for (int j = 0; j < twenty; j++) {
                ocean.shootAt(i, j);
            }
        }
        assertTrue(ocean.isGameOver());
    }

    /**
     * Test.
     */
    @Test
    public void testGetCounterValues() {
        final int expectedCounterValue = 0;
        assertFalse(ocean.isGameOver());
        assertEquals(expectedCounterValue, ocean.getShotsFired());
        assertEquals(expectedCounterValue, ocean.getHitCount());
        assertEquals(expectedCounterValue, ocean.getShipsSunk());
    }

    /**
     * Test.
     */
    @Test
    public void testOceanPrint() {
        final String line = "....................\n";
        final int times = 20;
        String expected = new String(new char[times]).replace("\0", line);
        final String actual = ocean.print();
        assertEquals(expected, actual);
    }
}
