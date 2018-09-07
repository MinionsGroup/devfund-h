package org.minions.devfund.richard.battleship;

import java.util.Random;

/**
 * Class.
 */
final class ShipHelper {

    private static boolean validPosition;

    /**
     * Constructor.
     */
    private ShipHelper() {
    }

    /**
     * @param ship  ship.
     * @param ocean Ocean.
     */
    static void setShip(final Ship ship, final Ocean ocean) {
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
    static boolean isValidPosition(final Ship ship, final Ocean ocean) {
        validPosition = true;
        StrategyManager.strategyValidPosition(StrategyVerifyFactory.createStrategy(ship.isHorizontal()), ship, ocean);
        return validPosition;
    }

    /**
     * @param ocean ocean.
     * @param index index.
     * @return index.
     */
    private static int indexBuilderPlus(final Ocean ocean, int index) {
        if (index + 1 < ocean.getShipArray().length) {
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
    static void verifyBorder(final Ocean ocean, int row, int column) {
        int rowPlus = indexBuilderPlus(ocean, row);
        int rowLess = indexBuilderLess(row);
        int columnPlus = indexBuilderPlus(ocean, column);
        int columnLess = indexBuilderLess(column);
        setValidPosition(!ocean.isOccupied(rowPlus, column));
        setValidPosition(!ocean.isOccupied(rowPlus, columnPlus));
        setValidPosition(!ocean.isOccupied(rowPlus, columnLess));
        setValidPosition(!ocean.isOccupied(rowLess, column));
        setValidPosition(!ocean.isOccupied(rowLess, columnPlus));
        setValidPosition(!ocean.isOccupied(rowLess, columnLess));
        setValidPosition(!ocean.isOccupied(row, columnLess));
        setValidPosition(!ocean.isOccupied(row, columnPlus));
    }

    /**
     * @param value Horizontal Occupied.
     */
    static void setValidPosition(final boolean value) {
        if (validPosition) {
            ShipHelper.validPosition = value;
        }
    }

    /**
     * @param ship  ship.
     * @param ocean ocean.
     */
    static void addShip(final Ocean ocean, final Ship ship) {
        Random random = new Random();
        int shipNumber = 1;
        while (shipNumber > 0) {
            boolean horizontal = random.nextBoolean();
            int row = random.nextInt(ocean.getShipArray().length);
            int column = random.nextInt(ocean.getShipArray().length);
            if (ship.okToPlaceShipAt(row, column, horizontal, ocean)) {
                ship.placeShipAt(row, column, horizontal, ocean);
                shipNumber--;
            }
        }
    }
}
