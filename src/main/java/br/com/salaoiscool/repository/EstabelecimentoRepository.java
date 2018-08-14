package br.com.salaoiscool.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.salaoiscool.entity.Estabelecimento;

@Repository
public interface EstabelecimentoRepository  extends CrudRepository<Estabelecimento, Integer> {	
	
}
