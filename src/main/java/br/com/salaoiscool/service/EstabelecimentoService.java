package br.com.salaoiscool.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.salaoiscool.conf.exception.BusinessException;
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
		
		if(dto.getPassword() == null  || dto.getSenhaConfirmacao() == null) {
			throw new BusinessException("Por informe uma senha e a confirmação.");
		}
		if(!dto.getSenhaConfirmacao().equals(dto.getPassword())) {
			throw new BusinessException("Por favor, informe senhas iguais.");
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

	public Estabelecimento buscarPorId(Integer id) {
		Optional<Estabelecimento> retorno =  estabelecimentoRepository.findById(id);
		Estabelecimento estabelecimento = retorno.get();
		return estabelecimento;		
	}
}
