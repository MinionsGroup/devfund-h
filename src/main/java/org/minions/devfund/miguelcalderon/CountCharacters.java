package org.minions.devfund.miguelcalderon;


import java.util.logging.Logger;

/**
 * Solution for "count the characters" kata.
 *
 * @version 1.0 18 Jul 2018  * @author
 * Miguel Calderon
 */

public class CountCharacters {
    private final static Logger LOGGER = Logger.getLogger(CountCharacters.class.getName());

    /**
     * Private constructor.
     */
    private CountCharacters() {
    }

    /**
     * Counts the how many times char "e" appears in word.
     */
    public static void main(final String[] args) {
        String word = "Martes de fuchitos";
        char character = 'e';
        int result = 0;

        for (char c : word.toCharArray()) {
            if (c == character) {
                result++;
            }
        }
        LOGGER.info(String.valueOf(result));
    }
}
