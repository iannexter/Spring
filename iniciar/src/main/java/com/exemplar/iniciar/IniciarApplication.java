package com.exemplar.iniciar;

import com.exemplar.iniciar.entities.Pessoa;
import com.exemplar.iniciar.repository.PessoaRepository;
import com.exemplar.iniciar.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.SQLOutput;
import java.util.List;

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
public class IniciarApplication implements CommandLineRunner {


	@Autowired
	public PessoaRepository pessoaRepository;


	//chamar a interface chama automaticamente a sua implementacao
	@Autowired
	public PessoaService pessoaService;

	public static void main(String[] args) {
		SpringApplication.run(IniciarApplication.class, args);


	}

	@Override
	public void run(String... args) throws Exception {

//		Pessoa pessoa = new Pessoa();
//
//		pessoa.setId(1L);
//		pessoa.setNome("João");
//		pessoa.setIdade(23);
//
//
//		pessoaRepository.save(pessoa);
//
//		Pessoa pessoa2 = new Pessoa(2l, "Cristiano", 26);
//
//		pessoaRepository.save(pessoa2);


//		pessoaService.criarPessoa(new Pessoa(5L, "Felipe", 19));
//
//		pessoaService.criarPessoa(new Pessoa(6L, "Matheus", 21));
//
//		pessoaService.criarPessoa(new Pessoa(7L, "Pedro", 23));


		System.out.println("Número de pessoas salvas: " + pessoaRepository.count());


		System.out.println("Numero de pessoas salvas: " + pessoaService.contarPessoas());

		//Mostrar a lista de pessoas:

		List<Pessoa> pessoasLista = pessoaRepository.findAll();

		pessoasLista.forEach(p -> System.out.println("Nome das pessoas: " + p.getNome()));


		List<Pessoa> pessoasLista2 = pessoaService.obterPessoas();


	}
}
