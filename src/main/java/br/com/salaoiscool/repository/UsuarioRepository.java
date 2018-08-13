package br.com.salaoiscool.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.salaoiscool.entity.Usuario;

@Repository
public interface UsuarioRepository  extends CrudRepository<Usuario, Integer> {	
	Usuario findByUsername(String username);
}
