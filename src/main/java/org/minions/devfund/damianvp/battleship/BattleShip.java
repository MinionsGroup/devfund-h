package org.minions.devfund.damianvp.battleship;

import java.util.Arrays;

public class BattleShip extends Ship{
    private String shipType = "battleship";
    BattleShip () {
        this.setLength(8);
        this.setHit(new boolean[8]);
        Arrays.fill(this.getHit(), false);
    }


    @Override
    String getShipType() {
        return this.shipType;
    }
}
