package org.minions.devfund.richard.battleship;

/**
 * Class.
 */
public class BattleShip extends Ship {

    private static final int SHIP_NUM = 1;
    private static final String SHIP_TYPE = "battleship";
    private static final int SHIP_LENGTH = 8;

    /**
     * Constructor.
     */
    BattleShip() {
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
