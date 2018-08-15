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

    void placeShipAt(int row, int column, boolean horizontal, Ocean ocean) {
        this.bowRow = row;
        this.bowColumn = column;
        this.horizontal = horizontal;

        if (this.horizontal) {
            for (int i = column; i < column + this.getLength(); i++) {
                ocean.getShipArray()[row][i] = this;
                ocean.cccc++;            }
        } else {
            for (int j = row; j < row + this.getLength(); j++) {
                ocean.getShipArray()[j][column] = this;
                ocean.cccc++;
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
        for (boolean b : hit) if (!b) return false;
        return true;
    }

    @Override
    public String toString() {
        if (isSunk()) {
            return "x";
        }
        return "S";
    }

    public boolean wasShootAt(int row, int column) {
        if (horizontal) {
            return hit[column - this.bowColumn] == true;
        } else {
            return hit[row - this.bowRow] == true;
        }
    }
}
