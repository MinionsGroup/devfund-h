package org.minions.devfund.noemiguzman.battleship;


import java.util.Arrays;

/**
 *  Destroyer class.
 */
public class Destroyer extends Ship {
    private static final int LENGTH_D = 4;
    /**
     * constructor.
     */
    public Destroyer() {
        this.setLength(LENGTH_D);
        this.setHit(new boolean[LENGTH_D]);
        Arrays.fill(this.getHit(), false);
    }

    @Override
    public String getShipType() {
        return "destroyer";
    }
}
