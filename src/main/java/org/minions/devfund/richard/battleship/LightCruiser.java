package org.minions.devfund.richard.battleship;

/**
 * Class.
 */
public class LightCruiser extends Ship {

    private static final int NUM = 2;
    private static final String TYPE = "light cruiser";
    private static final int LENGTH = 5;

    /**
     * Constructor.
     */
    LightCruiser() {
        super.setLength(LENGTH);
        super.setHit(new boolean[LENGTH]);
        super.setNumber(NUM);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    String getShipType() {
        return TYPE;
    }
}
