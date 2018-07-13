package org.minions.devfund;

import org.junit.Test;

import static org.junit.Assert.*;

public class CCTest {
    CC countChar = new CC();
    @Test
    public void charCount() {
        assertEquals(1, countChar.charCount("fzi", 'z'));
        assertEquals(2, countChar.charCount("fziz", 'z'));
        assertEquals(0, countChar.charCount("", 'a'));
    }
}
