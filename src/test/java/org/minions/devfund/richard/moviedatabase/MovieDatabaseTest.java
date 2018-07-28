package org.minions.devfund.richard.moviedatabase;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Test Class.
 */
public class MovieDatabaseTest {

    private MovieDatabase movieDatabase;
    private static final String MOVIE_ONE = "Movie1";
    private static final String MOVIE_TWO = "Movie2";
    private static final double TEN = 10.0;
    private static final double TWENTY = 20.0;

    /**
     * Before.
     */
    @Before
    public void setUp() {
        movieDatabase = new MovieDatabase();
    }

    /**
     * Test.
     */
    @Test
    public void testGetBestActor() {
        movieDatabase.addMovie(MOVIE_ONE, new String[]{"Actor1", "Actor2"});
        movieDatabase.addMovie(MOVIE_TWO, new String[]{"Actor1"});
        movieDatabase.addRating(MOVIE_ONE, TEN);
        movieDatabase.addRating(MOVIE_TWO, TWENTY);
        assertEquals("Actor1", movieDatabase.getBestActor());
    }

    /**
     * Test.
     */
    @Test
    public void testGetBestMovie() {
        movieDatabase.addMovie(MOVIE_ONE, new String[]{"Actor1", "Actor2"});
        movieDatabase.addMovie(MOVIE_TWO, new String[]{"Actor1"});
        movieDatabase.addRating(MOVIE_ONE, TEN);
        movieDatabase.addRating(MOVIE_TWO, TWENTY);
        assertEquals("Movie2", movieDatabase.getBestMovie());
    }

    /**
     * Test.
     */
    @Test
    public void testAddMovieActorExist() {
        movieDatabase.addMovie(MOVIE_ONE, new String[]{"Actor1", "Actor2"});
        movieDatabase.addMovie(MOVIE_ONE, new String[]{"Actor1", "Actor2"});
        movieDatabase.addMovie(MOVIE_TWO, new String[]{"Actor1", "Actor2"});
        movieDatabase.addMovie(MOVIE_TWO, new String[]{"Actor1", "Actor2"});
        assertEquals(2, movieDatabase.getMovieList().size());
        assertEquals(2, movieDatabase.getActorList().size());
        assertEquals(MOVIE_ONE, movieDatabase.getMovieList().get(0).getName());
        assertEquals(MOVIE_TWO, movieDatabase.getMovieList().get(1).getName());
        assertEquals("Actor1", movieDatabase.getActorList().get(0).getName());
        assertEquals("Actor2", movieDatabase.getActorList().get(1).getName());

    }

    /**
     * Test.
     */
    @Test
    public void testAddMovieAlreadyExist() {
        movieDatabase.addMovie(MOVIE_ONE, new String[]{"Actor1", "Actor2"});
        movieDatabase.addMovie(MOVIE_TWO, new String[]{"Actor1", "Actor2"});
        movieDatabase.addMovie(MOVIE_ONE, new String[]{"Actor1", "Actor2"});
        movieDatabase.addMovie(MOVIE_TWO, new String[]{"Actor1", "Actor2"});
        assertEquals(2, movieDatabase.getMovieList().size());
        assertEquals(2, movieDatabase.getActorList().size());
        assertEquals(MOVIE_ONE, movieDatabase.getMovieList().get(0).getName());
        assertEquals(MOVIE_TWO, movieDatabase.getMovieList().get(1).getName());
        assertEquals("Actor1", movieDatabase.getActorList().get(0).getName());
        assertEquals("Actor2", movieDatabase.getActorList().get(1).getName());
    }

    /**
     * Test.
     */
    @Test
    public void testUpdateRating() {
        movieDatabase.addMovie(MOVIE_ONE, new String[]{"Actor1", "Actor2"});
        movieDatabase.addMovie(MOVIE_TWO, new String[]{"Actor1"});
        movieDatabase.addRating(MOVIE_ONE, TEN);
        movieDatabase.updateRating(MOVIE_TWO, TWENTY);
        assertEquals(TEN, movieDatabase.getMovieList().get(0).getRating(), 0.0);
    }

    /**
     * Test.
     */
    @Test
    public void testRating() {
        movieDatabase.addMovie(MOVIE_ONE, new String[]{"Actor1", "Actor2"});
        movieDatabase.addRating(MOVIE_ONE, TEN);
        assertEquals(TEN, movieDatabase.getMovieList().get(0).getRating(), 0.0);
    }

}
