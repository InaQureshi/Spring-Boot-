package io.c360.moviecatlogservices.Services;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import io.c360.moviecatlogservices.Entity.CatlogItems;
import io.c360.moviecatlogservices.Entity.Movie;
import io.c360.moviecatlogservices.Entity.Rating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MovieInfo {

    @Autowired
    public RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "getFallBackCatlogItems"
            ,commandProperties =
            {
                    @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "2000"),
                    @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "5"),

                    @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "5000")
            }
    )
    public CatlogItems getCatlogItems(Rating rating) {
        Movie movie= restTemplate.getForObject(
                "https://api.themoviedb.org/3/movie/550?api_key=05c89f580be95b4dd3ebc64d84923da8",
                Movie.class);

        return new CatlogItems(movie.getName(), movie.getMovieName(), rating.getRating());
        //return new CatlogItems(movie.getName(), "DESCRIPTION", rating.getRating());
    }



    public CatlogItems getFallBackCatlogItems(Rating rating){

        return new CatlogItems("No Movie Found!!","",rating.getRating());
    }


}
