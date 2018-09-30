package org.minions.devfund.richard.moviedatabase;

import java.util.ArrayList;
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
        Movie newMovie = new Movie().setName(name);
        newMovie = newMovie.isMovieAlreadyAdded(movieHash)
                ? newMovie.getMovieAlreadyExist(movieHash)
                : newMovie;
        if (!newMovie.isMovieAlreadyAdded(movieHash)) {
            movieHash.add(newMovie);
        }
        for (String actorName : actors) {
            Actor newActor = new Actor().setName(actorName);
            newActor = newActor.isActorAlreadyAdded(actorHash)
                    ? newActor.getActorAlreadyExist(actorHash)
                    : newActor;
            newMovie.setActors(newActor);
            newActor.setMovies(newMovie);
            if (!newActor.isActorAlreadyAdded(actorHash)) {
                actorHash.add(newActor);
            }
        }
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
        return new Movie().getBestActor(actorHash);
    }

    /**
     * @return best movie.
     */
    String getBestMovie() {
        return new Actor().getBestMovie(movieHash);
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
