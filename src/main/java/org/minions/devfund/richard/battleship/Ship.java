package org.minions.devfund.richard.battleship;

import java.util.stream.IntStream;

/**
 * Class.
 */
public abstract class Ship {

    private static final String SUNK_CHAR = "x";
    private static final String NOT_SUNK_CHAR = "S";

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
        boolean flag = false;
        if (!isSunk()) {
            if (!horizontal && column == bowColumn && row >= bowRow && row < bowRow + length) {
                hit[row - bowRow] = true;
                flag = true;
            } else if (horizontal && row == bowRow && column >= bowColumn && column < bowColumn + length) {
                hit[column - bowColumn] = true;
                flag = true;
            }
        }
        if (this instanceof EmptySea) {
            flag = false;
        }
        return flag;
    }

    /**
     * @return boolean.
     */
    boolean isSunk() {
        return IntStream.range(0, hit.length)
                .mapToObj(idx -> hit[idx]).allMatch(element -> element);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return isSunk() ? SUNK_CHAR : NOT_SUNK_CHAR;
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
