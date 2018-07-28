package org.minions.devfund.richard.moviedatabase;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 * Class.
 */
public class Actor {

    private String name;
    private Set<Movie> movies;
    private double rating;

    /**
     * Constructor.
     */
    Actor() {
        this.name = "";
        this.rating = 0.0;
        this.movies = new LinkedHashSet<>();
    }

    /**
     * @return Actor name.
     */
    String getName() {
        return this.name;
    }

    /**
     * @param newMovie movie.
     * @return Actor.
     */
    Actor setMovies(final Movie newMovie) {
        movies.add(newMovie);
        return this;
    }

    /**
     * @return Actor rating.
     */
    double getRating() {
        return rating;
    }

    /**
     * @param name actor name.
     * @return Actor.
     */
    Actor setName(final String name) {
        this.name = name;
        return this;
    }

    /**
     * @return Movies List.
     */
    List<Movie> getMovies() {
        return new ArrayList<>(movies);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(final Object obj) {
        if (obj == null || this.getClass() != obj.getClass()) {
            return false;
        }
        return this.getName().equals(((Actor) obj).getName());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
