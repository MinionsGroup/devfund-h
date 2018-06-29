package org.minions.devfund.danielmontecinos;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Tests CountCharacters class.
 */
public class CountCharactersTest {

    /**
     * Test that CountCharacters class has a private constructor.
     *
     * @throws NoSuchMethodException     when no private constructor is defined.
     * @throws IllegalAccessException    when can not access to the constructor.
     * @throws InvocationTargetException when can not be perform a invocation.
     * @throws InstantiationException    when a instantiation can not be performed.
     */
    @Test
    public void testCheckConstructorPrivate() throws NoSuchMethodException, IllegalAccessException,
            InvocationTargetException, InstantiationException {
        Constructor<CountCharacters> constructor = CountCharacters.class.getDeclaredConstructor();

        assertTrue(Modifier.isPrivate(constructor.getModifiers()));
        constructor.setAccessible(true);
        constructor.newInstance();
    }

    /**
     * Checks if method returns expected value for a certain string.
     */
    @Test
    public void testCharCountStringOne() {
        final int actualResult = CountCharacters.charCount("fizzbuzz", 'z');
        final int expectedResult = 4;

        assertEquals(expectedResult, actualResult);
    }

    /**
     * Checks if method returns expected value using another string.
     */
    @Test
    public void testCharCountStringTwo() {
        final int actualResult = CountCharacters.charCount("Fancy fifth fly aloof", 'f');
        final int expectedResult = 5;

        assertEquals(expectedResult, actualResult);
    }
}
