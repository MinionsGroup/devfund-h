package org.minions.devfund.damianvp.moviedatabase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Optional;

/**
 * MovieDatabase class.
 */
public class MovieDatabase {
    private ArrayList<Movie> movieList;
    private ArrayList<Actor> actorList;

    /**
     * Constructor class.
     */
    MovieDatabase() {
        this.movieList = new ArrayList<>();
        this.actorList = new ArrayList<>();
    }

    /**
     * Method to get the movie list.
     * @return ArrayList<Movie>, movieList.
     */
    ArrayList<Movie> getMovieList() {
        return this.movieList;
    }

    /**
     * Method to get the actor list.
     * @return ArrayList<Actor>, actorList.
     */
    ArrayList<Actor> getActorList() {
        return this.actorList;
    }

    /**
     * Method to add a Movie.
     * @param name String type.
     * @param actors String List type
     */
    void addMovie(final String name, final String[] actors) {
        if (!containsMovie(name)) {
            Movie movie = getMovieObject(name);
            Arrays.stream(actors).forEach(actor -> {
                Actor actorObject = getActorObject(actor);
                int index = this.actorList.indexOf(actorObject);
                this.actorList.get(index).addMovie(movie);
                movie.addActor(this.actorList.get(index));
            });
            this.movieList.add(movie);
        }
    }

    /**
     * Method to check if movie already exist in class.
     * @param name String type.
     * @return true: if movie exist.
     *         false: if movie does not exist.
     */
    public boolean containsMovie(final String name) {
        return this.movieList.stream().anyMatch(o -> o.getName().equals(name));
    }

    /**
     * Method to get the Actor object.
     * @param name String type.
     * @return Actor object.
     */
    public Actor getActorObject(final String name) {
        Optional<Actor> actor = this.actorList.stream().filter(o -> o.getName().equals(name)).findAny();
        if (actor.isPresent()) {
            return actor.get();
        }
        Actor newActor = new Actor(name);
        this.actorList.add(newActor);
        return newActor;
    }

    /**
     * Method to get the Movie object form the list by movie name.
     * @param name String type.
     * @return Movie object from list: if movie already exists.
     *         new Movie object: if movie does not exists.
     */
    public Movie getMovieObject(final String name) {
        return this.movieList.stream().findAny().filter(o -> o.getName().equals(name)).orElse(new Movie(name));
    }

    /**
     * Method to add a rating to a specific movie.
     * @param name String type, name of movie.
     * @param rating double type, rating to set.
     */
    void addRating(final String name, double rating) {
        for (int i = 0; i < this.movieList.size(); i++) {
            if (this.movieList.get(i).getName().equals(name)) {
                this.movieList.get(i).setRating(rating);
                return;
            }
        }
    }

    /**
     * Method to update the rating of a specific movie.
     * @param name String type, name of movie.
     * @param newRating double type, rating to update.
     */
    void updateRating(final String name, double newRating) {
        addRating(name, newRating);
    }

    /**
     * Method to get the nest actor of class.
     * @return String type, name of the best actor.
     */
    String getBestActor() {
        return this.actorList.stream().max(Comparator.comparing(Actor::getRatingAverage)).orElse(new Actor()).getName();
    }

    /**
     * Method to get the best movie of the class.
     * @return String type, name of best movie.
     */
    String getBestMovie() {
        return this.movieList.stream().max(Comparator.comparing(Movie::getRating)).orElse(new Movie()).getName();
    }

}

