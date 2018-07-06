package org.minions.devfund;

public class CC {
    public static int charCount(String str, char c) {
        return (int) str.toLowerCase().chars().filter(character -> character == Character.toLowerCase(c)).count();
    }
}