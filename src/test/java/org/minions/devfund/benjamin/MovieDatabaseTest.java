package org.minions.devfund.benjamin;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
/**
 * Class to test MovieDatabase class.
 */
public class MovieDatabaseTest {
    /**
     * Test Add a new movie and actors.
     */
    @Test
    public void testAddMovieNewMovieAndActors() {
        MovieDatabase movieDatabase = new MovieDatabase();
        String newMovie = "Batman Forever";
        movieDatabase.addMovie(newMovie, new String[]{"Crhistian Bale", "Morgan Freeman"});
        assertEquals(1, movieDatabase.getMovieList().size());
        assertEquals(newMovie, movieDatabase.getMovieList().get(0).getName());
        assertEquals(2, movieDatabase.getActorList().size());
    }

    /**
     * Test add movie that already exist.
     */
    @Test
    public void testAddMovieAlreadyExist() {
        MovieDatabase movieDatabase = new MovieDatabase();
        String newMovie = "Batman Forever";
        movieDatabase.addMovie(newMovie, new String[]{"Crhistian Bale", "Morgan Freeman"});
        movieDatabase.addMovie(newMovie, new String[]{"Crhistian Bale", "Morgan Freeman"});
        assertEquals(1, movieDatabase.getMovieList().size());
        assertEquals(newMovie, movieDatabase.getMovieList().get(0).getName());
        assertEquals(2, movieDatabase.getActorList().size());
    }

    /**
     * Test add rating.
     */
    @Test
    public void testAddRatingNewMovie() {
        MovieDatabase movieDatabase = new MovieDatabase();
        String newMovie = "Batman Forever";
        movieDatabase.addMovie(newMovie, new String[]{"Crhistian Bale", "Morgan Freeman"});
        final double ten = 10.0;
        movieDatabase.addRating(newMovie, ten);
        assertEquals(ten, movieDatabase.getMovieList().get(0).getRating(), 0.0);
    }

    /**
     * Test update rating.
     */
    @Test
    public void testUpdateRating() {
        MovieDatabase movieDatabase = new MovieDatabase();
        String newMovie = "Batman Forever";
        movieDatabase.addMovie(newMovie, new String[]{"Crhistian Bale", "Morgan Freeman"});
        final double ten = 10.0;
        final double fifteen = 15.0;
        movieDatabase.addRating(newMovie, ten);
        movieDatabase.updateRating(newMovie, fifteen);
        assertEquals(fifteen, movieDatabase.getMovieList().get(0).getRating(), 0.0);
    }

    /**
     * Test get best actor.
     */
    @Test
    public void testGetBestActor() {
        MovieDatabase movieDatabase = new MovieDatabase();
        String newMovie = "Batman Forever";
        String newMovie2 = "NewMovie2";
        movieDatabase.addMovie(newMovie, new String[]{"Crhistian Bale", "Morgan Freeman"});
        movieDatabase.addMovie(newMovie2, new String[]{"Crhistian Bale"});
        final double ten = 10.0;
        final double fifteen = 15.0;
        movieDatabase.addRating(newMovie, ten);
        movieDatabase.addRating(newMovie2, fifteen);
        assertEquals("Crhistian Bale", movieDatabase.getBestActor());
    }

    /**
     * Test get best movie.
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
        MovieDatabase movieDatabase = new MovieDatabase();
        movieDatabase.addMovie(expectedMovie, new String[]{firstActor, secondActor});
        movieDatabase.addMovie(secondMovie, new String[]{firstActor, secondActor, thirdActor});
        final int actualMoviesSize = movieDatabase.getMovieList().size();
        final String actualMovie = movieDatabase.getMovieList().get(0).getName();
        final int actualActorsSize = movieDatabase.getActorList().size();
        assertEquals(expectedMoviesSize, actualMoviesSize);
        assertEquals(expectedMovie, actualMovie);
        assertEquals(expectedActorsSize, actualActorsSize);
    }
}
