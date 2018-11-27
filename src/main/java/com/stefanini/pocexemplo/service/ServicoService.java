package com.stefanini.pocexemplo.service;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stefanini.pocexemplo.enums.ServicoEnum;
import com.stefanini.pocexemplo.model.Transacao;
import com.stefanini.pocexemplo.repository.TransacaoRepository;

@Service
public class ServicoService {

	@Autowired
	private TransacaoRepository transacaoRepository;
	
	public List<ServicoEnum> obterServicos() {
		return Arrays.asList(ServicoEnum.values());
	}

	public void novaTransacao(Transacao transacao) {
		transacao.setData(LocalDateTime.now());
		transacaoRepository.save(transacao);
	}

	public List<Transacao> obterTransacoes(Long numeroConta) {
		return transacaoRepository.obterTransacoes(numeroConta);
	}
	
}