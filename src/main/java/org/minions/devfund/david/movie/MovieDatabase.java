package org.minions.devfund.david.movie;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Homework Assignment 3: movie Database.
 */
public class MovieDatabase {
    private List<Movie> movieList;
    private List<Actor> actorList;

    /**
     * Gets movie list.
     *
     * @return a list of movies.
     */
    public List<Movie> getMovieList() {
        return movieList;
    }

    /**
     * Gets actor list as Array list.
     *
     * @return a list of actors.
     */
    public List<Actor> getActorList() {
        return actorList;
    }

    /**
     * Constructor, initialize movie database.
     */
    public MovieDatabase() {
        movieList = new ArrayList<>();
        actorList = new ArrayList<>();
    }

    /**
     * Takes in the name of a movie that is not currently in the database along with a list of actors for that movie.
     *
     * @param name   of the movie.
     * @param actors list.
     */
    void addMovie(final String name, final String[] actors) {
        if (getMovieList().stream().noneMatch(movie -> movie.getName().equalsIgnoreCase(name))) {
            Movie movie = new Movie();
            movie.setName(name);
            movie.setActors(actors, name);
            movieList.add(movie);
            addActors(actors, name);
        }
    }

    /**
     * Adds a rating for this movie.
     *
     * @param name   of the movie.
     * @param rating value.
     */
    void addRating(final String name, final double rating) {
        movieList.stream().filter(movie -> name.equals(movie.getName())).forEach(movie -> movie.setRating(rating));
    }

    /**
     * Updates a rating gor the movie.
     *
     * @param name      of the movie.
     * @param newRating value to update.
     */
    void updateRating(final String name, final double newRating) {
        addRating(name, newRating);
    }

    /**
     * Gets best movie base rating.
     *
     * @return the name of the movie with the highest rating.
     */
    String getBestMovie() {
        return getMovieList().stream().max(Comparator.comparingDouble(Movie::getRating)).orElse(new Movie()).getName();
    }

    /**
     * Gets best actor base movies rating.
     *
     * @return the name of the actor that has the best average rating for their movies.
     */
    String getBestActor() {
        return getActorList().stream().max(Comparator.comparingDouble(Actor::getAverage)).orElse(new Actor()).getName();
    }

    /**
     * Adds actors into Actor list.
     *
     * @param actors    list.
     * @param movieName movie name.
     */
    void addActors(final String[] actors, final String movieName) {
        for (String actor : actors) {
            if (getActorList().stream().noneMatch(actor1 -> actor1.getName().equalsIgnoreCase(actor))) {
                Actor actualActor = new Actor();
                actualActor.setName(actor);
                actualActor.setMovies(movieName);
                actorList.add(actualActor);
            }
        }
    }
}
