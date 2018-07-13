package org.minions.devfund.david;

/**
 * Kata solution.
 */
public class CountCharacter {
    /**
     * Counts occurrence of chart in a String.
     *
     * @param srt String value.
     * @param c   char value.
     * @return return number of occurrence of a character in a string.
     */
    public int countChar(final String srt, final char c) {
        int count = 0;

        for (int index = 0; index < srt.length(); index++) {
            if (srt.toLowerCase().charAt(index) == Character.toLowerCase(c)) {
                count++;
            }
        }

        return count;
    }
}
