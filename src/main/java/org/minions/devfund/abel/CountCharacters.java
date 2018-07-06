package org.minions.devfund.abel;

import java.util.Arrays;

/**
 * Solving Kata https://www.codewars.com/kata/count-the-characters/java .
 */
public final class CountCharacters {

    /**
     * Private Constructor.
     */
    private CountCharacters() { }

    /**
     * Counts the repetitions of an specific character in a String.
     * @param str The string to review.
     * @param c The character to check repetitions.
     * @return int type.
     */
    public static int charCount(final String str, final char c) {
        return (int) Arrays.stream(str.split(""))
                .filter(ch -> ch.equalsIgnoreCase(Character.toString(c)))
                .count();
    }
}
