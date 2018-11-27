package com.stefanini.pocexemplo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.stefanini.pocexemplo.enums.ServicoEnum;
import com.stefanini.pocexemplo.model.Transacao;
import com.stefanini.pocexemplo.service.ServicoService;

@RestController
@RequestMapping("/servico")
public class ServicoController {

	@Autowired
	ServicoService service;
	
	@RequestMapping(method = RequestMethod.GET, value="/obter", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ServicoEnum>> obterServicos() {
		return new ResponseEntity<>(service.obterServicos(), HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST, value="/nova-transacao", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> novaTransacao(@RequestBody Transacao transacao){
		service.novaTransacao(transacao);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.GET, value="obter-transacoes/{numeroConta}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Transacao>> obterTransacoes(@PathVariable("numeroConta") Long numeroConta) {
		return new ResponseEntity<>(service.obterTransacoes(numeroConta), HttpStatus.OK);
	}
}