package org.minions.devfund.noemiguzman.battleship;
import java.util.Arrays;

/**
 * submarine class.
 */
public class Submarine extends Ship {
    private static final int LENGTH_SUB = 3;
    /**
     * constructor.
     */
    public Submarine() {
        this.setLength(LENGTH_SUB);
        this.setHit(new boolean[LENGTH_SUB]);
        Arrays.fill(this.getHit(), false);
    }

    @Override
    public String getShipType() {
        return "submarine";
    }
}
