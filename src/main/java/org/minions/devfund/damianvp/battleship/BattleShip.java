package org.minions.devfund.damianvp.battleship;

import java.util.Arrays;

/**
 * BattleShip class.
 */
public class BattleShip extends Ship {
    static final int LENGTH = 8;
    private String shipType = "battleship";

    /**
     * BattleShip class constructor.
     */
    BattleShip() {
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
