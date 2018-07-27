package org.minions.devfund.reinaldo.movie;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

/**
 * Created by reinaldo on 25-07-18.
 */
public class ActorTest {



    /**
     * Calculate rating average.
     */
    @Test
    public void testActorsMovieRatingAverageCalculation() {
        final Actor actor = new Actor("Tom crush");
        final double movieRating1 = 10;
        final double movieRating2 = 20;

        final double expectedAverage = 15.0;

        final double parameterDouble = 0;

        final Movie movie1 = new Movie("Monsters");
        movie1.setRating(movieRating1);
        final Movie movie2 = new Movie("Dora");
        movie2.setRating(movieRating2);
        actor.getMovies().add(movie1);
        actor.getMovies().add(movie2);

        assertEquals(expectedAverage, actor.movieRatingAverage(), parameterDouble);
    }

    /**
     *Tests for New actor.
     */
    @Test
    public void testWithNewActor() {
        final Actor actor = new Actor("Tom crush");
        final String expectedActor = "Tom crush";

        assertEquals(expectedActor, actor.getName());
    }

    /**
     * Get Movies list test.
     */
    @Test
    public void testSetActorsMovies() {
        final Actor actor = new Actor("Monsters Autor");

        final ArrayList<Movie> movies = new ArrayList<>();
        movies.add(new Movie("Monsters"));
        movies.add(new Movie("Dora"));
        actor.setMovies(movies);

        assertEquals(movies, actor.getMovies());
    }

    /**
     * Set an actor With other actor.
     */
    @Test
    public void testSetActorsWithOtherActor() {
        final Actor actor = new Actor("Tom Crush");
        final String setActor = "Tim twaro";
        actor.setName(setActor);
        assertEquals(setActor, actor.getName());
    }

}
