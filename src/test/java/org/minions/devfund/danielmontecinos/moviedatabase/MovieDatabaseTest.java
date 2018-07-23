package org.minions.devfund.danielmontecinos.moviedatabase;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Tests MovieDatabase class.
 */
public class MovieDatabaseTest {
    private MovieDatabase movieDatabase;

    /**
     * Creates a MovieDatabase object.
     */
    @Before
    public void setUp() {
        movieDatabase = new MovieDatabase();
    }

    /**
     * Tests movieList is empty when no movie is added.
     */
    @Test
    public void testGetMovieListIsEmptyWhenNoMoviesAreAdded() {
        assertTrue(movieDatabase.getMovieList().isEmpty());
    }

    /**
     * Tests actorList is empty when no movie is added.
     */
    @Test
    public void testGetActorListIsEmptyWhenNoMoviesAreAdded() {
        assertTrue(movieDatabase.getActorList().isEmpty());
    }

    /**
     * Tests addMovie method add movie names and movie actors.
     */
    @Test
    public void testAddMovieMethodAddsANewMovieWithAListOfActors() {
        movieDatabase.addMovie("Movie 1", new String[]{"Actor 1", "Actor 2", "Actor 3"});
        final int expectedSize = 1;

        assertEquals("Movie 1", movieDatabase.getMovieList().get(0).getName());
        assertEquals(expectedSize, movieDatabase.getMovieList().size());

        assertEquals("Actor 1", movieDatabase.getMovieList().get(0).getActors().get(0).getName());
        assertEquals("Actor 2", movieDatabase.getMovieList().get(0).getActors().get(1).getName());
        assertEquals("Actor 3", movieDatabase.getMovieList().get(0).getActors().get(2).getName());
    }

    /**
     * Tests that addMovie method doesn't add an exiting movie to movieList.
     */
    @Test
    public void testAddMovieMethodDoesNotAddSameMovies() {
        movieDatabase.addMovie("Movie 1", new String[]{"Actor 1", "Actor 2", "Actor 3"});
        movieDatabase.addMovie("Movie 1", new String[]{"Actor 4", "Actor 5", "Actor 6"});

        final int expectedSize = 1;
        assertEquals(expectedSize, movieDatabase.getMovieList().size());
    }

    /**
     * Tests that addMovie method can add different movies to movieList.
     */
    @Test
    public void testAddMovieMethodAddsDifferentMovies() {
        movieDatabase.addMovie("Movie 4", new String[]{"Actor 7"});
        movieDatabase.addMovie("Movie 5", new String[]{"Actor 7", "Actor 9"});

        final int expectedSize = 2;
        assertEquals(expectedSize, movieDatabase.getMovieList().size());
    }

    /**
     * Tests addMovie method only adds new actors to actorList.
     */
    @Test
    public void testAddMovieMethodOnlyAddNewActorsToActorList() {
        movieDatabase.addMovie("Movie 1", new String[] {"Actor 1", "Actor 2", "Actor 1", "Actor 2"});

        final int expectedSize = 2;
        assertEquals(expectedSize, movieDatabase.getActorList().size());
    }

    /**
     * Tests addMovie method doesn't add existing actors to actorList.
     */
    @Test
    public void testAddMovieMethodDoesNotAddSameActorsToActorList() {
        movieDatabase.addMovie("Movie 9", new String[]{"Actor 1", "Actor 2"});
        movieDatabase.addMovie("Movie 7", new String[]{"Actor 1", "Actor 2"});

        final int expectedSize = 2;
        assertEquals(expectedSize, movieDatabase.getActorList().size());
    }

    /**
     * Tests addRating method adds a rating value to movie instance.
     */
    @Test
    public void testAddRatingMethodAddsMovieRating() {
        final double actualRating = 98.0;
        movieDatabase.addMovie("Movie 7", new String[] {"Actor 6"});
        movieDatabase.addRating("Movie 7", actualRating);

        final double expectedRating = 98.0;
        assertEquals(expectedRating, movieDatabase.getMovieList().get(0).getRating(), 0.0);
    }

    /**
     * Tests that updateRating methods updates rating previously set.
     */
    @Test
    public void testUpdateRatingMethodUpdatesMovieRatingSetsBeforeUseIt() {
        movieDatabase.addMovie("Movie 10", new String[] {"Actor 10"});
        final double actualRating = 85.0;
        movieDatabase.addRating("Movie 10", actualRating);

        final double updatedRating = 100.0;
        movieDatabase.updateRating("Movie 10", updatedRating);

        final double expectedRating = 100.0;
        assertEquals(expectedRating, movieDatabase.getMovieList().get(0).getRating(), 0.0);
    }

    /**
     * Tests getBestActor method returns the actor with highest rating.
     */
    @Test
    public void testGetBestActorReturnsTheActorWithHighestRating() {
        final double midRating = 70.0;
        movieDatabase.addMovie("Movie 1", new String[] {"Actor 1", "Actor 7"});
        movieDatabase.addRating("Movie 1", midRating);

        final double worstRating = 20.0;
        movieDatabase.addMovie("Movie 2", new String[] {"Actor 9"});
        movieDatabase.addRating("Movie 2", worstRating);

        final double bestRating = 100.0;
        movieDatabase.addMovie("Movie 7", new String[] {"Actor 5"});
        movieDatabase.addRating("Movie 7", bestRating);
        assertEquals("Actor 5", movieDatabase.getBestActor());
    }

    /**
     * Tests getBestMovie returns movie with highest rating.
     */
    @Test
    public void testGetsBesMovieReturnsTheMovieWithHighestRating() {
        final double bestRating = 100.0;
        movieDatabase.addMovie("Best Movie", new String[] {"Actor 1", "Actor 2", "Actor 21"});
        movieDatabase.addRating("Best Movie", bestRating);

        final double midRating = 50.0;
        movieDatabase.addMovie("So so Movie", new String[] {"Actor 7", "Actor 12", "Actor 43"});
        movieDatabase.addRating("So so Movie", midRating);

        final double worstRating = 5.0;
        movieDatabase.addMovie("Worst Movie", new String[] {"Actor 111", "Actor 78"});
        movieDatabase.addRating("Worst Movie", worstRating);
        assertEquals("Best Movie", movieDatabase.getBestMovie());
    }
}
