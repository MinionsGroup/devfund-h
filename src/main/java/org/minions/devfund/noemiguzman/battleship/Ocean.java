package org.minions.devfund.noemiguzman.battleship;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Ocean class.
 */
public class Ocean {
    private static final int SIZE_OCEAN = 20;
    private static final int NRO_SHIPS = 13;
    private static final int BATTLESHIP_NUMBER = 1;
    private static final int BATTLE_CRUISER_NUMBER = 1;
    private static final int CRUISER_NUMBER = 2;
    private static final int LIGHT_CRUISER_NUMBER = 2;
    private static final int DESTROYER_NUMBER = 3;
    private static final int SUBMARINE_NUMBER = 4;
    private static final Map<String, Integer> FLEET_MAP = new HashMap<>();
    static {
        FLEET_MAP.put("BattleShip", BATTLESHIP_NUMBER);
        FLEET_MAP.put("BattleCruiser", BATTLE_CRUISER_NUMBER);
        FLEET_MAP.put("Cruiser", CRUISER_NUMBER);
        FLEET_MAP.put("LightCruiser", LIGHT_CRUISER_NUMBER);
        FLEET_MAP.put("Destroyer", DESTROYER_NUMBER);
        FLEET_MAP.put("Submarine", SUBMARINE_NUMBER);
    }
    private Ship[][] ships;
    private int shotsFired;
    private int hitCount;
    private int shipsSunk;
    private Random random;

    /**
     * Creates an empty ocean (fills the ships array with a bunch of EmptySea instances).
     * Also initializes any game variables, such as how many shots have been fired.
     */
    public Ocean() {
        ships = new Ship[SIZE_OCEAN][SIZE_OCEAN];
        for (int i = 0; i < SIZE_OCEAN; i++) {
            for (int j = 0; j < SIZE_OCEAN; j++) {
                EmptySea emptySea = new EmptySea();
                emptySea.placeShipAt(i, j, true, this);
            }
        }
        random = new Random();
    }

    /**
     * Place all randomly on the (initially empty) ocean.
     * Place larger ships before smaller ones, or you may end up with no legal place to put a large ship.
     */
    public void placeAllShipsRandomly() {

        for (Map.Entry<String, Integer> shipFleet : FLEET_MAP.entrySet()) {
            String shipType = shipFleet.getKey();
            int shipQuantity = shipFleet.getValue();
            int placedShips = 0;
            while (placedShips < shipQuantity) {
                Ship ship = ShipFactory.getShip(shipType);
                putRandom(ship);
                placedShips++;

            }

        }

    }

    /**
     * put ship on ocean.
     *
     * @param ship object
     */
    public void putRandom(final Ship ship) {
        int row;
        int column;
        boolean horizontalRando;
        do {
            row = random.nextInt(SIZE_OCEAN);
            column = random.nextInt(SIZE_OCEAN);
            horizontalRando = random.nextBoolean();

        } while (!ship.okToPlaceShipAt(row, column, horizontalRando, this));
        ship.placeShipAt(row, column, horizontalRando, this);
    }

    /**
     * Returns true if the given location contains a ship, false if it does not.
     *
     * @param row    number
     * @param column number
     * @return true if it is occupied.
     */
    public boolean isOccupied(int row, int column) {

        return !ships[row][column].getShipType().equals("empty");
    }

    /**
     * Returns true if the given location contains a real ship, still afloat, (not an EmptySea), false if it does not.
     * In addition, this method updates the number of shots that have been fired, and the number of hits.
     * If a location contains a real ship, shootAt should return true every time the user shoots at that same location.
     * Once a ship has been sunk, additional shots at its location should return false.
     *
     * @param row    number
     * @param column number
     * @return true
     */
    public boolean shootAt(int row, int column) {
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
        }
        ships[row][column].shootAt(row, column);
        return false;
    }

    /**
     * Returns the 20x20 array of ships.
     * Take an Ocean parameter really need to be able to look at the contents of this array;
     * the placeShipAt method even needs to modify it.
     *
     * @return Ships
     */
    public Ship[][] getShipArray() {
        return ships.clone();
    }

    /**
     * Returns the number of shots fired (in this game).
     *
     * @return in shots
     */
    public int getShotsFired() {
        return shotsFired;
    }


    /**
     * Returns the number of hits recorded (in this game).
     * All hits are counted, not just the first time a given square is hit.
     *
     * @return hits
     */
    public int getHitCount() {
        return hitCount;
    }


    /**
     * Returns the number of ships sunk (in this game).
     *
     * @return in sunk
     */
    public int getShipsSunk() {
        return shipsSunk;
    }

    /**
     * Returns true if all ships have been sunk, otherwise false.
     *
     * @return true if shipssumk
     */
    public boolean isGameOver() {
        return shipsSunk == NRO_SHIPS;
    }
}
