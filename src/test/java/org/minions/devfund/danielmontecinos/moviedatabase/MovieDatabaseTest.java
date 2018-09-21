package org.minions.devfund.danielmontecinos.moviedatabase;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Tests MovieDatabase class.
 */
public class MovieDatabaseTest {
    private static final String MOVIE_7 = "Movie 7";
    private static final String ACTOR_7 = "Actor 7";
    private static final String MOVIE_10 = "Movie 10";
    private static final String ACTOR_5 = "Actor 5";
    private static final String MOVIE_1 = "Movie 1";
    private static final String ACTOR_1 = "Actor 1";
    private static final String ACTOR_2 = "Actor 2";
    private static final String ACTOR_3 = "Actor 3";
    private static final String ACTOR_4 = "Actor 4";
    private static final String ACTOR_6 = "Actor 6";
    private static final String ACTOR_9 = "Actor 9";
    private static final String ACTOR_10 = "Actor 10";
    private static final String MOVIE_2 = "Movie 2";
    private static final String ACTOR_21 = "Actor 21";
    private static final String ACTOR_12 = "Actor 12";
    private static final String ACTOR_43 = "Actor 43";
    private static final String ACTOR_111 = "Actor 111";
    private static final String ACTOR_78 = "Actor 78";
    private static final String BEST_MOVIE = "Best Movie";
    private static final String SO_SO_MOVIE = "So so Movie";
    private static final String WORST_MOVIE = "Worst Movie";
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
        movieDatabase.addMovie(MOVIE_1, new String[]{ACTOR_1, ACTOR_2, ACTOR_3});
        final int expectedSize = 1;

        assertEquals(MOVIE_1, movieDatabase.getMovieList().get(0).getName());
        assertEquals(expectedSize, movieDatabase.getMovieList().size());

        assertEquals(ACTOR_1, movieDatabase.getMovieList().get(0).getActors().get(0).getName());
        assertEquals(ACTOR_2, movieDatabase.getMovieList().get(0).getActors().get(1).getName());
        assertEquals(ACTOR_3, movieDatabase.getMovieList().get(0).getActors().get(2).getName());
    }

    /**
     * Tests that addMovie method doesn't add an exiting movie to movieList.
     */
    @Test
    public void testAddMovieMethodDoesNotAddSameMovies() {
        movieDatabase.addMovie(MOVIE_1, new String[]{ACTOR_1, ACTOR_2, ACTOR_3});
        movieDatabase.addMovie(MOVIE_1, new String[]{ACTOR_4, ACTOR_5, ACTOR_6});

        final int expectedSize = 1;
        assertEquals(expectedSize, movieDatabase.getMovieList().size());
    }

    /**
     * Tests that addMovie method can add different movies to movieList.
     */
    @Test
    public void testAddMovieMethodAddsDifferentMovies() {
        movieDatabase.addMovie("Movie 4", new String[]{ACTOR_7});
        movieDatabase.addMovie("Movie 5", new String[]{ACTOR_7, ACTOR_9});

        final int expectedSize = 2;
        assertEquals(expectedSize, movieDatabase.getMovieList().size());
    }

    /**
     * Tests addMovie method only adds new actors to actorList.
     */
    @Test
    public void testAddMovieMethodOnlyAddNewActorsToActorList() {
        movieDatabase.addMovie(MOVIE_1, new String[]{ACTOR_1, ACTOR_2, ACTOR_1, ACTOR_2});

        final int expectedSize = 2;
        assertEquals(expectedSize, movieDatabase.getActorList().size());
    }

    /**
     * Tests addMovie method doesn't add existing actors to actorList.
     */
    @Test
    public void testAddMovieMethodDoesNotAddSameActorsToActorList() {
        movieDatabase.addMovie("Movie 9", new String[]{ACTOR_1, ACTOR_2});
        movieDatabase.addMovie(MOVIE_7, new String[]{ACTOR_1, ACTOR_2});

        final int expectedSize = 2;
        assertEquals(expectedSize, movieDatabase.getActorList().size());
    }

    /**
     * Tests addRating method adds a rating value to movie instance.
     */
    @Test
    public void testAddRatingMethodAddsMovieRating() {
        final double actualRating = 98.0;
        movieDatabase.addMovie(MOVIE_7, new String[]{ACTOR_6});
        movieDatabase.addRating(MOVIE_7, actualRating);

        final double expectedRating = 98.0;
        assertEquals(expectedRating, movieDatabase.getMovieList().get(0).getRating(), 0.0);
    }

    /**
     * Tests that updateRating methods doesn't updated rating if value is same that actual rating.
     */
    @Test
    public void testAddRatingMethodWhenValueIsSameThanTheUsedBefore() {
        movieDatabase.addMovie(MOVIE_1, new String[] {ACTOR_1, ACTOR_2});

        final double updatedRating = 0.0;
        movieDatabase.updateRating(MOVIE_1, updatedRating);
        assertEquals(updatedRating, movieDatabase.getMovieList().get(0).getRating(), 0.0);
    }

    /**
     * Tests that updateRating methods updates rating previously set.
     */
    @Test
    public void testUpdateRatingMethodUpdatesMovieRatingSetsBeforeUseIt() {
        movieDatabase.addMovie(MOVIE_10, new String[]{ACTOR_10});
        final double actualRating = 85.0;
        movieDatabase.addRating(MOVIE_10, actualRating);

        final double updatedRating = 100.0;
        movieDatabase.updateRating(MOVIE_10, updatedRating);

        final double expectedRating = 100.0;
        assertEquals(expectedRating, movieDatabase.getMovieList().get(0).getRating(), 0.0);
    }

    /**
     * Tests getBestActor method returns the actor with highest rating.
     */
    @Test
    public void testGetBestActorReturnsTheActorWithHighestRating() {
        final double midRating = 70.0;
        movieDatabase.addMovie(MOVIE_1, new String[]{ACTOR_1, ACTOR_7});
        movieDatabase.addRating(MOVIE_1, midRating);

        final double worstRating = 20.0;
        movieDatabase.addMovie(MOVIE_2, new String[]{ACTOR_9});
        movieDatabase.addRating(MOVIE_2, worstRating);

        final double bestRating = 100.0;
        movieDatabase.addMovie(MOVIE_7, new String[]{ACTOR_5});
        movieDatabase.addRating(MOVIE_7, bestRating);
        assertEquals(ACTOR_5, movieDatabase.getBestActor());
    }

    /**
     * Tests getBestMovie returns movie with highest rating.
     */
    @Test
    public void testGetsBesMovieReturnsTheMovieWithHighestRating() {
        final double bestRating = 100.0;
        movieDatabase.addMovie(BEST_MOVIE, new String[]{ACTOR_1, ACTOR_2, ACTOR_21});
        movieDatabase.addRating(BEST_MOVIE, bestRating);

        final double midRating = 50.0;
        movieDatabase.addMovie(SO_SO_MOVIE, new String[]{ACTOR_7, ACTOR_12, ACTOR_43});
        movieDatabase.addRating(SO_SO_MOVIE, midRating);

        final double worstRating = 5.0;
        movieDatabase.addMovie(WORST_MOVIE, new String[]{ACTOR_111, ACTOR_78});
        movieDatabase.addRating(WORST_MOVIE, worstRating);
        assertEquals(BEST_MOVIE, movieDatabase.getBestMovie());
    }
}
