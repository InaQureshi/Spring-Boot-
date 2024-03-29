package io.c360.movieinfoservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
public class MovieInfoServicesApplication {

	@Bean
	public RestTemplate restTemplate() {
		return
				new RestTemplate();
	}

	public static void main(String[] args) {


		SpringApplication.run(MovieInfoServicesApplication.class, args);
	}

}
