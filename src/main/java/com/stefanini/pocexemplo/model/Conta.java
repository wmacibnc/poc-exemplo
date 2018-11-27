package com.stefanini.pocexemplo.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
//@EntityListeners(ProjetoListeners.class)
public class Conta {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "CON_ID")
	private Long id;

	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "PES_ID")
	private Pessoa pessoa;

	/**
	 * Construtor padrão
	 */
	public Conta() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	@Override
	public String toString() {
		return "Conta [id=" + id + ", pessoa=" + pessoa + "]";
	}

}