package io.c360.movieinfoservices.resources;

import io.c360.movieinfoservices.entity.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/movies")
public class MovieResource {

    @Value("${api.key}")
    private String apiKey;

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/{movieid}")
    public Movie getMovie(@PathVariable("movieid")String movieid)
    {
        Movie movie= restTemplate.getForObject(
                "https://api.themoviedb.org/3/movie/550?api_key=05c89f580be95b4dd3ebc64d84923da8",
                Movie.class
        );


        return movie;
    }


}