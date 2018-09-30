package org.minions.devfund.richard.battleship;

/**
 * Class.
 */
public class LightCruiser extends Ship {

    private static final int SHIP_NUM = 2;
    private static final String SHIP_TYPE = "lightcruiser";
    private static final int SHIP_LENGTH = 5;

    /**
     * Constructor.
     */
    LightCruiser() {
        super.setLength(SHIP_LENGTH);
        super.setHit(new boolean[SHIP_LENGTH]);
        super.setNumber(SHIP_NUM);
    }

    /**
     * {@inheritDoc}.
     */
    @Override
    public String getShipType() {
        return SHIP_TYPE;
    }

}
