package com.stefanini.pocexemplo.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stefanini.pocexemplo.model.Conta;
import com.stefanini.pocexemplo.model.Pessoa;
import com.stefanini.pocexemplo.repository.ContaRepository;

@Service
public class ContaCorrenteService {

	@Autowired
	private ContaRepository repository;
	
	public Conta novoCadastro(Conta conta) {
		return repository.save(conta);
	}

	public Pessoa obterNomeConta(HttpServletRequest req) {
		if(req.getServletContext().getAttribute("numeroConta") !=null) {
			Long numeroConta = Long.parseLong(req.getServletContext().getAttribute("numeroConta").toString());
			return repository.findById(numeroConta).get().getPessoa();
		}
		return null;
	}
	
}
