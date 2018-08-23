package org.minions.devfund.katerinaanzoleaga.battleship;

/**
 * Abstract class Ship.
 */
public abstract class Ship {
    /**
     * bowRow setter.
     * @param bowRow int
     */
    public void setBowRow(int bowRow) {
        this.bowRow = bowRow;
    }

    /**
     * bowColumn setter.
     * @param bowColumn int
     */
    public void setBowColumn(int bowColumn) {
        this.bowColumn = bowColumn;
    }

    private int bowRow;
    private int bowColumn;
    private int length;
    private boolean horizontal;
    private boolean[] hit;
    protected static final int HITLENGHT = 8;

    /**
     * Returns the row position of the bow.
     * @return int
     */
    public int getBowRow() {
        return bowRow;
    }

    /**
     * Teturns the column position of the bow.
     * @return int
     */
    public int getBowColumn() {
        return bowColumn;
    }

    /**
     * Returns the length of the ship.
     * @return length
     */
    public int getLength() {
        return length;
    }

    /**
     * Sets the lenght of the ship from extended classes.
     * @param length int
     */
    public void setLength(int length) {
        this.length = length;
    }

    /**
     * Returns true if the ship is horizontal.
     * @return bool
     */
    public boolean isHorizontal() {
        return horizontal;
    }

    /**
     * Retruns the hits array.
     * @return hits array
     */
    public boolean[] getHit() {
        return hit;
    }

    /**
     * Updates the hit array.
     * @param hit hits array
     */
    protected void setHit(final boolean[] hit) {
        this.hit = hit;
    }

    /**
     * Abstract method to be overwrite by the extended classes.
     * @return string
     */
    abstract String getShipType();


    /**
     * Given the starting position, either row or column, this fuction returns.
     * true if the ship's larger position will feet in the ocean.
     * @param position either row or column
     * @param ocean the ocean reference.
     * @return ture if feets.
     */
    private boolean fitsInDirection(int position, final Ocean ocean) {
        int oceanLength = ocean.getShipArray().length;
        if (position >= 0) {
            return position + this.getLength() - 1 < ocean.getShipArray().length;
        } else {
            return false;
        }
    }

    /**
     * Given the current ship.
     * @param row int
     * @param column int
     * @param horizontal bool
     * @param ocean ocean
     * @return True if it is possible to place a ship in the defined position.
     */
    public boolean okToPlaceShipAt(int row, int column, boolean horizontal, final Ocean ocean) {
        if (ocean.isValidPosition(row, column)) {
            if (horizontal) {
                if (fitsInDirection(column, ocean)) {
                    for (int i = row - 1; i <= row + 1; ++i) {
                        for (int j = column - 1; j <= column + this.getLength(); ++j) {
                            if (ocean.isValidPosition(i, j)) {
                                if (ocean.isOccupied(i, j)) {
                                    return false;
                                }
                            }
                        }
                    }
                    return true;
                } else {
                    return false;
                }

            } else {
                if (fitsInDirection(row, ocean)) {
                    for (int i = row - 1; i <= row + this.getLength(); ++i) {
                        for (int j = column - 1; j <= column + 1; ++j) {
                            if (ocean.isValidPosition(i, j)) {
                                if (ocean.isOccupied(i, j)) {
                                    return false;
                                }
                            }
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
     * @param row int
     * @param column int
     * @param horizontal bool
     * @param ocean ocean
     */
    public void placeShipAt(int row, int column, boolean horizontal, final Ocean ocean) {
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
            }
            ocean.setShips(newShip);
        }
    }

    /**
     * This returns -1 if the position does not belong to the ship.
     * Returns the relative position of the hit i shot at that position.
     * @param row int
     * @param column int
     * @return Returns the relative position of the hit i shot at that position.
     */
    public int isInShipPosition(int row, int column) {
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
     * @param row int
     * @param column int
     * @return -1 if the position does not belong to the ship
     */

    public int hitPosition(int row, int column) {
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
     * @param row int
     * @param column int
     * @return Boolean if the shot was successful.
     */
    public boolean shootAt(int row, int column) {
        int hitAt = isInShipPosition(row, column);
        if (hitAt != -1 && !isSunk()) {
            this.hit[hitAt] = true;
            return true;
        } else {
            return false;
        }
    }

    /**
     * Returns true if the ship is sunk. Reads every hit position until the length of the ship.
     * @return false if some hit was not
     */
    public boolean isSunk() {
        for (int i = 0; i < length; ++i) {
            if (!hit[i]) {
                return false;
            }
        }
        return true;
    }

    /**
     * Writes X if the ship is sunk, S otherwise.
     * @return char x if sunk
     */
    @Override
    public String toString() {
        if (this.isSunk()) {
            return "x";
        } else {
            return "S";
        }

    }


}
