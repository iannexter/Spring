package com.exemplar.iniciar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


//essa anotacao coloca o @EnableAutoConfiguration @ComponentScan e @SpringBootConfiguration
@SpringBootApplication
public class IniciarApplication {

	public static void main(String[] args) {
		SpringApplication.run(IniciarApplication.class, args);
	}

}
