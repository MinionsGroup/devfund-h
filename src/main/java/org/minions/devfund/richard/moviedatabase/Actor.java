package org.minions.devfund.richard.moviedatabase;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

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
        if (!newMovie.isMovieAlreadyAdded(this.movies)) {
            this.movies.add(newMovie);
        }
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
     * @param otherActor actor.
     * @return boolean.
     */
    private boolean actorEquals(final Actor otherActor) {
        return otherActor.getName().equals(this.getName());
    }

    /**
     * @param actorHash movieHash.
     * @return boolean.
     */
    public boolean isActorAlreadyAdded(final Set<Actor> actorHash) {
        for (Actor actor : actorHash) {
            if (this.actorEquals(actor)) {
                return true;
            }
        }
        return false;
    }

    /**
     * @param actorHash movieHash.
     * @return Actor.
     */
    Actor getActorAlreadyExist(final Set<Actor> actorHash) {
        return actorHash.stream()
                .filter(actor -> actor.actorEquals(this))
                .collect(Collectors.toList()).get(0);

    }

    /**
     * @param moviesHash moviesHash.
     * @return best movie.
     */
    String getBestMovie(final Set<Movie> moviesHash) {
        return moviesHash.stream()
                .max(Comparator.comparing(Movie::getRating))
                .orElse(new Movie())
                .getName();
    }

}
