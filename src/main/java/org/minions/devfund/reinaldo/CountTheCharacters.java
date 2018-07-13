package org.minions.devfund.reinaldo;

import java.util.Arrays;

/**
 * Created by reinaldo on 05-07-18.
 */
public final class CountTheCharacters {

    /**
     * Constructor of the count the characters.
     */
    private CountTheCharacters() { }

    /**
     * Methods for count the character of a string.
     * @param str the string.
     * @param c the character.
     * @return int type.
     */
    public static int charCount(final String str, final char c) {

        return (int) Arrays.asList(str.split("")).stream()
                .filter(x -> x.equalsIgnoreCase(String.valueOf(c)))
                .count();
    }
}
