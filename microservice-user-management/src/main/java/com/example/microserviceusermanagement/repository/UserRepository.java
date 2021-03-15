package com.example.microserviceusermanagement.repository;

import com.example.microserviceusermanagement.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository  extends JpaRepository<User, Long> {

        User findByUsername(String username);

}
