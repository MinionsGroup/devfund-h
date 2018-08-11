package org.minions.devfund.damianvp.battleship;

import java.util.Arrays;

public class LightCruiser extends Ship{
    private String shipType = "light cruiser";

    public LightCruiser() {
        this.setLength(5);
        this.setHit(new boolean[5]);
        Arrays.fill(this.getHit(), false);
    }

    @Override
    String getShipType() {
        return this.shipType;
    }
}
