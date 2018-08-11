package org.minions.devfund.katerinaanzoleaga.battleship;

import java.util.Arrays;

/**
 * Destroyer class definition.
 * This extends Ship, with a length equal to 4.
 */
public class Destroyer extends Ship {

    private static final int LENGTH = 4;

    /**
     * Destroyer constructor.
     */
    public Destroyer() {
        this.setLength(LENGTH);
        this.fillHitArray();

    }

    /**
     * Initializes hit array wih false values.
     */
    private void fillHitArray() {
        boolean[] aHit = new boolean[HITLENGTH];
        Arrays.fill(aHit, 0, LENGTH - 1, false);
        this.setHit(aHit);
    }

    /**
     * Ship type getter.
     * @return "destroyer"
     */
    @Override
    String getShipType() {
        return "destroyer";
    }
}
