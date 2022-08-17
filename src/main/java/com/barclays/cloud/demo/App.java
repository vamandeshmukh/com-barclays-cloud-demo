package com.barclays.cloud.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App {

	public static void main(String[] args) {
		System.out.println("App starting...");
		SpringApplication.run(App.class, args);
		System.out.println("App started.");
	}

}
