package org.minions.devfund.richard.battleship;

/**
 * Class.
 */
public class BattleCruiser extends Ship {

    private static final int SHIP_NUM = 1;
    private static final String SHIP_TYPE = "battle cruiser";
    private static final int SHIP_LENGTH = 7;

    /**
     * Constructor.
     */
    public BattleCruiser() {
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
