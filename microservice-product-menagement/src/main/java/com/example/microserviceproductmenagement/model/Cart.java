package com.example.microserviceproductmenagement.model;

import lombok.Data;

import javax.persistence.*;

@Table(name = "card")
@Entity
@Data
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "pizza_id", referencedColumnName = "id")
    private Pizza pizza;

    @Column(name = "user_id")
    private Long userId;
    @Column(name = "quantity")
    private Long quantity;



}
