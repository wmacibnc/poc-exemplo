package com.stefanini.pocexemplo.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.stefanini.pocexemplo.model.Conta;
import com.stefanini.pocexemplo.model.Pessoa;
import com.stefanini.pocexemplo.service.ContaCorrenteService;

@RestController
@RequestMapping("/conta")
@CrossOrigin(origins = "*")
public class ContaController {

	@Autowired
	ContaCorrenteService service;
	
	@RequestMapping(method = RequestMethod.POST, value="/novo-cadastro", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Conta> novoCadastro(@RequestBody Conta conta){
		return new ResponseEntity<>(service.novoCadastro(conta), HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value="/atualizar/{numeroConta}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> atualizarNumeroConta(@PathVariable("numeroConta") Long numeroConta, HttpServletRequest req) {
		req.getServletContext().setAttribute("numeroConta", numeroConta);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.GET, value="/obter-numero-conta", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Long> obterNumeroConta(HttpServletRequest req) {
		Long numeroConta = Long.parseLong(req.getServletContext().getAttribute("numeroConta").toString());
		return new ResponseEntity<>(numeroConta, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.GET, value="/obter-nome-conta", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Pessoa> obterNomeConta(HttpServletRequest req) {
		return new ResponseEntity<>(service.obterNomeConta(req), HttpStatus.OK);
	}
}
