package org.minions.devfund.noemiguzman.battleship;


import java.util.Arrays;

/**
 * cruiser class.
 */
public class Cruiser extends Ship {
    private static final int LENGHT_CRUISER = 6;
    /**
    * constructor .
    */
    public Cruiser() {
        this.setLength(LENGHT_CRUISER);
        this.setHit(new boolean[LENGHT_CRUISER]);
        Arrays.fill(this.getHit(), false);
    }

    @Override
    public String getShipType() {
        return "cruiser";
    }
}
