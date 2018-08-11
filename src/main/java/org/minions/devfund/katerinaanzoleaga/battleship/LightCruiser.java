package org.minions.devfund.katerinaanzoleaga.battleship;

import java.util.Arrays;

public class LightCruiser extends Ship {
    public LightCruiser() {
        this.setLength(5);
        this.fillHitArray();

    }

    private void fillHitArray () {
        boolean[] aHit = new boolean[8];
        Arrays.fill(aHit, 0, 4, false);
        this.setHit(aHit);
    }

    @Override
    String getShipType() {
        return "lightcruiser";
    }
}
