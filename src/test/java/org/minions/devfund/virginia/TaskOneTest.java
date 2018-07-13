package org.minions.devfund.virginia;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Contains the tests to the created methods.
 */
public class TaskOneTest {
   private TaskOne taskOne;

    /***
     * Creates a instance for TaskOne class.
     */
    @Before
    public void createTaskOne() {
        taskOne = new TaskOne();
    }

    /**
     * Verifies some TaskOne method.
     */
    @Test
    public void testOne() {
        final int expectedFour = 4;
        assertEquals(expectedFour, taskOne.countChar("fizzbuzz", 'z'));
    }

    /**
     * Verifies some TaskOne method.
     */
    @Test
    public void testTwo() {
        final int expectedFive = 5;
        assertEquals(expectedFive, taskOne.countChar("Fancy fifth fly aloof", 'f'));
    }
}
