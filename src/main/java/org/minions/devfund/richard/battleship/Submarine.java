package org.minions.devfund.richard.battleship;

/**
 * Class.
 */
public class Submarine extends Ship {

    private static final int NUM = 4;
    private static final String TYPE = "submarine";
    private static final int LENGTH = 3;

    /**
     * Constructor.
     */
    Submarine() {
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
