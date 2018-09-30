package org.minions.devfund.abel.battleship;

/**
 * Class to handle Ship.
 */
public abstract class Ship {

    private int bowRow;
    private int bowColumn;
    private int length;
    private boolean horizontal;
    private boolean[] hit;
    private String shipType = this.getClass().getSimpleName().toLowerCase();

    /**
     * Get Bow Row.
     *
     * @return int.
     */
    public int getBowRow() {
        return bowRow;
    }

    /**
     * Set Bow Row.
     *
     * @param bowRow int.
     */
    public void setBowRow(int bowRow) {
        this.bowRow = bowRow;
    }

    /**
     * Get Bow Column.
     *
     * @return int.
     */
    public int getBowColumn() {
        return bowColumn;
    }

    /**
     * Set Bow Column.
     *
     * @param bowColumn int.
     */
    public void setBowColumn(int bowColumn) {
        this.bowColumn = bowColumn;
    }

    /**
     * Get Ship Length.
     *
     * @return int.
     */
    public int getLength() {
        return length;
    }

    /**
     * Set Ship Length.
     *
     * @param length int.
     */
    public void setLength(int length) {
        this.length = length;
    }

    /**
     * If the Ship is Horizontal or not.
     *
     * @return boolean.
     */
    public boolean isHorizontal() {
        return horizontal;
    }

    /**
     * Set Ship Horizontal.
     *
     * @param horizontal boolean.
     */
    public void setHorizontal(boolean horizontal) {
        this.horizontal = horizontal;
    }

    /**
     * Get Ship Hit status.
     *
     * @return boolean[].
     */
    public boolean[] getHit() {
        return hit.clone();
    }

    /**
     * Set Ship Hit Status.
     *
     * @param hit boolean[].
     */
    public void setHit(final boolean[] hit) {
        this.hit = hit.clone();
    }

    /**
     * Get Ship Type.
     *
     * @return String.
     */
    public String getShipType() {
        return shipType;
    }

    /**
     * If its ok to place the Ship at provided position.
     *
     * @param row        int.
     * @param column     int.
     * @param horizontal boolean.
     * @param ocean      Ocean.
     * @return boolean.
     */
    public boolean okToPlaceShipAt(int row, int column, boolean horizontal, final Ocean ocean) {
        int oceanLength = ocean.getShipArray().length;
        if (isShipInBounds(row, column, horizontal, oceanLength)) {
            return verifyIsOccupied(row, column, horizontal, ocean);
        }
        return false;
    }

    /**
     * Verify if the position is Occupied.
     * @param row int.
     * @param column int.
     * @param horizontal boolean.
     * @param ocean Ocean.
     * @return boolean.
     */
    private boolean verifyIsOccupied(int row, int column, boolean horizontal, final Ocean ocean) {
        int oceanLength = ocean.getShipArray().length;
        int initialBorderRow = row - 1 < 0 ? 0 : row - 1;
        int initialBorderColumn = column - 1 < 0 ? 0 : column - 1;
        int lastBorderRow = horizontal ? row + 1 : row + length;
        int lastBorderColumn = horizontal ? column + length : column + 1;
        lastBorderRow = lastBorderRow < oceanLength ? lastBorderRow : oceanLength - 1;
        lastBorderColumn = lastBorderColumn < oceanLength ? lastBorderColumn : oceanLength - 1;
        for (int i = initialBorderRow; i <= lastBorderRow; i++) {
            for (int j = initialBorderColumn; j <= lastBorderColumn; j++) {
                if (ocean.isOccupied(i, j)) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * If the provided position is in bounds.
     *
     * @param row         int.
     * @param column      int.
     * @param horizontal  boolean.
     * @param oceanLength int.
     * @return boolean.
     */
    private boolean isShipInBounds(int row, int column, boolean horizontal, int oceanLength) {
        int lastRow = horizontal ? row : row + length - 1;
        int lastColumn = horizontal ? column + length - 1 : column;
        boolean isFirstRowInBounds = 0 <= row && row < oceanLength;
        boolean isFirstColInBounds = 0 <= column && column < oceanLength;
        boolean isLastRowInBounds = 0 <= lastRow && lastRow < oceanLength;
        boolean isLastColInBounds = 0 <= lastColumn && lastColumn < oceanLength;

        return isFirstRowInBounds && isFirstColInBounds && isLastColInBounds && isLastRowInBounds;
    }

    /**
     * Place the ship at provided position.
     *
     * @param row        int.
     * @param column     int.
     * @param horizontal boolean.
     * @param ocean      Ocean.
     */
    public void placeShipAt(int row, int column, boolean horizontal, final Ocean ocean) {
        int lastRow = horizontal ? row : row + length - 1;
        int lastColumn = horizontal ? column + length - 1 : column;
        for (int i = row; i <= lastRow; i++) {
            for (int j = column; j <= lastColumn; j++) {
                bowRow = row;
                bowColumn = column;
                this.horizontal = horizontal;
                ocean.getShipArray()[i][j] = this;
            }
        }
    }

    /**
     * If the position contains a ship.
     *
     * @param row    int.
     * @param column int.
     * @return boolean.
     */
    public boolean shootAt(int row, int column) {
        boolean isInRowRange = bowRow <= row && row < bowRow + length;
        boolean isInColumnRange = bowColumn <= column && column < bowColumn + length;
        boolean isInRange = horizontal ? isInColumnRange && row == bowRow : isInRowRange && column == bowColumn;
        boolean result = !isSunk() && isInRange;
        if (result) {
            int position = horizontal ? column - bowColumn : row - bowRow;
            hit[position] = true;
        }
        return result;
    }

    /**
     * If the Ship is Sunk.
     *
     * @return boolean.
     */
    public boolean isSunk() {
        for (boolean bool : hit) {
            if (!bool) {
                return false;
            }
        }
        return true;
    }

    /**
     * {@inheritDoc}.
     */
    @Override
    public String toString() {
        return isSunk() ? "x" : "S";
    }
}
