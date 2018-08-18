package org.minions.devfund.richard.battleship;

public class EmptySea extends Ship {
    private static final String SHIP_TYPE = "empty";
    private static final int SHIP_LENGTH = 1;

    /**
     * Class
     */
    EmptySea() {
        super.setLength(SHIP_LENGTH);
        super.setHit(new boolean[SHIP_LENGTH]);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getShipType() {
        return SHIP_TYPE;
    }

    void fill(Ocean ocean) {
        for (int i = 0; i < ocean.getShips().length; i++) {
            for (int j = 0; j < ocean.getShips().length; j++) {
                placeShipAt(i, j, true, ocean);
            }
        }
    }
}
