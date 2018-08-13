package br.com.salaoiscool.dto;

import java.time.LocalDate;

import lombok.Data;
@Data
public class CadastroEstabelecimentoDTO {
	private String nome;
	private LocalDate dataCadastro;
	private String endereco;
	private String contato;
	private String username;
	private String password;
	private String senhaConfirmacao;
}
