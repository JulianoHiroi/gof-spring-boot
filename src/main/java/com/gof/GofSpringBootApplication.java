package com.gof;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class GofSpringBootApplication {
	public static void main(String[] args) {
		SpringApplication.run(GofSpringBootApplication.class, args);
	}
}
