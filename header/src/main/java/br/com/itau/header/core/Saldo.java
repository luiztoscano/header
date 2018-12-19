package br.com.itau.header.core;

import java.math.BigDecimal;
import java.util.Date;

public class Saldo {
	private BigDecimal valor;
	private Date dataHoraAtualizacao;

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public Date getDataHoraAtualizacao() {
		return dataHoraAtualizacao;
	}

	public void setDataHoraAtualizacao(Date dataHoraAtualizacao) {
		this.dataHoraAtualizacao = dataHoraAtualizacao;
	}

}
