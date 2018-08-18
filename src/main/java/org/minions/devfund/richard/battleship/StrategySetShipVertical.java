package org.minions.devfund.richard.battleship;

/**
 * Class.
 */
public class StrategySetShipVertical implements StrategyShip {

    /**
     * {@inheritDoc}
     */
    @Override
    public void action(Ship ship, Ocean ocean, int ind) {
        ocean.getShips()[ind][ship.getBowColumn()] = ship;
    }
}
