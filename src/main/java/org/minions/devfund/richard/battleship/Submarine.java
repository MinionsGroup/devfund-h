package org.minions.devfund.richard.battleship;

/**
 * Class.
 */
public class Submarine extends Ship {

    private static final int SHIP_NUM = 4;
    private static final String SHIP_TYPE = "submarine";
    private static final int SHIP_LENGTH = 3;

    /**
     * Constructor.
     */
    Submarine() {
        super.setLength(SHIP_LENGTH);
        super.setHit(new boolean[SHIP_LENGTH]);
        super.setNumber(SHIP_NUM);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getShipType() {
        return SHIP_TYPE;
    }
}
