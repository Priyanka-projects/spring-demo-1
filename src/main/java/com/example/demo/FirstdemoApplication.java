package com.example.demo;

import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages="com.example.demo")
public class FirstdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(FirstdemoApplication.class, args);
		System.out.println("aplication started");
	}

}
