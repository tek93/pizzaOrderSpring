package com.example.microserviceproductmenagement.service;

import com.example.microserviceproductmenagement.model.Cart;
import com.example.microserviceproductmenagement.model.CartDto;
import com.example.microserviceproductmenagement.model.Pizza;
import com.example.microserviceproductmenagement.model.converter.PizzaConverter;
import com.example.microserviceproductmenagement.repository.CardRepository;
import com.example.microserviceproductmenagement.repository.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PizzaServiceImpl  implements PizzaService{

    @Autowired
    private PizzaRepository pizzaRepository;
    @Autowired
    private CardRepository cardRepository;
    @Autowired
  private   PizzaConverter pizzaConverter;

    @Override
    public List<Pizza>allPizza(){
        return pizzaRepository.findAll();
    }
    @Override
    public Pizza findPizzaById(Long pizzaId){
        return pizzaRepository.findById(pizzaId).orElse(null);
    }

    @Override
    public List<CartDto>findCardOfUser(Long userId){
    return   pizzaConverter.findforuser(userId);



    }
    @Override
    public List<Cart>findCartOfPizza(Long pizzaId){
        return cardRepository.findAllByPizzaId(pizzaId);
    }
    @Override
    public  Cart addToCart(Cart cart){
        return cardRepository.save(cart);
    }

    @Override
    public Cart findCartOfId(Long id) {
       Cart cart =  cardRepository.findById(id).orElseThrow();
      Long qty =   cart.getQuantity()-1;
      cart.setQuantity(qty);
      return cardRepository.save(cart);
    }
    @Override
    public Pizza addNewPizza(Pizza pizza){

      return   pizzaRepository.save(pizza);
    }
}
