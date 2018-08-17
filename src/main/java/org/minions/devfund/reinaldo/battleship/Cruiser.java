package org.minions.devfund.reinaldo.battleship;

import java.util.Arrays;

/**
 * Created by reinaldo.
 */
public class Cruiser extends Ship {

    /**
     * Constructor of the Cruiser.
     */
    public Cruiser() {
        final int shipLength = 6;
        setLength(shipLength);
        setHit(new boolean[shipLength]);
        Arrays.fill(getHit(), false);
    }

    /**
     * {@inheritDoc}.
     */
    @Override
    String getShipType() {
        return ShipTypeEnum.CRUISER.toString().toLowerCase();
    }
}

