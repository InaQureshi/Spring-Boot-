package io.C360.springthymeleafdatabase.Services;

import io.C360.springthymeleafdatabase.Controller.Dto.UserRegistrationDto;
import io.C360.springthymeleafdatabase.Entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    User save(UserRegistrationDto registrationDto);
}
