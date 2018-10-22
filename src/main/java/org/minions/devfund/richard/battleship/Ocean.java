package org.minions.devfund.richard.battleship;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Class.
 */
public class Ocean {

    private static final int OCEAN_LENGTH = 20;
    private static final int SHIPS_QUANTITY = 13;
    private static final List<String> SHIP_LIST = Arrays.asList(
            "battleship",
            "battlecruiser",
            "cruiser",
            "lightcruiser",
            "destroyer",
            "submarine"
    );
    private Ship[][] ships;
    private int shotsFired;
    private int hitCount;
    private int shipsSunk;
    private Random random;

    /**
     * Ocean.
     */
    Ocean() {
        ships = new Ship[OCEAN_LENGTH][OCEAN_LENGTH];
        Arrays.stream(ships).forEach(row -> Arrays.fill(row, new EmptySea()));
        random = new Random();
    }

    /**
     * place all Ships randomly.
     */
    void placeAllShipsRandomly() {
        for (String ship : SHIP_LIST) {
            int shipNumber = ShipFactory.getShip(ship).getNumber();
            while (shipNumber > 0) {
                Ship myShip = ShipFactory.getShip(ship);
                boolean horizontal = random.nextBoolean();
                int row = random.nextInt(getShipArray().length);
                int column = random.nextInt(getShipArray().length);
                if (myShip.okToPlaceShipAt(row, column, horizontal, this)) {
                    myShip.placeShipAt(row, column, horizontal, this);
                    shipNumber--;
                }
            }
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
