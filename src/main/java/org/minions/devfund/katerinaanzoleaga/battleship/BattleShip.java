package org.minions.devfund.katerinaanzoleaga.battleship;
import java.util.Arrays;

public class BattleShip extends Ship {

    public BattleShip() {
        this.setLength(8);
        this.fillHitArray();

    }

    private void fillHitArray () {
        boolean[] aHit = new boolean[8];
        Arrays.fill(aHit,false);
        this.setHit(aHit);
    }

    @Override
    String getShipType() {
        return "battleship";
    }
}
