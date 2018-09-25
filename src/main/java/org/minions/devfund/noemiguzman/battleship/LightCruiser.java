package org.minions.devfund.noemiguzman.battleship;

import java.util.Arrays;

/**
 * Light cruiser class.
 */

public class LightCruiser extends Ship {
    private static final int LENGTH_LC = 5;

    /**
     * Constructor.
     */
    public LightCruiser() {
        this.setLength(LENGTH_LC);
        this.setHit(new boolean[LENGTH_LC]);
        Arrays.fill(this.getHit(), false);
    }

    @Override
    public String getShipType() {
        return "light cruiser";
    }
}
