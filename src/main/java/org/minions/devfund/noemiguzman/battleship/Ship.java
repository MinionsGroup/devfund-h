package org.minions.devfund.noemiguzman.battleship;


import java.util.Random;

public abstract class Ship {
    private int length;
    private boolean horizontal;
    private int bowRow;
    private int bowColumn;

    boolean[] hit;

    /*
     * This is an abstract method and therefore has no body.
     */
    public abstract String getShipType();

    /*
     * Returns true if it is okay to put a ship of this length with its bow in this location, with the given orientation, and returns false otherwise.
     * The ship must not overlap another ship, or touch another ship (vertically, horizontally, or diagonally), and it must not stickout beyond the array.
     * Do not actually change either the ship or the Ocean, just says whether it is legal to do so.
     */
    public boolean okToPlaceShipAt(int row, int column, boolean horizontal, Ocean ocean) {
//		System.out.println("ship at " + row + " " + column  + " " + horizontal);
        if (horizontal) {
            if (column + getLength() > 20) {
                return false;
            }
            for (int i = row - 1; i <= row + 1; i++) {
                for (int j = column - 1; j < column + getLength() + 1; j++) {
                    try {
//						System.out.println(i + " " + j + " " + ocean.getShipArray()[i][j].getShipType().equals("empty"));
                        if (!ocean.getShipArray()[i][j].getShipType().equals("empty")) {
                            return false;
                        }
                    } catch (Exception e) {
                        continue;
                    }
                }
            }
        } else {
            if (row + getLength() > 20) {
                return false;
            }
            for (int i = row - 1; i < row + getLength() + 1; i++) {
                for (int j = column - 1; j <= column + 1; j++) {
                    try {
//						System.out.println(i + " " + j + " " + ocean.getShipArray()[i][j].getShipType().equals("empty"));
                        if (!ocean.getShipArray()[i][j].getShipType().equals("empty")) {
                            return false;
                        }
                    } catch (Exception e) {
                        continue;
                    }
                }
            }
        }
//		System.out.println("");
        return true;
    }

    /*
     * Puts the ship in the ocean.
     * This involves giving values to the bowRow, bowColumn, and horizontal instance variables in the ship.
     */
    public void placeShipAt(int row, int column, boolean horizontal, Ocean ocean) {
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

    /*
     * Return true if the part of the ship was hit, false otherwise
     */
    public boolean wasShootAt(int row, int column) {
        if (horizontal) {
            return hit[column - this.bowColumn] == true;
        } else {
            return hit[row - this.bowRow] == true;
        }
    }

    /*
     * If a part of the ship occupies the given row and column, and the ship hasnot been sunk,
     * mark that part of the ship as hit (in the hit array, 0 indicates the bow) and return true,
     * otherwise return false.
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



    /*
     * Return true if every part of the ship has been hit, false otherwise.
     */
    public boolean isSunk() {
        for (boolean b : hit) if (!b) return false;
        return true;
    }

    /*
     * Return X if the ship has been sunk,  S if it has not been sunk.
     * This method can be used to print out locations in the ocean that have been shot at;
     * it should not be used to print locations that have not been shot at.
     */
    @Override
    public String toString() {
        return isSunk() ? "x" : "S";
    }

    public int getLength() {
        return length;
    }
    public void setLength(int length) {
        this.length = length;
    }

    public boolean[] getHit() {
        return hit;
    }
    public void setHit(boolean[] hit) {
        this.hit = hit;
    }

    public void putRandom(Ocean ocean) {
        Random random = new Random();
        int row;
        int column;
        boolean horizontal;
        while (true) {
            row = random.nextInt(20);
            column = random.nextInt(20);
            horizontal = random.nextBoolean();
            if (this.okToPlaceShipAt(row, column, horizontal, ocean)) {
                this.placeShipAt(row, column, horizontal, ocean);

                break;
            }
        }
    }

}
