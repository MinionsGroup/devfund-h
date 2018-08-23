package org.minions.devfund.david.movie;

import java.util.ArrayList;
import java.util.List;

/**
 * Class Actor.
 */
public class Actor {

    private String name;
    private List<Movie> movies;

    /**
     * Constructor Actor class.
     */
    public Actor() {
        movies = new ArrayList<>();
    }

    /**
     * Gets Actor name.
     *
     * @return name as string.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets Actor name.
     *
     * @param name of Actor.
     */
    public void setName(final String name) {
        this.name = name;
    }

    /**
     * Gets Movies of each actor.
     *
     * @return Movies as Array list.
     */
    public List<Movie> getMovies() {
        return movies;
    }

    /**
     * Sets movie name.
     *
     * @param name of movie.
     */
    public void setMovies(final String name) {
        Movie movie = new Movie();
        movie.setName(name);
        movies.add(movie);
    }

    /**
     * Gets Average of Actor base movie rating.
     *
     * @return rating.
     */
    public double getAverage() {
        return getMovies().stream().mapToDouble(Movie::getRating).average().orElse(0.0);
    }
}
