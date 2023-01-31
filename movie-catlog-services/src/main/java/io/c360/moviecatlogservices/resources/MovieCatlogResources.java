package io.c360.moviecatlogservices.resources;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import io.c360.moviecatlogservices.Entity.CatlogItems;
import io.c360.moviecatlogservices.Entity.Movie;
import io.c360.moviecatlogservices.Entity.Rating;
import io.c360.moviecatlogservices.Entity.UserRating;
import io.c360.moviecatlogservices.Services.MovieInfo;
import io.c360.moviecatlogservices.Services.UserRatingInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/catlog")
public class MovieCatlogResources {

    @Autowired
    public RestTemplate restTemplate;

//    @Autowired
//    WebClient.Builder webClientBuilder;
   @Autowired
    MovieInfo movieInfo;

    @Autowired
    UserRatingInfo userRatingInfo;


     @RequestMapping("/{userid}")
    public List<CatlogItems> getCatlogitems(@PathVariable("userid") String userid){
         UserRating userRating= userRatingInfo.getUserRating(userid);
        //UserRating ratings=restTemplate.getForObject();
        return userRating.getUserRating().stream().map(rating ->{return movieInfo.getCatlogItems(rating); })
                .collect(Collectors.toList());

     }

}

//        return Collections.singletonList(
//                new CatlogItems("Robot","robotic",4));

//        WebClient.Builder builder= WebClient.builder();
//
//        List<Rating> ratings= Arrays.asList(
//                new Rating("First",2),
//                new Rating("Second",3),
//                new Rating("Third",4)
//        );

//        Movie movie=  webBuilder.build()
//                    .get()
//                    .uri("http://localhost:8082/movies/"+rating.getMovieid())
//                    .retrieve()
//                    .bodyToMono(Movie.class)
//                    .block();