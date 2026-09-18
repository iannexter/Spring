package com.exemplar.iniciar.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tabela_pessoas")

//Lombok
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pessoa {


    @Id
    private Long id;

    private String nome;

    private int idade;

}
