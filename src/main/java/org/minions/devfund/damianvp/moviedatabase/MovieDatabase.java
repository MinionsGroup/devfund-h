package org.minions.devfund.damianvp.moviedatabase;

import java.util.ArrayList;
import java.util.Comparator;

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
            for (int i = 0; i < actors.length; i++) {
                if (containsActor(actors[i])) {
                    for (int j = 0; j < this.actorList.size(); j++) {
                        if (this.actorList.get(j).getName().equals(actors[i])) {
                            this.actorList.get(j).addMovie(movie);
                            movie.addActor(this.actorList.get(j));
                        }
                    }


                } else {
                    Actor actor = getActorObject(actors[i]);
                    actor.addMovie(movie);
                    movie.addActor(actor);
                    this.actorList.add(actor);
                }
            }
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
     * Method to check if actor already exist in class.
     * @param name String type.
     * @return true: if actor exist.
     *         false: if actor does not exist.
     */
    public boolean containsActor(final String name) {
        return this.actorList.stream().anyMatch(o -> o.getName().equals(name));
    }

    /**
     * Method to get the Actor object.
     * @param name String type.
     * @return Actor object.
     */
    public Actor getActorObject(final String name) {
        return this.actorList.stream().findAny().filter(o -> o.getName().equals(name)).orElse(new Actor(name));
    }

    /**
     * Method to get the Movie object form the list by movie name.
     * @param name String type.
     * @return Movie object from list: if movie already exists.
     *         new Movie object: if movie does not exists.
     */
    public Movie getMovieObject(final String name) {
        Movie ob = this.movieList.stream().findAny().filter(o -> o.getName().equals(name)).orElse(new Movie(name));
        return ob;
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
        Comparator<Actor> comparator = Comparator.comparing(Actor::getRatingAverage);
        String name = this.actorList.stream().max(comparator).get().getName();
        Actor actor = getActorObject(name);
        return actor.getName();
    }

    /**
     * Method to get the best movie of the class.
     * @return String type, name of best movie.
     */
    String getBestMovie() {
        Comparator<Movie> comparator = Comparator.comparing(Movie::getRating);
        return this.movieList.stream().max(comparator).get().getName();
    }

}

