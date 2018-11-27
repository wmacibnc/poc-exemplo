package com.stefanini.pocexemplo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.stefanini.pocexemplo.model.Conta;
import com.stefanini.pocexemplo.service.ContaCorrenteService;

@RestController
@RequestMapping("/conta")
public class ContaController {

	@Autowired
	ContaCorrenteService service;
	
	@RequestMapping(method = RequestMethod.POST, value="/novo-cadastro", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Conta> novoCadastro(@RequestBody Conta conta){
		return new ResponseEntity<>(service.novoCadastro(conta), HttpStatus.OK);
	}
}
