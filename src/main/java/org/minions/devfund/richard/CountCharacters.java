package org.minions.devfund.richard;

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
     * This method count the number of times that character appears in the string. The count is case insensitive.
     *
     * @param str (String) This variable is the string in order to processing.
     * @param c   (char) This variable is the chart in order to verify repetitions.
     * @return (int) This returns the number of repetitions.
     */
    public static int countChar(final String str, final char c) {
        return (int) str
                .toLowerCase()
                .chars()
                .filter(myChar -> myChar == Character.toLowerCase(c))
                .count();
    }
}
