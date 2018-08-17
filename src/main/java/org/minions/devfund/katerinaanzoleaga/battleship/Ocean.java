package org.minions.devfund.katerinaanzoleaga.battleship;

import java.util.Arrays;
import java.util.Formatter;
import java.util.Random;

public class Ocean {



    private Ship[][] ships = new Ship[20][20];



    private int shotsFired;
    private int hitCount;
    private int shipsSunk;

    private static final int BATTLESHIPSNUMBER = 1;
    private static final int BATTLECRUSIERSNUMBER = 1;
    private static final int CRUSIERSNUMBER = 2;
    private static final int LIGHTCRUISIERSNUMBER = 2;
    private static final int DESTROYERSNUMBER = 3;
    private static final int SUBMARINESNUMBER = 4;


    public Ship[][] getShipArray() {
        return ships;
    }

    public void setShips(Ship[][] ships) {
        this.ships = ships;
    }

    public int getShotsFired() {
        return shotsFired;
    }

    public int getHitCount() {
        return hitCount;
    }

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
        for (int i = 0; i < this.ships.length; ++i)
            for (int j = 0; j < this.ships.length; ++j) {
                EmptySea emptySea = new EmptySea();
                this.ships[i][j] = emptySea;
            }
    }

    /**
     * Returns the ocean with the column and row numbers added.
     *
     * @return
     */
    public String toString() {
        String lineSeparator = System.lineSeparator();
        StringBuilder sb = new StringBuilder();
        Formatter fmt = new Formatter(sb);
        int hitPosition;

        final String SPACES = " ";
        for (int i = -1; i < this.ships.length; ++i){
            for (int j = -1; j < this.ships.length; ++j) {
                if (i == -1 && j == -1) {
                    fmt.format("%2s", "");
                }
                if (i == -1 && j != -1) {
                    sb.append(SPACES);
                    fmt.format("%02d", j);
                }
                if (j == -1 && i != -1) {
                    fmt.format("%02d", i);
                }
                if (i != -1 && j != -1) {
                    if (this.ships[i][j].getShipType() == "empty") {
                        if (this.ships[i][j].getHit()[0]) {
                            fmt.format("%3s", "-");
                        } else {
                            fmt.format("%3s", ".");
                        }
                    } else {
                        if (this.ships[i][j].isSunk()) {
                            fmt.format("%3s", "x");
                        } else {
                            hitPosition = this.ships[i][j].hitPosition(i,j);
                            if (hitPosition != -1) {
                                if (this.ships[i][j].getHit()[hitPosition]) {
                                    fmt.format("%3s", this.ships[i][j].toString());
                                } else {
                                    fmt.format("%3s", ".");
                                }
                            }
                        }
                    }
                }
            }
            sb.append(lineSeparator);
        }
        return sb.toString();
    }


    public void print() {
        System.out.println(this);
    }


    /**
     * Returns true if the position is valid from 0 to the length of the ocean.
     * @param row
     * @param column
     * @return boolean
     */
    public boolean isValidPosition (int row, int column) {
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

        for (int i=1; i<=BATTLESHIPSNUMBER; ++i) {
            row = randomNumber.nextInt(this.getShipArray().length);
            colum = randomNumber.nextInt(this.getShipArray().length);
            horizontal= randomNumber.nextInt(2);
            battleShip = new BattleShip();
            while (!battleShip.okToPlaceShipAt(row,colum, horizontal == 1,this)) {
                row = randomNumber.nextInt(this.getShipArray().length);
                colum = randomNumber.nextInt(this.getShipArray().length);
                horizontal= randomNumber.nextInt(2);
            }
            battleShip.placeShipAt(row, colum, horizontal ==1, this);
        }

        for (int i=1; i<=BATTLECRUSIERSNUMBER; ++i) {
            row = randomNumber.nextInt(this.getShipArray().length);
            colum = randomNumber.nextInt(this.getShipArray().length);
            horizontal= randomNumber.nextInt(2);
            battleCruiser = new BattleCruiser();
            while (!battleCruiser.okToPlaceShipAt(row,colum, horizontal == 1,this)) {
                row = randomNumber.nextInt(this.getShipArray().length);
                colum = randomNumber.nextInt(this.getShipArray().length);
                horizontal= randomNumber.nextInt(2);
            }
            battleCruiser.placeShipAt(row, colum, horizontal ==1, this);
        }

        for (int i=1; i<=CRUSIERSNUMBER; ++i) {
            row = randomNumber.nextInt(this.getShipArray().length);
            colum = randomNumber.nextInt(this.getShipArray().length);
            horizontal= randomNumber.nextInt(2);
            cruiser = new Cruiser();
            while (!cruiser.okToPlaceShipAt(row,colum, horizontal == 1,this)) {
                row = randomNumber.nextInt(this.getShipArray().length);
                colum = randomNumber.nextInt(this.getShipArray().length);
                horizontal= randomNumber.nextInt(2);
            }
            cruiser.placeShipAt(row, colum, horizontal ==1, this);
        }

        for (int i=1; i<=LIGHTCRUISIERSNUMBER; ++i) {
            row = randomNumber.nextInt(this.getShipArray().length);
            colum = randomNumber.nextInt(this.getShipArray().length);
            horizontal= randomNumber.nextInt(2);
            lightCruiser = new LightCruiser();
            while (!lightCruiser.okToPlaceShipAt(row,colum, horizontal == 1,this)) {
                row = randomNumber.nextInt(this.getShipArray().length);
                colum = randomNumber.nextInt(this.getShipArray().length);
                horizontal= randomNumber.nextInt(2);
            }
            lightCruiser.placeShipAt(row, colum, horizontal ==1, this);
        }

        for (int i=1; i<=DESTROYERSNUMBER; ++i) {
            row = randomNumber.nextInt(this.getShipArray().length);
            colum = randomNumber.nextInt(this.getShipArray().length);
            horizontal= randomNumber.nextInt(2);
            destroyer = new Destroyer();
            while (!destroyer.okToPlaceShipAt(row,colum, horizontal == 1,this)) {
                row = randomNumber.nextInt(this.getShipArray().length);
                colum = randomNumber.nextInt(this.getShipArray().length);
                horizontal= randomNumber.nextInt(2);
            }
            destroyer.placeShipAt(row, colum, horizontal ==1, this);
        }

        for (int i=1; i<=SUBMARINESNUMBER; ++i) {
            row = randomNumber.nextInt(this.getShipArray().length);
            colum = randomNumber.nextInt(this.getShipArray().length);
            horizontal= randomNumber.nextInt(2);
            submarine = new Submarine();
            while (!submarine.okToPlaceShipAt(row,colum, horizontal == 1,this)) {
                row = randomNumber.nextInt(this.getShipArray().length);
                colum = randomNumber.nextInt(this.getShipArray().length);
                horizontal= randomNumber.nextInt(2);
            }
            submarine.placeShipAt(row, colum, horizontal ==1, this);
        }
    }

    public boolean shootAt(int row, int column) {
        if (this.isValidPosition(row, column)) {
            Ship aShip;
            ++this.shotsFired;
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
                }
                else {
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
        if (shipsSunk == BATTLESHIPSNUMBER + BATTLECRUSIERSNUMBER +
                CRUSIERSNUMBER + LIGHTCRUISIERSNUMBER + DESTROYERSNUMBER + SUBMARINESNUMBER) {
            return true;
        } else {
            return false;
        }
    }





}
