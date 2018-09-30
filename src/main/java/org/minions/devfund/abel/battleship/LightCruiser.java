package org.minions.devfund.abel.battleship;

/**
 * Class to handle LightCruiser.
 */
public class LightCruiser extends Ship {

    private static final int LENGTH = 5;

    /**
     * Default Constructor.
     */
    public LightCruiser() {
        setLength(LENGTH);
        setHit(new boolean[LENGTH]);
    }
}
