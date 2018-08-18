package org.minions.devfund.richard.battleship;

/**
 * Class.
 */
public abstract class Ship {

    private int bowRow;
    private int bowColumn;
    private int length;
    private boolean horizontal;
    private boolean[] hit;
    private int number;

    /**
     * @return String.
     */
    abstract String getShipType();

    /**
     * @param row        row.
     * @param column     column.
     * @param horizontal horizontal.
     * @param ocean      ocean.
     * @return boolean.
     */
    boolean okToPlaceShipAt(int row, int column, boolean horizontal, Ocean ocean) {
        this.bowRow = row;
        this.bowColumn = column;
        this.horizontal = horizontal;
        return ShipHelper.isValidPosition(this, ocean);
    }

    /**
     * @param row        row.
     * @param column     column.
     * @param horizontal horizontal.
     * @param ocean      ocean.
     */
    void placeShipAt(int row, int column, boolean horizontal, Ocean ocean) {
        this.bowRow = row;
        this.bowColumn = column;
        this.horizontal = horizontal;
        ShipHelper.setShip(this, ocean);
    }

    /**
     * @param row    row.
     * @param column column.
     * @return boolean.
     */
    Boolean shootAt(int row, int column) {
        return false;
    }

    /**
     * @return boolean.
     */
    boolean isSunk() {
        return false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        //x undido
        //s si no esta undido
        return "x";
    }

    /**
     * @return bowRow.
     */
    int getBowRow() {
        return bowRow;
    }

    /**
     * @return bowColumn.
     */
    int getBowColumn() {
        return bowColumn;
    }

    /**
     * @return length.
     */
    int getLength() {
        return length;
    }

    /**
     * @return boolean.
     */
    boolean isHorizontal() {
        return horizontal;
    }

    /**
     * @return hit.
     */
    boolean[] getHit() {
        return hit;
    }

    /**
     * @return number of chip withing the ocean.
     */
    int getNumber() {
        return number;
    }

    /**
     * @param length chip length.
     */
    void setLength(int length) {
        this.length = length;
    }

    /**
     * @param hit chip hit.
     */
    void setHit(boolean[] hit) {
        this.hit = hit;
    }

    /**
     * @param number number of chip withing the ocean.
     */
    void setNumber(int number) {
        this.number = number;
    }

    /**
     * @param ocean ocean.
     */
    void addShip(Ocean ocean) {
        ShipHelper.addShip(ocean, this);
    }

}
