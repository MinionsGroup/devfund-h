package org.minions.devfund.noemiguzman.moviedatabase;

import java.util.ArrayList;
/**
 * class movie data base.
 */
public class MovieDatabase {
    private ArrayList<Movie> movieList;
    private ArrayList<Actor> actorList;

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
    public ArrayList<Movie> getMovieList() {
        return this.movieList;
    }

    /**
     * Getter for the actors in the database.
     * @return an ArrayList of all the actors in the
     * database
     */
    public ArrayList<Actor> getActorList() {
        return this.actorList;
    }

    /**
     * Getter for the String names of the movies.
     * @return ArrayList of Strings of the names of all
     * the movies in the database.
     */
    private ArrayList<String> getMovieNames() {
        ArrayList<String> movieNames = new ArrayList<>();
        for (Movie movie: this.movieList) {
            movieNames.add(movie.getName());
        }
        return movieNames;
    }


    /**
     * Add a movie to the database.
     * @param name String for the movie's name
     * @param actors Array of Strings for the actors'
     *               names.
     */
    public void addMovie(final String name, final String[] actors) {
        if (!this.getMovieNames().contains(name)) {
            Movie newMovie = new Movie(name);
            this.movieList.add(newMovie);
            for (String actorName: actors) {
                Actor newActor = new Actor(actorName, this.movieList);
                newMovie.addActor(newActor);
                boolean added = false;
                for (Actor actor: this.actorList) {
                    if (actorName.equals(actor.getName())) {
                        actor.addMovie(newMovie);
                        added = true;
                    }
                }
                if (!added) {
                    this.actorList.add(newActor);
                }
            }
        }
    }

    /**
     * Add a rating to a particular movie.
     * @param name The String name of the movie
     * @param rating the rating value
     */
    public void addRating(final String name, double rating) {
        for (Movie movie: movieList) {
            if (movie.getName().equals(name)) {
                movie.setRating(rating);
            } else {
                continue;
            }
        }
    }

    /**
     * Update a particular movie's rating.
     * @param name The String name of the movie
     * @param newRating The double representing the new
     *                  value for the movie's rating
     */
    public void updateRating(final String name, double newRating) {
        this.addRating(name, newRating);
    }

    /**
     * Get the actor with the best average rating.
     * @return String of the name of the actor
     */
    public String getBestActor() {
        String actorName = "";
        double averageRating = 0.0;

        for (Actor actor: actorList) {
            double totalRating = 0.0;
            for (Movie movie: actor.getMovies()) {
                totalRating += movie.getRating();
            }
            double average = totalRating / actor.getMovies().size();

            if (average > averageRating) {
                averageRating = average;
                actorName = actor.getName();
            }
        }
        return actorName;
    }

    /**
     * Get the movie with the highest rating.
     * @return String of the name of the movie.
     */
    public String getBestMovie() {
        double bestRating = 0.0;
        String movieName = "";
        for (Movie movie: this.movieList) {
            if (movie.getRating() > bestRating) {
                bestRating = movie.getRating();
                movieName = movie.getName();
            }
        }
        return movieName;
    }
}
