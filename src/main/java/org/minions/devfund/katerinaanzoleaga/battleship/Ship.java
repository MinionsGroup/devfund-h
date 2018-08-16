package org.minions.devfund.katerinaanzoleaga.battleship;

/**
 * Abstract class Ship.
 */
public abstract class Ship {

    private int bowRow;
    private int bowColumn;
    private int length;
    private boolean horizontal;
    private boolean[] hit;

    protected static final int HITLENGTH = 8;


    public int getBowRow() {
        return bowRow;
    }

    public int getBowColumn() {
        return bowColumn;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public boolean isHorizontal() {
        return horizontal;
    }

    public boolean[] getHit() {
        return hit;
    }

    protected void setHit(boolean[] hit) {
        this.hit = hit;
    }


    abstract String getShipType();


    /**
     * Given the starting position, either row or columen, this fuction returns
     * true if the ship's larger posstion will feet in the ocean.
     * @param position either row or column
     * @param ocean the ocean reference.
     * @return ture if feets.
     */
    private boolean fitsInDirection (int position, Ocean ocean) {
        int oceanLength = ocean.getShipArray().length;
        if (position >= 0) {
            return position + this.getLength() - 1 < ocean.getShipArray().length;
        } else {
            return false;
        }
    }

    /**
     * Given the current ship.
     * @param row
     * @param column
     * @param horizontal
     * @param ocean
     * @return True if it is possible to place a ship in the defined position.
     */
    boolean okToPlaceShipAt(int row, int column, boolean horizontal, Ocean ocean) {
        if (ocean.isValidPosition(row, column)) {
            if (horizontal) {
                if (fitsInDirection(column, ocean)) {
                    for (int i = row - 1; i <= row + 1; ++i)
                        for (int j = column - 1; j <= column + this.getLength(); ++j)
                            if (ocean.isValidPosition(i, j)) {
                                if (ocean.isOccupied(i, j)) {
                                    return false;
                                }
                            }
                    return true;
                } else {
                    return false;
                }

            } else {
                if (fitsInDirection(row, ocean)) {
                    for (int i = row - 1; i <= row + this.getLength(); ++i )
                        for (int j = column - 1; j <= column + 1; ++j)
                            if (ocean.isValidPosition(i, j)) {
                                if (ocean.isOccupied(i, j)) {
                                    return false;
                                }
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
     * Places a ship at the position specified and with the direction specified.
     * @param row
     * @param column
     * @param horizontal
     * @param ocean
     */
    void placeShipAt(int row, int column, boolean horizontal, Ocean ocean) {
        if (okToPlaceShipAt(row, column, horizontal, ocean)) {
            this.bowRow = row;
            this.bowColumn = column;
            this.horizontal = horizontal;
            Ship[][] newShip = ocean.getShipArray();
            if (horizontal) {
                for (int i = column; i < column + this.length; ++i) {
                    newShip[row][i] = this;
                }
                ocean.setShips(newShip);
            } else {
                for (int i = row; i < row + this.length; ++i) {
                    newShip[i][column] = this;
                }
                ocean.setShips(newShip);
            }
        }

    }

    /**
     * This returns -1 if the position does not belong to the ship.
     * Returns the relative position of the hit i shot at that position.
     * @param row
     * @param column
     * @return Returns the relative position of the hit i shot at that position.
     */
    private int isInShipPosition(int row, int column) {
        if (horizontal) {
            if (row != bowRow) {
                return -1;
            }
            for (int j = bowColumn; j < bowColumn + this.length; ++j) {
                if (column == j) {
                    return j - bowColumn;
                }
            }
            return -1;
        } else {
            if (column != bowColumn) {
                return -1;
            }
            for (int i = bowRow; i < bowRow + this.length; ++i) {
                if (row == i) {
                    return i - bowRow;
                }
            }
            return -1;
        }
    }

    /**
     * This method returns the index position of the hit relative to the position of a ship reference.
     * @param row
     * @param column
     * @return -1 if the position does not belong to the ship
     */

    public int hitPosition (int row, int column) {
        if (this.isInShipPosition(row, column) != -1) {
            if (horizontal) {
                return column - bowColumn;
            } else {
                return row - bowRow;
            }
        } else {
            return -1;
        }
    }

    /**
     * Verifies if the position belongs to the ship, is so, updates the hit array accordingly.
     * @param row
     * @param column
     * @return Boolean if the shot was successful.
     */

    boolean shootAt (int row, int column) {
        int hitAt = isInShipPosition(row, column);
        if (hitAt != -1 && !isSunk()) {
            this.hit[hitAt] = true;
            return true;
        } else {
            return false;
        }
    }

    boolean isSunk() {
        for (int i = 0; i < length; ++i) {
            if (!hit[i]) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        if (this.isSunk()){
            return "X";
        } else return "S";

    }


}
