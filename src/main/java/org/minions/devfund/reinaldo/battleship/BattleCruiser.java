package org.minions.devfund.reinaldo.battleship;

import java.util.Arrays;

/**
 * Created by reinaldo.
 */
public class BattleCruiser extends Ship {

    /**
     * Constructor of the BattleCruiser.
     */
    public BattleCruiser() {
        final int shipLength = 7;
        setLength(shipLength);
        setHit(new boolean[shipLength]);
        Arrays.fill(getHit(), false);
    }

    /**
     * {@inheritDoc}.
     *
     * @return
     */
    @Override
    String getShipType() {
        return ShipTypeEnum.BATTLE_CRUISER.toString().toLowerCase();
    }
}
