package org.minions.devfund.reinaldo.battleship;

import java.util.Arrays;

/**
 * Created by reinaldo.
 */
public class BattleShip extends Ship {

    /**
     * Constructor of the BattleShip.
     */
    public BattleShip() {
        final int shipLength = 8;
        setLength(shipLength);
        setHit(new boolean[shipLength]);
        Arrays.fill(getHit(), false);
    }
    /**
     * {@inheritDoc}.
     */
    @Override
    String getShipType() {
        return ShipTypeEnum.BATTLESHIP.toString().toLowerCase();
    }
}

