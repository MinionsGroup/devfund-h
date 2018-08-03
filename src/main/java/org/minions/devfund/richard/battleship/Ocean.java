package org.minions.devfund.richard.battleship;

public class Ocean {

    private static final int SHIP = 13;
    private static final int OCEAN_LENGTH = 20;

    Ship[][] ships;
    int shotsFired;
    int hitCount;
    int shipsSunk;


    Ocean() {
        ships = new Ship[OCEAN_LENGTH][OCEAN_LENGTH];
        Strategy.action(new StrategyEmpty(), this);
    }

    void placeAllShipsRandomly() {
        Strategy.action(new StrategyShip(), this);
    }

    int getOceanLength() {
        return OCEAN_LENGTH;
    }

    public Ship[][] getShips() {
        return ships.clone();
    }

}
