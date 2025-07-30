package com.project.ToDo.repository;

import com.project.ToDo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {

    boolean existsByEmail(String email) ;

    Optional<User> findByUserName(String userName);
}
