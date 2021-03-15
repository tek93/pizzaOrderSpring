package com.example.microserviceproductmenagement.controller;

import com.example.microserviceproductmenagement.intercomm.UserClient;
import com.example.microserviceproductmenagement.model.Cart;
import com.example.microserviceproductmenagement.model.Pizza;
import com.example.microserviceproductmenagement.service.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    private UserClient userClient;
    @Autowired
    private PizzaService pizzaService;
    @Autowired
    private DiscoveryClient discoveryClient;
    @Autowired
    private Environment env;
    @Value("${spring.application.name}")
    private String serviceId;

    private byte[] bytes;

    @PostMapping("/service/upload")
    public void uploadImage(@RequestParam("imageFile") MultipartFile file) throws IOException {
        this.bytes = file.getBytes();
    }

    public String getPort(){
        return "Service is working at port "+env.getProperty("local.server.port");

    }

    @GetMapping("/service/cart/{userId}")
    public ResponseEntity<?> findCartOfUser(@PathVariable Long userId){
        return ResponseEntity.ok(pizzaService.findCardOfUser(userId));

    }

    @PostMapping("/service/add")
    public ResponseEntity<?> addToCart(@RequestBody Cart cart){
        cart.setPizza(pizzaService.findPizzaById(cart.getPizza().getId()));
        return new ResponseEntity<>(pizzaService.addToCart(cart), HttpStatus.CREATED);

    }
   @PostMapping("/service/product/add")
   public Pizza addProduct(@RequestBody Pizza pizza){
        pizza.setPicByte(this.bytes);
       Pizza pizza1 = pizzaService.addNewPizza(pizza);
       this.bytes = null;
       return pizza1;
   }
   @PutMapping("/service/remove")
    public ResponseEntity<?> editToCart(@RequestBody Cart cart){


       return new ResponseEntity<>( pizzaService.findCartOfId(cart.getId()), HttpStatus.CREATED);
    }
    @GetMapping("/service/all")
    public List<Pizza> getAllPizza(){
        return pizzaService.allPizza();
    }
    @PostMapping("/service/{id}")
    public  Pizza getPizza(@PathVariable Long id){
     return    pizzaService.findPizzaById(id);
    }

}
