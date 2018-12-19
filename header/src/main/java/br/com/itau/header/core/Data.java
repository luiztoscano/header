package br.com.itau.header.core;

import java.math.BigDecimal;
import java.util.UUID;

public class Data {
	private UUID codigoCorrelacao;
	private String estadoEvento;
	private String fase;
	private Integer codigoTransacao;
	private BigDecimal valorLancamento;
	private String textoComplementoLancamento;
	private String urlCallback;
	private Conta contaDebito;
	private Conta contaCredito;

	public UUID getCodigoCorrelacao() {
		return codigoCorrelacao;
	}

	public void setCodigoCorrelacao(UUID codigoCorrelacao) {
		this.codigoCorrelacao = codigoCorrelacao;
	}

	public String getEstadoEvento() {
		return estadoEvento;
	}

	public void setEstadoEvento(String estadoEvento) {
		this.estadoEvento = estadoEvento;
	}

	public String getFase() {
		return fase;
	}

	public void setFase(String fase) {
		this.fase = fase;
	}

	public Integer getCodigoTransacao() {
		return codigoTransacao;
	}

	public void setCodigoTransacao(Integer codigoTransacao) {
		this.codigoTransacao = codigoTransacao;
	}

	public BigDecimal getValorLancamento() {
		return valorLancamento;
	}

	public void setValorLancamento(BigDecimal valorLancamento) {
		this.valorLancamento = valorLancamento;
	}

	public String getTextoComplementoLancamento() {
		return textoComplementoLancamento;
	}

	public void setTextoComplementoLancamento(String textoComplementoLancamento) {
		this.textoComplementoLancamento = textoComplementoLancamento;
	}

	public String getUrlCallback() {
		return urlCallback;
	}

	public void setUrlCallback(String urlCallback) {
		this.urlCallback = urlCallback;
	}

	public Conta getContaDebito() {
		return contaDebito;
	}

	public void setContaDebito(Conta contaDebito) {
		this.contaDebito = contaDebito;
	}

	public Conta getContaCredito() {
		return contaCredito;
	}

	public void setContaCredito(Conta contaCredito) {
		this.contaCredito = contaCredito;
	}

}
