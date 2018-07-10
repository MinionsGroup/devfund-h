package org.minions.devfund.amilcar;

public class Count_repeated_characters {
        //
        public static int charCount(final String str, final char c) {
            char[] ch = str.toCharArray();
            int count = 0;
            for(int i=0; i<str.length();i++) {
                if(Character.toUpperCase(ch[i]) == Character.toUpperCase(c)) {
                    count++;
                }
            }
            return count;
        }
    }


