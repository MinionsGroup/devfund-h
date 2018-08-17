package org.minions.devfund.reinaldo.battleship;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertThat;

/**
 * Ship type enum class.
 */
public class ShipTypeEnumTest {

    /**
     * Verifies if ship type exist on the enum.
     */
    @Test
    public void testVerifiesTheShipTypeOnTheEnum() {
        assertThat(ShipTypeEnum.BATTLE_CRUISER.valueOf("BATTLE_CRUISER"), is(notNullValue()));
    }
}
