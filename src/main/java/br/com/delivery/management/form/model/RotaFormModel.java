package br.com.delivery.management.form.model;

import javax.validation.constraints.NotNull;

public class RotaFormModel {
	@NotNull
	private String nome;
	
	@NotNull
	private String pontoInicial;
	
	@NotNull
	private String pontoFinal;
	
	@NotNull
	private Double autonomiaCaminhao;
	
	@NotNull
	private Double valorKilometro;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getPontoInicial() {
		return pontoInicial;
	}

	public void setPontoInicial(String pontoInicial) {
		this.pontoInicial = pontoInicial;
	}

	public String getPontoFinal() {
		return pontoFinal;
	}

	public void setPontoFinal(String pontoFinal) {
		this.pontoFinal = pontoFinal;
	}

	public double getAutonomiaCaminhao() {
		return autonomiaCaminhao;
	}

	public void setAutonomiaCaminhao(double autonomiaCaminhao) {
		this.autonomiaCaminhao = autonomiaCaminhao;
	}

	public double getValorKilometro() {
		return valorKilometro;
	}

	public void setValorKilometro(double valorKilometro) {
		this.valorKilometro = valorKilometro;
	}

}
