/*
Class to count the number of occurrences of a char in a string
 */
package org.minions.devfund;


public final class CC {
    /*
    This is the class CC with method charCount that will do the counting
     */
    static int charCount(final String str, char c) {
        // your code here
        int count = 0;
        int i = 0;
        int j = str.length() - 1;
        char uperC = Character.toUpperCase(c);
        while (j >= i) {
            if (i == j && Character.toUpperCase(str.charAt(i)) == uperC) {
                count++;
            } else {
                if (Character.toUpperCase(str.charAt(i)) == uperC
                        || Character.toUpperCase(str.charAt(j)) == uperC) {
                    count++;
                }
            }
            i++;
            j--;
        }
        return count;
    }
}
