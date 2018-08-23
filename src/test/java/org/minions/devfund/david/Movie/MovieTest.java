package org.minions.devfund.david.Movie;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

/**
 * Movie tests class.
 */
public class MovieTest {

    private static final String NEW_MOVIE = "Movie1";
    private static final String ACTOR_1 = "Actor1";
    private static final String ACTOR_2 = "Actor2";
    private static final String ACTOR_3 = "Actor3";
    private Movie movie;

    /**
     * Setup movie object.
     */
    @Before
    public void setupMovie() {
        movie = new Movie();
    }

    /**
     * Gets movie name test.
     */
    @Test
    public void getName() {
        assertNull(movie.getName());
    }

    /**
     * Sets movie name test.
     */
    @Test
    public void setName() {
        movie.setName(NEW_MOVIE);

        assertEquals(NEW_MOVIE, movie.getName());
    }

    /**
     * Gets movie's actors empty test.
     */
    @Test
    public void getActors() {
        assertTrue(movie.getActors().isEmpty());
    }

    /**
     * Sets actors into movie test.
     */
    @Test
    public void setActors() {
        movie.setName(NEW_MOVIE);
        String[] actors = new String[]{ACTOR_1, ACTOR_2, ACTOR_3};
        movie.setActors(actors, NEW_MOVIE);

        assertEquals(NEW_MOVIE, movie.getName());
        assertEquals(ACTOR_1, movie.getActors().get(0).getName());
        assertEquals(ACTOR_2, movie.getActors().get(1).getName());
        assertEquals(ACTOR_3, movie.getActors().get(2).getName());
    }

    /**
     * Gets rating of a movie test.
     */
    @Test
    public void getRating() {
        final double expectedRating = 0.0;
        assertEquals(expectedRating, movie.getRating(), 0.0);
    }

    /**
     * Sets rating of a movie test.
     */
    @Test
    public void setRating() {
        final double rating = 6.5;
        movie.setRating(rating);

        final double expectedRating = rating;
        assertEquals(expectedRating, movie.getRating(), 0.0);
    }
}
