package org.minions.devfund.reinaldo.battleship;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * BattleCruiserTest class.
 */
public class BattleCruiserTest {

    /**
     * Get The Type for BattleCruiser Ship.
     */
    @Test
    public void testGetTheTypeforCrucerShip() {
        Ship ship = new BattleCruiser();
        ship.setHorizontal(true);
        assertEquals("BATTLE_CRUISER", ship.getShipType().toUpperCase());
    }
}
