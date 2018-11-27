package com.stefanini.pocexemplo.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.stefanini.pocexemplo.converter.LocalDateTimeConverter;
import com.stefanini.pocexemplo.enums.ServicoEnum;

@Entity
//@EntityListeners(ProjetoListeners.class)
public class Transacao {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "TRA_ID")
	private Long id;

	@ManyToOne
	@JoinColumn(name = "CON_ID")
	private Conta conta;

	@Column(name = "TRA_VALOR")
	private Long valor;

	@Column(name = "TRA_SERVICO")
	@Enumerated(EnumType.STRING)
	private ServicoEnum servico;

	@Convert(converter = LocalDateTimeConverter.class)
	@Column(name = "TRA_DATA")
	private LocalDateTime data;

	/**
	 * Construtor padrão
	 */
	public Transacao() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}

	public Long getValor() {
		return valor;
	}

	public void setValor(Long valor) {
		this.valor = valor;
	}

	public ServicoEnum getServico() {
		return servico;
	}

	public void setServico(ServicoEnum servico) {
		this.servico = servico;
	}

	public LocalDateTime getData() {
		return data;
	}

	public void setData(LocalDateTime data) {
		this.data = data;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((conta == null) ? 0 : conta.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((servico == null) ? 0 : servico.hashCode());
		result = prime * result + ((valor == null) ? 0 : valor.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Transacao other = (Transacao) obj;
		if (conta == null) {
			if (other.conta != null)
				return false;
		} else if (!conta.equals(other.conta))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (servico != other.servico)
			return false;
		if (valor == null) {
			if (other.valor != null)
				return false;
		} else if (!valor.equals(other.valor))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Transacao [id=" + id + ", conta=" + conta + ", valor=" + valor + ", servico=" + servico + ", data=" + data + "]";
	}

}