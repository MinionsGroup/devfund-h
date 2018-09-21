package org.minions.devfund.richard.battleship;

/**
 * Class.
 */
final class StrategyVerifyFactory {

    /**
     * Private Constructor.
     */
    private StrategyVerifyFactory() {

    }

    /**
     * @param horizontal boolean.
     * @return Strategy.
     */
    static StrategyShip createStrategy(final boolean horizontal) {
        return horizontal ? new StrategyVerifyHorizontal() : new StrategyVerifyVertical();
    }
}
