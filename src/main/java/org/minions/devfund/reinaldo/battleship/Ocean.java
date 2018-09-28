package org.minions.devfund.reinaldo.battleship;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Ocean class.
 */
public class Ocean {
    private Ship[][] ships;
    private int shotsFired; //int shotsFired - The total number of shots fired by the user.
    private int hitCount; //int hitCount - The number of times a shot hit a ship.
    private int shipsSunk; //The number of ships sunk. Remember that you have a total of 13 ships.

    static final int SHIPLENGTH = 20;
    private static final int SHIPS_QUANTITY = 13;

    private static final List<ShipTypeEnum> SHIPS_TO_PLACE;

    static {
        SHIPS_TO_PLACE = new ArrayList<>();
        SHIPS_TO_PLACE.add(ShipTypeEnum.BATTLESHIP);
        SHIPS_TO_PLACE.add(ShipTypeEnum.BATTLE_CRUISER);
        SHIPS_TO_PLACE.add(ShipTypeEnum.CRUISER);
        SHIPS_TO_PLACE.add(ShipTypeEnum.CRUISER);
        SHIPS_TO_PLACE.add(ShipTypeEnum.LIGHT_CRUISER);
        SHIPS_TO_PLACE.add(ShipTypeEnum.LIGHT_CRUISER);
        SHIPS_TO_PLACE.add(ShipTypeEnum.DESTROYER);
        SHIPS_TO_PLACE.add(ShipTypeEnum.DESTROYER);
        SHIPS_TO_PLACE.add(ShipTypeEnum.DESTROYER);
        SHIPS_TO_PLACE.add(ShipTypeEnum.SUBMARINE);
        SHIPS_TO_PLACE.add(ShipTypeEnum.SUBMARINE);
        SHIPS_TO_PLACE.add(ShipTypeEnum.SUBMARINE);
        SHIPS_TO_PLACE.add(ShipTypeEnum.SUBMARINE);
    }

    /**
     * Constructors to Ocean class.
     */
    public Ocean() {

        ships = new Ship[SHIPLENGTH][SHIPLENGTH];
        fillTheEmptyOcean();
        shotsFired = 0;
        hitCount = 0;
        shipsSunk = 0;
    }

    /**
     * Creates an empty ocean (fills the ships array with a bunch of EmptySea instances).
     * Also initializes any game variables, such as how many shots have been fired.
     */
    private void fillTheEmptyOcean() {
        Arrays.stream(ships).forEach(shipRow -> Arrays.fill(shipRow, new EmptySea()));
    }

    /**
     * Creates a ships randomly on ocean.
     */
    public void placeAllShipsRandomly() {
        Random random = new Random();
        ShipFactory factory = new ShipFactory();
        SHIPS_TO_PLACE.forEach(newShip -> {
            boolean placeShip;
            do {
                int row = random.nextInt(SHIPLENGTH);
                int column = random.nextInt(SHIPLENGTH);
                boolean horizontal = random.nextBoolean();
                placeShip = factory.getShip(newShip).okToPlaceShipAt(row, column, horizontal, this);
                if (placeShip) {
                    factory.getShip(newShip).placeShipAt(row, column, horizontal, this);
                }
            }
            while (!placeShip);
        });

    }

    /**
     * Looks the position if it is exist on that position.
     *
     * @param row    int row position.
     * @param column int column position.
     * @return true if position was occupied.
     */
    boolean isOccupied(final int row, final int column) {
        return ships[row][column].getLength() > 1;
    }

    /**
     * Shoots a position.
     *
     * @param row    int row position.
     * @param column int column position.
     * @return true if ship was shot.
     */
    boolean shootAt(final int row, final int column) {
        shotsFired++;
        if (ships[row][column].shootAt(row, column)) {
            increaseHitCounters(row, column);
            return true;
        }
        return false;
    }

    /**
     * Uptates the hit counters and sunk.
     *
     * @param row    row position.
     * @param column column position.
     */
    private void increaseHitCounters(final int row, final int column) {
        if (ships[row][column].isSunk()) {
            shipsSunk++;
        }
        hitCount++;
    }

    /**
     * Gets the shots fired.
     *
     * @return int shots fired quantity.
     */
    int getShotsFired() {
        return shotsFired;
    }

    /**
     * Gets the hit count.
     *
     * @return int he hit number.
     */
    int getHitCount() {
        return hitCount;
    }

    /**
     * Gets the ships sunk quantity.
     *
     * @return int ships sunk number.
     */
    int getShipsSunk() {
        return shipsSunk;
    }

    /**
     * if the game over to battleship.
     *
     * @return true if game over.
     */
    boolean isGameOver() {
        return shipsSunk == SHIPS_QUANTITY;
    }

    /**
     * Gets the ship array.
     *
     * @return matrix of ship
     */
    Ship[][] getShipArray() {
        return ships;
    }
}

