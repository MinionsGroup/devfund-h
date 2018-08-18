package org.minions.devfund.richard.battleship;

/**
 * Class
 */
public class StrategySetShipHorizontal implements StrategyShip {

    /**
     * {@inheritDoc}
     */
    @Override
    public void action(Ship ship, Ocean ocean, int ind) {
        ocean.getShips()[ship.getBowRow()][ind] = ship;
    }
}
