package org.minions.devfund.royrodriguez.movie;

import java.util.ArrayList;
import java.util.List;

/**
 * Actor class.
 */
public class Actor {
    private String name;
    private List<Movie> movies;

    /**
     * Gets Actor's name.
     *
     * @return actor's name string.
     */
    public String getName() {
        return name;
    }

    /**
     * Gets movies where the actor performs.
     *
     * @return List of movies.
     */
    public List getMovies() {
        return movies;
    }

    /**
     * Sets movies for an actor.
     *
     * @param movies list of movies.
     */
    public void setMovies(final List<Movie> movies) {
        this.movies = movies;
    }

    /**
     * Constructor.
     */
    public Actor() {
        movies = new ArrayList<>();
    }

    /**
     * Sets actor's name.
     *
     * @param name of the actor.
     */
    public void setName(final String name) {
        this.name = name;
    }

    /**
     * Gets average of movies' rating.
     *
     * @return average rating.
     */
    public double getAverageRating() {
        int count = movies.size();
        double sumRatings = movies.stream().mapToDouble(Movie::getRating).sum();
        return sumRatings / count;
    }
}
