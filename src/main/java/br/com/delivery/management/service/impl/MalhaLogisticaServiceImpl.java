package br.com.delivery.management.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import br.com.delivery.management.domain.MalhaLogistica;
import br.com.delivery.management.domain.Message;
import br.com.delivery.management.domain.Rota;
import br.com.delivery.management.form.model.RotaFormModel;
import br.com.delivery.management.json.MalhaLogisticaJson;
import br.com.delivery.management.repository.MalhaLogisticaRepository;
import br.com.delivery.management.service.MalhaLogisticaService;

@Service
public class MalhaLogisticaServiceImpl implements MalhaLogisticaService  {
	@Autowired
	MalhaLogisticaRepository malhaLogisticaRepository;
	
	@Override
	public List<MalhaLogistica> listar() {
		return malhaLogisticaRepository.findAll();
	}

	@Override
	public Message cadastrar(MalhaLogisticaJson malhaLogistica) {
		malhaLogisticaRepository.save(malhaLogistica.getMalhaLogistica());
		return new Message("Malha Logistica incluída com sucesso");
	}

	@Override
	public Rota obterRota(RotaFormModel rotaFormModel) {
		
		/* Obtenho todas as rotas do mapa informado */
		
		List<MalhaLogistica> rotas = malhaLogisticaRepository.findByNome(rotaFormModel.getNome());

		/* Obtenho a lista com as possíveis rotas */

		List<Rota> lstRotas = obtemRotas(rotas, rotaFormModel.getPontoInicial(), rotaFormModel.getPontoFinal(),
				rotaFormModel.getAutonomiaCaminhao(), rotaFormModel.getValorKilometro());
		
		return obterMelhorRota(lstRotas);
	}
	
	private List<Rota> obtemRotas(List<MalhaLogistica> rotas, String pontoInicial, String pontoFinal, double autonomia,
			double valorKilometro) {

		double distancia = 0;
		double valorCusto = 0;

		String rota = "";
		String pontoFinalAtual = "";
		String pontoFinalAnterior = "";

		List<Rota> lstRotas = new ArrayList<>();

		for (MalhaLogistica malha : rotas) {

			if (isPontoInicialAndFinal(pontoInicial, pontoFinal, malha)) {
				distancia += malha.getDistancia();

				rota = pontoInicial + pontoFinal;

				valorCusto = calculaCusto(distancia, autonomia, valorKilometro);

				lstRotas.add(new Rota(rota, valorCusto));
				distancia = 0;
				rota = "";
			} 
			
			else {

				if (isPontoInicial(pontoInicial, pontoFinalAtual, malha) && distancia == 0) {
					distancia += malha.getDistancia();

					pontoFinalAtual = malha.getPontoFinal();

					rota += pontoInicial + pontoFinalAtual;
					
				}
				else{
					
					if (isPontoFinalAnterior(malha.getPontoInicial(), pontoFinalAtual)) {
						distancia += malha.getDistancia();
						pontoFinalAnterior = pontoFinalAtual;
						pontoFinalAtual = malha.getPontoFinal();
						rota += pontoFinalAtual;
					}
					
					if (isPontoFinal(malha.getPontoFinal(), pontoFinal, malha.getPontoInicial(), pontoFinalAnterior)) {
						valorCusto = calculaCusto(distancia, autonomia, valorKilometro);

						lstRotas.add(new Rota(rota, valorCusto));
						
						distancia = 0;
						rota = "";
						pontoFinalAtual = "";
					}
					
				}
			}
		}

		return lstRotas;
	}
	
	private Rota obterMelhorRota( List<Rota> rotasSelecionadas){
		if(rotasSelecionadas.isEmpty()){
			throw new ResourceNotFoundException("Não foi encontrada nenhuma rota para e destino informadas");
		}
		
		Rota melhorRota = Collections.min(rotasSelecionadas);
		return melhorRota;
	}

	private boolean isPontoFinal(String pontoFinalAtual, String pontoFinal, String pontoInicialAtual, String pontoFinalAnterior) {
		return pontoFinalAtual.equals(pontoFinal) && pontoFinalAnterior.equals(pontoInicialAtual) ;
	}
	
	private boolean isPontoFinalAnterior(String pontoInicialAtual, String pontoFinalAnterior){
		return pontoInicialAtual.equals(pontoFinalAnterior);
	}
	
	private boolean isPontoInicial(String pontoInicial, String pontoFinalAtual, MalhaLogistica malha) {
		String pontoInicialAtual = malha.getPontoInicial();
		
		return pontoInicialAtual.equals(pontoInicial) && pontoFinalAtual.isEmpty();
	}

	private boolean isPontoInicialAndFinal(String pontoInicial, String pontoFinal, MalhaLogistica malha) {
		String pontoInicialAtual = malha.getPontoInicial();
		String pontoFinalAtual = malha.getPontoFinal();
		
		return pontoInicialAtual.equals(pontoInicial) && pontoFinalAtual.equals(pontoFinal);
	}
	
	private double calculaCusto(double distancia, double autonomia, double valorKilometro){
		return (distancia / autonomia ) * valorKilometro ;
	}
}
