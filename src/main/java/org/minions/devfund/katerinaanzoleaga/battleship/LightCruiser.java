package org.minions.devfund.katerinaanzoleaga.battleship;


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
        this.setHit(new boolean[LENGTH]);

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
