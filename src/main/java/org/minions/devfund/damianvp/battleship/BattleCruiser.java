package org.minions.devfund.damianvp.battleship;

import java.util.Arrays;

/**
 * BattleCruiser class.
 */
public class BattleCruiser extends Ship {
    static final int LENGTH = 7;
    private String shipType = "battlecruiser";

    /**
     * Battle Cruiser constructor.
     */
    public BattleCruiser() {
        this.setLength(LENGTH);
        this.setHit(new boolean[LENGTH]);
        Arrays.fill(this.getHit(), false);
    }

    /**
     * Override method to get type of the ship class.
     * @return String type, type of ship.
     */
    @Override
    String getShipType() {
        return this.shipType;
    }
}
