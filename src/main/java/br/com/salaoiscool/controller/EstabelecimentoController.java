package br.com.salaoiscool.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.salaoiscool.dto.CadastroEstabelecimentoDTO;
import br.com.salaoiscool.service.EstabelecimentoService;

@RestController
@RequestMapping("/estabelecimento")
public class EstabelecimentoController {
	@Autowired
	private EstabelecimentoService estabelecimentoService;
	
	@RequestMapping(path="/salvar",method=RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
	public void salvarEstabelecimento(@RequestBody CadastroEstabelecimentoDTO dto) {
		try {
			estabelecimentoService.salvar(dto);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
