package org.minions.devfund.reinaldo.battleship;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Empty Sea Test class.
 */
public class EmptySeaTest {

    /**
     * Verifies the to string for is not hit.
     */
    @Test
    public void testGetToStringWhenIsNotHit() {
        Ship ship = new EmptySea();
        ship.setHorizontal(true);
        assertEquals(".", ship.toString());
    }

    /**
     * Verifies the to string for is hit.
     */
    @Test
    public void testGetToStringWhenIsHit() {
        Ship ship = new EmptySea();
        ship.setHorizontal(true);
        ship.shootAt(0, 0);
        assertEquals("-", ship.toString());
    }

    /**
     * Get The Type for Crucer Ship.
     */
    @Test
    public void testGetTheTypeforCrucerShip() {
        Ship ship = new EmptySea();
        ship.setHorizontal(true);
        assertEquals("EMPTY", ship.getShipType().toUpperCase());
    }

}
