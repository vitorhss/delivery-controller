package br.com.delivery.management.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.delivery.management.domain.MalhaLogistica;

public interface MalhaLogisticaRepository extends JpaRepository<MalhaLogistica, Integer> {
	
	List<MalhaLogistica> findByNome(String nome);

}
