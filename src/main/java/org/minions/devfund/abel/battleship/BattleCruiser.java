package org.minions.devfund.abel.battleship;

/**
 * Class to handle BattleCruiser.
 */
public class BattleCruiser extends Ship {

    private static final int LENGTH = 7;

    /**
     * Default Constructor.
     */
    public BattleCruiser() {
        setLength(LENGTH);
        setHit(new boolean[LENGTH]);
    }
}
