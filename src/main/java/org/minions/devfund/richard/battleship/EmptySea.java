package org.minions.devfund.richard.battleship;

public class EmptySea extends Ship {
    private static final String TYPE = "empty";
    private static final int LENGTH = 1;

    /**
     * Class
     */
    public EmptySea() {
        super.setLength(LENGTH);
        super.setHit(new boolean[LENGTH]);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getShipType() {
        return TYPE;
    }
}
