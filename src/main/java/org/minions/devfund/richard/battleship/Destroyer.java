package org.minions.devfund.richard.battleship;

/**
 * Class.
 */
public class Destroyer extends Ship {

    private static final int NUM = 3;
    private static final String TYPE = "destroyer";
    private static final int LENGTH = 4;

    /**
     * Constructor.
     */
    public Destroyer() {
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
