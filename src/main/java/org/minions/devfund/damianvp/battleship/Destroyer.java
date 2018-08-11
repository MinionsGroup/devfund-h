package org.minions.devfund.damianvp.battleship;

import java.util.Arrays;

public class Destroyer extends Ship{
    private String shipType = "destroyer";

    public Destroyer() {
        this.setLength(4);
        this.setHit(new boolean[4]);
        Arrays.fill(this.getHit(), false);
    }
    @Override
    String getShipType() {
        return this.shipType;
    }
}
