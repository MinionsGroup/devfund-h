package org.minions.devfund.marylin;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Movie database test class.
 */
public class MovieDatabaseTest {
    private MovieDatabase movieDatabase;

    /**
     * Method to create an instance of CC class.
     */
    @Before
    public void setUp() {
        final double rating1 = 50.0;
        final double rating2 = 25.0;
        final double rating3 = 35.0;
        final String movie1 = "Sleepers";
        final String movie2 = "Troy";
        final String movie3 = "Casablanca";
        final String actor1 = "Brad Pitt";
        final String actor2 = "Dustin Hoffman";
        final String actor3 = "Kevin Bacon";
        final String actor4 = "Diane Kruger";
        final String actor5 = "Eric Bana";
        final String actor6 = "Humphrey Bogart";

        movieDatabase = new MovieDatabase();
        String[] actors = {actor1, actor2, actor3};
        movieDatabase.addMovie(movie1, actors);
        String[] actors1 = {actor1, actor4, actor5};
        movieDatabase.addMovie(movie2, actors1);
        String[] actors2 = {actor6};
        movieDatabase.addMovie(movie3, actors2);
        movieDatabase.addRating(movie1, rating1);
        movieDatabase.addRating(movie2, rating2);
        movieDatabase.addRating(movie3, rating3);
    }

    /**
     * Method to count all the lower case characters.
     */
    @Test
    public void testGetBestActor() {
        final String expectedBestActor = "Dustin Hoffman";
        assertEquals(expectedBestActor, movieDatabase.getBestActor());
    }

    /**
     * test.
     */
    @Test
    public void testGetBestMovie() {
        final String expectedBestMovie = "Sleepers";
        assertEquals(expectedBestMovie, movieDatabase.getBestMovie());
    }

    /**
     * test.
     */
    @Test
    public void testAddMovieActorExist() {
        final String testActor = "Brad Pitt";
        String[] actors = {testActor};
        movieDatabase.addMovie("Troy", actors);
        assertTrue(movieDatabase.getActorCount(testActor) == 1);
    }

    /**
     * test.
     */
    @Test
    public void testAddMovieAlreadyExist() {
        final String testMovie = "Sleepers";
        String[] actors = {"Dustin Hoffman"};
        movieDatabase.addMovie(testMovie, actors);
        assertTrue(movieDatabase.getMovieCount(testMovie) == 1);
    }

    public void testUpdateMovieRating() {
        final double rating4 = 30.0;
        final String testMovie = "Sleepers";
        movieDatabase.updateRating(testMovie,rating4);
        assertEquals(movieDatabase.getMovie(testMovie).getRating(), rating4, 0);
    }
}
