package org.minions.devfund.damianvp.battleship;

/**
 * Ship class.
 */
public abstract class Ship {
    private int bowRow;
    private int bowColumn;
    private int length;
    private boolean horizontal;
    private boolean[] hit;

    /**
     * Method to get BowRow of current class.
     * @return int type, bowRow.
     */
    public int getBowRow() {
        return bowRow;
    }

    /**
     * Method to get bowColumn.
     * @return int type, bowColumn.
     */
    public int getBowColumn() {
        return bowColumn;
    }

    /**
     * Method to get the length of ship.
     * @return int type, length of ship.
     */
    public int getLength() {
        return length;
    }

    /**
     * This method verifies if position is horizontal.
     * @return true if ship is placed horizontally.
     *         false if ship is placed vertically.
     */
    public boolean isHorizontal() {
        return horizontal;
    }

    /**
     * This method gets the array hit.
     * @return boolean array, hit.
     */
    public boolean[] getHit() {
        return hit;
    }

    /**
     * This method sets the bow row of ship.
     * @param bowRow int, row position.
     */
    public void setBowRow(int bowRow) {
        this.bowRow = bowRow;
    }

    /**
     * This method sets the bow column of ship.
     * @param bowColumn int, column position.
     */
    public void setBowColumn(int bowColumn) {
        this.bowColumn = bowColumn;
    }

    /**
     * This method sets the length of ship.
     * @param length int, length of ship.
     */
    public void setLength(int length) {
        this.length = length;
    }

    /**
     * This method sets if ship is horizontal or vertical.
     * @param horizontal bolean, (true if ship is horizontal, false if ship is vertical).
     */
    public void setHorizontal(boolean horizontal) {
        this.horizontal = horizontal;
    }

    /**
     * This method set the hit.
     * @param hit boolean array.
     */
    public void setHit(boolean[] hit) {
        this.hit = hit;
    }

    abstract String getShipType();

    /**
     * This method verifies if position are ok to place a ship.
     * @param row int row position.
     * @param column int column position.
     * @param horizontal boolean, (true if ship is horizontal, false if ship is vertical).
     * @param ocean Ocean type.
     * @return true if positions are ok to place a ship.
     *         false if positions does not ok to place a ship.
     */
    boolean okToPlaceShipAt(int row, int column, boolean horizontal, Ocean ocean) {
        int rowLimitA;
        int rowLimitB;
        int columnLimitA;
        int columnLimitB;
        if (horizontal) {
            if (column + this.getLength() > 20) {
                return false;
            }
            Long r = Math.round(row * 0.019 + 0.49);
            rowLimitA = row - r.intValue();
            Long r2 = Math.round((19 - row) * 0.019 + 0.49);
            rowLimitB = row + r2.intValue();
            Long c1 = Math.round((column) * 0.019 + 0.49);
            columnLimitA = column - c1.intValue();
            Long c2 = Math.round((19 - column + this.getLength())* 0.019 + 0.49);
            columnLimitB = column + this.getLength() - c2.intValue();
        } else {
            if (row + this.getLength() > 20) {
                return false;
            }
            Long r = Math.round((row) * 0.019 + 0.49);
            rowLimitA = row - r.intValue();
            Long r2 = Math.round((row + this.getLength())* 0.019 + 0.49);
            rowLimitB = row + this.getLength() - r2.intValue();
            Long c1 = Math.round((column - 1) * 0.019 + 0.49);
            columnLimitA = column - c1.intValue();
            Long c2 = Math.round((19 - column)* 0.019 + 0.49);
            columnLimitB = column + c2.intValue();

        }

        for (int i = rowLimitA; i <= rowLimitB; i++) {
            for (int j = columnLimitA; j <= columnLimitB ; j ++ ) {
                if (!ocean.getShipArray()[i][j].getShipType().equals("empty")) {
                    return false;
                }
            }

        }
        return true;
    }

    /**
     * This method places a ship in specific ocean.
     * @param row int row position.
     * @param column int column position.
     * @param horizontal boolean, (true if ship is horizontal, false if ship is vertical).
     * @param ocean Ocean type.
     */
    void placeShipAt(int row, int column, boolean horizontal, Ocean ocean) {
        this.bowRow = row;
        this.bowColumn = column;
        this.horizontal = horizontal;

        if (this.horizontal) {
            for (int i = column; i < column + this.getLength(); i++) {
                ocean.getShipArray()[row][i] = this;
            }
        } else {
            for (int j = row; j < row + this.getLength(); j++) {
                ocean.getShipArray()[j][column] = this;
            }
        }
    }

    /**
     * This method shot at in a specific position.
     * @param row int row position.
     * @param column int column position.
     * @return true, If a part of the ship occupies the given row and column.
     *         false, otherwise
     */
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

    /**
     * This method verifies if ship is sunk.
     * @return true if every part of the ship has been hit, false otherwise.
     */
    boolean isSunk() {
        for (boolean b : hit) if (!b) return false;
        return true;
    }

    /**
     * THis method verifies if position was shoot at.
     * @param row int row position.
     * @param column int column position.
     * @return true if position was shoot at.
     *         false otherwise.
     */
    public boolean wasShootAt(int row, int column) {
        if (horizontal) {
            return hit[column - this.bowColumn] == true;
        } else {
            return hit[row - this.bowRow] == true;
        }
    }

    @Override
    public String toString() {
        if (isSunk()) {
            return "x";
        }
        return "S";
    }
}
