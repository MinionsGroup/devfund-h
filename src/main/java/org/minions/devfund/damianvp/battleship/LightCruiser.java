package org.minions.devfund.damianvp.battleship;

import java.util.Arrays;

/**
 * LightCruiser class.
 */
public class LightCruiser extends Ship {
    static final int LENGTH = 5;
    private String shipType = "light cruiser";

    /**
     * LightCruiser class constructor.
     */
    public LightCruiser() {
        this.setLength(LENGTH);
        this.setHit(new boolean[LENGTH]);
        Arrays.fill(this.getHit(), false);
    }

    /**
     * Override method to get the type of the ship.
     * @return String type, type of ship.
     */
    @Override
    String getShipType() {
        return this.shipType;
    }
}
