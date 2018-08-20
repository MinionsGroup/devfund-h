package org.minions.devfund.damianvp.battleship;

import java.util.Arrays;

/**
 * Cruiser class.
 */
public class Cruiser extends Ship {
    static final int LENGTH = 6;
    private String shipType = "cruiser";

    /**
     * Cruiser class constructor.
     */
    public Cruiser() {
        this.setLength(LENGTH);
        this.setHit(new boolean[LENGTH]);
        Arrays.fill(this.getHit(), false);
    }

    /**
     * Override methdo to get the type of the ship.
     * @return String type, type of ship.
     */
    @Override
    String getShipType() {
        return this.shipType;
    }
}
