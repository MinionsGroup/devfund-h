package org.minions.devfund;

import org.junit.Assert;
import org.junit.Test;

public class TaskOneTest {

    /**
     * Verify some TaskOne method.
     */
    @Test
    public void testOne() {
        TaskOne taskOne = new TaskOne();
        int result = taskOne.countChar("fizzbuzz",'z');
        Assert.assertEquals(4, result);
    }

    @Test
    public void testTwo() {
        TaskOne taskOne = new TaskOne();
        int result = taskOne.countChar("Fancy fifth fly aloof",'f');
        Assert.assertEquals(5, result);
    }
}
