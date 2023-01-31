package io.C360.redisexamplespring;

import io.C360.redisexamplespring.Repository.ProductRepo;
import io.C360.redisexamplespring.entity.Products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SpringBootApplication

public class RedisExampleApplication {


	public static void main(String[] args) {
		SpringApplication.run(RedisExampleApplication.class, args);
	}

}
