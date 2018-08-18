package org.minions.devfund.richard.battleship;

import java.util.Random;

/**
 * Class.
 */
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
     * @param ocean ocean.
     * @param index index.
     * @return index.
     */
    private static int indexBuilderPlus(Ocean ocean, int index) {
        if (index + 1 < ocean.getShips().length) {
            index += 1;
        }
        return index;
    }

    /**
     * @param index index.
     * @return index.
     */
    private static int indexBuilderLess(int index) {
        if (index - 1 >= 0) {
            index -= 1;
        }
        return index;
    }

    /**
     * @param ocean  Ocean.
     * @param row    row.
     * @param column column.
     */
    static void verifyBorder(Ocean ocean, int row, int column) {
        int rowPlus = indexBuilderPlus(ocean, row);
        int rowLess = indexBuilderLess(row);
        int columnPlus = indexBuilderPlus(ocean, column);
        int columnLess = indexBuilderLess(column);
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

    /**
     * @param ship  ship.
     * @param ocean ocean.
     */
    static void addShip(Ocean ocean, Ship ship) {
        Random random = new Random();
        int index = 0;
        int shipNumber = ship.getNumber();
        while (shipNumber > index) {
            boolean horizontal = random.nextBoolean();
            int row = random.nextInt(ocean.getShips().length);
            int column = random.nextInt(ocean.getShips().length);
            if (ship.okToPlaceShipAt(row, column, horizontal, ocean)) {
                ship.placeShipAt(row, column, horizontal, ocean);
                shipNumber--;
            }
        }
    }
}
