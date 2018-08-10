package org.minions.devfund.noemiguzman.battleship;

import java.util.Arrays;

/**
 * Light cruiser class.
 */

public class LightCruiser extends Ship {
    private final int lengthLC = 5;

    /**
     * Constructor.
     */
    public LightCruiser() {
        this.setLength(lengthLC);
        this.setHit(new boolean[lengthLC]);
        Arrays.fill(this.getHit(), false);
    }

    @Override
    public String getShipType() {
        return "light cruiser";
    }
}
