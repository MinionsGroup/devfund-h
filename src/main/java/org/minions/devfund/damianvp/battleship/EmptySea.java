package org.minions.devfund.damianvp.battleship;

import java.util.Arrays;

public class EmptySea extends Ship{

    EmptySea() {
        this.setLength(1);
        this.setHit(new boolean[1]);
        Arrays.fill(this.getHit(), false);
    }

    @Override
    boolean shootAt(int row, int column) {
        this.getHit()[0] = true;
        return false;
    }

    @Override
    boolean isSunk() {
        return false;
    }

    @Override
    public String toString() {
        return this.getHit()[0] ? "-" : ".";
    }

    @Override
    String getShipType() {
        return "empty";
    }

}
