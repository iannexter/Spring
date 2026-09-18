package com.exemplar.iniciar.controller;


import com.exemplar.iniciar.entities.Pessoa;
import com.exemplar.iniciar.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
@RequestMapping("/pessoas")
public class PessoaController {


    @Autowired
    private PessoaService pessoaService;



    @GetMapping
    //model é um objeto usado para transportar dados do Controller para a View
    public String listarPessoas(Model model){

        List<Pessoa> pessoas = pessoaService.obterPessoas();

        model.addAttribute("pessoas", pessoas);


        //retorna uma página
        return "listar";

    }


















    // @GetMapping("/saudar")
    //    public String saudarUsuario(Model model) {
    //        // Adiciona dados ao Model (Chave, Valor)
    //        model.addAttribute("mensagem", "Olá, seja bem-vindo ao Spring!");
    //        model.addAttribute("usuario", "Maria");
    //
    //        // Retorna o nome da página HTML (ex: saudar.html)
    //        return "saudar";
    //    }

}
