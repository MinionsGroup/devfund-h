package org.minions.devfund.danielmontecinos.moviedatabase;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Collections;
import java.util.Comparator;

/**
 * Class that adds new movies and actors to Lists.
 */
public class MovieDatabase {
    private List<Movie> movieList;
    private List<Actor> actorList;

    /**
     * Creates an instance of {@link MovieDatabase}.
     */
    public MovieDatabase() {
        movieList = new ArrayList<>();
        actorList = new ArrayList<>();
    }

    /**
     * Gets movieList instance.
     *
     * @return movieList.
     */
    public List<Movie> getMovieList() {
        return movieList;
    }

    /**
     * Gets actorList instance.
     *
     * @return actorList.
     */
    public List<Actor> getActorList() {
        return actorList;
    }

    /**
     * Adds a new Movie object to movieList.
     *
     * @param name as String.
     * @param actors as an array of Strings.
     */
    public void addMovie(final String name, final String[] actors) {
        if (movieList.stream().noneMatch(m -> m.getName().equalsIgnoreCase(name))) {
            Movie newMovie = new Movie();
            newMovie.setName(name);
            newMovie.setActors(name, actors);
            movieList.add(newMovie);
            setMoviesList(name, actors);
        }
    }

    /**
     * Adds rating to a Movie object.
     *
     * @param name as String.
     * @param rating as double.
     */
    public void addRating(final String name, final double rating) {
        for (Movie movie : movieList) {
            if (movie.getName().equalsIgnoreCase(name) && movie.getRating() != rating) {
                movie.setRating(rating);
            }
        }
    }

    /**
     * Updates Movie's object rating.
     *
     * @param name as String.
     * @param rating as double.
     */
    public void updateRating(final String name, final double rating) {
        addRating(name, rating);
    }

    /**
     * Gets best movie actor based of rating assigned.
     *
     * @return actor that has highest rating.
     */
    public String getBestActor() {
        List<Double> ratingPerMovie = new ArrayList<>();
        Map<String, Double> actorRating = new HashMap<>();
        for (Actor actor : actorList) {
            actor.getMovies().forEach(r -> ratingPerMovie.add(r.getRating()));
            actorRating.put(actor.getName(), Collections.max(ratingPerMovie));
        }

        return Collections.max(actorRating.entrySet(), Comparator.comparingDouble(Map.Entry::getValue)).getKey();
    }

    /**
     * Gets best movie based on rating assigned.
     *
     * @return movie that has highest rating.
     */
    public String getBestMovie() {
        Map<String, Double> ratingMovie = new HashMap<>();
        for (Movie movie : movieList) {
            ratingMovie.put(movie.getName(), movie.getRating());
        }
        return Collections.max(ratingMovie.entrySet(), Comparator.comparingDouble(Map.Entry::getValue)).getKey();
    }

    /**
     * Stores new actors on actorList instance.
     *
     * @param movieName as String
     * @param actorList as an Array of Strings.
     */
    private void setMoviesList(final String movieName, final String[] actorList) {
        for (String actor : actorList) {
            if (this.actorList.stream().noneMatch(a -> a.getName().equalsIgnoreCase(actor))) {
                Actor newActor = new Actor();
                newActor.setName(actor);
                newActor.setMovie(movieName);
                this.actorList.add(newActor);
            }
        }
    }
}
