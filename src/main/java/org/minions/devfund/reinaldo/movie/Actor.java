package org.minions.devfund.reinaldo.movie;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by reinaldo on 25-07-18.
 */
public class Actor {
    private String name;
    private List<Movie> movies;

    /**
     * Constructor for the Actor Class.
     *
     * @param name actor.
     */
    public Actor(final String name) {
        this.name = name;
        movies = new ArrayList<>();
    }

    /**
     * Gets the name for the autor.
     * @return string autor name.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the autor name.
     * @param name value autor name.
     */
    public void setName(final String name) {
        this.name = name;
    }

    /**
     * Gets the collection movies.
     * @return list for movie save.
     */
    public List<Movie> getMovies() {
        return movies;
    }

    /**
     * Set a movie in the list.
     * @param movies list of the movie for the autor.
     */
    public void setMovies(final List<Movie> movies) {
        this.movies = movies;
    }

    /**
     * Rating averages of the actor on the list.
     *
     * @return movie rating average.
     */
    public double movieRatingAverage() {
        return movies.stream()
                .collect(Collectors.averagingDouble(Movie::getRating));
    }
}
