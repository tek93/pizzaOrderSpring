package com.example.microserviceproductmenagement.repository;

import com.example.microserviceproductmenagement.model.Cart;
import com.example.microserviceproductmenagement.model.CartDto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CardRepository extends JpaRepository<Cart,Long> {


    List<Cart> findAllByUserId(Long userId);

    List<Cart> findAllByPizzaId(Long pizzaId);

}
