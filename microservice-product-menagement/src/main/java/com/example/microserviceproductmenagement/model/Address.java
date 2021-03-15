package com.example.microserviceproductmenagement.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "address")
@Getter
@Setter
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

        private String street;
        private String houseNumber;
        private String city;
        private String postCode;
        @OneToOne
        @PrimaryKeyJoinColumn
        private Order order;


}
