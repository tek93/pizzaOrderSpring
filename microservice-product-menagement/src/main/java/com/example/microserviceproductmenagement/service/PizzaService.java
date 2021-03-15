package com.example.microserviceproductmenagement.service;

import com.example.microserviceproductmenagement.model.Cart;
import com.example.microserviceproductmenagement.model.CartDto;
import com.example.microserviceproductmenagement.model.Pizza;

import java.util.List;

public interface PizzaService {
    List<Pizza> allPizza();

    Pizza findPizzaById(Long pizzaId);

    List<CartDto>findCardOfUser(Long userId);

    List<Cart>findCartOfPizza(Long pizzaId);

    Cart addToCart(Cart cart);

    Cart findCartOfId(Long id);

    Pizza addNewPizza(Pizza pizza);
}
