package org.minions.devfund.abel.moviedatabase;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Class for Movie Database Unit Tests.
 */
public class MovieDatabaseTest {

    /**
     * Test AddMovie.
     */
    @Test
    public void testAddMovieNewMovieAndActors() {
        MovieDatabase movieDatabase = new MovieDatabase();
        String newMovie = "NewMovie";
        movieDatabase.addMovie(newMovie, new String[]{"Actor1", "Actor2"});

        assertEquals(1, movieDatabase.getMovieList().size());
        assertEquals(newMovie, movieDatabase.getMovieList().get(0).getName());
        assertEquals(2, movieDatabase.getActorList().size());
    }

    /**
     * Test AddMovie.
     */
    @Test
    public void testAddMovieAlreadyAdded() {
        MovieDatabase movieDatabase = new MovieDatabase();
        String newMovie = "NewMovie";
        movieDatabase.addMovie(newMovie, new String[]{"Actor1", "Actor2"});
        movieDatabase.addMovie(newMovie, new String[]{"Actor1", "Actor2"});

        assertEquals(1, movieDatabase.getMovieList().size());
        assertEquals(newMovie, movieDatabase.getMovieList().get(0).getName());
        assertEquals(2, movieDatabase.getActorList().size());
    }

    /**
     * Test AddMovie.
     */
    @Test
    public void testAddMovieNewActors() {
        MovieDatabase movieDatabase = new MovieDatabase();
        String newMovie = "NewMovie";
        String secondMovie = "SecondMovie";
        movieDatabase.addMovie(newMovie, new String[]{"Actor1", "Actor2"});
        movieDatabase.addMovie(secondMovie, new String[]{"Actor1", "Actor2", "Actor3"});
        final int three = 3;

        assertEquals(2, movieDatabase.getMovieList().size());
        assertEquals(newMovie, movieDatabase.getMovieList().get(0).getName());
        assertEquals(three, movieDatabase.getActorList().size());
    }

    /**
     * Test AddRating.
     */
    @Test
    public void testAddRatingNewMovie() {
        MovieDatabase movieDatabase = new MovieDatabase();
        String newMovie = "NewMovie";
        movieDatabase.addMovie(newMovie, new String[]{"Actor1", "Actor2"});
        final double ten = 10.0;
        movieDatabase.addRating(newMovie, ten);

        assertEquals(ten, movieDatabase.getMovieList().get(0).getRating(), 0.0);
    }

    /**
     * Test UpdateRating.
     */
    @Test
    public void testUpdateRatingToExistingMovie() {
        MovieDatabase movieDatabase = new MovieDatabase();
        String newMovie = "NewMovie";
        movieDatabase.addMovie(newMovie, new String[]{"Actor1", "Actor2"});
        final double ten = 10.0;
        final double fifteen = 15.0;
        movieDatabase.addRating(newMovie, ten);
        movieDatabase.updateRating(newMovie, fifteen);

        assertEquals(fifteen, movieDatabase.getMovieList().get(0).getRating(), 0.0);
    }

    /**
     * Test GetBestActor.
     */
    @Test
    public void testGetBestActor() {
        MovieDatabase movieDatabase = new MovieDatabase();
        String newMovie = "NewMovie";
        String newMovie2 = "NewMovie2";
        movieDatabase.addMovie(newMovie, new String[]{"Actor1", "Actor2"});
        movieDatabase.addMovie(newMovie2, new String[]{"Actor1"});
        final double ten = 10.0;
        final double fifteen = 15.0;
        movieDatabase.addRating(newMovie, ten);
        movieDatabase.addRating(newMovie2, fifteen);

        assertEquals("Actor1", movieDatabase.getBestActor());
    }

    /**
     * Test GetBestMovie.
     */
    @Test
    public void testGetBestMovie() {
        MovieDatabase movieDatabase = new MovieDatabase();
        String newMovie = "NewMovie";
        String newMovie2 = "NewMovie2";
        movieDatabase.addMovie(newMovie, new String[]{"Actor1", "Actor2"});
        movieDatabase.addMovie(newMovie2, new String[]{"Actor1"});
        final double ten = 10.0;
        final double fifteen = 15.0;
        movieDatabase.addRating(newMovie, ten);
        movieDatabase.addRating(newMovie2, fifteen);

        assertEquals("NewMovie2", movieDatabase.getBestMovie());
    }
}
