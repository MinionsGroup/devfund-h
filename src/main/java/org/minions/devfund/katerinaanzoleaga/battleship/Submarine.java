package org.minions.devfund.katerinaanzoleaga.battleship;

import java.util.Arrays;

public class Submarine extends Ship {
    public Submarine() {
        this.setLength(3);
        this.fillHitArray();

    }

    private void fillHitArray () {
        boolean[] aHit = new boolean[8];
        Arrays.fill(aHit, 0, 2, false);
        this.setHit(aHit);
    }

    @Override
    String getShipType() {
        return "submarine";
    }
}
