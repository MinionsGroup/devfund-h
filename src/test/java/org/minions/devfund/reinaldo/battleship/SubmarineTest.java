package org.minions.devfund.reinaldo.battleship;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Submarine Test class.
 */
public class SubmarineTest {

    /**
     * Get The Type for Submarine Ship.
     */
    @Test
    public void testGetTheTypeforSubmarineShip() {
        Ship ship = new Submarine();
        ship.setHorizontal(true);
        assertEquals("SUBMARINE", ship.getShipType().toUpperCase());
    }
}
