package org.minions.devfund.richard.battleship;

/**
 * Class.
 */
public class BattleShip extends Ship {

    private static final int NUM = 1;
    private static final String TYPE = "battleship";
    private static final int LENGTH = 8;

    /**
     * Constructor.
     */
    public BattleShip() {
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
