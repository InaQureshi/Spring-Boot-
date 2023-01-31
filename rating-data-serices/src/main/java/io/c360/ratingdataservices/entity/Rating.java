package io.c360.ratingdataservices.entity;

public class Rating {

    public String movieid;

    public int rating;

    public String getMovieid() {
        return movieid;
    }

    public void setMovieid(String movieid) {
        this.movieid = movieid;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public Rating(String movieid, int rating) {
        this.movieid = movieid;
        this.rating = rating;
    }
}
