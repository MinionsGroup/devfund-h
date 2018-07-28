package org.minions.devfund.richard.moviedatabase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 * Class.
 */
public class MovieDatabase {

    private Set<Movie> movieHash;
    private Set<Actor> actorHash;

    /**
     * Constructor.
     */
    MovieDatabase() {
        movieHash = new LinkedHashSet<>();
        actorHash = new LinkedHashSet<>();
    }

    /**
     * @param name   Movie name.
     * @param actors Array of actors.
     */
    void addMovie(final String name, final String[] actors) {
        Movie newMovie = new Movie();
        Arrays.asList(actors)
                .forEach(actorName -> movieHash.add(newMovie.setName(name).setActors(new Actor().setName(actorName))));
        Arrays.asList(actors)
                .forEach(actorName -> actorHash.add(new Actor().setName(actorName).setMovies(newMovie)));
    }

    /**
     * @param name   Movie name.
     * @param rating Movie rating.
     */
    void addRating(final String name, final double rating) {
        movieHash.stream()
                .filter(movieName -> name.equals(movieName.getName()))
                .forEach(movieName -> movieName.setRating(rating));
    }

    /**
     * @param name      Movie name.
     * @param newRating Movie rating.
     */
    void updateRating(final String name, final double newRating) {
        addRating(name, newRating);
    }

    /**
     * @return best actor.
     */
    String getBestActor() {
        return actorHash.stream()
                .max(Comparator.comparing(Actor::getRating))
                .orElse(new Actor())
                .getName();
    }

    /**
     * @return best movie.
     */
    String getBestMovie() {
        return movieHash.stream()
                .max(Comparator.comparing(Movie::getRating))
                .orElse(new Movie())
                .getName();
    }

    /**
     * @return Array List Movies.
     */
    List<Movie> getMovieList() {
        return new ArrayList<>(movieHash);
    }

    /**
     * @return Array List Actors.
     */
    List<Actor> getActorList() {

        return new ArrayList<>(actorHash);
    }

}
