package org.minions.devfund.katerinaanzoleaga.battleship;

import java.util.Arrays;

/**
 * Submarine class definition.
 * Extends Ship with a length of 3.
 */
public class Submarine extends Ship {

    private static final int LENGTH = 3;

    /**
     * Submarine constructor.
     */
    public Submarine() {
        this.setLength(LENGTH);
        this.fillHitArray();

    }

    /**
     * Initializes hit array with false values.
     */
    private void fillHitArray() {
        boolean[] aHit = new boolean[HITLENGTH];
        Arrays.fill(aHit, 0, LENGTH - 1, false);
        this.setHit(aHit);
    }

    /**
     * Ship type getter.
     * @return "submarine"
     */
    @Override
    String getShipType() {
        return "submarine";
    }
}
