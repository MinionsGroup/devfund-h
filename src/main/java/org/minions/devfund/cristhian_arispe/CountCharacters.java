package org.minions.devfund.cristhian_arispe;

/**
 * This is the solution for the first kata.
 */
public final class CountCharacters {

    /**
     * CountCharacters constructor.
     */
    private CountCharacters() {
    }

    /**
     * Count characters on the String.
     *
     * @param str String value.
     * @param c   Char value.
     * @return The number of characters that are found in the string.
     */
    static int charCount(final String str, final char c) {
        int counter = 0;
        char[] wordArray = str.toLowerCase().toCharArray();
        for (char aWordArray : wordArray) {
            if (aWordArray == Character.toLowerCase(c)) {
                counter++;
            }
        }
        return counter;
    }

}
