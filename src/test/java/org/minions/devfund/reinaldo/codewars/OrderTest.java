package org.minions.devfund.reinaldo.codewars;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Created by reinaldo on 08-07-18.
 */
public class OrderTest {

    /**
     *Methods that order as test1.
     *
     */
    @Test
    public void test1() {
        assertThat(Order.order("is2 Thi1s T4est 3a"), equalTo("Thi1s is2 3a T4est"));
    }

    /**
     * Methods that order as test2.
     */
    @Test
    public void test2() {
        assertThat(Order.order("4of Fo1r pe6ople g3ood th5e the2"), equalTo("Fo1r the2 g3ood 4of th5e pe6ople"));
    }

    /**
     * Methods that order as test3.
     */
    @Test
    public void test3() {
        assertThat("Empty input should return empty string", Order.order(""), equalTo(""));
    }

}
