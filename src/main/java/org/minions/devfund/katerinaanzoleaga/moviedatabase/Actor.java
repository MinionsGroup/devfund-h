package org.minions.devfund.katerinaanzoleaga.moviedatabase;

import java.util.ArrayList;

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


    public String getName() {
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    public void addMovie(Movie movie) {
        this.movies.add(movie);
    }

    public double getAverageRating () {
        double sum = 0;
        for (Movie movie : this.movies) {
            sum = sum + movie.getRating();
        }
        return sum/(this.movies.size() * 1.0);
    }

    public boolean hasMovie(String name) {
        for (Movie aMovie : this.movies){
            if (aMovie.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    public String[] getMovies() {
        String [] theMovies = new String[this.movies.size()];
        for (int i = 0; i < this.movies.size(); i++) {
            theMovies[i] = this.movies.get(i).getName();
        }
        return theMovies;
    }


}

