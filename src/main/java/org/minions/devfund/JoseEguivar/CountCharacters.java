package org.minions.devfund.JoseEguivar;

/**
 * My primer javadoc.
 */
public final class CountCharacters {
    /**
     * Constructor.
     */
    private CountCharacters() {
    }

    /**
     * Counter class.
     * @param str string value.
     * @param c char value.
     * @return number of characters in the string.
     */

    public static int charCount(final String str, final char c) {
        int counter = 0;
        String str2 = Character.toString(c);
        String[] wordArray = str.split("");
        for (int i = 0; i < str.length(); i++) {
            if (wordArray[i].equalsIgnoreCase(str2)) {
                counter++;
            }
        }
        return counter;
    }
}

