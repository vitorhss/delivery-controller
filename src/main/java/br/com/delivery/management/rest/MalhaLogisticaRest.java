package br.com.delivery.management.rest;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.delivery.management.domain.MalhaLogistica;
import br.com.delivery.management.domain.Message;
import br.com.delivery.management.domain.Rota;
import br.com.delivery.management.form.model.RotaFormModel;
import br.com.delivery.management.json.MalhaLogisticaJson;
import br.com.delivery.management.service.MalhaLogisticaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/malha-logistica")
@Api("Malha Logística")
public class MalhaLogisticaRest extends AbstractRest {
	@Autowired
	MalhaLogisticaService malhaLogisticaService;
	
	@ApiOperation("Listagem dos Mapas")
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<MalhaLogistica>> listar(){
		return responseOk(malhaLogisticaService.listar());
	}
	
	@ApiOperation("Obtenção da melhor rota e preço")
	@RequestMapping(value = "/route", method = RequestMethod.GET)
	public ResponseEntity<Rota> obterRota(@Valid @ModelAttribute RotaFormModel rotaFormModel){
		return responseOk(malhaLogisticaService.obterRota(rotaFormModel));
	}
	@ApiOperation("Cadastro dos mapas")
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Message> cadastrar(@Valid @RequestBody MalhaLogisticaJson malhaLogistica) {
		return responseOk(malhaLogisticaService.cadastrar(malhaLogistica));
	}
}
