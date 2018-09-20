package org.minions.devfund.katerinaanzoleaga.moviedatabase;


import java.util.ArrayList;

public class Movie {
    private String name;
    private ArrayList<Actor> actors;
    private double rating;

    /**
     * Movie constructor to be defined the way we are going to set the actors list
     */
    public Movie(String name) {
        this.name = name;
        this.rating = 0;
        this.actors = new ArrayList<Actor>();
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }


    /**
     * Returns true if setting the rating was possible
     * @param rating
     * @return
     */
    public boolean setRating(double rating) {
        if (rating > 0) {
            this.rating = rating;
            return true;
        }
        return false;
    }

    public double getRating() {
        return this.rating;
    }


    public void addActor(Actor actor) {
        this.actors.add(actor);
    }

    public boolean hasActor(String name) {
        for (Actor anActor : this.actors){
            if (anActor.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    public String[] getActors() {
        String [] theActors = new String[this.actors.size()];
        for (int i = 0; i < this.actors.size(); i++) {
            theActors[i] = this.actors.get(i).getName();
        }
        return theActors;
    }

}

