package org.minions.devfund.david.movie;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * movie database tests class.
 */
public class MovieDatabaseTest {
    private static final String NEW_MOVIE = "NewMovie";
    private static final String OLD_MOVIE = "OldMovie";
    private static final String ACTOR_1 = "Actor1";
    private static final String ACTOR_2 = "Actor2";
    private MovieDatabase movieDatabase;

    /**
     * Setup movie database class.
     */
    @Before
    public void setupMovieDatabase() {
        movieDatabase = new MovieDatabase();
    }

    /**
     * Test get best actor.
     */
    @Test
    public void testGetBestActor() {
        final double newMovieRating = 8.0;
        movieDatabase.addMovie(NEW_MOVIE, new String[]{ACTOR_1, ACTOR_2});
        movieDatabase.addRating(NEW_MOVIE, newMovieRating);


        final double oldMovieRating = 10.0;
        movieDatabase.addRating(OLD_MOVIE, oldMovieRating);
        movieDatabase.addMovie(OLD_MOVIE, new String[]{ACTOR_1});

        assertEquals(ACTOR_1, movieDatabase.getBestActor());
    }

    /**
     * Test get best movie.
     */
    @Test
    public void testGetBestMovie() {
        final double newMovieRating = 9.0;
        movieDatabase.addMovie(NEW_MOVIE, new String[]{ACTOR_2});
        movieDatabase.addRating(NEW_MOVIE, newMovieRating);


        final double oldMovieRating = 10.5;
        movieDatabase.addMovie(OLD_MOVIE, new String[]{ACTOR_1});
        movieDatabase.addRating(OLD_MOVIE, oldMovieRating);

        assertEquals(OLD_MOVIE, movieDatabase.getBestMovie());
    }

    /**
     * Test add movie with actor that exist.
     */
    @Test
    public void testAddMovieActorExist() {
        movieDatabase.addMovie(NEW_MOVIE, new String[]{ACTOR_1, ACTOR_2});
        final int expectedActorSize = 2;

        assertEquals(expectedActorSize, movieDatabase.getActorList().size());

        String actor3 = ACTOR_1;
        movieDatabase.addMovie(OLD_MOVIE, new String[]{ACTOR_1, ACTOR_2, actor3});

        assertEquals(expectedActorSize, movieDatabase.getActorList().size());
    }

    /**
     * Test add movie already exist.
     */
    @Test
    public void testAddMovieAlreadyExist() {
        movieDatabase.addMovie(NEW_MOVIE, new String[]{ACTOR_1, ACTOR_2});
        final int expectedMovieSize = 1;

        assertEquals(expectedMovieSize, movieDatabase.getMovieList().size());
        assertEquals(NEW_MOVIE, movieDatabase.getMovieList().get(0).getName());

        movieDatabase.addMovie(NEW_MOVIE, new String[]{ACTOR_1, ACTOR_2});

        assertEquals(expectedMovieSize, movieDatabase.getMovieList().size());
        assertEquals(NEW_MOVIE, movieDatabase.getMovieList().get(0).getName());
    }

    /**
     * Test update rating of a movie.
     */
    @Test
    public void testUpdateRating() {
        movieDatabase.addMovie(NEW_MOVIE, new String[]{ACTOR_1, ACTOR_2});
        final double firtRating = 10.0;
        final double finalRating = 9.5;
        movieDatabase.addRating(NEW_MOVIE, firtRating);
        movieDatabase.updateRating(NEW_MOVIE, finalRating);

        assertEquals(finalRating, movieDatabase.getMovieList().get(0).getRating(), 0.0);
    }

    /**
     * Test add movie.
     */
    @Test
    public void testAddMovieActor() {
        movieDatabase.addMovie(NEW_MOVIE, new String[]{ACTOR_1, ACTOR_2});
        final int expectedActorSize = 2;

        assertEquals(expectedActorSize, movieDatabase.getActorList().size());
    }

    /**
     * Test add movie with actors.
     */
    @Test
    public void testAddMovieMovie() {
        movieDatabase.addMovie(NEW_MOVIE, new String[]{ACTOR_1, ACTOR_2});
        final int expectedMovieSize = 1;

        assertEquals(expectedMovieSize, movieDatabase.getMovieList().size());
        assertEquals(NEW_MOVIE, movieDatabase.getMovieList().get(0).getName());
    }

    /**
     * Test add rating.
     */
    @Test
    public void testAddRating() {
        movieDatabase.addMovie(NEW_MOVIE, new String[]{ACTOR_1, ACTOR_2});
        final double rating = 10.0;
        movieDatabase.addRating(NEW_MOVIE, rating);

        assertEquals(rating, movieDatabase.getMovieList().get(0).getRating(), 0.0);
    }
}
