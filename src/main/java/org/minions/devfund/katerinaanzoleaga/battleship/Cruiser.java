package org.minions.devfund.katerinaanzoleaga.battleship;

import java.util.Arrays;

/**
 * Cuiser class definition.
 * Extends Ship with a length equal to 6.
*/
public class Cruiser extends Ship {

    private static final int LENGTH = 6;
    /**
     * Cruiser constructor.
     */
    public Cruiser() {
        this.setLength(LENGTH);
        this.fillHitArray();

    }

    /**
     * Initializes the hit array. This users only six hit positions.
     */
    private void fillHitArray() {
        boolean[] aHit = new boolean[HITLENGTH];
        Arrays.fill(aHit, 0, LENGTH - 1, false);
        this.setHit(aHit);
    }

    /**
     * Ship type getter.
     * @return 'cruiser'
     */
    @Override
    String getShipType() {
        return "cruiser";
    }


}
