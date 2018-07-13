package org.minions.devfund.carlosorellana;

/**
 * The goal is count the number of characters appears in a string.
 *
 * @author Carlos Orellana.
 * @since 07/06/2018.
 */
public class KataCountCharacters {

    /**
     * Gets the number of characters that matches with the char founding.
     *
     * @param sentence - String sentence to review.
     * @param charToCount - Char to count matches in the sentence.
     * @return Number of chars that matches in the String sentence.
     */
    public int countCharacteres(final String sentence, final char charToCount) {
        int count = 0;

        int numericValue = Character.getNumericValue(charToCount);

        for (int i = 0; i < sentence.length(); i++) {

            if (Character.getNumericValue(sentence.charAt(i)) != numericValue) {
                continue;
            }
            count++;
        }

        return count;
    }
}
