package com.example.microserviceproductmenagement.repository;

import com.example.microserviceproductmenagement.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository   extends JpaRepository<Customer, Long> {

}
