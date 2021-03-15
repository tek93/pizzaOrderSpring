package com.example.microserviceproductmenagement.controller;

import com.example.microserviceproductmenagement.model.dto.Purchase;
import com.example.microserviceproductmenagement.model.dto.PurchaseResponse;
import com.example.microserviceproductmenagement.service.CheckoutService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/service/checkout")
@AllArgsConstructor
public class CheckoutController {

    private CheckoutService checkoutService;


    @PostMapping("/purchase")
    public PurchaseResponse pleaceOrder(@RequestBody Purchase purchase){
        PurchaseResponse purchaseResponse = checkoutService.placeOrder(purchase);
        return purchaseResponse;
    }




}
