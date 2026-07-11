package com.apirestspringboot.apirest.repository;


import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.apirestspringboot.apirest.model.UserModel;

public interface UserRepository extends JpaRepository<UserModel, UUID>{


    //Executa: SELECT * FROM Users WHERE id = ?
    Optional<UserModel> findById(UUID id);

    //Exemplo:
    //
    //Optional<UserModel> user = repository.findById(id);
    //
    //Se existir:
    //
    //user.isPresent()
    //
    //será true.


    //o Spring entende:
    //
    //Procure um usuário pelo campo name.
    //
    //SELECT * FROM Users WHERE name = ?
    Optional<UserModel> findByName(String name);


    //verifica apenas se existe um registro.
    //
    //SELECT EXISTS(SELECT * FROM Users WHERE model_car = ? AND cel_number = ?)
    //Exemplo: repository.existsByModelCarAndCelNumber(
    //    "Gol",
    //    "9999");
    //
    //Resultado: true
    Boolean existsByModelCarAndCelNumber(String modelCar, String celNumber);


    //Aqui diz: Não gere a consulta automaticamente. Use exatamente este SQL.

    //ativeQuery = true Isso significa: Este comando é SQL puro do banco.

    @Query(value = "SELECT * FROM Users WHERE email = :email", nativeQuery = true)

    Optional<UserModel> buscarPorEmailNativo(@Param("email") String email);

    //@Param
    //@Param("email")
    //String email
    //
    //Essa anotação liga o parâmetro do metodo ao parâmetro nomeado da consulta.
    //
    //Aqui:
    //
    //WHERE email = :email
    //
    //o :email será substituído pelo valor recebido no metodo.
    //
    //Exemplo:
    //
    //repository.buscarPorEmailNativo("joao@gmail.com");
    //
    //O Spring executa:
    //
    //SELECT *
    //FROM Users
    //WHERE email = 'joao@gmail.com'

}
