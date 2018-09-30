package org.minions.devfund.benjamin;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Class to test Actor class.
 */
public class ActorTest {

    /**
     * Test setName function.
     */
    @Test
    public void testSetName() {
        Actor actor = new Actor();
        final String name = "Morgan Freeman";
        actor.setName(name);
        assertEquals(name, actor.getName());
    }

    /**
     * Test addMovie function.
     */
    @Test
    public void testAddMovie() {
        Actor actor = new Actor();
        final String movieName = "Batman - Dark of night";
        actor.addMovie(movieName);

        assertEquals(movieName, actor.getMovies().get(0).getName());
    }
}
