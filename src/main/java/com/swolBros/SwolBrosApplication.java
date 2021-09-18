package com.swolBros;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages="com.swolBros")
public class SwolBrosApplication {
		
	public static void main(String[] args) {
		SpringApplication.run(SwolBrosApplication.class, args);
		System.out.println("back-end running");
	}	

}
