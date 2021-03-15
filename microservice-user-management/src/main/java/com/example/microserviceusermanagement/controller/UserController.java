package com.example.microserviceusermanagement.controller;

import com.example.microserviceusermanagement.model.Role;
import com.example.microserviceusermanagement.model.User;
import com.example.microserviceusermanagement.service.UserService;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;
import java.security.Principal;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private DiscoveryClient discoveryClient;
    @Autowired
    private Environment env;


    @PostMapping("service/registration")
    public ResponseEntity<?>save(@RequestBody User user){
        if(userService.findByUsername(user.getUsername())!=null){
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        user.setRole(Role.USER);
        return new  ResponseEntity<>(userService.save(user), HttpStatus.CREATED);
    }

    @GetMapping("service/login")
    public ResponseEntity<?>getUser(Principal principal){

        if(principal ==null||principal.getName()==null){
            //ok
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return ResponseEntity.ok(userService.findByUsername(principal.getName()));


    }
    @GetMapping("service/test")
    public ResponseEntity<?>test(){
        return ResponseEntity.ok("Działa!");
    }
    @GetMapping("service/port")
    public String getPort(){
        return env.getProperty("local.server.port");
    }
    @GetMapping("service/all")
    public List<User> getAll(){
        return userService.getAll();
    }



}
