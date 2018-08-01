package org.minions.devfund.damianvp.moviedatabase;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Optional;

public class MovieDatabase {

    private ArrayList<Movie> movieList;
    private ArrayList<Actor> actorList;

    MovieDatabase() {
        this.movieList = new ArrayList<>();
        this.actorList = new ArrayList<>();
    }

    ArrayList<Movie> getMovieList() {
        return this.movieList;
    }

    ArrayList<Actor> getActorList() {
        return this.actorList;
    }

    void addMovie(String name, String[] actors) {
        System.out.println("------Movie------------");
        System.out.println(containsMovie(name));
        if (!containsMovie(name)) {
            Movie newMovie = new Movie(name);
            for(int i = 0; i < actors.length; i++) {
                Actor actor;
                if (!containsActor(actors[i])) {
                    actor = new Actor(actors[i]);
                    System.out.println("----added actor on main class");
                    this.actorList.add(actor);
                } else {
                    actor = getExistentActorObject(actors[i]);
                }
                actor.addMovie(newMovie);
                newMovie.addActor(actor);
            }
        }
    }

    public boolean containsMovie(final String name){
        return this.movieList.stream().anyMatch(o -> o.getName().equals(name));
//        return this.movieList.stream().filter(o -> o.getName().equals(name)).findFirst().isPresent();
    }

    public boolean containsActor(final String name){
        return this.actorList.stream().anyMatch(o -> o.getName().equals(name));
    }

//    public Optional<Actor> getActorObject(String name) {
////        Boolean b = this.actorList.stream().anyMatch(o -> o.getName().equals(name));
////        return this.actorList.stream().findFirst(actor -> actor.getName());
//        return this.actorList..stream()..filter(actor -> actor.getName().equals(name))..findFirst();
//    }
    public Actor getExistentActorObject(String name) {
        int i = 0;
        while (this.actorList.get(i).getName() != name) {
            i++;
        }
        return this.actorList.get(i);
    }

    void addRating(String name, double rating) {

    }

    public static void main(String[] args)
    {

        MovieDatabase movieDB = new MovieDatabase();
        String[] actorList = {"actor1", "actor2"};
        movieDB.addMovie("movie1", actorList);
        movieDB.addMovie("movie2", actorList);
        movieDB.addMovie("movie1", actorList);

    }
}
