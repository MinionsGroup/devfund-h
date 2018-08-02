package org.minions.devfund.abel.moviedatabase;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Class for Movie Database Unit Tests.
 */
public class MovieDatabaseTest {

    private static final String NEW_MOVIE = "NewMovie";
    private static final String ACTOR1 = "Actor1";
    private static final String ACTOR2 = "Actor2";
    private static final String NEW_MOVIE2 = "NewMovie2";
    private MovieDatabase movieDatabase;

    /**
     * SetUp method.
     */
    @Before
    public void setUp() {
        movieDatabase = new MovieDatabase();
    }

    /**
     * Test AddMovie.
     */
    @Test
    public void testAddMovieNewMovieAndActors() {
        movieDatabase.addMovie(NEW_MOVIE, new String[]{ACTOR1, ACTOR2});

        assertEquals(1, movieDatabase.getMovieList().size());
        assertEquals(NEW_MOVIE, movieDatabase.getMovieList().get(0).getName());
        assertEquals(2, movieDatabase.getActorList().size());
    }

    /**
     * Test AddMovie.
     */
    @Test
    public void testAddMovieAlreadyAdded() {
        movieDatabase.addMovie(NEW_MOVIE, new String[]{ACTOR1, ACTOR2});
        movieDatabase.addMovie(NEW_MOVIE, new String[]{ACTOR1, ACTOR2});

        assertEquals(1, movieDatabase.getMovieList().size());
        assertEquals(NEW_MOVIE, movieDatabase.getMovieList().get(0).getName());
        assertEquals(2, movieDatabase.getActorList().size());
    }

    /**
     * Test AddMovie.
     */
    @Test
    public void testAddMovieNewActors() {
        movieDatabase.addMovie(NEW_MOVIE, new String[]{ACTOR1, ACTOR2});
        String actor3 = "Actor3";
        movieDatabase.addMovie(NEW_MOVIE2, new String[]{ACTOR1, ACTOR2, actor3});
        final int three = 3;

        assertEquals(2, movieDatabase.getMovieList().size());
        assertEquals(NEW_MOVIE, movieDatabase.getMovieList().get(0).getName());
        assertEquals(three, movieDatabase.getActorList().size());
    }

    /**
     * Test AddRating.
     */
    @Test
    public void testAddRatingNewMovie() {
        movieDatabase.addMovie(NEW_MOVIE, new String[]{ACTOR1, ACTOR2});
        final double ten = 10.0;
        movieDatabase.addRating(NEW_MOVIE, ten);

        assertEquals(ten, movieDatabase.getMovieList().get(0).getRating(), 0.0);
    }

    /**
     * Test UpdateRating.
     */
    @Test
    public void testUpdateRatingToExistingMovie() {
        movieDatabase.addMovie(NEW_MOVIE, new String[]{ACTOR1, ACTOR2});
        final double ten = 10.0;
        final double fifteen = 15.0;
        movieDatabase.addRating(NEW_MOVIE, ten);
        movieDatabase.updateRating(NEW_MOVIE, fifteen);

        assertEquals(fifteen, movieDatabase.getMovieList().get(0).getRating(), 0.0);
    }

    /**
     * Test GetBestActor.
     */
    @Test
    public void testGetBestActor() {
        movieDatabase.addMovie(NEW_MOVIE, new String[]{ACTOR1, ACTOR2});
        movieDatabase.addMovie(NEW_MOVIE2, new String[]{ACTOR1});
        final double ten = 10.0;
        final double fifteen = 15.0;
        movieDatabase.addRating(NEW_MOVIE, ten);
        movieDatabase.addRating(NEW_MOVIE2, fifteen);

        assertEquals(ACTOR1, movieDatabase.getBestActor());
    }

    /**
     * Test GetBestMovie.
     */
    @Test
    public void testGetBestMovie() {
        movieDatabase.addMovie(NEW_MOVIE, new String[]{ACTOR1, ACTOR2});
        movieDatabase.addMovie(NEW_MOVIE2, new String[]{ACTOR1});
        final double ten = 10.0;
        final double fifteen = 15.0;
        movieDatabase.addRating(NEW_MOVIE, ten);
        movieDatabase.addRating(NEW_MOVIE2, fifteen);

        assertEquals(NEW_MOVIE2, movieDatabase.getBestMovie());
    }
}
