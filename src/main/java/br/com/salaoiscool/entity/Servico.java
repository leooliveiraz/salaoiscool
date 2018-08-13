package br.com.salaoiscool.entity;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;

@Entity
@Data
public class Servico {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String descricao;
	@OneToMany(fetch=FetchType.LAZY,  mappedBy = "servico")
	private List<ValorServico> valores;
	
	public BigDecimal getValorAtual() {
		BigDecimal valor = null;
		if(getValores() != null) {
			int i = getValores().size()-1;
			valor = getValores().get(i).getValor();
		}
		return valor;
	}
	
}
