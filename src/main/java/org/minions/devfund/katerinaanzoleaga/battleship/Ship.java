package org.minions.devfund.katerinaanzoleaga.battleship;

public abstract class Ship {

    private int bowRow;
    private int bowColumn;
    private int length;
    private boolean horizontal;


    private boolean[] hit;

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

    boolean okToPlaceShipAt (int row, int column, boolean horizontal, Ocean ocean) {
        return true;

    }

    void placeShipAt (int row, int column, boolean horizontal, Ocean ocean) {
        ;
    }

    boolean shootAt (int row, int column) {
        return true;
    }

    boolean isSunk() {
        return true;
    }

    @Override
    public String toString() {
        if (this.isSunk()){
            return "X";
        } else return "S";

    }







}
