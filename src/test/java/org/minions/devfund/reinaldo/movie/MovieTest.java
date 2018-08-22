package org.minions.devfund.reinaldo.movie;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
/**
 * Created by reinaldo on 25-07-18.
 */
public class MovieTest {

    /**
     * Test new movie.
     */
    @Test
    public void testNewMovieW() {
        final Movie movie = new Movie("Monster");
        final String expectedMovieName = "Monster";
        assertEquals(expectedMovieName, movie.getName());
    }

    /**
     * Set actors for movies list test.
     */
    @Test
    public void testSetActorsMovies() {
        final Movie movie = new Movie("Dora1");
        final ArrayList<Actor> newActors = new ArrayList<>();
        newActors.add(new Actor("Tom crush1"));
        newActors.add(new Actor("Rayos1"));
        movie.setActors(newActors);
        assertEquals(newActors, movie.getActors());
    }

    /**
     * Set the new movie.
     */
    @Test
    public void testSetMovieName() {
        final Movie movie = new Movie("dora2");
        final String newMovie = "dora new2";
        movie.setName(newMovie);
        assertEquals(newMovie, movie.getName());
    }

    /**
     * Set rating for movie.
     */
    @Test
    public void testSetMovieRating() {
        final Movie movie = new Movie("dora3");
        final double newRating = 5;
        final double parameterDoble = 0;
        movie.setRating(newRating);
        assertEquals(newRating, movie.getRating(), parameterDoble);
    }

}
