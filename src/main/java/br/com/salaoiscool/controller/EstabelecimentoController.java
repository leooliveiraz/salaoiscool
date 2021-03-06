package br.com.salaoiscool.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.salaoiscool.dto.CadastroEstabelecimentoDTO;
import br.com.salaoiscool.service.EstabelecimentoService;
import br.com.salaoiscool.util.ErroUtil;

@RestController
@SuppressWarnings("unchecked")
@RequestMapping("/estabelecimento")
public class EstabelecimentoController {
	@Autowired
	private EstabelecimentoService estabelecimentoService;
	
	@RequestMapping(path="/salvar",method=RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CadastroEstabelecimentoDTO> salvarEstabelecimento(@RequestBody CadastroEstabelecimentoDTO dto) {
		try {
			estabelecimentoService.salvar(dto);
			return new ResponseEntity<CadastroEstabelecimentoDTO>(HttpStatus.OK);
		}catch (Exception e) {
			return ErroUtil.erro(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
