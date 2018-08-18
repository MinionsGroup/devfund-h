package org.minions.devfund.richard.battleship;

/**
 * Class.
 */
class StrategyManager {

    /**
     * Constructor.
     */
    private StrategyManager() {
    }

    /**
     * @param strategyShip Strategy.
     * @param ship         Ship.
     * @param ocean        Ocean.
     */
    static void strategyHorizontal(StrategyShip strategyShip, Ship ship, Ocean ocean) {
        for (int j = ship.getBowColumn(); j < ship.getBowColumn() + ship.getLength(); j++) {
            strategyShip.action(ship, ocean, j);
        }
    }

    /**
     * @param strategyShip Strategy.
     * @param ship         Ship.
     * @param ocean        Ocean.
     */
    static void strategyVertical(StrategyShip strategyShip, Ship ship, Ocean ocean) {
        for (int i = ship.getBowRow(); i < ship.getBowRow() + ship.getLength(); i++) {
            strategyShip.action(ship, ocean, i);
        }
    }

    /**
     * @param strategyShip Strategy.
     * @param ship         Ship.
     * @param ocean        Ocean.
     */
    static void strategyValidPosition(StrategyShip strategyShip, Ship ship, Ocean ocean) {
        if (ship.isHorizontal() && ship.getBowColumn() + ship.getLength() - 1 < ocean.getShipArray().length) {
            strategyHorizontal(strategyShip, ship, ocean);
        } else if (!ship.isHorizontal() && ship.getBowRow() + ship.getLength() - 1 < ocean.getShipArray().length) {
            strategyVertical(strategyShip, ship, ocean);
        } else {
            ShipHelper.setValidPosition(false);
        }
    }
}
