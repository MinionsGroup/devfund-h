package org.minions.devfund.katerinaanzoleaga.moviedatabase;

import java.util.ArrayList;


/**
 * MovieDatabase class.
 */
public class MovieDatabase {
    private ArrayList<Movie> movieList;
    private ArrayList<Actor> actorList;

    /**
     * Constructor starts empty Movies and Actors' list.
     */
    MovieDatabase() {
        this.movieList = new ArrayList<>();
        this.actorList = new ArrayList<>();
    }


    /**
     * This method returns the index of an element if exists in the movieList.
     * If the element does not exists it returns -1
     *
     * @param name string
     * @return int
     */
    public int movieExists(final String name) {
        for (int i = 0; i < this.movieList.size(); i++) {
            if (this.movieList.get(i).getName().equals(name)) {
                return i;
            }
        }
        return -1;
    }


    /**
     * This method returns the index of an element if exists in the actorsList.
     * If the element does not exists it returns -1
     *
     * @param name string.
     * @return int
     */
    public int actorExists(final String name) {
        for (int i = 0; i < this.actorList.size(); i++) {
            if (this.actorList.get(i).getName().equals(name)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Actors list getter.
     * @return the list of actors.
     */
    public ArrayList<Actor> getActorList() {
        return this.actorList;
    }

    /**
     * Movies list getter.
     * @return Movies list
     */
    public ArrayList<Movie> getMovieList() {
        return this.movieList;

    }

    /**
     * This method takes in the name of a movie that is not currently in the database.
     * Along with a list of actors for that movie.
     * If the movie is already in the database, your code ignores this request
     * (this specification is an oversimplification).
     * If the movie is a new movie, a movie object is created and added to the movieList.
     * If any of the actors happen to be new, they will be added to the actorList.
     *
     * @param name movie name
     * @param actors List of actors
     */
    public void addMovie(final String name, final String[] actors) {
        if (this.movieExists(name) == -1) {
            Movie aMovie = new Movie(name);
            this.movieList.add(aMovie);
            for (String actor : actors) {
                int i = this.actorExists(actor);
                if (i == -1) {
                    Actor anActor = new Actor();
                    anActor.setName(actor);
                    aMovie.addActor(anActor);
                    anActor.addMovie(aMovie);
                    this.actorList.add(anActor);
                } else {
                    aMovie.addActor(this.actorList.get(i));
                    this.actorList.get(i).addMovie(aMovie);
                }
            }
        }
    }

    /**
     * Adds a rating to a movie with the name specified only if the rating is zero.
     * @param name  of the movie
     * @param rating the rating of the movie
     */
    void addRating(final String name, double rating) {
        int i = this.movieExists(name);
        if (i != -1) {
            Movie aMovie;
            aMovie = this.movieList.get(i);
            if (aMovie.getRating() == 0) {
                aMovie.setRating(rating);
            }
        }
    }

    /**
     * Updates the rating of a movie regardless of its original value.
     * @param name of the movie
     * @param newRating as its name
     */
    void updateRating(final String name, double newRating) {
        // The following gets the movie index and updates the rating
        int i = this.movieExists(name);
        if (i != -1) {
            Movie aMovie;
            aMovie = this.movieList.get(i);
            aMovie.setRating(newRating);
        }
    }

    /**
     * Gets the Actor with best average rating.
     * @return name of t he actor
     */
    String getBestActor() {
        double maxAvrRating = 0;
        double avrRating = 0;
        int index = -1;
        Actor theActor;
        for (Actor actor : this.actorList) {
            avrRating = actor.getAverageRating();
            if (avrRating > maxAvrRating) {
                maxAvrRating = avrRating;
                index = this.actorList.indexOf(actor);
            }
        }
        theActor = this.actorList.get(index);
        return theActor.getName();
    }

    /**
     * Gets the best movie based on the max rating.
     * @return the name of hte movie
     */
    String getBestMovie() {
        double maxRating = 0;
        int index = -1;
        Movie theMovie;
        for (Movie movie : this.movieList) {
            if (movie.getRating() > maxRating) {
                maxRating = movie.getRating();
                index = this.movieList.indexOf(movie);
            }
        }
        theMovie = this.movieList.get(index);
        return theMovie.getName();
    }
}






