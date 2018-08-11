package org.minions.devfund.katerinaanzoleaga.battleship;
import java.util.Arrays;

public class BattleCruiser extends Ship {

    public BattleCruiser() {
        this.setLength(7);
        this.fillHitArray();

    }

    private void fillHitArray () {
        boolean[] aHit = new boolean[8];
        Arrays.fill(aHit, 0, 6, false);
        this.setHit(aHit);
    }

    @Override
    String getShipType() {
        return "battlecruiser";
    }
}