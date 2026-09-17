package com.exemplar.iniciar.repository;

import com.exemplar.iniciar.entities.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {


}
