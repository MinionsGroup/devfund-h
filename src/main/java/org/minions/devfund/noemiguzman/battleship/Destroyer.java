package org.minions.devfund.noemiguzman.battleship;


import java.util.Arrays;

/**
 *  Destroyer class.
 */
public class Destroyer extends Ship {
    private final int lengthD = 4;
    /**
     * constructor.
     */
    public Destroyer() {
        this.setLength(lengthD);
        this.setHit(new boolean[lengthD]);
        Arrays.fill(this.getHit(), false);
    }

    @Override
    public String getShipType() {
        return "destroyer";
    }
}
