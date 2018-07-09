package org.minions.devfund.danielmontecinos;

/**
 * My solution for kata https://www.codewars.com/kata/count-the-characters/.
 */
public final class CountCharacters {

    /**
     * Constructor.
     */
    public CountCharacters() {
        // Do nothing.
    }

    /**
     * Counts the how many times char "c" appears on str.
     *
     * @param str as String.
     * @param c   as char.
     * @return times "c" appears on str.
     */
    public int charCount(final String str, final char c) {
        return (int) str.toLowerCase().chars()
                .filter(chr -> chr == Character.toLowerCase(c))
                .count();
    }
}
