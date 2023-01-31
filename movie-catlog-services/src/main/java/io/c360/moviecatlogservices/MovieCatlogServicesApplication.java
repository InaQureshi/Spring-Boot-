package io.c360.moviecatlogservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
@EnableCircuitBreaker
@EnableEurekaClient
@EnableHystrixDashboard
public class MovieCatlogServicesApplication {

	@Bean
	public RestTemplate getrestTempate(){
		return new RestTemplate();
	}

//	@Bean
//	public WebClient.Builder getBuilder()
//	{
//
//		return WebClient.builder();
//	}

	public static void main(String[] args) {
		SpringApplication.run(MovieCatlogServicesApplication.class, args);
	}

	//@Bean
//	public RestTemplate restTemplate() {
//		HttpComponentsClientHttpRequestFactory httpComponentsClientHttpRequestFactory=new HttpComponentsClientHttpRequestFactory();
//		httpComponentsClientHttpRequestFactory.setReadTimeout(3000); //millisecond
//		return new RestTemplate(httpComponentsClientHttpRequestFactory);
//
//		//return new RestTemplate();
//	}



}
