package org.minions.devfund.benjamin.moviedatabase;

import java.util.ArrayList;
import java.util.List;
import java.util.Comparator;

/**
 * Class MovieDatabase.
 */
public class MovieDatabase {
    private List<Movie> movieList;
    private List<Actor> actorList;

    /**
     * Constructor.
     */
    public MovieDatabase() {
        movieList = new ArrayList<>();
        actorList = new ArrayList<>();
    }
    /**
     * Get the Movie list.
     *
     * @return List of Movies.
     */
    public List<Movie> getMovieList() {
        return movieList;
    }
    /**
     * Get the Actor list.
     *
     * @return List of Actors.
     */
    public List<Actor> getActorList() {
        return actorList;
    }
    /**
     * Add movies and actors to lists.
     *
     * @param name   String movie name.
     * @param actors String[] actors list.
     */
    public void addMovie(final String name, final String[] actors) {
        if (movieList.stream().noneMatch(movie -> name.equals(movie.getName()))) {
            Movie movie = new Movie();
            movie.setName(name);
            movie.addActors(actors);
            movieList.add(movie);
            addActors(name, actors);
        }
    }
    /**
     * Add new actors.
     *
     * @param name   String.
     * @param actors String[].
     */
    private void addActors(final String name, final String[] actors) {
        for (String actor : actors) {
            if (actorList.stream().noneMatch(a -> actor.equals(a.getName()))) {
                Actor currentActor = new Actor();
                currentActor.setName(actor);
                currentActor.addMovie(name);
                actorList.add(currentActor);
            }
        }
    }
    /**
     * Add rating to the movies.
     *
     * @param name   String.
     * @param rating double.
     */
    public void addRating(final String name, double rating) {
        movieList.stream().filter(m -> name.equals(m.getName())).forEach(m -> m.setRating(rating));
    }
    /**
     * Update the rating of a movie.
     *
     * @param name   String.
     * @param rating double.
     */
    public void updateRating(final String name, double rating) {
        addRating(name, rating);
    }
    /**
     * Get the Best actor based on movie's rating Average.
     *
     * @return String.
     */
    public String getBestActor() {
        return actorList.stream()
                .max(Comparator.comparing(Actor::getAverage))
                .orElse(new Actor())
                .getName();
    }
    /**
     * Get the Best Movie based on rating.
     *
     * @return String.
     */
    public String getBestMovie() {
        return movieList.stream()
                .max(Comparator.comparing(Movie::getRating))
                .orElse(new Movie())
                .getName();
    }
}
