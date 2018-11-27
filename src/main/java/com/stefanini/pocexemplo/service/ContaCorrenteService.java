package com.stefanini.pocexemplo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stefanini.pocexemplo.model.Conta;
import com.stefanini.pocexemplo.repository.ContaRepository;

@Service
public class ContaCorrenteService {

	@Autowired
	private ContaRepository repository;
	
	public Conta novoCadastro(Conta conta) {
		return repository.save(conta);
	}
	
}
