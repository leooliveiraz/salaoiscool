package br.com.salaoiscool.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.salaoiscool.entity.ServicoFeito;

@Repository
public interface ServicoFeitoRepository  extends CrudRepository<ServicoFeito, Integer> {	
}
