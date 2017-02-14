package br.com.delivery.management.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

@Entity(name ="malha_logistica")
public class MalhaLogistica {
	@Id
	@GeneratedValue
	@Column(updatable = false, insertable = false)
	private Integer id;
	
	@NotNull
	@Length(max = 50)
	private String nome;
	
	@NotNull
	@Length(max = 50)
	private String pontoInicial;
	
	@NotNull
	@Length(max = 50)
	private String pontoFinal;
	
	@NotNull
	@DecimalMin(value = "1")
	private double distancia;

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

	public Double getDistancia() {
		return distancia;
	}

	public void setDistancia(Double distancia) {
		this.distancia = distancia;
	}
}
