package br.com.salaoiscool.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.salaoiscool.entity.AgendaServico;

@Repository
public interface AgendaServicoRepository  extends CrudRepository<AgendaServico, Integer> {	
}
