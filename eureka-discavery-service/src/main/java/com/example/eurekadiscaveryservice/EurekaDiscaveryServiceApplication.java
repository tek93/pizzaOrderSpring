package com.example.eurekadiscaveryservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaDiscaveryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaDiscaveryServiceApplication.class, args);
	}

}
