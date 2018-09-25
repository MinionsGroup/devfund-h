package org.minions.devfund.katerinaanzoleaga.moviedatabase;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * MovieDatabase class.
 */
public class MovieDatabase {
    ArrayList<Movie> movieList;
    ArrayList<Actor> actorList;

    /**
     * Constructor starts empty Movies and Actors' list.
     */
    MovieDatabase() {
        this.movieList = new ArrayList<Movie>();
        this.actorList = new ArrayList<Actor>();
    }


    /**
     * This method returns the index of an element if exists in the movieList,
     * if the element does not exists it returns -1
     * @param name
     * @return
     */
    public int movieExists (String name) {
        for (int i = 0; i < this.movieList.size(); i++) {
            if (this.movieList.get(i).getName().equals(name)){
                return i;
            }
        }
        return -1;
    }


    /**
     * This method returns the index of an element if exists in the actorsList,
     * if the element does not exists it returns -1
     * @param name
     * @return
     */
    public int actorExists (String name) {
        for (int i = 0; i < this.actorList.size(); i++) {
            if (this.actorList.get(i).getName().equals(name)){
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
     * @return
     */
    public ArrayList<Movie> getMovieList() {
        return this.movieList;

    }

    /**
     * This method takes in the name of a movie that is not currently in the database along with a list of actors for that movie.
     * If the movie is already in the database, your code ignores this request (this specification is an oversimplification).
     * If the movie is a new movie, a movie object is created and added to the movieList.
     * If any of the actors happen to be new, they will be added to the actorList.
     * @param name
     * @param actors
     */
    public void addMovie(String name, String[] actors){
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
                }
                else{
                    aMovie.addActor(this.actorList.get(i));
                    this.actorList.get(i).addMovie(aMovie);
                }
            }
        }
    }

    /**
     * Adds a rating to a movie with the name specified only if the rating is zero.
     * @param name
     * @param rating
     */
    void addRating(String name, double rating) {
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
     * @param name
     * @param newRating
     */
    void updateRating(String name, double newRating) {
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
     * @return
     */
    String getBestActor() {
        double maxAvrRating = 0;
        double avrRating = 0;
        int index = -1;
        Actor theActor;
        for (Actor actor: this.actorList) {
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
     * @return
     */
    String getBestMovie() {
        double maxRating = 0;
        int index = -1;
        Movie theMovie;
        for (Movie movie : this.movieList) {
            if (movie.getRating() > maxRating){
                maxRating = movie.getRating();
                index = this.movieList.indexOf(movie);
            }
        }
        theMovie = this.movieList.get(index);
        return theMovie.getName();

    }


    /**
     * Fill Movies list from file.
     * @param fileName
     */
    void fillMoviesFromFile(String fileName) {
        try {
            File moviesFile = new File(fileName);
            Scanner scnr = new Scanner(moviesFile);
            String[] array1;
            while (scnr.hasNext()) {
                String aLine = scnr.nextLine();
                array1 = aLine.split(",");

                String[] actors = new String[1];
                actors[0] = array1[0].trim();
                for (int j = 1; j < array1.length; j++) {
                    int i = this.movieExists(array1[j].trim());
                    if (i != -1) {
                        int a = this.actorExists(array1[0].trim());
                        if (a == -1) {
                            Actor anActor;
                            anActor = new Actor();
                            anActor.setName(array1[0].trim());
                            anActor.addMovie(this.movieList.get(i));
                            this.movieList.get(i).addActor(anActor);
                            this.actorList.add(anActor);
                        }
                        else {
                            this.actorList.get(a).addMovie(this.movieList.get(i));
                        }
                    }
                    else
                        this.addMovie(array1[j].trim(), actors);
                }
            }
            scnr.close();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


    /**
     * Fills the movies rationgs from the file.
     * @param fileName
     */
    void fillRatingsFromFile(String fileName) {
        try {
            File ratingsFile = new File(fileName);
            Scanner scnr = new Scanner(ratingsFile);
            String[] array1;
            while (scnr.hasNext()) {
                String aLine = scnr.nextLine();
                array1 = aLine.split("	");
                String aRating = array1[1];
                if (! aRating.equals("critic_score")){
                    double rating;
                    try {
                        rating = Integer.parseInt(aRating);
                        this.addRating(array1[0], rating*1.0);
                    }
                    catch (NumberFormatException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
/**
    /**
     * Maim
     * @param args

    public static void main(String[] args) {
        MovieDatabase movieDatabase;
        movieDatabase = new MovieDatabase();
        movieDatabase.fillMoviesFromFile("src/movies.txt");
        movieDatabase.fillRatingsFromFile("src/ratings.txt");
        for (Movie aMovie : movieDatabase.movieList) {
            System.out.println(aMovie.getName());
            System.out.println(aMovie.getRating());
            for (String anActor : aMovie.getActors()) {
                System.out.println(" ------    "+ anActor);
            }
        }
        System.out.println("--------------------------------------");
        for (Actor anActor : movieDatabase.actorList) {
            System.out.println(anActor.getName());
            for (String aMovie : anActor.getMovies()) {
                System.out.println(" ------ "+ aMovie);
            }
        }
        System.out.println("Best movie: "+ movieDatabase.getBestMovie());
        System.out.println("Best movie: "+ movieDatabase.getBestActor());

    }
*/
}






