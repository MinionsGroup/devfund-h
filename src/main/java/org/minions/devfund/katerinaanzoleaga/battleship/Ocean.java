package org.minions.devfund.katerinaanzoleaga.battleship;

import java.util.Arrays;
import java.util.Currency;
import java.util.Random;
import java.util.stream.Collectors;

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


    public Ship[][] getShips() {
        return ships;
    }

    public void setShips(Ship[][] ships) {
        this.ships = ships;
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
        EmptySea emptySea = new EmptySea();
        for (Ship[] row : this.ships)
            Arrays.fill(row, emptySea);
    }

    @Override
    public String toString() {
        String[][] array = { { "a", "b" }, { "c" } };

        String lineSeparator = System.lineSeparator();
        StringBuilder sb = new StringBuilder();

        for (Ship[] row : this.ships) {
            for (Ship ship : row) {
                sb.append(ship.toString());

            }
            sb.append(lineSeparator);
        }

        return sb.toString();
    }


    /**
     * Returns true if the position is valid from 0 to the length of the ocean.
     * @param row
     * @param column
     * @return boolean
     */
    public boolean isValidPosition (int row, int column) {
        int maxPosition = this.getShips().length - 1;
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
    public void placeAllShipRandomly() {


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
            row = randomNumber.nextInt(this.getShips().length);
            colum = randomNumber.nextInt(this.getShips().length);
            horizontal= randomNumber.nextInt(2);
            battleShip = new BattleShip();
            while (!battleShip.okToPlaceShipAt(row,colum, horizontal == 1,this)) {
                row = randomNumber.nextInt(this.getShips().length);
                colum = randomNumber.nextInt(this.getShips().length);
                horizontal= randomNumber.nextInt(2);
            }
            battleShip.placeShipAt(row, colum, horizontal ==1, this);
        }

        for (int i=1; i<=BATTLECRUSIERSNUMBER; ++i) {
            row = randomNumber.nextInt(this.getShips().length);
            colum = randomNumber.nextInt(this.getShips().length);
            horizontal= randomNumber.nextInt(2);
            battleCruiser = new BattleCruiser();
            while (!battleCruiser.okToPlaceShipAt(row,colum, horizontal == 1,this)) {
                row = randomNumber.nextInt(this.getShips().length);
                colum = randomNumber.nextInt(this.getShips().length);
                horizontal= randomNumber.nextInt(2);
            }
            battleCruiser.placeShipAt(row, colum, horizontal ==1, this);
        }

        for (int i=1; i<=CRUSIERSNUMBER; ++i) {
            row = randomNumber.nextInt(this.getShips().length);
            colum = randomNumber.nextInt(this.getShips().length);
            horizontal= randomNumber.nextInt(2);
            cruiser = new Cruiser();
            while (!cruiser.okToPlaceShipAt(row,colum, horizontal == 1,this)) {
                row = randomNumber.nextInt(this.getShips().length);
                colum = randomNumber.nextInt(this.getShips().length);
                horizontal= randomNumber.nextInt(2);
            }
            cruiser.placeShipAt(row, colum, horizontal ==1, this);
        }

        for (int i=1; i<=LIGHTCRUISIERSNUMBER; ++i) {
            row = randomNumber.nextInt(this.getShips().length);
            colum = randomNumber.nextInt(this.getShips().length);
            horizontal= randomNumber.nextInt(2);
            lightCruiser = new LightCruiser();
            while (!lightCruiser.okToPlaceShipAt(row,colum, horizontal == 1,this)) {
                row = randomNumber.nextInt(this.getShips().length);
                colum = randomNumber.nextInt(this.getShips().length);
                horizontal= randomNumber.nextInt(2);
            }
            lightCruiser.placeShipAt(row, colum, horizontal ==1, this);
        }

        for (int i=1; i<=DESTROYERSNUMBER; ++i) {
            row = randomNumber.nextInt(this.getShips().length);
            colum = randomNumber.nextInt(this.getShips().length);
            horizontal= randomNumber.nextInt(2);
            destroyer = new Destroyer();
            while (!destroyer.okToPlaceShipAt(row,colum, horizontal == 1,this)) {
                row = randomNumber.nextInt(this.getShips().length);
                colum = randomNumber.nextInt(this.getShips().length);
                horizontal= randomNumber.nextInt(2);
            }
            destroyer.placeShipAt(row, colum, horizontal ==1, this);
        }

        for (int i=1; i<=SUBMARINESNUMBER; ++i) {
            row = randomNumber.nextInt(this.getShips().length);
            colum = randomNumber.nextInt(this.getShips().length);
            horizontal= randomNumber.nextInt(2);
            submarine = new Submarine();
            while (!submarine.okToPlaceShipAt(row,colum, horizontal == 1,this)) {
                row = randomNumber.nextInt(this.getShips().length);
                colum = randomNumber.nextInt(this.getShips().length);
                horizontal= randomNumber.nextInt(2);
            }
            submarine.placeShipAt(row, colum, horizontal ==1, this);
        }


        System.out.println(this);


    }




}
