package org.minions.devfund.reinaldo.movie;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by reinaldo on 25-07-18.
 */
public class MovieDatabase {

    private List<Movie> movieList;
    private List<Actor> actorList;

    /**
     * Constructors for the movieDatabase class.
     */
    public MovieDatabase() {
        movieList = new ArrayList<>();
        actorList = new ArrayList<>();
    }

    /**
     * Gets the movies list.
     *
     * @return list of movies.
     */
    public List<Movie> getMovieList() {
        return movieList;
    }

    /**
     * Gets the actors list.
     *
     * @return list of actors.
     */
    public List<Actor> getActorList() {
        return actorList;
    }

    /**
     * Adds a movie in the movie list.
     *
     * @param name   movie name.
     * @param actors array for the actor.
     */
    public void addMovie(final String name, final String[] actors) {
        if (movieList.stream().noneMatch(movieObject -> movieObject.getName().equals(name))) {
            Movie newMovie = new Movie(name);
            newMovie.addActor(actors);
            movieList.add(newMovie);
            addNewActors(actors);
        }
    }

    /**
     * Adds the new actor.
     *
     * @param actors list.
     */
    private void addNewActors(final String[] actors) {
        boolean verify = actorList.stream().noneMatch(actor -> actor.getName().equals(actor.getName()));
        Stream.of(actors)
                .map(Actor::new)
                .filter(actor -> verify)
                .forEach(actor -> actorList.add(actor));
    }

    /**
     * Adds rating for movie.
     *
     * @param name  movie.
     * @param rating value.
     */
    public void addRating(final String name, final double rating) {
        updateRating(name, rating);
    }

    /**
     * Updates the rating for a movie.
     *
     * @param name      movie name.
     * @param rating new rating.
     */
    public void updateRating(final String name, final double rating) {
        movieList.stream()
                .filter(movie -> movie.getName().equals(name))
                .forEach(movie -> movie.setRating(rating));
    }

    /**
     * Gets the best name of the actor.
     *
     * @return best actor.
     */
    public String getBestActor() {
        return actorList.stream()
                .max(Comparator.comparing(Actor::movieRatingAverage))
                .map(Actor::getName)
                .get();

    }

    /**
     * Gets the best name of the movie.
     *
     * @return string best movie.
     */
    public String getBestMovie() {
        return movieList.stream()
                .max(Comparator.comparing(Movie::getRating))
                .map(Movie::getName)
                .get();
    }

}
