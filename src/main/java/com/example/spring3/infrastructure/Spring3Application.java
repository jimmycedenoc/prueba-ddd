package com.example.spring3.infrastructure;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.example.spring3.application", "com.example.spring3.infrastructure"})
public class Spring3Application {

	public static void main(String[] args) {
		SpringApplication.run(Spring3Application.class, args);
	}

}
