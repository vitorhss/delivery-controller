package br.com.delivery.management.service;

import java.util.List;

import br.com.delivery.management.domain.MalhaLogistica;
import br.com.delivery.management.domain.Message;
import br.com.delivery.management.domain.Rota;
import br.com.delivery.management.form.model.RotaFormModel;
import br.com.delivery.management.json.MalhaLogisticaJson;

public interface MalhaLogisticaService {
	List<MalhaLogistica> listar();
	Message cadastrar(MalhaLogisticaJson malhaLogistica);

	Rota obterRota(RotaFormModel rotaFormModel);
}
