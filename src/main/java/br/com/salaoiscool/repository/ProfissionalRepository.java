package br.com.salaoiscool.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.salaoiscool.entity.Profissional;

@Repository
public interface ProfissionalRepository  extends CrudRepository<Profissional, Integer> {	
}
