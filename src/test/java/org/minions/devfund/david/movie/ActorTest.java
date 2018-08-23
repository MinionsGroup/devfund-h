package org.minions.devfund.david.movie;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

/**
 * Actor unit tests class.
 */
public class ActorTest {

    private static final String NEW_ACTOR = "Actor1";
    private static final String NEW_MOVIE = "Movie1";
    private static final String OLD_MOVIE = "Movie2";
    private Actor actor;

    /**
     * Setup Actor.
     */
    @Before
    public void setupActor() {
        actor = new Actor();
    }

    /**
     * Gets actor name test.
     */
    @Test
    public void getName() {
        assertNull(actor.getName());
    }

    /**
     * Sets actor name test.
     */
    @Test
    public void setName() {
        actor.setName(NEW_ACTOR);
        assertEquals(NEW_ACTOR, actor.getName());
    }

    /**
     * Gets movies objects test.
     */
    @Test
    public void getMovies() {
        assertTrue(actor.getMovies().isEmpty());
    }

    /**
     * Sets movies test.
     */
    @Test
    public void setMovies() {
        actor.setMovies(OLD_MOVIE);
        actor.setMovies(NEW_MOVIE);
        int expected = 2;

        assertEquals(expected, actor.getMovies().size());
    }

    /**
     * Gets average test.
     */
    @Test
    public void getAverage() {
        double expected = 0.0;
        assertEquals(expected, actor.getAverage(), 0.0);
    }
}
