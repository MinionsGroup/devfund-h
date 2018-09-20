package org.minions.devfund.richard.battleship;

/**
 * Class.
 */
public class Cruiser extends Ship {

    private static final int SHIP_NUM = 2;
    private static final String SHIP_TYPE = "cruiser";
    private static final int SHIP_LENGTH = 6;

    /**
     * Constructor.
     */
    Cruiser() {
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

    /**
     * {@inheritDoc}.
     */
    @Override
    Ship getShip() {
        return new Cruiser();
    }
}
