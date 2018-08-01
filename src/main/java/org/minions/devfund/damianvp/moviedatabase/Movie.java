package org.minions.devfund.damianvp.moviedatabase;

import java.util.ArrayList;

public class Movie {
    private String name;
    private ArrayList<Actor> actors;
    private double rating;

    Movie(String name) {
        this.name = name;
        this.actors = new ArrayList<>();
        this.rating = 0.0;
    }

    String getName() {
        return this.name;
    }

    ArrayList<Actor> getActors() {
        return this.actors;
    }

    double getRating() {
        return this.rating;
    }

    void addActor(Actor actor) {
        if (!actorExists(actor.getName())) {

            Actor newActor = new Actor(actor.getName());
            newActor.addMovie(this);
            this.actors.add(actor);
        }

        System.out.println("--------addedActor on movie class----------");
//        for(int i = 0; i < actors.length; i++) {
//            System.out.println(actorExists(actors[i]));
//            if (!actorExists(actors[i])) {
//                Actor newActor = new Actor(actors[i]);
//                this.actors.add(newActor);
//            }
//        }
    }


    public boolean actorExists(final String name){
        return this.actors.stream().anyMatch(o -> o.getName().equals(name));
    }
}
