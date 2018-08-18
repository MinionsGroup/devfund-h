package org.minions.devfund.richard.battleship;

/**
 * Class.
 */
public class Destroyer extends Ship {

    private static final int SHIP_NUM = 3;
    private static final String SHIP_TYPE   = "destroyer";
    private static final int SHIP_LENGTH = 4;

    /**
     * Constructor.
     */
    public Destroyer() {
        super.setLength(SHIP_LENGTH);
        super.setHit(new boolean[SHIP_LENGTH]);
        super.setNumber(SHIP_NUM);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getShipType() {
        return SHIP_TYPE ;
    }
}
