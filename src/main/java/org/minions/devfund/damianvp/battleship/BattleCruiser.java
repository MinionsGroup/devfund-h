package org.minions.devfund.damianvp.battleship;

import java.util.Arrays;

public class BattleCruiser extends Ship{
    private String shipType = "battlecruiser";

    public BattleCruiser() {
        this.setLength(7);
        this.setHit(new boolean[7]);
        Arrays.fill(this.getHit(), false);
    }

    @Override
    String getShipType() {
        return this.shipType;
    }
}
