package org.minions.devfund.damian;

import java.util.regex.Pattern;

/**
 * Class solution for Kata #1: Count the Characters.
 *
 * @author Damian
 */

public class CharCount {
    /**
     * method to count the number of times that a characters appears in a string.
     *
     * @param str String type
     * @param c   Sting type
     * @return the number of times that character appears in the string (insensitive case)
     */
    public int characterCounter(final String str, final char c) {
        return Pattern.compile("(?i)[^" + c + "]").matcher(str).replaceAll("").length();
    }
}
