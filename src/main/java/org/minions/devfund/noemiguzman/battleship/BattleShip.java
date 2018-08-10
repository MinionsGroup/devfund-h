package org.minions.devfund.noemiguzman.battleship;

import java.util.Arrays;
/**
* Battleship class.
*/
public class BattleShip extends Ship {
    private final int length = 8;

    /**
     * constructor battleship.
     */
    public BattleShip() {
        this.setLength(length);
        this.setHit(new boolean[length]);
        Arrays.fill(this.getHit(), false);
    }

    @Override
    public String getShipType() {
        return "battleship";
    }

}
