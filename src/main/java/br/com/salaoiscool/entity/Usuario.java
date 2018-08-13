package br.com.salaoiscool.entity;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
@Entity
public class Usuario {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String username;
	private String password;
	@ManyToOne
	@JoinColumn(name = "estabelecimento_id", referencedColumnName = "id", foreignKey= @ForeignKey(name = "fk_usuario_estabelecimento"))
	private Estabelecimento estabelecimento;
}
