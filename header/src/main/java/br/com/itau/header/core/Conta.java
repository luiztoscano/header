package br.com.itau.header.core;

import java.util.UUID;

public class Conta {
	private String numeroAgencia;
	private String numeroConta;
	private String numeroDac;
	private String numeroTitularidade;
	private String sufixo;
	private UUID idConta;
	private String nomeCliente;
	private String literal;
	private String autenticacao;
	private Saldo saldo;

	public String getNumeroAgencia() {
		return numeroAgencia;
	}

	public void setNumeroAgencia(String numeroAgencia) {
		this.numeroAgencia = numeroAgencia;
	}

	public String getNumeroConta() {
		return numeroConta;
	}

	public void setNumeroConta(String numeroConta) {
		this.numeroConta = numeroConta;
	}

	public String getNumeroDac() {
		return numeroDac;
	}

	public void setNumeroDac(String numeroDac) {
		this.numeroDac = numeroDac;
	}

	public String getNumeroTitularidade() {
		return numeroTitularidade;
	}

	public void setNumeroTitularidade(String numeroTitularidade) {
		this.numeroTitularidade = numeroTitularidade;
	}

	public String getSufixo() {
		return sufixo;
	}

	public void setSufixo(String sufixo) {
		this.sufixo = sufixo;
	}

	public UUID getIdConta() {
		return idConta;
	}

	public void setIdConta(UUID idConta) {
		this.idConta = idConta;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public String getLiteral() {
		return literal;
	}

	public void setLiteral(String ligeral) {
		this.literal = ligeral;
	}

	public String getAutenticacao() {
		return autenticacao;
	}

	public void setAutenticacao(String autenticacao) {
		this.autenticacao = autenticacao;
	}

	public Saldo getSaldo() {
		return saldo;
	}

	public void setSaldo(Saldo saldo) {
		this.saldo = saldo;
	}

}
