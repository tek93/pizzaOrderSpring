package com.example.microserviceproductmenagement.repository;

import com.example.microserviceproductmenagement.model.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PizzaRepository extends JpaRepository<Pizza,Long> {

}
