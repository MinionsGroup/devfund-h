package org.minions.devfund.abel.battleship;

/**
 * Class to handle Destroyer.
 */
public class EmptySea extends Ship {

    private static final String EMPTY = "empty";
    private static final String DASH = "-";
    private static final String DOT = ".";

    /**
     * Default Constructor.
     */
    public EmptySea() {
        setLength(1);
        setHit(new boolean[1]);
    }

    /**
     * {@inheritDoc}.
     */
    @Override
    public String getShipType() {
        return EMPTY;
    }

    /**
     * {@inheritDoc}.
     */
    @Override
    public boolean shootAt(int row, int column) {
        boolean[] isHit = {true};
        setHit(isHit);
        return false;
    }

    /**
     * {@inheritDoc}.
     */
    @Override
    public boolean isSunk() {
        return false;
    }

    /**
     * {@inheritDoc}.
     */
    @Override
    public String toString() {
        return getHit()[0] ? DASH : DOT;
    }
}
