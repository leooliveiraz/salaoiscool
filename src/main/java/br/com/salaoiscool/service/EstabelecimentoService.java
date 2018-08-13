package br.com.salaoiscool.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.salaoiscool.dto.CadastroEstabelecimentoDTO;
import br.com.salaoiscool.entity.Estabelecimento;
import br.com.salaoiscool.entity.Usuario;
import br.com.salaoiscool.repository.EstabelecimentoRepository;

@Service
public class EstabelecimentoService {
	@Autowired
	UsuarioService usuarioService;
	@Autowired
	EstabelecimentoRepository estabelecimentoRepository;
	
	public void salvar(CadastroEstabelecimentoDTO dto) throws Exception {
		Estabelecimento estabelecimento = new Estabelecimento();
		Usuario usuario = new Usuario();
		
		if(!dto.getSenhaConfirmacao().equals(dto.getPassword())) {
			throw new Exception("Por favor, informe senhas iguais.");
		}
		
		estabelecimento.setContato(dto.getContato());
		estabelecimento.setDataCadastro(dto.getDataCadastro());
		estabelecimento.setEndereco(dto.getEndereco());
		estabelecimento.setNome(dto.getNome());
		
		usuario.setUsername(dto.getUsername());
		usuario.setPassword(dto.getPassword());
		usuario.setEstabelecimento(estabelecimento);
		
		if(!usuarioService.verificaExistenciausuario(usuario)) {
			estabelecimentoRepository.save(estabelecimento);
			usuarioService.salvar(usuario);
		}		
	}
}
