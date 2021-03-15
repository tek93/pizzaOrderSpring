package com.example.microserviceproductmenagement.service;


import com.example.microserviceproductmenagement.model.dto.Purchase;
import com.example.microserviceproductmenagement.model.dto.PurchaseResponse;

public interface CheckoutService {
    PurchaseResponse placeOrder(Purchase purchase);

}
