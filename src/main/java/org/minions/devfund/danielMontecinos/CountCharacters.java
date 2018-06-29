package org.minions.devfund.danielMontecinos;

import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * My solution for kata https://www.codewars.com/kata/count-the-characters/.
 */
public final class CountCharacters {
    private static final String EMPTY_STRING = "";

    /**
     * Private constructor.
     */
    private CountCharacters() {
    }

    /**
     * Counts the how many times char "c" appears on str.
     *
     * @param str as String.
     * @param c   as char.
     * @return times "c" appears on str.
     */
    public static int charCount(final String str, final char c) {
        Predicate<String> ifCharacterMatch = chr -> chr.equalsIgnoreCase(String.valueOf(c));
        return (int) Stream.of(str.split(EMPTY_STRING)).filter(ifCharacterMatch).count();
    }
}
