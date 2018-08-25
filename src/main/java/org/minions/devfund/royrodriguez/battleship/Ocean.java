package org.minions.devfund.royrodriguez.battleship;

public class Ocean {
    Ship[][] ships = new Ship[20][20];
    private int shotsFired;
    private int hitCount;
    private int shipsSunk;

    Ocean() {

    }

    void placeAllShipsRandomly() {

    }

    boolean isOccupied(int row, int column) {
        return false;
    }

    boolean shootAt(int row, int column) {
        return false;
    }


    public int getShotsFired() {
        return shotsFired;
    }

    public int getHitCount() {
        return hitCount;
    }

    public int getShipsSunk() {
        return shipsSunk;
    }

    boolean isGameOver() {
        return false;
    }

    Ship[][] getShipArray() {
        return ships;
    }

    void print() {

    }
}
