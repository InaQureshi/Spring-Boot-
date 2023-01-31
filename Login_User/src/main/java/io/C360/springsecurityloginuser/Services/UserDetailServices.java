package io.C360.springsecurityloginuser.Services;

import io.C360.springsecurityloginuser.Entity.MyUserDetails;
import io.C360.springsecurityloginuser.Entity.User;
import io.C360.springsecurityloginuser.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class UserDetailServices implements UserDetailsService {

    @Autowired
    UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

        Optional<User> user=userRepo.findByUserName(userName);

        user.orElseThrow(()-> new UsernameNotFoundException("Not Found :" + userName));

        return user.map(MyUserDetails::new).get();

    }
}
