package br.com.salaoiscool.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity
@Data
public class ValorServico {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	@ManyToOne
	@JoinColumn(name = "servico_id", referencedColumnName = "id", foreignKey= @ForeignKey(name = "fk_valorservico_servico"))
	private Servico servico;
	@Column( precision = 9, scale = 2)
	private BigDecimal valor;
	
	
}
