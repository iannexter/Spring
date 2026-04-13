package com.iansistemas.criptoApiJdbc.repository;

import com.iansistemas.criptoApiJdbc.entity.Coin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class CoinRepository {


    private static String INSERT = ""

    private JdbcTemplate jdbcTemplate;


    @Autowired
    public CoinRepository(JdbcTemplate jdbcTemplate){

        this.jdbcTemplate = jdbcTemplate;

    }


    public Coin insert(Coin coin){


        jdbcTemplate.update("",)

    }



}
