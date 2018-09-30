package org.minions.devfund.abel.battleship;

/**
 * Class to handle Cruiser.
 */
public class Cruiser extends Ship {

    private static final int LENGTH = 6;

    /**
     * Default Constructor.
     */
    public Cruiser() {
        setLength(LENGTH);
        setHit(new boolean[LENGTH]);
    }
}
