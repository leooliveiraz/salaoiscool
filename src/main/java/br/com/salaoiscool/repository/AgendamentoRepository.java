package br.com.salaoiscool.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.salaoiscool.entity.Agendamento;

@Repository
public interface AgendamentoRepository  extends CrudRepository<Agendamento, Integer> {	
}
