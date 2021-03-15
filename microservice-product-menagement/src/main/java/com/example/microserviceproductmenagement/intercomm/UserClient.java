package com.example.microserviceproductmenagement.intercomm;

import org.springframework.cloud.openfeign.FeignClient;

import java.util.List;

@FeignClient("user-service")
public interface UserClient {

//    List<String>getUserNames()
}
