package org.minions.devfund.Benjamin;

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
     * @param str string value.
     * @param c char value.
     * @return number of matches.
     */
    public static int charCount(final String str, final char c) {
        // your code here
        int contMatches = 0;
        String subStr = Character.toString(c);
        subStr = subStr.toUpperCase();
        String[] array = str.toUpperCase().split("");

        for (int i = 0; i <= str.length() - 1; i++) {
            if (subStr.equals(array[i])) {
                contMatches++;
            }
        }

        return contMatches;
    }
}
