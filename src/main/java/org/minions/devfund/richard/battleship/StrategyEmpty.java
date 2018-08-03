package org.minions.devfund.richard.battleship;

/**
 * Class.
 */
public class StrategyEmpty extends Strategy {

    /**
     * Constructor.
     */
    StrategyEmpty() {
    }

    /**
     * {@inheritDoc}
     */
    @Override
    void action() {
        getOcean().getShips()[getRow()][getColumn()] = new EmptySea();
    }
}
