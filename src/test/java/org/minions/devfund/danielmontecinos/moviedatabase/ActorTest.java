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
    private static final String MOVIE_1 = "Movie 1";
    private static final String MOVIE_2 = "Movie 2";
    private static final String MOVIE_3 = "Movie 3";
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
        actor.setMovie(MOVIE_1);
        actor.setMovie(MOVIE_2);
        actor.setMovie(MOVIE_3);
        final int expectedSize = 3;
        assertEquals(expectedSize, actor.getMovies().size());
    }

    /**
     * Tests getMovies method.
     */
    @Test
    public void testGetMoviesGetName() {
        actor.setMovie(MOVIE_1);
        actor.setMovie(MOVIE_2);
        actor.setMovie(MOVIE_3);
        assertEquals(MOVIE_1, actor.getMovies().get(0).getName());
        assertEquals(MOVIE_2, actor.getMovies().get(1).getName());
        assertEquals(MOVIE_3, actor.getMovies().get(2).getName());
    }
}
