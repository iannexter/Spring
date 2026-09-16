package com.exemplar.iniciar;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

// tradicional é usada para renderizar páginas e visuais (como HTML via Thymeleaf ou JSP)
@Controller
@RequestMapping("/controller")
public class HelloWorld {

    @GetMapping("/")
    //esse faz converter para json e rodar String na web
    @ResponseBody
    public String paginaPadrao(){

        return "Página Padrão do /controller";

    }

    @GetMapping("/helloworld1")
    @ResponseBody
    public String mostrarMensagem1(){


        return "Olá Mundo do Spring! 1";

    }


    @GetMapping("/helloworld2")
    @ResponseBody
    public String mostrarMensagem2(){


        return "Olá Mundo do Spring! 2";

    }



    //@RestController (APIs RESTful)Objetivo: É uma meta-anotação que equivale
    // a @Controller + @ResponseBody aplicada em nível de classe.
    // Retorno de dados: O valor retornado por qualquer
    // metodo é serializado diretamente (geralmente em formato JSON ou XML)
    // e enviado no corpo da resposta HTTP
}
