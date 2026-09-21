package com.exemplar.iniciar.service.impl;

import com.exemplar.iniciar.entities.Pessoa;
import com.exemplar.iniciar.repository.PessoaRepository;
import com.exemplar.iniciar.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;



//O Impl (abreviação de Implementation ou Implementação) é uma
// convenção de nomenclatura em Java e no framework Spring
// usada para indicar a classe que implementa o código real de
// uma regra de negócio definida anteriormente por uma interface.

@Service
public class PessoaServiceImpl implements PessoaService {

    @Autowired
    PessoaRepository pessoaRepository;



    @Override
    public List<Pessoa> obterPessoas() {
        return pessoaRepository.findAll();
    }


    @Override
    public Pessoa obterPessoaPeloId(Long id) {
        return pessoaRepository.findById(id).orElse(null);
    }

    @Override
    public Pessoa criarPessoa(Pessoa pessoa) {
        return pessoaRepository.save(pessoa);
    }

    @Override
    public Pessoa atualizarPessoa(Long id, Pessoa pessoa) {

        Pessoa pessoaBBDD = pessoaRepository.findById(id).orElse(null);

        if(pessoaBBDD != null) {

            pessoaBBDD.setNome(pessoa.getNome());
            pessoaBBDD.setIdade(pessoa.getIdade());

            return pessoaRepository.save(pessoaBBDD);

        }

        return null;

    }

    @Override
    public void eliminarPessoa(Long id) {

        pessoaRepository.deleteById(id);

    }

    @Override
    public Long contarPessoas() {
        return pessoaRepository.count();
    }
}
