package org.minions.devfund.richard.moviedatabase;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;


/**
 * Test Class.
 */
public class ActorTest {

    private Actor actor;

    /**
     * Before.
     */
    @Before
    public void setUp() {
        actor = new Actor();
    }

    /**
     * Test.
     */
    @Test
    public void testAddMovieAlreadyExist() {
        final Movie movie1 = new Movie();
        final Movie movie2 = new Movie();
        movie1.setName("Movie1");
        movie2.setName("Movie2");
        actor.setMovies(movie1);
        actor.setMovies(movie2);
        actor.setMovies(movie1);
        assertEquals(2, actor.getMovies().size());
        assertEquals("Movie1", actor.getMovies().get(0).getName());
        assertEquals("Movie2", actor.getMovies().get(1).getName());
    }

    /**
     * Test.
     */
    @Test
    public void testEquals() {
        assertFalse(actor.equals(null));
        assertFalse(actor.equals(new Movie()));
    }

}
