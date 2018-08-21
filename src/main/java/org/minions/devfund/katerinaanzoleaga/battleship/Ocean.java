package org.minions.devfund.katerinaanzoleaga.battleship;

import java.util.Formatter;
import java.util.Random;

/**
 * Ocean class is the base of BattleShip game. It holds the ships to be sunk.
 */
public class Ocean {


    private int shotsFired;
    private int hitCount;
    private int shipsSunk;
    private static final int LENGTH = 15;
    private static final int BATTLESHIPSNUMBER = 1;
    private static final int BATTLECRUSIERSNUMBER = 1;
    private static final int CRUSIERSNUMBER = 2;
    private static final int LIGHTCRUISIERSNUMBER = 2;
    private static final int DESTROYERSNUMBER = 3;
    private static final int SUBMARINESNUMBER = 4;

    private Ship[][] ships = new Ship[LENGTH][LENGTH];

    /**
     * Returns the Ships array.
     * @return Array of ships
     */
    public Ship[][] getShipArray() {
        return ships;
    }

    /**
     * Updates the Ships array.
     * @param ships of the ocean.
     */
    public void setShips(final Ship[][] ships) {
        this.ships = ships;
    }

    /**
     * Returns the number of shots the gamer fired.
     * @return shots fired.
     */
    public int getShotsFired() {
        return shotsFired;
    }

    /**
     * Returns the number of hits.
     * @return hit count
     */
    public int getHitCount() {
        return hitCount;
    }

    /**
     * Returns the number of Ships already sunk.
     * @return shis sunk
     */
    public int getShipsSunk() {
        return shipsSunk;
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
        for (int i = 0; i < this.ships.length; ++i) {
            for (int j = 0; j < this.ships.length; ++j) {
                EmptySea emptySea = new EmptySea();
                emptySea.setBowRow(i);
                emptySea.setBowColumn(j);
                this.ships[i][j] = emptySea;
            }
        }
    }

    /**
     * Prints the ocean with the values to display the game board and ships' status.
     *
     */
    public void print(){
        String lineSeparator = System.lineSeparator();
        StringBuilder sb = new StringBuilder();
        Formatter fmt = new Formatter(sb);
        int hitPosition;

        final String spaces = " ";
        for (int i = -1; i < this.ships.length; ++i) {
            for (int j = -1; j < this.ships.length; ++j) {
                if (i == -1 && j == -1) {
                    fmt.format("%2s", "");
                }
                if (i == -1 && j != -1) {
                    sb.append(spaces);
                    fmt.format("%02d", j);
                }
                if (j == -1 && i != -1) {
                    fmt.format("%02d", i);
                }
                if (i != -1 && j != -1) {
                    hitPosition = this.ships[i][j].isInShipPosition(i, j);
                    if (hitPosition != -1) {
                        if (this.ships[i][j].getHit()[hitPosition]) {
                            fmt.format("%3s", this.ships[i][j].toString());
                        } else {
                            fmt.format("%3s", ".");
                        }
                    }
                }
            }
            sb.append(lineSeparator);
        }
        System.out.println(sb.toString());
    }



    /**
     * Returns true if the position is valid from 0 to the length of the ocean.
     * @param row int
     * @param column int
     * @return boolean
     */
    public boolean isValidPosition(int row, int column) {
        int maxPosition = this.getShipArray().length - 1;
        return row >= 0 && row <= maxPosition && column >= 0 && column <= maxPosition;
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


    /**
     * Places the number of ships as indicated by the constant numbers in this class.
     * It places each ship in a random position and direction.
     */
    public void placeAllShipsRandomly() {


        Random randomNumber;
        randomNumber = new Random();
        int row, colum, horizontal;
        BattleShip battleShip;
        BattleCruiser battleCruiser;
        Cruiser cruiser;
        LightCruiser lightCruiser;
        Destroyer destroyer;
        Submarine submarine;

        for (int i = 1; i <= BATTLESHIPSNUMBER; ++i) {
            row = randomNumber.nextInt(this.getShipArray().length);
            colum = randomNumber.nextInt(this.getShipArray().length);
            horizontal = randomNumber.nextInt(2);
            battleShip = new BattleShip();
            while (!battleShip.okToPlaceShipAt(row, colum, horizontal == 1, this)) {
                row = randomNumber.nextInt(this.getShipArray().length);
                colum = randomNumber.nextInt(this.getShipArray().length);
                horizontal = randomNumber.nextInt(2);
            }
            battleShip.placeShipAt(row, colum, horizontal == 1, this);
        }

        for (int i = 1; i <= BATTLECRUSIERSNUMBER; ++i) {
            row = randomNumber.nextInt(this.getShipArray().length);
            colum = randomNumber.nextInt(this.getShipArray().length);
            horizontal = randomNumber.nextInt(2);
            battleCruiser = new BattleCruiser();
            while (!battleCruiser.okToPlaceShipAt(row, colum, horizontal == 1, this)) {
                row = randomNumber.nextInt(this.getShipArray().length);
                colum = randomNumber.nextInt(this.getShipArray().length);
                horizontal = randomNumber.nextInt(2);
            }
            battleCruiser.placeShipAt(row, colum, horizontal == 1, this);
        }

        for (int i = 1;  i <= CRUSIERSNUMBER; ++i) {
            row = randomNumber.nextInt(this.getShipArray().length);
            colum = randomNumber.nextInt(this.getShipArray().length);
            horizontal = randomNumber.nextInt(2);
            cruiser = new Cruiser();
            while (!cruiser.okToPlaceShipAt(row, colum, horizontal == 1, this)) {
                row = randomNumber.nextInt(this.getShipArray().length);
                colum = randomNumber.nextInt(this.getShipArray().length);
                horizontal = randomNumber.nextInt(2);
            }
            cruiser.placeShipAt(row, colum, horizontal == 1, this);
        }

        for (int i = 1; i <= LIGHTCRUISIERSNUMBER; ++i) {
            row = randomNumber.nextInt(this.getShipArray().length);
            colum = randomNumber.nextInt(this.getShipArray().length);
            horizontal = randomNumber.nextInt(2);
            lightCruiser = new LightCruiser();
            while (!lightCruiser.okToPlaceShipAt(row, colum, horizontal == 1, this)) {
                row = randomNumber.nextInt(this.getShipArray().length);
                colum = randomNumber.nextInt(this.getShipArray().length);
                horizontal = randomNumber.nextInt(2);
            }
            lightCruiser.placeShipAt(row, colum, horizontal == 1, this);
        }

        for (int i = 1;  i <= DESTROYERSNUMBER; ++i) {
            row = randomNumber.nextInt(this.getShipArray().length);
            colum = randomNumber.nextInt(this.getShipArray().length);
            horizontal = randomNumber.nextInt(2);
            destroyer = new Destroyer();
            while (!destroyer.okToPlaceShipAt(row, colum, horizontal == 1, this)) {
                row = randomNumber.nextInt(this.getShipArray().length);
                colum = randomNumber.nextInt(this.getShipArray().length);
                horizontal =  randomNumber.nextInt(2);
            }
            destroyer.placeShipAt(row, colum, horizontal == 1, this);
        }

        for (int i = 1; i <= SUBMARINESNUMBER; ++i) {
            row = randomNumber.nextInt(this.getShipArray().length);
            colum = randomNumber.nextInt(this.getShipArray().length);
            horizontal = randomNumber.nextInt(2);
            submarine = new Submarine();
            while (!submarine.okToPlaceShipAt(row, colum, horizontal == 1, this)) {
                row = randomNumber.nextInt(this.getShipArray().length);
                colum = randomNumber.nextInt(this.getShipArray().length);
                horizontal = randomNumber.nextInt(2);
            }
            submarine.placeShipAt(row, colum, horizontal == 1, this);
        }
    }

    /**
     * Retruns true if the shot hit a ship.
     * @param row int
     * @param column int
     * @return boolean
     */
    public boolean shootAt(int row, int column) {
        ++this.shotsFired;
        if (this.isValidPosition(row, column)) {
            Ship aShip;
            aShip = this.ships[row][column];
            if (aShip.isSunk()) {
                return false;
            } else {
                if (aShip.shootAt(row, column)) {
                    ++this.hitCount;
                    if (aShip.isSunk()) {
                        ++this.shipsSunk;
                    }
                    return true;
                } else {
                    return false;
                }
            }
        } else {
            return false;
        }
    }

    /**
     * Returns true only if all ships were sunk.
     * @return boolean
     */
    public boolean isGameOver() {
        return shipsSunk == BATTLESHIPSNUMBER + BATTLECRUSIERSNUMBER + CRUSIERSNUMBER
                + LIGHTCRUISIERSNUMBER + DESTROYERSNUMBER + SUBMARINESNUMBER;
    }
}
