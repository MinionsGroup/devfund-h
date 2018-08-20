package org.minions.devfund.damianvp.battleship;

import java.util.Arrays;

/**
 * Destroyer class.
 */
public class Destroyer extends Ship {
    static final int LENGTH = 4;
    private String shipType = "destroyer";

    /**
     * Destroyer class constructor.
     */
    public Destroyer() {
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
