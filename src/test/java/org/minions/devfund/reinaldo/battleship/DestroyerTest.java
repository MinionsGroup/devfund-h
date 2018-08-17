package org.minions.devfund.reinaldo.battleship;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Destroyer Test class.
 */
public class DestroyerTest {

    /**
     * Get The Type for Destroyer Ship.
     */
    @Test
    public void testGetTheTypeforDestroyerShip() {
        Ship ship = new Destroyer();
        ship.setHorizontal(true);
        assertEquals("DESTROYER", ship.getShipType().toUpperCase());
    }
}
