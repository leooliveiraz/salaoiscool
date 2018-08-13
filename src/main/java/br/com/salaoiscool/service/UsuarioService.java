package br.com.salaoiscool.service;

import javax.persistence.NoResultException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.salaoiscool.entity.Usuario;
import br.com.salaoiscool.repository.UsuarioRepository;

@Service
public class UsuarioService {
	@Autowired
	UsuarioRepository usuarioRepository;
	
	public boolean verificaExistenciausuario(Usuario usuario) {
		try {
			Usuario usuario_ = usuarioRepository.findByUsername(usuario.getUsername());
			if(usuario_ != null) {
				return true;
			}else {
				return false;
			}
		} catch (NoResultException e) {
			return false;
		}
		
	}

	public void salvar(Usuario usuario) {
		usuarioRepository.save(usuario);
	}
	
}
