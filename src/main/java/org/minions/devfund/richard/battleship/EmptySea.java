package org.minions.devfund.richard.battleship;

/**
 * Class.
 */
public class EmptySea extends Ship {

    private static final String SHIP_TYPE = "empty";
    private static final int SHIP_LENGTH = 1;
    private static final String NOTHING_FIRED_CHAR = "-";
    private static final String NEVER_FIRED_CHAR = ".";

    /**
     * Class.
     */
    EmptySea() {
        super.setLength(SHIP_LENGTH);
        super.setHit(new boolean[SHIP_LENGTH]);
    }

    /**
     * {@inheritDoc}.
     */
    @Override
    public String getShipType() {
        return SHIP_TYPE;
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
        return getHit()[0] ? NOTHING_FIRED_CHAR : NEVER_FIRED_CHAR;
    }

    /**
     * {@inheritDoc}.
     */
    @Override
    public boolean shootAt(int row, int column) {
        boolean[] hitArray = {true};
        setHit(hitArray);
        return false;
    }

    /**
     * {@inheritDoc}.
     */
    @Override
    Ship getShip() {
        return new EmptySea();
    }
}
