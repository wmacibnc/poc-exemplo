package com.stefanini.pocexemplo.repository;

import org.springframework.data.repository.CrudRepository;

import com.stefanini.pocexemplo.model.Pessoa;

public interface PessoaRepository extends CrudRepository<Pessoa, Long>{

}
