package org.minions.devfund.katerinaanzoleaga.battleship;


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
        this.setHit(new boolean[LENGTH]);

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
