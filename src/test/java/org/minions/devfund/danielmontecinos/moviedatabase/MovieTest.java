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
    private static final String MOVIE_1 = "Movie 1";
    private static final String ACTOR_1 = "Actor 1";
    private static final String ACTOR_2 = "Actor 2";
    private static final String ACTOR_3 = "Actor 3";
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
        movie.setName(MOVIE_1);
        assertEquals(MOVIE_1, movie.getName());
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
        movie.setName(MOVIE_1);
        movie.setActors(MOVIE_1, new String[]{ACTOR_1, ACTOR_2, ACTOR_3});
        assertEquals(MOVIE_1, movie.getName());
        assertEquals(ACTOR_1, movie.getActors().get(0).getName());
        assertEquals(ACTOR_2, movie.getActors().get(1).getName());
        assertEquals(ACTOR_3, movie.getActors().get(2).getName());


        assertEquals(MOVIE_1, movie.getActors().get(0).getMovies().get(0).getName());
        assertEquals(MOVIE_1, movie.getActors().get(1).getMovies().get(0).getName());
        assertEquals(MOVIE_1, movie.getActors().get(2).getMovies().get(0).getName());
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
