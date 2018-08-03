package org.minions.devfund.richard.battleship;

/**
 * Class.
 */
public class BattleCruiser extends Ship {

    private static final int NUM = 1;
    private static final String TYPE = "battle cruiser";
    private static final int LENGTH = 7;

    /**
     * Constructor.
     */
    public BattleCruiser() {
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
