package org.minions.devfund.richard.battleship;

public abstract class Ship {

    private int bowRow;
    private int bowColumn;
    private int length;
    private boolean horizontal;
    private boolean[] hit;
    private int number;

    abstract String getShipType();

    boolean okToPlaceShipAt(int fila, int columna, boolean horizontal, Ocean ocean) {
        return false;
    }

    void placeShipAt(int fila, int columna, boolean horizontal, Ocean ocean) {

    }

    Boolean shootAt(int fila, int columna) {
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

    void setBowRow(int bowRow) {
        this.bowRow = bowRow;
    }

    void setBowColumn(int bowColumn) {
        this.bowColumn = bowColumn;
    }

    void setLength(int length) {
        this.length = length;
    }

    void setHorizontal(boolean horizontal) {
        this.horizontal = horizontal;
    }

    void setHit(boolean[] hit) {
        this.hit = hit;
    }

    void setNumber(int number) {
        this.number = number;
    }

}
