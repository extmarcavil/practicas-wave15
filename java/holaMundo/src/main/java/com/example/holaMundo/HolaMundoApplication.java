package com.example.holaMundo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication //cada vez que hay un @ es una anotacion. Inicializa el programa.
public class HolaMundoApplication {

	public static void main(String[] args) {

		SpringApplication.run(HolaMundoApplication.class, args);
	}

}
