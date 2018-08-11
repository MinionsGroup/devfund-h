package org.minions.devfund.katerinaanzoleaga.battleship;

import java.util.Arrays;

/**
 * LightCruiser class definition.
 * Extends Ship with a length of 5.
 */
public class LightCruiser extends Ship {

    private static final int LENGTH = 5;

    /**
     * LightCruiser constructor.
     */
    public LightCruiser() {
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
     * @return "lightcruiser"
     */
    @Override
    String getShipType() {
        return "lightcruiser";
    }
}
