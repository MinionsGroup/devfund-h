package org.minions.devfund.danielmontecinos.moviedatabase;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

/**
 * Tests Actor class.
 */
public class ActorTest {
    private Actor actor;

    /**
     * Creates actor object.
     */
    @Before
    public void setUp() {
        actor = new Actor();
    }

    /**
     * Tests testsGetNameMethod method.
     */
    @Test
    public void testGetNameMethod() {
        assertNull(actor.getName());
    }

    /**
     * Tests testsSetNameMethod method.
     */
    @Test
    public void testSetNameMethod() {
        actor.setName("Actor 1");
        assertEquals("Actor 1", actor.getName());
    }

    /**
     * Tests getMovies method.
     */
    @Test
    public void testGetMoviesMethod() {
        assertTrue(actor.getMovies().isEmpty());
    }

    /**
     * Tests setMovie method.
     */
    @Test
    public void testSetMovieMethod() {
        actor.setMovie("Movie 1");
        actor.setMovie("Movie 2");
        actor.setMovie("Movie 3");
        final int expectedSize = 3;
        assertEquals(expectedSize, actor.getMovies().size());
    }

    /**
     * Tests getMovies method.
     */
    @Test
    public void testGetMoviesGetName() {
        actor.setMovie("Movie 1");
        actor.setMovie("Movie 2");
        actor.setMovie("Movie 3");
        assertEquals("Movie 1", actor.getMovies().get(0).getName());
        assertEquals("Movie 2", actor.getMovies().get(1).getName());
        assertEquals("Movie 3", actor.getMovies().get(2).getName());
    }
}
