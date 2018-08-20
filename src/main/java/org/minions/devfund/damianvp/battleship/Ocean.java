package org.minions.devfund.damianvp.battleship;

import java.util.Random;

/**
 * Ocean class.
 */
public class Ocean {
    static final int LENGTH = 20;
    static final int ALLOWED_SHIPS = 13;
    private Ship[][] ships = new Ship[LENGTH][LENGTH];
    private int shotsFired;
    private int hitCount;
    private int shipsSunk;

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
    }

    /**
     * methohd to place all ship randomly.
     */
    void placeAllShipsRandomly() {
        Random random = new Random();
        Ship[] ships = new Ship[ALLOWED_SHIPS];
        for (int i = 0; i < ALLOWED_SHIPS; i++) {
            if (i == 0) {
                ships[i] = new BattleShip();
            } else if (i == 1) {
                ships[i] = new BattleCruiser();
            } else if (i < 4) {
                ships[i] = new Cruiser();
            } else if (i < 6) {
                ships[i] = new LightCruiser();
            } else if (i < 9) {
                ships[i] = new Destroyer();
            } else if (i < 13) {
                ships[i] = new Submarine();
            }
        }

        for (Ship ship : ships) {
            while (true) {
                int row = random.nextInt(LENGTH);
                int column = random.nextInt(LENGTH);
                boolean horizontal = random.nextBoolean();

                if (ship.okToPlaceShipAt(row, column, horizontal, this)) {

                    ship.placeShipAt(row, column, horizontal, this);
                    break;
                }
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
        return shipsSunk == 13;
    }

    /**
     * Method to get the Ship board.
     * @return the Ship board.
     */
    Ship[][] getShipArray() {
        return ships;
    }

    public void print() {
        System.out.println(toString());
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(" ");
        for (int i = 0; i < 20; i++) {
            sb.append(String.format("%3d", i));
        }
        sb.append("\n");

        for (int i = 0; i < 20; i++) {
            sb.append(String.format("%2d ", i));
            for (int j = 0; j < 20; j++) {
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
