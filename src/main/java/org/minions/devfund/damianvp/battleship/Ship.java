package org.minions.devfund.damianvp.battleship;

public abstract class Ship {
    private int bowRow; //the row (0 to 19) which contains the bow (front) of the ship.
    private int bowColumn; //- the column which contains the bow (front) of the ship.
    private int length; // – the number of squares occupied by the ship. An ”empty sea” location has length 1.
    private boolean horizontal; // – true if the ship occupies a single row, false otherwise. Ships will either be placed vertically or horizontally in the ocean.
    private boolean[] hit; // - this is a boolean array of size 8 that record hits. Only battleships use all the locations. The others will use fewer.

    public int getBowRow() {
        return bowRow;
    }

    public int getBowColumn() {
        return bowColumn;
    }

    public int getLength() {
        return length;
    }

    public boolean isHorizontal() {
        return horizontal;
    }

    public boolean[] getHit() {
        return hit;
    }

    public void setBowRow(int bowRow) {
        this.bowRow = bowRow;
    }

    public void setBowColumn(int bowColumn) {
        this.bowColumn = bowColumn;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public void setHorizontal(boolean horizontal) {
        this.horizontal = horizontal;
    }

    public void setHit(boolean[] hit) {
        this.hit = hit;
    }

    abstract String getShipType();

    boolean okToPlaceShipAt(int row, int column, boolean horizontal, Ocean ocean) {
        if (row > 20 || column > 20) {
            return false;
        }

        if (horizontal) {
            for (int i = column - 1; i < this.getLength(); i++) {
                if (!ocean.getShipArray()[row][i].getShipType().equals("empty")) {
                    return false;
                }
            }
        } else {
            for (int i = row - 1; i < this.getLength(); i++) {
                if (!ocean.getShipArray()[i][column].getShipType().equals("empty")) {
                    return false;
                }
            }
        }
        return true;
    }

    void placeShipAt(int row, int column, boolean horizontal, Ocean ocean) {
        this.bowRow = row;
        this.bowColumn = column;
        this.horizontal = horizontal;

        if (this.horizontal) {
            for (int i = column - 1; i < this.getLength(); i++) {
                ocean.getShipArray()[row][i] = this;
            }
        } else {
            for (int i = row - 1; i < this.getLength(); i++) {
                ocean.getShipArray()[i][column] = this;
            }
        }
    }

    boolean shootAt(int row, int column) {
        if (!isSunk()) {
            if (this.horizontal) {
                if (row == this.bowRow && column >= this.bowColumn && column <= this.bowColumn + this.length) {
                    this.hit[column - this.bowColumn] = true;
                    return true;
                }
            } else {
                if (column == this.bowColumn && row >= this.bowRow && row <= this.bowRow + this.length) {
                    this.hit[row - this.bowRow] = true;
                    return true;
                }
            }
        }
        return false;
    }

    boolean isSunk() {
        for (boolean h : this.hit) {
            if (!h) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        if (isSunk()) {
            return "x";
        }
        return "S";
//        return isSunk() ? "x" : "S";
    }
}
