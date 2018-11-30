package org.minions.devfund.reinaldo.battleship;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Battle Ship Test class.
 */
public class BattleShipTest {

    /**
     * Get The Type for BattleShip Ship.
     */
    @Test
    public void testGetTheTypeforBattleShip() {
        Ship ship = new BattleShip();
        ship.setHorizontal(true);
        assertEquals("BATTLESHIP", ship.getShipType().toUpperCase());
    }
}
