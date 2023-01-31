package io.C360.springsecurityloginuser;

import io.C360.springsecurityloginuser.Repository.UserRepo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = UserRepo.class)
public class LoginUserApplication {

	public static void main(String[] args) {

		SpringApplication.run(LoginUserApplication.class, args);
	}

}
