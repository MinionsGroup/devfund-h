package org.minions.devfund.katerinaanzoleaga.battleship;

import java.util.Arrays;

public class Destroyer extends Ship {
    public Destroyer() {
        this.setLength(4);
        this.fillHitArray();

    }

    private void fillHitArray () {
        boolean[] aHit = new boolean[8];
        Arrays.fill(aHit, 0, 3, false);
        this.setHit(aHit);
    }

    @Override
    String getShipType() {
        return "destroyer";
    }
}
