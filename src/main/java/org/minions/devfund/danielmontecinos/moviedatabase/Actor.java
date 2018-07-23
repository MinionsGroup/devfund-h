package org.minions.devfund.danielmontecinos.moviedatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Creates Actor objects.
 */
public class Actor {
    private String name;
    private List<Movie> movies;

    /**
     * Creates an instance of {@link Actor}.
     */
    public Actor() {
        movies = new ArrayList<>();
    }

    /**
     * Return name instance.
     *
     * @return name assigned to actor object.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets value for name instance.
     *
     * @param name as String.
     */
    public void setName(final String name) {
        this.name = name;
    }

    /**
     * Gets movie instance.
     *
     * @return list of Movie objects.
     */
    public List<Movie> getMovies() {
        return movies;
    }

    /**
     * Create a new movie object, adds name ann object to movies list.
     *
     * @param name as String.
     */
    public void setMovie(final String name) {
        Movie movie = new Movie();
        movie.setName(name);
        movies.add(movie);
    }
}
