package br.com.salaoiscool.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.salaoiscool.entity.Servico;

@Repository
public interface ServicoRepository  extends CrudRepository<Servico, Integer> {	
}
