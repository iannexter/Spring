package com.iansistemas.criptoApiJdbc.repository;

import com.iansistemas.criptoApiJdbc.entity.Coin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


@Repository
@EnableAutoConfiguration
public class CoinRepository {


    private static String INSERT = "insert into coin (name, price, quantity, datetime) values (?,?,?,?)";

    private JdbcTemplate jdbcTemplate;


    @Autowired
    public CoinRepository(JdbcTemplate jdbcTemplate){

        this.jdbcTemplate = jdbcTemplate;

    }


    public Coin insert(Coin coin){


        Object[] attr = new Object[] {

                coin.getName(),
                coin.getPrice(),
                coin.getQuantity(),
                coin.getDatetime()

        };


        //Como seu array é Object[], você pode verificar cada elemento:
        //
        //for (Object obj : attr) {
        //    if (obj instanceof Coin) {
        //        System.out.println("Encontrou um Coin");
        //    }
        //}
        //No seu caso, isso também vai dar false, porque você colocou:
        //
        //coin.getName(),      // String
        //coin.getPrice(),     // BigDecimal/Double
        //coin.getQuantity(),  // Integer
        //coin.getDatetime()   // Date/LocalDateTime
        //
        //Ou seja, não existe nenhum Coin dentro do array, só atributos.

        //Se você realmente tivesse um array de Coin, faria assim:
        //
        //if (attr instanceof Coin[]) {
        //    System.out.println("É um array de Coin");
        //}
        //
        //Mas isso só funciona se o array tiver sido criado como:
        //
        //Coin[] attr = new Coin[...];



        jdbcTemplate.update(INSERT, attr);

        return coin;

    }



}
