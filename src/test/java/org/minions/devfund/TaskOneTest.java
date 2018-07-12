package org.minions.devfund;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Contains the tests to the created methods.
 */
public class TaskOneTest {
    private static final int FOUR = 4;
    private static final int FIVE = 5;
    private static TaskOne taskOne;

    /***
     * Creates a instance for TaskOne class.
     */
    @BeforeClass
    public static void createTaskOne() {
        taskOne = new TaskOne();

    }

    /**
     * Verifies some TaskOne method.
     */
    @Test
    public void testOne() {
        int actualCounter = taskOne.countChar("fizzbuzz", 'z');
        Assert.assertEquals(FOUR, actualCounter);
    }

    /**
     * Verifies some TaskOne method.
     */
    @Test
    public void testTwo() {
        int actualCounter = taskOne.countChar("Fancy fifth fly aloof", 'f');
        Assert.assertEquals(FIVE, actualCounter);
    }
}
