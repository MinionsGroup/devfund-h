package org.minions.devfund.reinaldo.battleship;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * Created by reinaldo.
 */
public abstract class Ship {

    private int bowRow;
    private int bowColumn;
    private int length;
    private boolean horizontal;
    private boolean[] hit;

    /**
     * Obtains the ship type.
     *
     * @return String with the ship type.
     */
    abstract String getShipType();

    /**
     * Verifies if this is possible to put a ship in a position on ocean.
     *
     * @param row        the row.
     * @param column     the column.
     * @param horizontal the orientation to ship.
     * @param ocean      {@link Ocean}.
     * @return true if is possible to place a ship in the position.
     */
    boolean okToPlaceShipAt(final int row, final int column, final boolean horizontal, final Ocean ocean) {
        return horizontal ? column + length - 1 < Ocean.SHIPLENGTH
                && isHorizontalOrVerticalLineOccupied(row, column, column, horizontal, ocean)
                : row + length - 1 < Ocean.SHIPLENGTH
                && isHorizontalOrVerticalLineOccupied(row, column, row, horizontal, ocean);
    }

    /**
     * Verifies if horizontal or vertical line is occupied in the ocean.
     *
     * @param row        int ro position.
     * @param column     int column position.
     * @param iterator   int iterate.
     * @param horizontal the orientation to ship.
     * @param ocean      {@link Ocean}.
     * @return true if line is occupied.
     */
    private boolean isHorizontalOrVerticalLineOccupied(final int row, final int column, final int iterator,
                                                       final boolean horizontal, final Ocean ocean) {
        for (int j = iterator; j < iterator + length; j++) {
            final boolean occupiedHorizontal = ocean.isOccupied(row, j) || ocean.isBorderOccupied(row, j);
            final boolean occupiedVertital = ocean.isOccupied(j, column) || ocean.isBorderOccupied(j, column);
            final boolean isOccupied = horizontal ? occupiedHorizontal : occupiedVertital;
            if (isOccupied) {
                return false;
            }
        }
        return true;
    }

    /**
     * Places a ship in a position.
     *
     * @param row        row for the ship.
     * @param column     column for the ship.
     * @param horizontal orientation of the ship.
     * @param ocean      {@link Ocean}.
     */
    void placeShipAt(final int row, final int column, final boolean horizontal, final Ocean ocean) {
        bowColumn = column;
        bowRow = row;
        setHorizontal(horizontal);
        if (horizontal) {
            for (int j = column; j < column + length; j++) {
                ocean.getShipArray()[row][j] = this;
            }
        }
        if (!horizontal) {
            for (int i = row; i < row + length; i++) {
                ocean.getShipArray()[i][column] = this;
            }
        }
    }

    /**
     * Shots at a certain position.
     *
     * @param row    int the row position.
     * @param column int the column position.
     * @return true if a ship was shot.
     */
    boolean shootAt(final int row, final int column) {
        if (isSunk()) {
            return false;
        }
        boolean isHittable = horizontal ? row == bowRow && column >= bowColumn && column < bowColumn + length
                : column == bowColumn && row >= bowRow && row < bowRow + length;
        if (isHittable) {
            final int hitPosition = horizontal ? column - bowColumn : row - bowRow;
            hit[hitPosition] = true;
            return true;
        }
        return false;
    }

    /**
     * Verifies that ship is sunk.
     *
     * @return true when the ship is sunk.
     */
    boolean isSunk() {
        return IntStream.range(0, hit.length)
                .mapToObj(idx -> hit[idx]).allMatch(element -> element);
    }

    /**
     * {@inheritDoc}.
     */
    @Override
    public String toString() {
        return isSunk() ? "x" : "S";
    }

    /**
     * Gets the bow row property.
     *
     * @return int bow row.
     */
    public int getBowRow() {
        return bowRow;
    }

    /**
     * Sets the bow row value property.
     *
     * @param bowRow int new bow row value.
     */
    public void setBowRow(final int bowRow) {
        this.bowRow = bowRow;
    }

    /**
     * Gets the bow column property.
     *
     * @return int the bowl column value.
     */
    public int getBowColumn() {
        return bowColumn;
    }

    /**
     * Sets the bow column.
     *
     * @param bowColumn int new bow column value property.
     */
    public void setBowColumn(final int bowColumn) {
        this.bowColumn = bowColumn;
    }

    /**
     * Gets the length of each ship.
     *
     * @return int ship length.
     */
    public int getLength() {
        return length;
    }

    /**
     * Sets the length for a ship.
     *
     * @param finalLength the new length vale.
     */
    public void setLength(final int finalLength) {
        this.length = finalLength;
    }

    /**
     * Gets horizontal value position.
     *
     * @return true if ship is horizontal.
     */
    public boolean isHorizontal() {
        return horizontal;
    }

    /**
     * Sets horizontal value position.
     *
     * @param finalHorizontal boolean new horizontal value.
     */
    public void setHorizontal(final boolean finalHorizontal) {
        this.horizontal = finalHorizontal;
    }

    /**
     * Gets the hit.
     *
     * @return the hit.
     */
    public boolean[] getHit() {
        return Arrays.copyOf(hit, length);
    }

    /**
     * Sets the hit.
     *
     * @param finalHit new hit.
     */
    public void setHit(final boolean[] finalHit) {
        hit = Arrays.copyOf(finalHit, length);
    }
}
