package io.c360.ratingdataservices.ratingresource;


import io.c360.ratingdataservices.entity.Rating;
import io.c360.ratingdataservices.entity.UserRating;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
//@RequestMapping("/ratings")
public class RatingResource {

    @RequestMapping("/{movieid}")
    public Rating geRating(@PathVariable("movieid")String moiveid){
        return new Rating(moiveid,2);
    }

    @RequestMapping("users/{userid}")
    public UserRating getUser(@PathVariable("userid")String userid)
    {
        List<Rating> ratings= Arrays.asList(
                new Rating("one",121),
                new Rating("second",120),
                new Rating("second",120),
                new Rating("second",120)
        );
        UserRating userRating=new UserRating();
        userRating.setUserRating(ratings);
        return userRating;
    }
}
