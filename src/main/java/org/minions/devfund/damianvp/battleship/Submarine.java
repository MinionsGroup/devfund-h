package org.minions.devfund.damianvp.battleship;

import java.util.Arrays;

public class Submarine extends Ship {
    private String shipType = "submarine";

    public Submarine() {
        this.setLength(3);
        this.setHit(new boolean[3]);
        Arrays.fill(this.getHit(), false);
    }

    @Override
    String getShipType() {
        return this.shipType;
    }



}
