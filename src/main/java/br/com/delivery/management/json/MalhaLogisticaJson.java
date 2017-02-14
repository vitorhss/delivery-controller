package br.com.delivery.management.json;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import br.com.delivery.management.domain.MalhaLogistica;

public class MalhaLogisticaJson {
	@Valid
	@NotNull
	private MalhaLogistica malhaLogistica;
	
	public MalhaLogistica getMalhaLogistica() {
		return malhaLogistica;
	}
	public void setMalhaLogistica(MalhaLogistica malhaLogistica) {
		this.malhaLogistica = malhaLogistica;
	}
}
