package org.minions.devfund.noemiguzman.battleship;

import java.util.Arrays;
/**
* Battle Cruiser class
*/
public class BattleCruiser extends Ship {


    private final int lengthBc = 7;
    /**
     * constructor on battle cruiser
     */
    public BattleCruiser() {
        this.setLength(lengthBc);
        this.setHit(new boolean[lengthBc]);
        Arrays.fill(this.getHit(), false);
    }

    @Override
    public String getShipType() {
        return "battlecruiser";
    }
}
