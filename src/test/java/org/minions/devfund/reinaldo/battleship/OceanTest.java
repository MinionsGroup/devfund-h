package org.minions.devfund.reinaldo.battleship;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by reinaldo on 15-08-18.
 */
public class OceanTest {

    private Ocean ocean;

    /**
     * Preconditions.
     */
    @Before
    public void setup() {
        ocean = new Ocean();
    }


    /**
     * test to initial value.
     */
    @Test
    public void testWhenInitialValues() {
        ocean.placeAllShipsRandomly();
        assertFalse("Is game over", ocean.isGameOver());
        assertEquals(0, ocean.getHitCount());
        assertEquals(0, ocean.getShipsSunk());
        assertEquals(0, ocean.getShotsFired());
    }


    /**
     * Test Place occupied in ocean test.
     */
    @Test
    public void testWhenIsOccupied() {
        final int row = 0;
        final int column = 0;
        final BattleShip battleShip = new BattleShip();
        battleShip.placeShipAt(row, column, true, ocean);
        assertTrue(ocean.isOccupied(row, column));
    }

    /**
     * Shoot a place occupied by ship in ocean test.
     */
    @Test
    public void testWhenShootAtShip() {
        final int row = 0;
        final int column = 0;
        final BattleShip battleShip = new BattleShip();
        battleShip.placeShipAt(row, column, true, ocean);
        assertTrue(ocean.shootAt(row, column));
    }

    /**
     * Test Shoot a place not occupied by ship in ocean test.
     */
    @Test
    public void testWhenIsShootAtEmpty() {
        final int row = 0;
        final int column = 0;
        assertFalse(ocean.shootAt(row, column));
    }

    /**
     * Test When Increase Shoots Count.
     */
    @Test
    public void testWhenIncreaseShootsCount() {
        final int row = 0;
        final int column = 0;
        final int expectedCount = 2;
        ocean.shootAt(row, column);
        ocean.shootAt(row, column);
        assertEquals(expectedCount, ocean.getShotsFired());
    }

    /**
     * test When Increase Hit Count.
     */
    @Test
    public void testWhenIncreaseHitCount() {
        final int row = 0;
        final int column = 0;
        final int expectedCount = 3;
        final BattleShip battleShip = new BattleShip();
        battleShip.placeShipAt(row, column, true, ocean);
        ocean.shootAt(row, column);
        ocean.shootAt(row, column);
        ocean.shootAt(row, column);

        assertEquals(expectedCount, ocean.getHitCount());
    }

    /**
     * Test Shoots all places of a ship in ocean and asserts the sunk counter value.
     */
    @Test
    public void testWhenIncreaseSunkCount() {
        final int row = 0;
        final int columnSubmarineZero = 0;
        final int columnSubmarineOne = 1;
        final int columnSubmarineTwo = 2;
        final int expectedHitCount = 1;
        final Submarine submarine = new Submarine();
        submarine.placeShipAt(row, columnSubmarineZero, true, ocean);
        ocean.shootAt(row, columnSubmarineZero);
        ocean.shootAt(row, columnSubmarineOne);
        ocean.shootAt(row, columnSubmarineTwo);
        assertEquals(expectedHitCount, ocean.getShipsSunk());
    }

    /**
     * Verifies game finishes when all ships are sunk.
     */
    @Test
    public void testWhenIsGameOver() {
        ocean.placeAllShipsRandomly();
        final int oceanSize = 20;
        for (int i = 0; i < oceanSize; i++) {
            for (int j = 0; j < oceanSize; j++) {
                ocean.shootAt(i, j);
            }
        }
        assertTrue("The game didn't finish", ocean.isGameOver());
    }
}
