package org.minions.devfund.benjamin;

/**
 * Class for count characters.
 */
public final class CountCharacters {

    /**
     * Constructor.
     */
    private CountCharacters() {
    }

    /**
     * Count characters.
     *
     * @param str string value.
     * @param c   char value.
     * @return number of matches.
     */
    public static int charCount(final String str, final char c) {
        int contMatches = 0;
        char[] array = str.toUpperCase().toCharArray();
        for (char anArray : array) {
            if (Character.toUpperCase(c) == anArray) {
                contMatches++;
            }
        }
        return contMatches;
    }
}
