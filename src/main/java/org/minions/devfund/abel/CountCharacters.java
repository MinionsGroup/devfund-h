package org.minions.devfund.abel;


/**
 * Solving Kata https://www.codewars.com/kata/count-the-characters/java .
 */
public final class CountCharacters {

    /**
     * Private Constructor.
     */
    private CountCharacters() {
    }

    /**
     * Counts the repetitions of an specific character in a String.
     *
     * @param str The string to review.
     * @param c   The character to check repetitions.
     * @return int type.
     */
    public static int charCount(final String str, char c) {
        return (int) str.toLowerCase().chars()
                .filter(ch -> ch == Character.toLowerCase(c))
                .count();
    }
}
