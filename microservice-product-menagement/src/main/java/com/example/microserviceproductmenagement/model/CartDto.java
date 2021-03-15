package com.example.microserviceproductmenagement.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
@Getter
@Setter
public class CartDto {

    private Long id;

    private String name;
    private  String price;
    private String size;


    private Long userId;

    private Long quantity;
}
