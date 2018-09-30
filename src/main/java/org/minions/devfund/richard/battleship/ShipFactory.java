package org.minions.devfund.richard.battleship;

import java.util.HashMap;
import java.util.Map;

/**
 * Ship Factory.
 */
final class ShipFactory {
    private static final Map<String, ShipBuilder> SHIP_FACTORY = new HashMap<>();

    static {
        SHIP_FACTORY.put("battleship", BattleShip::new);
        SHIP_FACTORY.put("battlecruiser", BattleCruiser::new);
        SHIP_FACTORY.put("cruiser", Cruiser::new);
        SHIP_FACTORY.put("lightcruiser", LightCruiser::new);
        SHIP_FACTORY.put("destroyer", Destroyer::new);
        SHIP_FACTORY.put("submarine", Submarine::new);
    }

    /**
     * Ship Factory.
     */
    private ShipFactory() {
    }

    /**
     * shipBuilder interface.
     */
    interface ShipBuilder {
        /**
         * Builds a new ship.
         *
         * @return {@link Ship}.
         */
        Ship buildShip();
    }

    /**
     * This method get the instance of specific class of ship.
     *
     * @param shipType string type of ship.
     * @return specific ship instance.
     */
    static Ship getShip(final String shipType) {
        return SHIP_FACTORY.getOrDefault(shipType, EmptySea::new).buildShip();
    }
}
