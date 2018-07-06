package org.minions.devfund;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

import org.junit.runners.JUnit4;

// TODO: Replace examples and use TDD development by writing your own tests

public class CCTest {
    @Test
    public void testSomething() {
        assertEquals(4, CC.charCount("fizzbuzz", 'z'));
        assertEquals(4, CC.charCount("FIZZBUZZ", 'z'));
    }
}