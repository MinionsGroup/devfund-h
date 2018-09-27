package org.minions.devfund.abel.battleship;

/**
 * Class to handle Destroyer.
 */
public class Destroyer extends Ship {

    private static final int LENGTH = 4;

    /**
     * Default Constructor.
     */
    public Destroyer() {
        setLength(LENGTH);
        setHit(new boolean[LENGTH]);
    }
}
