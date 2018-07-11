package org.minions.devfund.reinaldo.codewars;

import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by reinaldo on 08-07-18.
 */
public final class Accumul {

    /**
     * The constructor for Accumul class.
     */
    private Accumul() { }

    /**
     * Methods for accum.
     * @param s word.
     * @return String result of the word.
     */
    public static String accum(final String s) {
        return IntStream.range(0, s.length())
                .mapToObj(n -> s.substring(n, n + 1).toUpperCase()
                        + (n < 1 ? "" : String.join("", Collections.nCopies(n, s.substring(n, n + 1).toLowerCase()))))
                .collect(Collectors.joining("-"));
    }
}
