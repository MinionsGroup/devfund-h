package org.minions.devfund.katerinaanzoleaga.battleship;


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
        this.setHit(new boolean[LENGTH]);

    }


    /**
     * Ship type getter.
     * @return "destroyer"
     */
    @Override
    public String getShipType() {
        return "destroyer";
    }
}
