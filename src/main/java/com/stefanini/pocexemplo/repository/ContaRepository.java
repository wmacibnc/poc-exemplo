package com.stefanini.pocexemplo.repository;

import org.springframework.data.repository.CrudRepository;

import com.stefanini.pocexemplo.model.Conta;

public interface ContaRepository extends CrudRepository<Conta, Long>{

}
