package org.minions.devfund.abel.battleship;

/**
 * Class to handle BattleShip.
 */
public class BattleShip extends Ship {

    private static final int LENGTH = 8;

    /**
     * Default Constructor.
     */
    public BattleShip() {
        setLength(LENGTH);
        setHit(new boolean[LENGTH]);
    }
}
