package com.example.microserviceproductmenagement.model.dto;

import com.example.microserviceproductmenagement.model.Address;
import com.example.microserviceproductmenagement.model.Customer;
import com.example.microserviceproductmenagement.model.Order;
import com.example.microserviceproductmenagement.model.OrderItem;
import lombok.Data;

import java.util.Set;

@Data

public class Purchase {
    private Customer customer;
    private Address deliveryAddress;
    private Order order;
    private Set<OrderItem> orderItems;


}
