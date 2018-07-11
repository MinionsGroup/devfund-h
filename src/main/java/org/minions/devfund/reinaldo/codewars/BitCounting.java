package org.minions.devfund.reinaldo.codewars;

import java.util.stream.Stream;

/**
 * Created by reinaldo on 08-07-18.
 */
public final class BitCounting {

    /**
     * Constructors for bit counting.
     */
    private BitCounting() { }

    /**
     * Methods for count bits.
     * @param n number
     * @return int the count bits
     */
    public static int countBits(int n) {
      return Math.toIntExact(Stream.of(Integer.toBinaryString(n).split(""))
              .filter(c -> c.equalsIgnoreCase("1"))
              .count());
    }
}
