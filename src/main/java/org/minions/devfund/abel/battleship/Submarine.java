package org.minions.devfund.abel.battleship;

/**
 * Class to handle Submarine.
 */
public class Submarine extends Ship {
    private static final int LENGTH = 3;

    /**
     * Default Constructor.
     */
    public Submarine() {
        setLength(LENGTH);
        setHit(new boolean[LENGTH]);
    }
}
