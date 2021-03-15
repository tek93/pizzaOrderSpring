package com.example.microserviceproductmenagement.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
@Data
@Table(name = "pizza")
@Entity
@Getter
@Setter
public class Pizza {
        @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "price")
    private String  price;
    @Column(name = "category")
    private String  category;
    @Column(name = "size")
    private String  size;

    @Column(name = "picByte", length = 10000)
    private byte[] picByte;






}
