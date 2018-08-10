package org.minions.devfund.damianvp.battleship;

public class BattleShip extends Ship{
    private String shipType = "battleship";
    BattleShip () {
        this.setLength(8);
    }


    @Override
    String getShipType() {
        return this.shipType;
    }
}
