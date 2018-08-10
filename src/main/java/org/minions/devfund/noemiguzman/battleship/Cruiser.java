package org.minions.devfund.noemiguzman.battleship;


import java.util.Arrays;

/**
 * cruiser class
 */
public class Cruiser extends Ship {
    private final int lenghtCruiser = 6;
    /**
    * constructor .
    */
    public Cruiser() {
        this.setLength(lenghtCruiser);
        this.setHit(new boolean[lenghtCruiser]);
        Arrays.fill(this.getHit(), false);
    }

    @Override
    public String getShipType() {
        return "cruiser";
    }
}
