package org.minions.devfund.damianvp.battleship;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Ocean class.
 */
public class Ocean {
    static final int LENGTH = 20;
    static final int TOTAL_SHIPS = 13;
    private Ship[][] ships = new Ship[LENGTH][LENGTH];
    private int shotsFired;
    private int hitCount;
    private int shipsSunk;
    private Map<String, Integer> fleet;

    /**
     * Ocean constructor.
     */
    Ocean() {
        for (int i = 0; i < LENGTH; i++) {
            for (int j = 0; j < LENGTH; j++) {
                EmptySea emptySea = new EmptySea();
                this.ships[i][j] = emptySea;
                emptySea.placeShipAt(i, j, true, this);
            }
        }
        this.shotsFired = 0;
        this.hitCount = 0;
        this.shipsSunk = 0;
        setFleet();
    }

    /**
     * This method sets the quantity of ships allowed in the game.
     */
    private void setFleet() {
        final int destroyer = 3;
        final int submarine = 4;
        fleet = new HashMap<>();
        fleet.put("BattleShip", 1);
        fleet.put("BattleCruiser", 1);
        fleet.put("Cruiser", 2);
        fleet.put("LightCruiser", 2);
        fleet.put("Destroyer", destroyer);
        fleet.put("Submarine", submarine);
    }

    /**
     * methohd to place all ship randomly.
     */
    void placeAllShipsRandomly() {
        Random random = new Random();
        ShipCreator creator = new ShipCreator();
        for (String shipType : fleet.keySet()) {
            int placedShips = 0;
            while (placedShips < fleet.get(shipType)) {
                Ship ship = creator.getShip(shipType);
                int row;
                int column;
                boolean horizontal;
                do {
                    row = random.nextInt(LENGTH);
                    column = random.nextInt(LENGTH);
                    horizontal = random.nextBoolean();

                } while (!ship.okToPlaceShipAt(row, column, horizontal, this));
                ship.placeShipAt(row, column, horizontal, this);
                placedShips++;
            }
        }

    }

    /**
     * method to verify if a specific position is occupied.
     * @param row int value of specific position.
     * @param column int value of specific position.
     * @return true, if position is occupied.
     *         false, if position is empty.
     */
    boolean isOccupied(int row, int column) {
        return !ships[row][column].getShipType().equals("empty");
    }

    /**
     * Method to shot at under specific position.
     * @param row int value of specific position.
     * @param column int value of specific position.
     * @return true, if any ship was sunk in te position.
     *         false, other case.
     */
    boolean shootAt(int row, int column) {
        this.shotsFired++;
        if (isOccupied(row, column)) {
            if (ships[row][column].shootAt(row, column)) {
                if (ships[row][column].isSunk()) {
                    shipsSunk++;
                }
                hitCount++;
                return true;
            }
            return false;
        } else {
            ships[row][column].shootAt(row, column);
        }
        return false;
    }

    /**
     * Method to get the Ship board.
     * @return the Ship board.
     */
    public Ship[][] getShips() {
        return ships;
    }

    /**
     * Method to get the shot fired counter.
     * @return the shotFired counter.
     */
    public int getShotsFired() {
        return shotsFired;
    }

    /**
     * Method to get the Hit counter.
     * @return the Hit Counter.
     */
    public int getHitCount() {
        return hitCount;
    }

    /**
     * Method to get the ships sunk counter.
     * @return ShipSunk counter.
     */
    public int getShipsSunk() {
        return shipsSunk;
    }

    /**
     * Method to verify if game is over.
     * @return true if game is over.
     *         false if game continue.
     */
    boolean isGameOver() {
        return shipsSunk == TOTAL_SHIPS;
    }

    /**
     * Method to get the Ship board.
     * @return the Ship board.
     */
    Ship[][] getShipArray() {
        return ships;
    }

    /**
     * Method to print the ocean.
     */
    public void print() {
        System.out.println(toString());
    }

    /**
     * Method to build the ocean matrix.
     * @return String format of matrix.
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(" ");
        for (int i = 0; i < LENGTH; i++) {
            sb.append(String.format("%3d", i));
        }
        sb.append("\n");

        for (int i = 0; i < LENGTH; i++) {
            sb.append(String.format("%2d ", i));
            for (int j = 0; j < LENGTH; j++) {
                if (!ships[i][j].wasShootAt(i, j)) { // never been fired
                    sb.append(".");
                } else {
                    sb.append(ships[i][j].toString());
                }
                sb.append("  ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
