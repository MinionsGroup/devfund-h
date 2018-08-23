package org.minions.devfund.katerinaanzoleaga.battleship;


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
        this.setHit(new boolean[LENGTH]);

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
