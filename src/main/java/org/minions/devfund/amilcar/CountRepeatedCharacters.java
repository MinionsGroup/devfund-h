package org.minions.devfund.amilcar;

/**
 * Class about count repeated character inside a string.
 */
public final class CountRepeatedCharacters {
    /**
     * This is the private constructor.
     */

    private CountRepeatedCharacters() {

    }

    /**
     * Method to count repeated characters in a string.
     * @param str store the string that will be evaluated.
     * @param c store the number of repeated characters.
     * @return count the number of repeated characters.
     */
    public static int charCount(final String str, final char c) {
        /**
         * @param ch will contain the string converted in array.
         * @param count will contain the repeated characters in the string.
         */
        char[] ch = str.toCharArray();
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (Character.toUpperCase(ch[i]) == Character.toUpperCase(c)) {
                count++;
            }
        }
        return count;
    }
}


