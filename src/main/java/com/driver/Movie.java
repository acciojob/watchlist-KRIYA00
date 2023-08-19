package com.driver;

public class Movie
{
    public Movie() {

    }

    public Movie(String name, int durationInMinutes, double imdbRating)
    {
        this.name = name;
        this.durationInMinutes = durationInMinutes;
        this.imdbRating = imdbRating;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;
    private int durationInMinutes;
    private double imdbRating;

}
