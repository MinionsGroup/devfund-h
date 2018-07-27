package org.minions.devfund.reinaldo.movie;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by reinaldo on 26-07-18.
 */
public class MovieDatabaseTest {

    private static final int FIRST_MOVIE = 0;
    private static final double PARAMETER_FOR_DOUBLE = 0;
    public static final String THE_PIANIST2 = "The Pianist2";

    /**
     * Get best actor in the collection.
     */
    @Test
    public void testGetBestActor() {
        final MovieDatabase movieDatabase = new MovieDatabase();

        final String movie1 = "Monster";
        final String[] movie1WithActors = {"Denzel Washington"};
        final int movie1WithRating = 20;

        final String movie2 = "The Pianist";
        final String[] movie2WithActors = new String[]{"Adrien Brody", "Chris Pine"};
        final int movie2WithRating = 5;

        final String expectedBestActor = "Denzel Washington";
        movieDatabase.addMovie(movie1, movie1WithActors);
        movieDatabase.addMovie(movie2, movie2WithActors);
        movieDatabase.updateRating(movie1, movie1WithRating);
        movieDatabase.updateRating(movie2, movie2WithRating);
        assertEquals(expectedBestActor, movieDatabase.getBestActor());
    }

    /**
     * Get best movie in the collection.
     */
    @Test
    public void testGetBestMovie() {
        final MovieDatabase movieDatabase = new MovieDatabase();

        final String movie1 = "Monster";
        final String[] movie1WithActors = {"Denzel Washington", "Charlize Theron"};
        final int movie1WithRating = 20;

        final String movie2 = "The Pianist";
        final String[] movie2WithActors = new String[]{"Adrien Brody", "Chris Pine"};
        final int movie2WithRating = 5;

        final String expectedBestMovie = "Monster";

        movieDatabase.addMovie(movie1, movie1WithActors);
        movieDatabase.addMovie(movie2, movie2WithActors);
        movieDatabase.updateRating(movie1, movie1WithRating);
        movieDatabase.updateRating(movie2, movie2WithRating);
        assertEquals(expectedBestMovie, movieDatabase.getBestMovie());
    }

    /**
     * Add new movie and actor in the collection.
     */
    @Test
    public void testAddMovieActorExist() {
        final MovieDatabase movieDatabase = new MovieDatabase();
        final String movieOld = THE_PIANIST2;
        final String[] actors = {"Anne Hathaway1", "Matthew McConaughey1"};

        final String movieNew = THE_PIANIST2;
        final String[] actorsNew = {"Anne Hathaway"};

        final int expectedMovieListSize = 1;
        final int expectedActorsListSize = 2;
        movieDatabase.addMovie(movieOld, actors);
        movieDatabase.addMovie(movieNew, actorsNew);

        assertEquals(expectedMovieListSize, movieDatabase.getMovieList().size());
        assertEquals(expectedActorsListSize, movieDatabase.getActorList().size());
    }

    /**
     * Add the same movie in the collection.
     */
    @Test
    public void testAddMovieAlreadyExist() {
        final MovieDatabase movieDatabase = new MovieDatabase();
        final String movie = THE_PIANIST2;
        final String[] actors = {"Anne Hathaway2", "Matthew McConaughey2"};

        final int expectedMovieListSize = 1;
        final int expectedActorsListSize = 2;

        movieDatabase.addMovie(movie, actors);
        movieDatabase.addMovie(movie, actors);

        assertEquals(expectedMovieListSize, movieDatabase.getMovieList().size());
        assertEquals(expectedActorsListSize, movieDatabase.getActorList().size());
    }

    /**
     * Updated the movie rating.
     */
    @Test
    public void testUpdateRating() {
        final MovieDatabase movieDatabase = new MovieDatabase();
        final String movie = THE_PIANIST2;
        final String[] actors = {"Anne Hathaway3", "Matthew McConaughey3"};
        final int newRating = 10;
        final int updateRating = 20;

        movieDatabase.addMovie(movie, actors);
        movieDatabase.addRating(movie, newRating);
        movieDatabase.addRating(movie, updateRating);
        assertEquals(updateRating, movieDatabase.getMovieList().get(FIRST_MOVIE).getRating(), PARAMETER_FOR_DOUBLE);
    }

    /**
     * Add the movie rating.
     */
    @Test
    public void testAddRating() {
        final MovieDatabase movieDatabase = new MovieDatabase();
        final String movie = THE_PIANIST2;
        final String[] actors = {"Anne Hathaway4", "Matthew McConaughey4"};
        final int newRating = 10;

        movieDatabase.addMovie(movie, actors);
        movieDatabase.addRating(movie, newRating);
        assertEquals(newRating, movieDatabase.getMovieList().get(FIRST_MOVIE).getRating(), PARAMETER_FOR_DOUBLE);
    }

    /**
     * Test empty actors and movies lists.
     */
    @Test
    public void testForMovieAndActorAreEmpty() {
        final MovieDatabase movieDatabase = new MovieDatabase();
        assertTrue(movieDatabase.getMovieList().isEmpty());
        assertTrue(movieDatabase.getActorList().isEmpty());
    }
}
