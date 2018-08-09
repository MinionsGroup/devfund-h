package org.minions.devfund.noemiguzman.battleship;


import java.util.Arrays;

public class Destroyer extends Ship {
    public Destroyer() {
        this.setLength(4);
        this.setHit(new boolean[4]);
        Arrays.fill(this.getHit(), false);
    }

    @Override
    public String getShipType() {
        return "destroyer";
    }
}
