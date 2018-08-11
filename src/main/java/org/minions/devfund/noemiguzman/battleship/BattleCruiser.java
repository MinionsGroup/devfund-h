package org.minions.devfund.noemiguzman.battleship;

import java.util.Arrays;
/**
* Battle Cruiser class.
*/
public class BattleCruiser extends Ship {


    static final int LENGTH_BC = 7;
    /**
     * constructor on battle cruiser.
     */
    public BattleCruiser() {
        this.setLength(LENGTH_BC);
        this.setHit(new boolean[LENGTH_BC]);
        Arrays.fill(this.getHit(), false);
    }

    @Override
    public String getShipType() {
        return "battlecruiser";
    }
}
