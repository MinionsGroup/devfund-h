package org.minions.devfund.richard.battleship;

class ShipHelper {

    private static boolean occupied;

    /**
     * Constructor.
     */
    private ShipHelper() {
    }

    /**
     * @param ship  ship.
     * @param ocean Ocean.
     */
    static void setShip(Ship ship, Ocean ocean) {
        if (ship.isHorizontal()) {
            StrategyManager.strategyHorizontal(new StrategySetShipHorizontal(), ship, ocean);
        } else {
            StrategyManager.strategyVertical(new StrategySetShipVertical(), ship, ocean);
        }
    }

    /**
     * @param ship  ship.
     * @param ocean Ocean.
     * @return boolean.
     */
    static boolean isValidPosition(Ship ship, Ocean ocean) {
        occupied = false;
        if (ship.isHorizontal() && ship.getBowColumn() + ship.getLength() - 1 < ocean.getShips().length) {
            StrategyManager.strategyHorizontal(new StrategyVerifyHorizontal(), ship, ocean);
            return !occupied;
        } else if (!ship.isHorizontal() && ship.getBowRow() + ship.getLength() - 1 < ocean.getShips().length) {
            StrategyManager.strategyVertical(new StrategyVerifyVertical(), ship, ocean);
            return !occupied;
        }
        return false;
    }

    /**
     * @param ocean  Ocean.
     * @param row    row.
     * @param column column.
     */
    static void verifyBorder(Ocean ocean, int row, int column) {
        int rowPlus = row;
        int rowLess = row;
        int columnPlus = column;
        int columnLess = column;
        if (row + 1 < ocean.getShips().length) {
            rowPlus += 1;
        }
        if (row - 1 >= 0) {
            rowLess -= 1;
        }
        if (column + 1 < ocean.getShips().length) {
            columnPlus += 1;
        }
        if (column - 1 >= 0) {
            columnLess -= 1;
        }
        setOccupied(ocean.isOccupied(rowPlus, column));
        setOccupied(ocean.isOccupied(rowPlus, columnPlus));
        setOccupied(ocean.isOccupied(rowPlus, columnLess));
        setOccupied(ocean.isOccupied(rowLess, column));
        setOccupied(ocean.isOccupied(rowLess, columnPlus));
        setOccupied(ocean.isOccupied(rowLess, columnLess));
        setOccupied(ocean.isOccupied(row, columnLess));
        setOccupied(ocean.isOccupied(row, columnPlus));
    }

    /**
     * @param value Horizontal Occupied.
     */
    static void setOccupied(boolean value) {
        if (!occupied) {
            ShipHelper.occupied = value;
        }
    }
}
