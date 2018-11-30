package org.minions.devfund.reinaldo.battleship;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Cruiser class.
 */
public class CruiserTest {

    /**
     * Get The Type for Cruiser Ship.
     */
    @Test
    public void testGetTheTypeforCruiserShip() {
        Ship ship = new Cruiser();
        ship.setHorizontal(true);
        assertEquals("CRUISER", ship.getShipType().toUpperCase());
    }
}
