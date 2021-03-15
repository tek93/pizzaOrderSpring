package com.example.microserviceproductmenagement.service;

import com.example.microserviceproductmenagement.model.Customer;
import com.example.microserviceproductmenagement.model.Order;
import com.example.microserviceproductmenagement.model.OrderItem;
import com.example.microserviceproductmenagement.model.dto.Purchase;
import com.example.microserviceproductmenagement.model.dto.PurchaseResponse;
import com.example.microserviceproductmenagement.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Service
@AllArgsConstructor
public class CheckoutServiceImpl implements CheckoutService {

    private CustomerRepository customerRepository;



    @Override
    @Transactional
    public PurchaseResponse placeOrder(Purchase purchase) {
       // retrive the order info from dto
        Order order = new Order();

        //generate number order;
        //populate order with orderItems
        Set<OrderItem> orderItems = purchase.getOrderItems();

        //populate order with deliveryaddress
        orderItems.forEach(item -> order.add(item));
        //populate customer with order
        order.setDeliveryAddress(purchase.getDeliveryAddress());
        Customer customer = new Customer();
        customer.add(order);

        //save to the db
        customerRepository.save(customer);
        //retur  response
        return new PurchaseResponse();

    }
}
