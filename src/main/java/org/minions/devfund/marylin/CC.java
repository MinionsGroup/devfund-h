package org.minions.devfund.marylin;

/**
 * Class to count the number of occurrences of a character in case insensitive mode.
 */
public class CC {
    /**
     * Method to count the number of occurrences of a character in case insensitive mode.
     *
     * @param str String to used to count the ocurrences.
     * @param c Character to be count.
     * @return  Number of occurrences.
     */
    public int charCount(final String str, char c) {
        return (int) str.toLowerCase().chars().filter(character -> character == Character.toLowerCase(c)).count();
    }
}
