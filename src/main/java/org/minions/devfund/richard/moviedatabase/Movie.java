package org.minions.devfund.richard.moviedatabase;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 * Class.
 */
public class Movie {

    private String name;
    private Set<Actor> actors;
    private double rating;

    /**
     * Constructor.
     */
    Movie() {
        this.actors = new LinkedHashSet<>();
    }

    /**
     * @return Movie name.
     */
    String getName() {
        return this.name;
    }

    /**
     * @param name Movie name.
     * @return Movie
     */
    Movie setName(final String name) {
        this.name = name;
        return this;
    }

    /**
     * @param newActor Actor.
     * @return Actor.
     */
    Movie setActors(final Actor newActor) {
        this.actors.add(newActor);
        return this;
    }

    /**
     * @param rating rating.
     */
    void setRating(double rating) {
        this.rating = rating;
    }

    /**
     * @return rating.
     */
    double getRating() {
        return rating;
    }

    /**
     * @return List of actors.
     */
    List<Actor> getActors() {
        return new ArrayList<>(actors);
    }


    /**
     * @param otherMovie movie.
     * @return boolean.
     */
    private boolean movieEquals(final Movie otherMovie) {
        return otherMovie.getName().equals(this.getName());
    }

    /**
     * @param movieHash movieHash.
     * @return boolean.
     */
    public boolean isMovieAlreadyAdded(final Set<Movie> movieHash) {
        for (Movie movie : movieHash) {
            if (this.movieEquals(movie)) {
                return true;
            }
        }
        return false;
    }
}
