package org.minions.devfund.abel.battleship;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Class to handle Ocean.
 */
public class Ocean {

    private static final int SIZE = 20;
    private Ship[][] ships;
    private int shotsFired;
    private int hitCount;
    private int shipsSunk;
    private static final int TOTAL_SHIPS = 13;
    private static final int THREE = 3;
    private static final int FOUR = 4;
    private static final Map<String, Integer> FLEET;

    static {
        FLEET = new HashMap<>();
        FLEET.put("BattleShip", 1);
        FLEET.put("BattleCruiser", 1);
        FLEET.put("Cruiser", 2);
        FLEET.put("LightCruiser", 2);
        FLEET.put("Destroyer", THREE);
        FLEET.put("Submarine", FOUR);
    }

    /**
     * Default Constructor.
     */
    public Ocean() {
        this.ships = new Ship[SIZE][SIZE];
        for (Ship[] row : this.ships) {
            Arrays.fill(row, new EmptySea());
        }
    }

    /**
     * Place all Ships Randomly.
     */
    public void placeAllShipsRandomly() {
        Random rng = new Random();
        FLEET.keySet().forEach(t -> {
            int successCount = 0;
            while (successCount < FLEET.get(t)) {
                int row = rng.nextInt(SIZE);
                int col = rng.nextInt(SIZE);
                boolean horizontal = rng.nextBoolean();
                final Ship ship = ShipFactory.getShip(t);
                if (ship.okToPlaceShipAt(row, col, horizontal, this)) {
                    ship.placeShipAt(row, col, horizontal, this);
                    successCount++;
                }
            }
        });
    }

    /**
     * Check if the position is occupied.
     *
     * @param row    int.
     * @param column int.
     * @return boolean.
     */
    public boolean isOccupied(int row, int column) {
        return !(ships[row][column] instanceof EmptySea);
    }

    /**
     * Shoot at a specific position.
     *
     * @param row    int.
     * @param column int.
     * @return boolean.
     */
    public boolean shootAt(int row, int column) {
        shotsFired++;
        if (isOccupied(row, column) && ships[row][column].shootAt(row, column)) {
            if (ships[row][column].isSunk()) {
                shipsSunk++;
            }
            hitCount++;
            return true;
        }
        return false;
    }

    /**
     * Get shots fired.
     *
     * @return int.
     */
    public int getShotsFired() {
        return shotsFired;
    }

    /**
     * Get hit count.
     *
     * @return int.
     */
    public int getHitCount() {
        return hitCount;
    }

    /**
     * Get ships sunk.
     *
     * @return int.
     */
    public int getShipsSunk() {
        return shipsSunk;
    }

    /**
     * If the game is over.
     *
     * @return boolean.
     */
    public boolean isGameOver() {
        return TOTAL_SHIPS == shipsSunk;
    }

    /**
     * Get ship array.
     *
     * @return Ship[][].
     */
    public Ship[][] getShipArray() {
        return ships.clone();
    }

    /**
     * Print the ocean.
     *
     * @return String.
     */
    public String print() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                result.append(ships[i][j]);
            }
            result.append("\n");
        }
        return result.toString();
    }
}
