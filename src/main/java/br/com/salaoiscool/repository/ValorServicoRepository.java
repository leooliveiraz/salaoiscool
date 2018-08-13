package br.com.salaoiscool.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.salaoiscool.entity.Agenda;

@Repository
public interface ValorServicoRepository  extends CrudRepository<Agenda, Integer> {	
}
