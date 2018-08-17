package org.minions.devfund.reinaldo.battleship;

import java.util.Arrays;

/**
 * Created by reinaldo.
 */
public class LightCruiser extends Ship {

    /**
     * Constructor of the LightCruiser.
     */
    public LightCruiser() {
        final int shipLength = 5;
        setLength(shipLength);
        setHit(new boolean[shipLength]);
        Arrays.fill(getHit(), false);
    }

    /**
     * {@inheritDoc}.
     */
    @Override
    String getShipType() {
        return ShipTypeEnum.LIGHT_CRUISER.toString().toLowerCase();
    }
}
