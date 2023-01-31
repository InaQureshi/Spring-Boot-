package io.c360.moviecatlogservices.Entity;

import java.util.List;

public class UserRating {

   private List<Rating> userRating;

   private String userid;

    public UserRating() {
    }

    public UserRating(List<Rating> userRating, String userid) {
        this.userRating = userRating;
        this.userid = userid;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public List<Rating> getUserRating() {
        return userRating;
    }

    public void setUserRating(List<Rating> userRating) {
        this.userRating = userRating;
    }
}
