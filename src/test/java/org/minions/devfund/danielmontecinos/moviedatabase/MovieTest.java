package org.minions.devfund.danielmontecinos.moviedatabase;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

/**
 * Tests Movie class.
 */
public class MovieTest {
    private Movie movie;

    /**
     * Creates movie object.
     */
    @Before
    public void setUp() {
        movie = new Movie();
    }

    /**
     * Tests getName method.
     */
    @Test
    public void testGetNameMethod() {
        assertNull(movie.getName());
    }

    /**
     * Tests testsSetNameMethod method.
     */
    @Test
    public void testSetNameMethod() {
        movie.setName("Movie 1");
        assertEquals("Movie 1", movie.getName());
    }

    /**
     * Tests getActors method.
     */
    @Test
    public void testGetActorsMethod() {
        assertTrue(movie.getActors().isEmpty());
    }

    /**
     * Tests setActors method.
     */
    @Test
    public void testSetActorsMethod() {
        movie.setName("Movie 1");
        movie.setActors("Movie 1", new String[]{"Actor 1", "Actor 2", "Actor 3"});
        assertEquals("Movie 1", movie.getName());
        assertEquals("Actor 1", movie.getActors().get(0).getName());
        assertEquals("Actor 2", movie.getActors().get(1).getName());
        assertEquals("Actor 3", movie.getActors().get(2).getName());


        assertEquals("Movie 1", movie.getActors().get(0).getMovies().get(0).getName());
        assertEquals("Movie 1", movie.getActors().get(1).getMovies().get(0).getName());
        assertEquals("Movie 1", movie.getActors().get(2).getMovies().get(0).getName());
    }

    /**
     * Tests getRating method.
     */
    @Test
    public void testGetRatingMethod() {
        final double expectedRating = 0.0;
        assertEquals(expectedRating, movie.getRating(), 0.0);
    }

    /**
     * Tests setRating method.
     */
    @Test
    public void testSetRatingMethod() {
        final double newRating = 10.50;
        movie.setRating(newRating);

        final double expectedRating = 10.50;
        assertEquals(expectedRating, movie.getRating(), 0.0);
    }
}
