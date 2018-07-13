package org.minions.devfund;

/**
 * This contains the methods for first task.
 **/
public class TaskOne {

    /**
     * Counts  the number of time that character appears in a string.
     * @param word string where searching the given character.
     * @param charToSearch char to search.
     * @return the number of time that character appears in the string .
     */
    public int countChar(final String word, final char charToSearch) {
        int countCharacters = 0;
        for (char c: word.toCharArray()) {
            if (Character.toLowerCase(c) == Character.toLowerCase(charToSearch)) {
                countCharacters++;
            }
        }
        return countCharacters;
    }
}
