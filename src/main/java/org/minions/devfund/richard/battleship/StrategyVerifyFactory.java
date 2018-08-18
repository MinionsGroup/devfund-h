package org.minions.devfund.richard.battleship;

/**
 * Class.
 */
class StrategyVerifyFactory {

    /**
     * Private Constructor.
     */
    private StrategyVerifyFactory() {

    }

    /**
     * @param horizontal boolean.
     * @return Strategy;
     */
    static StrategyShip createStrategy(boolean horizontal) {
        return (horizontal) ? new StrategyVerifyHorizontal() : new StrategyVerifyVertical();
    }
}
