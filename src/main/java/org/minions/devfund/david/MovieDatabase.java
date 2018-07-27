package org.minions.devfund.david;

import java.util.ArrayList;

public class MovieDatabase {
    private ArrayList<Movie> movieList;
    private ArrayList<Actor> actorList;

    public ArrayList<Movie> getMovieList() {
        return movieList;
    }

    public ArrayList<Actor> getActorList() {
        return actorList;
    }

    public MovieDatabase(){
        movieList = new ArrayList<>();
        actorList = new ArrayList<>();
    }

    void addMovie(String name, String[] actors){
        if (getMovieList().stream().noneMatch(movie -> movie.getName().equalsIgnoreCase(name))){
            Movie movie = new Movie();
            movie.setName(name);
            movie.setActors(actors, name);
            movieList.add(movie);
            addActor(actors);
        }
    }

    void addRating(){
        
    }

    void addActor(String[] actors){
        for (String actor : actors){
            if (getActorList().stream().noneMatch(a -> a.getName().equalsIgnoreCase(actor))){
                Actor actor1 = new Actor();
                actor1.setName(actor);
                actorList.add(actor1);
            }
        }
    }
}
