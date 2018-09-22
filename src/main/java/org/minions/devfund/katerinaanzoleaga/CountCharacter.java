package org.minions.devfund.katerinaanzoleaga;

/**
 * Class to count the number of occurrences of a char in a string.
 */
public class CountCharacter {
    /**
     * This is the method to get charCount that will do the counting of the occurrences of c ub str.
     *
     * @param str The string
     * @param c   The character to count
     * @return int how many times c appears on str
     */
    public int charCount(final String str, char c) {
        int count = 0;
        int i = 0;
        int j = str.length() - 1;
        char upperCase = Character.toUpperCase(c);
        while (j >= i) {
            if (Character.toUpperCase(str.charAt(i)) == upperCase
                    || Character.toUpperCase(str.charAt(j)) == upperCase) {
                count++;
            }
            i++;
            j--;
        }
        return count;
    }
}
