package org.minions.devfund.katerinaanzoleaga.moviedatabase;

import java.util.ArrayList;

/**
 * Actor class.
 */
public class Actor {
    String name;
    ArrayList<Movie> movies;

    /**
     * Actor class constructor, to be defined the way we are going to get the movies list
     */
    public Actor() {
        this.name = "";
        this.movies = new ArrayList<Movie>();
    }

    /**
     * Name getter.
     * @return name
     */
    public String getName() {
        return this.name;
    }

    /**
     * Name setter.
     * @param name the name
     */
    public void setName(String name){
        this.name = name;
    }

    /**
     * Movies getter.
     * @return the list of movies of an actor
     */
    public String[] getMovies() {
        String [] theMovies = new String[this.movies.size()];
        for (int i = 0; i < this.movies.size(); i++) {
            theMovies[i] = this.movies.get(i).getName();
        }
        return theMovies;
    }

    /**
     * Adds a movie to the movie list of an actor.
     * @param movie the movie
     */
    public void addMovie(Movie movie) {
        this.movies.add(movie);
    }

    /**
     * Get the average rating of the actor across his/her movies.
     * @return
     */
    public double getAverageRating () {
        double sum = 0;
        for (Movie movie : this.movies) {
            sum = sum + movie.getRating();
        }
        return sum/(this.movies.size() * 1.0);
    }

    /**
     * Returns true if the list of the movies of the actor includes the mavie name parameter.
     * @param name the name of the movie to look for
     * @return true if the movie is in the list
     */
    public boolean hasMovie(String name) {
        for (Movie aMovie : this.movies){
            if (aMovie.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }



}

