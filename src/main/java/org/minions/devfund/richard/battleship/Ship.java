package org.minions.devfund.richard.battleship;

public abstract class Ship {

    private int bowRow;
    private int bowColumn;
    private int length;
    private boolean horizontal;
    private boolean[] hit;
    private int number;

    abstract String getShipType();

    boolean okToPlaceShipAt(int row, int column, boolean horizontal, Ocean ocean) {
        this.bowRow = row;
        this.bowColumn = column;
        this.horizontal = horizontal;
        return ShipHelper.isValidPosition(this, ocean);
    }

    void placeShipAt(int row, int column, boolean horizontal, Ocean ocean) {
        this.bowRow = row;
        this.bowColumn = column;
        this.horizontal = horizontal;
        ShipHelper.setShip(this, ocean);
    }

    Boolean shootAt(int row, int column) {
        return false;
    }

    boolean isSunk() {
        return false;
    }

    @Override
    public String toString() {
        //x undido
        //s si no esta undido
        return "x";
    }

    int getBowRow() {
        return bowRow;
    }

    int getBowColumn() {
        return bowColumn;
    }

    int getLength() {
        return length;
    }

    boolean isHorizontal() {
        return horizontal;
    }

    boolean[] getHit() {
        return hit;
    }

    int getNumber() {
        return number;
    }

    void setLength(int length) {
        this.length = length;
    }

    void setHit(boolean[] hit) {
        this.hit = hit;
    }

    void setNumber(int number) {
        this.number = number;
    }

    public void setBowRow(int bowRow) {
        this.bowRow = bowRow;
    }

    public void setBowColumn(int bowColumn) {
        this.bowColumn = bowColumn;
    }

    public void setHorizontal(boolean horizontal) {
        this.horizontal = horizontal;
    }

}
