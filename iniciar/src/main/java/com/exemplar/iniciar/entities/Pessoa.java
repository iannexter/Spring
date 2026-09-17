package com.exemplar.iniciar.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tabela_pessoas")
public class Pessoa {


    @Id
    private Long id;

    private String nome;

    private int idade;

}
