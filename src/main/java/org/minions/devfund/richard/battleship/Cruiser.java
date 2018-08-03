package org.minions.devfund.richard.battleship;

/**
 * Class.
 */
public class Cruiser extends Ship {

    private static final int NUM = 2;
    private static final String TYPE = "cruiser";
    private static final int LENGTH = 6;

    /**
     * Constructor.
     */
    public Cruiser() {
        super.setLength(LENGTH);
        super.setHit(new boolean[LENGTH]);
        super.setNumber(NUM);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getShipType() {
        return TYPE;
    }
}

