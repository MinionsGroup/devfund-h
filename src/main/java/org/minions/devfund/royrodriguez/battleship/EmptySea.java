package org.minions.devfund.royrodriguez.battleship;

public class EmptySea extends Ship {
    @Override
    String getShipType() {
        return null;
    }

    EmptySea() {

    }

    @Override
    boolean shootAt(int row, int column) {
        return false;
    }

    @Override
    boolean isSunk() {
        return false;
    }

    @Override
    public String toString() {
        return null;
    }
}
