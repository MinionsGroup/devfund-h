package org.minions.devfund.noemi_guzman;

/**
 *  Kata solution Count the Characters.
 */
public final class CountCharacters {
    /**
     * Counts occurrence of chart in a String.
     *
     * @param str String value.
     * @param c   char value.
     * @return return number of occurrence of a character in a string.
     */
    public int countChar(final String str, final char c) {

        return str.replaceAll("(?i)[^" + c + "]", "").length();
    }
}

