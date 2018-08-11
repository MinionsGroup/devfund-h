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

    /**
     * Ocean constructor.
     */
    public Ocean() {
        shotsFired = 0;
        hitCount = 0;
        shipsSunk = 0;
        this.fillOcean();
    }

    /**
     * Fills the Ocean with empty ships.
     */
    private void fillOcean() {
        EmptySea emptySea = new EmptySea();
        for (Ship[] row : ships)
            Arrays.fill(row, emptySea);
    }

    /**
     * Verifies if a ship positon in the Ocean is 'empty'.
     * @param row number
     * @param column number
     * @return Ture if the ship in this position has its type equal to 'empty'
     */
    public boolean isOccupied(int row, int column) {
        return ships[row][column].getShipType() != "empty";
    }




}
