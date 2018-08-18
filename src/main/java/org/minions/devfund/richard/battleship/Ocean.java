package org.minions.devfund.richard.battleship;

import java.util.Arrays;
import java.util.List;

public class Ocean {

    private static final int OCEAN_LENGTH = 20;

    private Ship[][] ships;
    private int shotsFired;
    private int hitCount;
    private int shipsSunk;

    private Ship battleCruiser;
    private Ship battleShip;
    private Ship destroyer;
    private Ship lightCruiser;
    private Ship subMarine;

    Ocean() {
        ships = new Ship[OCEAN_LENGTH][OCEAN_LENGTH];
        battleCruiser = new BattleCruiser();
        battleShip = new BattleShip();
        destroyer = new Destroyer();
        lightCruiser = new LightCruiser();
        subMarine = new Submarine();
        new EmptySea().fill(this);
    }

    void placeAllShipsRandomly() {
        List<Ship> shipsList = Arrays.asList(battleCruiser, battleShip, destroyer, lightCruiser, subMarine);
        for (Ship ship : shipsList) {
            ship.addShip(this);
        }
    }

    Ship[][] getShips() {
        return ships.clone();
    }

    boolean isOccupied(final int row, final int column) {
        return ships[row][column].getLength() > 1;
    }
}
