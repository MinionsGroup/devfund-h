package org.minions.devfund.reinaldo.battleship;

import java.util.Arrays;

/**
 * Created by reinaldo on 10-08-18.
 */
public class EmptySea extends Ship {

        /**
         * Constructor of the EmptySea.
         */
        public EmptySea() {
            setLength(1);
            setHit(new boolean[1]);
            Arrays.fill(getHit(), false);
        }

        /**
         * {@inheritDoc}.
         */
        @Override
        boolean shootAt(int row, int column) {
            setHit(new boolean[]{true});
            return false;
        }

        /**
         * {@inheritDoc}.
         */
        @Override
        boolean isSunk() {
            return false;
        }

        /**
         * {@inheritDoc}.
         */
        @Override
        String getShipType() {
            return ShipTypeEnum.EMPTY.toString().toLowerCase();
        }

        /**
         * {@inheritDoc}.
         */
        @Override
        public String toString() {
            return getHit()[0] ? "-" : ".";
        }
    }
