package com.example.microserviceusermanagement.service;

import com.example.microserviceusermanagement.model.User;
import com.example.microserviceusermanagement.repository.UserRepository;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    //bean is in security config
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public User save(User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }
    @Override
    public User findByUsername(String username){
        return userRepository.findByUsername(username);
    }
    @Override
    public List<User> getAll(){
       return userRepository.findAll();
    }
}
