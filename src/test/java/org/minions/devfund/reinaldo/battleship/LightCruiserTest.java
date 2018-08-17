package org.minions.devfund.reinaldo.battleship;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Light Cruiser Test class.
 */
public class LightCruiserTest {

    /**
     * Get The Type for LightCruiser Ship.
     */
    @Test
    public void testGetTheTypeforLightCruiserShip() {
        Ship ship = new LightCruiser();
        ship.setHorizontal(true);
        assertEquals("LIGHT_CRUISER", ship.getShipType().toUpperCase());
    }
}
