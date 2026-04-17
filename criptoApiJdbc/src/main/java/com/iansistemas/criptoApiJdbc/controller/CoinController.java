package com.iansistemas.criptoApiJdbc.controller;


import com.iansistemas.criptoApiJdbc.entity.Coin;
import com.iansistemas.criptoApiJdbc.repository.CoinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;

@RestController
@RequestMapping("/coin")
public class CoinController {



    private CoinRepository coinRepository;

    @Autowired
    public CoinController(CoinRepository coinRepository){

        this.coinRepository = coinRepository;
    }


    @PostMapping
    public ResponseEntity post(@RequestBody  Coin coin) {


        try{

            coin.setDatetime(new Timestamp(System.currentTimeMillis()));


            return new ResponseEntity<>(coinRepository.insert(coin), HttpStatus.CREATED);
        } catch(Exception error){

            return new ResponseEntity<>(error.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);

        }

    }



    @GetMapping
    public ResponseEntity get(){

        return new ResponseEntity<>(coinRepository.getAll(), HttpStatus.OK);

    }


    @GetMapping("/{name}")
    public ResponseEntity get(@PathVariable String name){

        try{

            return new ResponseEntity<>(coinRepository.getByName(name), HttpStatus.OK);

        }catch (Exception error){

            return new ResponseEntity<>(error.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);


        }


    }


}
