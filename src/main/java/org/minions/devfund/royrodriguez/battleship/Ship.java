package org.minions.devfund.royrodriguez.battleship;

public abstract class Ship {
    private int bowRow;
    int bowColumn;
    int lenght;
    boolean horizontal;
    boolean[] hit;

    abstract String getShipType();

    boolean okToPlaceShipAt(int row, int column, boolean horizontal, Ocean ocean) {
        return false;
    }

    void placeShipAt(int row, int column, boolean horizontal, Ocean ocean) {

    }

    boolean shootAt(int row, int column) {
        return false;
    }

    boolean isSunk() {
        return false;
    }

    @Override
    public String toString() {
        return null;
    }
}
