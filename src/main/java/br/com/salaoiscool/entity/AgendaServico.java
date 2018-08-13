package br.com.salaoiscool.entity;

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
public class AgendaServico {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	@ManyToOne
	@JoinColumn(name = "servico_id", referencedColumnName = "id", foreignKey= @ForeignKey(name = "fk_agendaservico_servico"))
	private Servico servico;
	@ManyToOne
	@JoinColumn(name = "agenda_id", referencedColumnName = "id", foreignKey= @ForeignKey(name = "fk_agendaservico_agenda"))
	private Agenda agenda;
	private Boolean ativo;
}
