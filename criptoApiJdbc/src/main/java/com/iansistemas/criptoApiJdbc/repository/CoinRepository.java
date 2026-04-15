package com.iansistemas.criptoApiJdbc.repository;

import com.iansistemas.criptoApiJdbc.entity.Coin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


@Repository
@EnableAutoConfiguration
public class CoinRepository {


    private static String INSERT = "insert into coin (name, price, quantity, datetime) values (?,?,?,?)";

    private static String SELECT_ALL = "select name, sum(quantity) as quantity from coin group by name";

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



    //RowMapper é uma interface do Spring usada para
    // converter cada linha de um ResultSet (resultado do banco de dados) em um objeto Java.

    //Para cada linha retornada do banco:
    //Chama o metodo mapRow(...)
    //Junta todos os objetos retornados em uma List<Coin>

    public List<Coin> getAll(){

        return jdbcTemplate.query(SELECT_ALL, new RowMapper<Coin>() {
            @Override
            public Coin mapRow(ResultSet rs, int rowNum) throws SQLException {


                Coin coin = new Coin();

                coin.setName(rs.getString("name"));
                coin.setQuantity(rs.getBigDecimal("quantity"));


                return coin;

            }
        });


    }

}
