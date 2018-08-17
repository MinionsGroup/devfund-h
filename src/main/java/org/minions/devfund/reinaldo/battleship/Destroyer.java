package org.minions.devfund.reinaldo.battleship;

import java.util.Arrays;

/**
 * Created by reinaldo.
 */
public class Destroyer extends Ship {

    /**
     * Constructor of the Destroyer.
     */
    public Destroyer() {
        final int shipLength = 4;
        setLength(shipLength);
        setHit(new boolean[shipLength]);
        Arrays.fill(getHit(), false);
    }

    /**
     * {@inheritDoc}.
     */
    @Override
    String getShipType() {
        return ShipTypeEnum.DESTROYER.toString().toLowerCase();
    }
}

