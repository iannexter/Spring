package com.exemplar.iniciar.service;

import com.exemplar.iniciar.entities.Pessoa;

import java.util.List;

public interface PessoaService {

    List<Pessoa> obterPessoas();


    Pessoa obterPessoaPeloId(Long id);

    Pessoa criarPessoa(Pessoa pessoa);

    Pessoa atualizarPessoa(Long id, Pessoa pessoa);

    void eliminarPessoa(Long id);

    Long contarPessoas();

}
