package org.minions.devfund.abel.moviedatabase;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Class for Movie Database Unit Tests.
 */
public class MovieDatabaseTest {

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
        final String expectedMovie = "NewMovie";
        final String firstActor = "Actor1";
        final String secondActor = "Actor2";
        final int expectedmoviesSize = 1;
        final int expectedActorsSize = 2;

        movieDatabase.addMovie(expectedMovie, new String[]{firstActor, secondActor});
        final int actualMoviesSize = movieDatabase.getMovieList().size();
        final String actualMovie = movieDatabase.getMovieList().get(0).getName();
        final int actualActorsSize = movieDatabase.getActorList().size();

        assertEquals(expectedmoviesSize, actualMoviesSize);
        assertEquals(expectedMovie, actualMovie);
        assertEquals(expectedActorsSize, actualActorsSize);
    }

    /**
     * Test AddMovie.
     */
    @Test
    public void testAddMovieAlreadyAdded() {
        final String expectedMovie = "NewMovie";
        final String firstActor = "Actor1";
        final String secondActor = "Actor2";
        final int expectedMoviesSize = 1;
        final int expectedActorsSize = 2;

        movieDatabase.addMovie(expectedMovie, new String[]{firstActor, secondActor});
        movieDatabase.addMovie(expectedMovie, new String[]{firstActor, secondActor});
        final int actualMoviesSize = movieDatabase.getMovieList().size();
        final String actualMovie = movieDatabase.getMovieList().get(0).getName();
        final int actualActorsSize = movieDatabase.getActorList().size();

        assertEquals(expectedMoviesSize, actualMoviesSize);
        assertEquals(expectedMovie, actualMovie);
        assertEquals(expectedActorsSize, actualActorsSize);
    }

    /**
     * Test AddMovie.
     */
    @Test
    public void testAddMovieNewActors() {
        final String expectedMovie = "NewMovie";
        final String secondMovie = "NewMovie2";
        final String firstActor = "Actor1";
        final String secondActor = "Actor2";
        final String thirdActor = "Actor3";
        final int expectedMoviesSize = 2;
        final int expectedActorsSize = 3;

        movieDatabase.addMovie(expectedMovie, new String[]{firstActor, secondActor});
        movieDatabase.addMovie(secondMovie, new String[]{firstActor, secondActor, thirdActor});
        final int actualMoviesSize = movieDatabase.getMovieList().size();
        final String actualMovie = movieDatabase.getMovieList().get(0).getName();
        final int actualActorsSize = movieDatabase.getActorList().size();

        assertEquals(expectedMoviesSize, actualMoviesSize);
        assertEquals(expectedMovie, actualMovie);
        assertEquals(expectedActorsSize, actualActorsSize);
    }

    /**
     * Test AddRating.
     */
    @Test
    public void testAddRatingNewMovie() {
        final String newMovie = "NewMovie";
        final String firstActor = "Actor1";
        final String secondActor = "Actor2";
        final double expectedRating = 10.0;

        movieDatabase.addMovie(newMovie, new String[]{firstActor, secondActor});
        movieDatabase.addRating(newMovie, expectedRating);
        final double actualRating = movieDatabase.getMovieList().get(0).getRating();

        assertEquals(expectedRating, actualRating, 0.0);
    }

    /**
     * Test UpdateRating.
     */
    @Test
    public void testUpdateRatingToExistingMovie() {
        final String newMovie = "NewMovie";
        final String firstActor = "Actor1";
        final String secondActor = "Actor2";
        final double initialRating = 10.0;
        final double expectedRating = 15.0;

        movieDatabase.addMovie(newMovie, new String[]{firstActor, secondActor});
        movieDatabase.addRating(newMovie, initialRating);
        movieDatabase.updateRating(newMovie, expectedRating);
        final double actualRating = movieDatabase.getMovieList().get(0).getRating();

        assertEquals(expectedRating, actualRating, 0.0);
    }

    /**
     * Test GetBestActor.
     */
    @Test
    public void testGetBestActor() {
        final String firstMovie = "NewMovie";
        final String secondMovie = "NewMovie2";
        final String expectedBestActor = "Actor1";
        final String secondActor = "Actor2";
        final double firstMovieRating = 10.0;
        final double secondMovieRating = 15.0;

        movieDatabase.addMovie(firstMovie, new String[]{expectedBestActor, secondActor});
        movieDatabase.addMovie(secondMovie, new String[]{expectedBestActor});
        movieDatabase.addRating(firstMovie, firstMovieRating);
        movieDatabase.addRating(secondMovie, secondMovieRating);
        final String actualBestActor = movieDatabase.getBestActor();

        assertEquals(expectedBestActor, actualBestActor);
    }

    /**
     * Test GetBestMovie.
     */
    @Test
    public void testGetBestMovie() {
        final String firstMovie = "NewMovie";
        final String expectedBestMovie = "NewMovie2";
        final String firstActor = "Actor1";
        final String secondActor = "Actor2";
        final double firstMovieRating = 10.0;
        final double secondMovieRating = 15.0;

        movieDatabase.addMovie(firstMovie, new String[]{firstActor, secondActor});
        movieDatabase.addMovie(expectedBestMovie, new String[]{firstActor});
        movieDatabase.addRating(firstMovie, firstMovieRating);
        movieDatabase.addRating(expectedBestMovie, secondMovieRating);
        final String actualBestMovie = movieDatabase.getBestMovie();

        assertEquals(expectedBestMovie, actualBestMovie);
    }
}
