package org.minions.devfund.damianvp.battleship;

import java.util.Arrays;

/**
 * Submarine class.
 */
public class Submarine extends Ship {
    private String shipType = "submarine";

    /**
     * Submarine class constructor.
     */
    public Submarine() {
        this.setLength(3);
        this.setHit(new boolean[3]);
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
