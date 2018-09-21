package org.minions.devfund.richard.battleship;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Class.
 */
public class Ocean {

    private static final int OCEAN_LENGTH = 20;
    private static final int SHIPS_QUANTITY = 13;

    private Ship[][] ships;
    private int shotsFired;
    private int hitCount;
    private int shipsSunk;
    private static final Map<String, Ship> SHIP_MAP = new HashMap<>();

    static {
        SHIP_MAP.put("BattleShip", new BattleShip());
        SHIP_MAP.put("BattleCruiser", new BattleCruiser());
        SHIP_MAP.put("Cruiser", new Cruiser());
        SHIP_MAP.put("LightCruiser", new LightCruiser());
        SHIP_MAP.put("Destroyer", new Destroyer());
        SHIP_MAP.put("Submarine", new Submarine());
    }

    /**
     * Ocean.
     */
    Ocean() {
        ships = new Ship[OCEAN_LENGTH][OCEAN_LENGTH];
        Arrays.stream(ships).forEach(row -> Arrays.fill(row, new EmptySea().getShip()));
    }

    /**
     * place all Ships randomly.
     */
    void placeAllShipsRandomly() {
        for (Map.Entry<String, Ship> entry : SHIP_MAP.entrySet()) {
            entry.getValue().addShip(this);
        }
    }

    /**
     * @param row    row.
     * @param column column.
     * @return boolean.
     */
    boolean isOccupied(final int row, final int column) {
        return !(ships[row][column] instanceof EmptySea);
    }

    /**
     * @param row    row.
     * @param column column.
     * @return boolean.
     */
    boolean shootAt(int row, int column) {
        shotsFired++;
        if (ships[row][column].shootAt(row, column)) {
            if (ships[row][column].isSunk()) {
                shipsSunk++;
            }
            hitCount++;
            return true;
        }
        return false;
    }

    /**
     * @return ships.
     */
    Ship[][] getShipArray() {
        return ships.clone();
    }

    /**
     * @return boolean.
     */
    boolean isGameOver() {
        return shipsSunk == SHIPS_QUANTITY;
    }

    /**
     * @return shotsFired.
     */
    int getShotsFired() {
        return shotsFired;
    }

    /**
     * @return hitCount.
     */
    int getHitCount() {
        return hitCount;
    }

    /**
     * @return shipsSunk.
     */
    int getShipsSunk() {
        return shipsSunk;
    }
}
