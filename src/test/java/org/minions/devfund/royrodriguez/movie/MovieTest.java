package org.minions.devfund.royrodriguez.movie;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

/**
 * Tests for movie.
 */
public class MovieTest {
    /**
     * Test new movie.
     */
    @Test
    public void testNewMovieW() {
        final Movie movie = new Movie();
        movie.setName("Monster");
        final String expectedMovieName = "Monster";
        assertEquals(expectedMovieName, movie.getName());
    }

    /**
     * Set actors for movies list test.
     */
    @Test
    public void testSetActorsMovies() {
        final Movie movie = new Movie();
        movie.setName("Dora1");
        final ArrayList<Actor> newActors = new ArrayList<>();
        final Actor actor1 = new Actor();
        actor1.setName("Tom crush1");
        final Actor actor = new Actor();
        actor.setName("Rayos1");
        newActors.add(actor);
        newActors.add(actor1);
        movie.setActors(newActors);
        assertEquals(newActors, movie.getActors());
    }

    /**
     * Set the new movie.
     */
    @Test
    public void testSetMovieName() {
        final Movie movie = new Movie();
        movie.setName("dora2");
        final String newMovie = "dora new2";
        movie.setName(newMovie);
        assertEquals(newMovie, movie.getName());
    }

    /**
     * Set rating for movie.
     */
    @Test
    public void testSetMovieRating() {
        final Movie movie = new Movie();
        movie.setName("dora3");
        final double newRating = 5;
        final double parameterDoble = 0;
        movie.setRating(newRating);
        assertEquals(newRating, movie.getRating(), parameterDoble);
    }
}
