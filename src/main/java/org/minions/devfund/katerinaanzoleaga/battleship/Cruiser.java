package org.minions.devfund.katerinaanzoleaga.battleship;

import java.util.Arrays;

public class Cruiser extends Ship {
    public Cruiser() {
        this.setLength(6);
        this.fillHitArray();

    }

    private void fillHitArray () {
        boolean[] aHit = new boolean[8];
        Arrays.fill(aHit, 0, 5, false);
        this.setHit(aHit);
    }

    @Override
    String getShipType() {
        return "cruiser";
    }


}
