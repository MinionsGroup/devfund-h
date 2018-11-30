package org.minions.devfund.reinaldo.battleship;

import java.util.Arrays;

/**
 * Created by reinaldo.
 */
public class Submarine extends Ship {

    /**
     * Constructor of the Submarine.
     */
    public Submarine() {
        final int shipLength = 3;
        setLength(shipLength);
        setHit(new boolean[shipLength]);
        Arrays.fill(getHit(), false);
    }

    /**
     * {@inheritDoc}.
     */
    @Override
    String getShipType() {
        return ShipTypeEnum.SUBMARINE.toString().toLowerCase().toLowerCase();
    }
}

