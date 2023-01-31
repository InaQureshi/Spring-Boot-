package io.c360.movieinfoservices.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Movie {

    String movieid;
@JsonProperty("original_title")
    String movieName;
    String name;
@JsonProperty("backdrop_path")
    String backdrop ;


}
