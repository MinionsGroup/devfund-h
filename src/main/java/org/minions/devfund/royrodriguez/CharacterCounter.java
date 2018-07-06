package org.minions.devfund.royrodriguez;

/**
 * Kata https://www.codewars.com/kata/count-the-characters .
 * solution
 */
public class CharacterCounter {

    /**
     * Counts chars from a given String.
     *
     * @param str String to count chars.
     * @param c   char to count.
     * @return number of characters found.
     */
    public int charCount(final String str, final char c) {
        return (int) str
                .chars().mapToObj(i -> (char) i)
                .filter(i -> i.toString().equalsIgnoreCase(String.valueOf(c)))
                .count();
    }
}
