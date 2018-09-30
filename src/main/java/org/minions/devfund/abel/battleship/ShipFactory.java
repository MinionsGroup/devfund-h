package org.minions.devfund.abel.battleship;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

/**
 * Class to handle ShipFactory.
 */
public class ShipFactory implements IShipFactory {

    private static final Map<String, Supplier<Ship>> SHIP_FACTORY = new HashMap<>();

    static {
        SHIP_FACTORY.put("BattleShip", BattleShip::new);
        SHIP_FACTORY.put("BattleCruiser", BattleCruiser::new);
        SHIP_FACTORY.put("Cruiser", Cruiser::new);
        SHIP_FACTORY.put("LightCruiser", LightCruiser::new);
        SHIP_FACTORY.put("Destroyer", Destroyer::new);
        SHIP_FACTORY.put("Submarine", Submarine::new);
    }

    /**
     * {@inheritDoc}.
     */
    @Override
    public Ship getShip(final String shipType) {
        return SHIP_FACTORY.getOrDefault(shipType, EmptySea::new).get();
    }
}
