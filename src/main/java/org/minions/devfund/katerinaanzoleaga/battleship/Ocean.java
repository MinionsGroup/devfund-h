package org.minions.devfund.katerinaanzoleaga.battleship;

import java.util.Arrays;

public class Ocean {

    private Ship[][] ships = new Ship[20][20];
    private int shotsFired;
    private int hitCount;
    private int shipsSunk;

    public Ship[][] getShips() {
        return ships;
    }

    public Ocean() {
        shotsFired = 0;
        hitCount = 0;
        shipsSunk = 0;
        this.fillOcean();
    }
    private void fillOcean() {
        EmptySea emptySea = new EmptySea();
        for (Ship[] row : ships)
            Arrays.fill(row, emptySea);
    }

}
