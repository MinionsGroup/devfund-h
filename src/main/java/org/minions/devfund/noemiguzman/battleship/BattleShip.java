package org.minions.devfund.noemiguzman.battleship;

import java.util.Arrays;
/**
* Battleship class.
*/
public class BattleShip extends Ship {
    static final int LENGTHBS = 8;

    /**
     * constructor battleship.
     */
    public BattleShip() {
        this.setLength(LENGTHBS);
        this.setHit(new boolean[LENGTHBS]);
        Arrays.fill(this.getHit(), false);
    }

    @Override
    public String getShipType() {
        return "battleship";
    }

}
