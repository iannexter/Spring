package com.exemplar.iniciar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//ORM(Object Relational Mapping) tecnica usada para mapear objetos
//em linguagens orientadas a objetos para tabelas em uma base de
//dados relacional


//MVC camada de apresentacao, camada de negocio e camada de acesso a dados

//JPA define entidades, define relacoes e define comportamento

//hibernate trata-se de uma ferramenta de ORM

//Spring data trata-se de um projeto dentro do ecossistema Spring
//que simplifica o acesso a base de dados e a persistencia
//de maneira geral

//Spring data JPA trata-se de uma sub-parte do Spring data

//inversao de controle é uma tecnica para reduzir o acoplamento entre classes

//essa anotacao coloca o @EnableAutoConfiguration @ComponentScan e @SpringBootConfiguration
@SpringBootApplication
public class IniciarApplication {

	public static void main(String[] args) {
		SpringApplication.run(IniciarApplication.class, args);
	}

}
