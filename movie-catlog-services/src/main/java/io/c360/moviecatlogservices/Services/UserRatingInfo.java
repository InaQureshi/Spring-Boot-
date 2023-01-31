package io.c360.moviecatlogservices.Services;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import io.c360.moviecatlogservices.Entity.Rating;
import io.c360.moviecatlogservices.Entity.UserRating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@Service
public class UserRatingInfo {

    @Autowired
    public RestTemplate restTemplate;

    public UserRating getFallBackUserRatings(@PathVariable("userid") String userid){
        UserRating userRating=new UserRating();
        userRating.setUserid(userid);
        userRating.setUserRating(
                Arrays.asList(
                        new Rating("",0)
                ));
        return userRating;
    }
    @HystrixCommand(fallbackMethod = "getFallBackUserRatings"
                    ,commandProperties =
            {
                    @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "2000"),
                    @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "5"),

                    @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "5000")
            }
    )


    // @HystrixProperty(name = "circuitBreaker.errorThresholdPrecentage",value = "50"),

    public UserRating getUserRating(@PathVariable("userid") String userid)
    {

        return  restTemplate.getForObject("http://Rating-Data-Services/users/"+userid , UserRating.class);
    }



}
