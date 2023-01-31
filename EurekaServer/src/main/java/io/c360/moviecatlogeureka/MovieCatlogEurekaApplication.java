package io.c360.moviecatlogeureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class MovieCatlogEurekaApplication {

	public static void main(String[] args) {
		SpringApplication.run(MovieCatlogEurekaApplication.class, args);
	}

}
