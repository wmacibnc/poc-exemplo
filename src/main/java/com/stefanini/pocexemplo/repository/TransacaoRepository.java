package com.stefanini.pocexemplo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.stefanini.pocexemplo.model.Transacao;

public interface TransacaoRepository extends CrudRepository<Transacao, Long>{
	
	@Query("SELECT t FROM Transacao t "
			+ " where t.conta.id = :numeroConta "
			+ " order by t.data ")
	List<Transacao> obterTransacoes(@Param("numeroConta") Long numeroConta);

}
