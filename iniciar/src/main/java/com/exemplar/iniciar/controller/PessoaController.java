package com.exemplar.iniciar.controller;


import com.exemplar.iniciar.entities.Pessoa;
import com.exemplar.iniciar.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/pessoas")
public class PessoaController {


    @Autowired
    private PessoaService pessoaService;


    //O que vai acontecer:
    //Navegador
    //   ↓
    //PessoaController
    //   ↓
    //PessoaService
    //   ↓
    //Banco de dados
    //   ↓
    //List<Pessoa>
    //   ↓
    //Model
    //   ↓
    //listar.html
    //   ↓
    //Tabela na tela


    @GetMapping
    //model é um objeto usado para transportar dados do Controller para a View
    public String listarPessoas(Model model){

        List<Pessoa> pessoas = pessoaService.obterPessoas();


        model.addAttribute("pessoas", pessoas);


        //retorna uma página
        return "listar";

    }




    @GetMapping("/nova")
    public String mostrarFormulario(Model model) {

        Pessoa pessoa = new Pessoa();

        model.addAttribute("pessoa", pessoa);

        return "formulario";
    }


    @PostMapping("/nova")
    public String salvarPessoa(@ModelAttribute Pessoa pessoa) {

        pessoaService.criarPessoa(pessoa);

        return "redirect:/pessoas";
    }











//        @GetMapping("/nova")
//        public String mostrarFormularioDeNovaPessoa(Model model){
//
//        model.addAttribute("pessoa", new Pessoa());


        //model.addAttribute("acao", "/pessoas/nova");
        //
        //Então o Thymeleaf gera algo equivalente a:
        //
        //<form action="/pessoas/nova" method="post">

        //"Coloque dentro do Model uma informação chamada acao,
        // cujo valor é /pessoas/nova."
        //
        //Imagine o Model como uma caixa
        // que o Controller entrega para o HTML.
        //O "acao" é o nome que o Thymeleaf vai usar para
        // encontrar essa informação.
        //
        //E "/pessoas/nova" é o valor.

            //coloca esse objeto dentro do Model com o nome "pessoa":
            //
            //Model
            //┌────────────────────────────┐
            //│ "pessoa" → Pessoa          │
            //│                            │
            //│            ┌────────────┐  │
            //│            │ id = null  │  │
            //│            │ nome=null  │  │
            //│            │ idade=0    │  │
            //│            └────────────┘  │
            //└────────────────────────────┘
            //2. O th:object="${pessoa}"
            //
            //Agora o Thymeleaf recebe esse Model.
            //
            //Você escreveu:
            //
            //<form th:object="${pessoa}">
            //
            //O:
            //
            //${pessoa}
            //
            //significa:
            //
            //"Pegue do Model o objeto chamado pessoa."
            //
            //Então:
            //
            //th:object="${pessoa}"
//        model.addAttribute("acao", "/pessoas/nova");
//
//        return "formulario";
//
//        }

        //Ele vai receber do front-end via POST um objeto
        //@ModelAttribute
//        @PostMapping("/nova")
//        public String salvarNovaPessoa(@ModelAttribute Pessoa pessoa){
//
//            pessoaService.criarPessoa(pessoa);
//
//            return "redirect:/pessoas";
//
//        }
















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
