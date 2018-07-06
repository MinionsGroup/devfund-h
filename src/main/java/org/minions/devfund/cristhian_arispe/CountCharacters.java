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
     * @param str String value.
     * @param c Char value.
     * @return The number of characters that are found in the string.
     */
    public static int charCount(final String str, final char c) {
        String[] wordArray = str.split("");
        int counter = 0;
        for (int i = 0; i < str.length(); i++) {
            if (wordArray[i].toLowerCase().equals((c + "").toLowerCase())) {
                counter++;
            }
        }
        return counter;

    }

}
