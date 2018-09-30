package org.minions.devfund.noemiguzman.moviedatabase;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * class movie data base.
 */
public class MovieDatabase {
    private List<Movie> movieList;
    private List<Actor> actorList;

    /**
     * Initializes the MovieDatabase object.
     */
    public MovieDatabase() {
        this.movieList = new ArrayList<>();
        this.actorList = new ArrayList<>();
    }

    /**
     * Getter for the movies in the database.
     * @return  all the movies in the bd
     */
    public List<Movie> getMovieList() {
        return this.movieList;
    }

    /**
     * Getter for the actors in the database.
     * @return an ArrayList of all the actors in the
     * database
     */
    public List<Actor> getActorList() {
        return this.actorList;
    }
    /**
     * Adds a movie in the movie list.
     *
     * @param name   movie name.
     * @param actors array for the actor.
     */
    public void addMovie(final String name, final String[] actors) {
        if (movieList.stream().noneMatch(movie -> name.equals(movie.getName()))) {
            Movie movie = new Movie(name);
            movie.addActor(actors);
            movieList.add(movie);
            addActors(name, actors);
        }
    }

    /**
     * Adds the new actor.
     *
     * @param movieName movieName.
     * @param actors list.
     */
    private void addActors(final String movieName, final String[] actors) {
        for (String actor : actors) {
            if (actorList.stream().noneMatch(a -> actor.equals(a.getName()))) {
                Actor currentActor = new Actor(actor);
                currentActor.addMovie(new Movie(movieName));
                actorList.add(currentActor);
            }
        }
    }
    /**
     * Add a rating given movie name.
     * @param name The String name of the movie
     * @param rating the rating value
     */
    public void addRating(final String name, double rating) {
        movieList.stream().filter(m -> name.equals(m.getName())).forEach(m -> m.setRating(rating));
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
     * Gets the best name of the movie.
     *
     * @return string best movie.
     */
    public String getBestMovie() {
        return movieList.stream()
                .max(Comparator.comparing(Movie::getRating))
                .map(Movie::getName).orElse("");
    }


    /**
     * Gets the best name of the actor.
     *
     * @return best actor.
     */
    public String getBestActor() {
        return actorList.stream()
                .max(Comparator.comparing(Actor::movieRatingAverage))
                .map(Actor::getName).orElse("");
    }
}
