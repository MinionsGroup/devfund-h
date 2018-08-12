package org.minions.devfund.noemiguzman.battleship;


import java.util.Random;

/**
 * Ship class.
 */
public abstract class Ship {
    private int length;
    private int bowRow;
    private int bowColumn;
    private boolean horizontal;
    private static final int SIZE_OCEAN = 20;
    private boolean[] hit;

    /**
     * This is an abstract method and therefore has no body.
     * @return ship string
     */
    public abstract String getShipType();

    /**
     * Returns true if it is okay to put a ship of this length with its bow in this location,
     * with the given orientation, and returns false otherwise.
     * The ship must not overlap another ship, or touch another ship (vertically, horizontally, or diagonally),
     * and it must not stickout beyond the array.
     * Do not actually change either the ship or the Ocean, just says whether it is legal to do so.
     * @param row numeric
     * @param column numeric
     * @param horizontal true
     * @param ocean object
     * @return true
     */
    public boolean okToPlaceShipAt(int row, int column, boolean horizontal, final Ocean ocean) {


        if (horizontal) {
            if (column + getLength() > SIZE_OCEAN) {
                return false;
            }
            return helpToPlaceShipAt(column,  row,  1,   getLength() + 1, ocean);

        } else {
            if (row + getLength() > SIZE_OCEAN) {
                return false;
            }
            return helpToPlaceShipAt(column,  row,  getLength(),   1, ocean);
        }
    }

    /**
     * help to ask to place ship at.
     * @param column numeric
     * @param row numeric
     * @param lenghtRow maxrow
     * @param lengthColumn maxcolumn
     * @param ocean object
     * @return true
     */
    private boolean helpToPlaceShipAt(int column, int row, int lenghtRow, int lengthColumn, final Ocean ocean) {

        for (int i = row - 1; i <= row + lenghtRow; i++) {
            for (int j = column - 1; j < column + lengthColumn; j++) {
                try {

                    if (!ocean.getShipArray()[i][j].getShipType().equals("empty")) {
                        return false;
                    }
                } catch (Exception e) {
                    continue;
                }
            }
        }
        return true;
    }

    /**
     * Puts the ship in the ocean.
     * This involves giving values to the bowRow, bowColumn, and horizontal instance variables in the ship.
     * @param row number
     * @param column number
     * @param horizontal true
     * @param ocean object
     */
    public void placeShipAt(int row, int column, boolean horizontal, final Ocean ocean) {
        bowRow = row;
        bowColumn = column;
        this.horizontal = horizontal;

        /*
         * Set references to the ship in the ships array in the Ocean object
         */
        if (horizontal) {
            for (int j = column; j < column + getLength(); j++) {
                ocean.getShipArray()[row][j] = this;
            }
        } else {
            for (int i = row; i < row + getLength(); i++) {
                ocean.getShipArray()[i][column] = this;
            }
        }
    }


    /**
     * Return true if the part of the ship was hit, false otherwise.
     * @param row number
     * @param column number
     * @return true
     */
    public boolean wasShootAt(int row, int column) {
        if (horizontal) {
            return hit[column - this.bowColumn];
        } else {
            return hit[row - this.bowRow];
        }
    }

    /**
     * If a part of the ship occupies the given row and column, and the ship hasnot been sunk,
     * mark that part of the ship as hit (in the hit array, 0 indicates the bow) and return true,
     * otherwise return false.
     * @param row number
     * @param column number
     * @return true
     */
    public boolean shootAt(int row, int column) {
        if (!isSunk()) {
            if (horizontal) {
                if (row == this.bowRow && column < this.bowColumn + length) {
                    hit[column - this.bowColumn] = true;
                    return true;
                }
            } else {
                if (column == this.bowColumn && row < this.bowRow + length) {
                    hit[row - this.bowRow] = true;
                    return true;
                }
            }
        }
        return false;
    }


    /**
     * Return true if every part of the ship has been hit, false otherwise.
     * @return true
     */
    public boolean isSunk() {
        for (boolean b : hit) {
            if (!b) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        return isSunk() ? "x" : "S";
    }

    /**
     * returns length.
     * @return int size
     */
    public int getLength() {
        return length;
    }

    /**
     * set size.
     * @param length int
     */
    public void setLength(int length) {
        this.length = length;
    }

    /**
     * returns hit.
     * @return true hit
     */
    public boolean[] getHit() {
        return hit.clone();
    }

    /**
     * set hit.
     * @param hit object
     */
    public void setHit(final boolean[] hit) {
        this.hit = hit.clone();
    }

    /**
     * put ship on ocean.
     * @param ocean object
     */
    public void putRandom(final Ocean ocean) {
        Random random = new Random();
        int row;
        int column;
        boolean horizontalRando;
        while (true) {
            row = random.nextInt(SIZE_OCEAN);
            column = random.nextInt(SIZE_OCEAN);
            horizontalRando = random.nextBoolean();
            if (this.okToPlaceShipAt(row, column, horizontalRando, ocean)) {
                this.placeShipAt(row, column, horizontalRando, ocean);

                break;
            }
        }
    }

}
