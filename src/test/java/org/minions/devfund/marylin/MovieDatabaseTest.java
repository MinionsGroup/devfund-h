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
        movieDatabase = new MovieDatabase();
        String[] actors = {"Brad Pitt", "Dustin Hoffman", "Kevin Bacon"};
        movieDatabase.addMovie("Sleepers", actors);
        String[] actors1 = {"Brad Pitt", "Diane Kruger", "Eric Bana"};
        movieDatabase.addMovie("Troy", actors1);
        String[] actors2 = {"Humphrey Bogart"};
        movieDatabase.addMovie("Casablanca", actors2);

        movieDatabase.addRating("Sleepers", rating1);
        movieDatabase.addRating("Troy", rating2);
        movieDatabase.addRating("Casablanca", rating3);
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
        String[] actors = {"Brad Pitt"};
        movieDatabase.addMovie("testMovie", actors);
        assertTrue(movieDatabase.getActorCount("Brad Pitt") == 1);
    }

    /**
     * test.
     */
    @Test
    public void testAddMovieAlreadyExist() {
        String[] actors = {"testActor"};
        movieDatabase.addMovie("Sleepers", actors);
        assertTrue(movieDatabase.getMovieCount("Sleepers") == 1);
    }
}
