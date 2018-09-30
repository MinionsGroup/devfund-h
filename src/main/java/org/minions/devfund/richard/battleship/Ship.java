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
     * @return New Ship.
     */
    abstract Ship getShip();

    /**
     * @param row        row.
     * @param column     column.
     * @param horizontal horizontal.
     * @param ocean      ocean.
     * @return boolean.
     */
    boolean okToPlaceShipAt(final int row, final int column, final boolean horizontal, final Ocean ocean) {
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
    void placeShipAt(final int row, final int column, final boolean horizontal, final Ocean ocean) {
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
    boolean shootAt(int row, int column) {
        if (isSunk()) {
            return false;
        }
        final boolean isHittable = horizontal ? row == bowRow && column >= bowColumn && column < bowColumn + length
                : column == bowColumn && row >= bowRow && row < bowRow + length;
        if (isHittable) {
            final int hitPosition = horizontal ? column - bowColumn : row - bowRow;
            hit[hitPosition] = true;
            return true;
        }
        return false;
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
    void setHit(final boolean[] hit) {
        this.hit = hit;
    }

    /**
     * @param number number of chip withing the ocean.
     */
    void setNumber(int number) {
        this.number = number;
    }

}
