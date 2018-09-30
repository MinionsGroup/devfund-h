package org.minions.devfund.damianvp.battleship;

import java.util.HashMap;
import java.util.Map;

/**
 * ShipFactory class.
 */
final class ShipFactory {
    /**
     * ShipFactory private constructor.
     */
    private ShipFactory() {
        super();
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

    private static final Map<String, ShipBuilder> SHIP_FACTORY = new HashMap<>();
    static {
        SHIP_FACTORY.put("BattleShip", BattleShip::new);
        SHIP_FACTORY.put("BattleCruiser", BattleCruiser::new);
        SHIP_FACTORY.put("Cruiser", Cruiser::new);
        SHIP_FACTORY.put("LightCruiser", LightCruiser::new);
        SHIP_FACTORY.put("Destroyer", Destroyer::new);
        SHIP_FACTORY.put("Submarine", Submarine::new);
    }

    /**
     * This method get the instance of specific class of ship.
     * @param shipType string type of ship.
     * @return specific ship instance.
     */
    public static Ship getShip(final String shipType) {
        return SHIP_FACTORY.getOrDefault(shipType, EmptySea::new).buildShip();
    }
}
