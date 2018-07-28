package org.minions.devfund.richard.moviedatabase;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotEquals;

/**
 * Test Class.
 */
public class MovieTest {

    private Movie movie;

    /**
     * Before.
     */
    @Before
    public void setUp() {
        movie = new Movie();
    }

    /**
     * Test.
     */
    @Test
    public void testAddActorAlreadyExist() {
        final Actor actor1 = new Actor();
        final Actor actor2 = new Actor();
        actor1.setName("Actor1");
        actor2.setName("Actor2");
        movie.setActors(actor1);
        movie.setActors(actor2);
        movie.setActors(actor1);
        assertEquals(2, movie.getActors().size());
        assertEquals("Actor1", movie.getActors().get(0).getName());
        assertEquals("Actor2", movie.getActors().get(1).getName());
    }

    /**
     * Test.
     */
    @Test
    public void testEquals() {
        assertNotNull(movie);
        assertNotEquals(movie, new Actor());
    }
}
