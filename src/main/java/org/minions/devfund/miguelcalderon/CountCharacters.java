package org.minions.devfund.miguelcalderon;

/**
 * Solution for "count the characters" kata.
 *
 * @version 1.0 18 Jul 2018  * @author
 * Miguel Calderon
 */

public final class CountCharacters {

    /**
     * Private constructor.
     */
    private CountCharacters() {
    }

    /**
     * Count number of times that a letter appears in a sentence.
     *
     * @param word sentence
     * @param e letter
     * @return number of times that letter appears in sentence
     */
    public int countCharcters(final String word, char e) {
        int result = 0;
        for (char i : word.toCharArray()) {
            if (i == e) {
                result++;
            }
        }
        return result;
    }
}
