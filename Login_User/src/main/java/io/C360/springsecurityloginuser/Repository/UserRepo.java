package io.C360.springsecurityloginuser.Repository;

import io.C360.springsecurityloginuser.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User,Integer> {

    Optional<User> findByUserName(String userName);
}
