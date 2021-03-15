package com.example.microserviceusermanagement.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;

@Data
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;
    @Column(name = "email")
    @Email
    private String email;
    @Column(name = "tel")
    private String tel;

    //role
    @Enumerated(value = EnumType.STRING)
    @Column(name = "role")
    private Role role;

}
