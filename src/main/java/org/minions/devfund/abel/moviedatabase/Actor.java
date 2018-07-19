package org.minions.devfund.abel.moviedatabase;

import java.util.HashSet;
import java.util.Set;

/**
 * Class to handle Actors.
 */
public class Actor {

    private String name;
    private Set<Movie> movies;

    /**
     * Default Constructor.
     */
    public Actor() {
        this.movies = new HashSet<>();
    }

    /**
     * Get Actor name.
     *
     * @return String.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the Actor name.
     *
     * @param name String.
     */
    public void setName(final String name) {
        this.name = name;
    }

    /**
     * Add a new movie to the Movies Set.
     *
     * @param movieName String.
     */
    public void addMovie(final String movieName) {
        Movie movie = new Movie();
        movie.setName(movieName);
        movies.add(movie);
    }

    /**
     * Get the movie's average rating.
     *
     * @return double.
     */
    public double getAverage() {
        return movies.stream()
                .mapToDouble(Movie::getRating)
                .average()
                .orElse(Double.NaN);
    }
}
