package br.com.salaoiscool.entity;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Data;

@Data
@Entity
public class Agenda {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String descricao;
	private LocalDate data;
	private LocalTime horaInicio;
	private LocalTime horaFim;
	private Boolean ativo;
	@ManyToOne
	@JoinColumn(name = "profissional_id", referencedColumnName = "id", foreignKey= @ForeignKey(name = "fk_profissional_agenda"))
	private Profissional profissional;
	@OneToMany(fetch=FetchType.LAZY,  mappedBy = "agenda")
	private List<AgendaServico> servicos;
	
	public List<AgendaServico> servicosAtivos() {
		List<AgendaServico> list = new ArrayList<>();
		for(AgendaServico a : servicos) {
			if(a.getAtivo()) {
				list.add(a);
			}
		}
		return list;
	}
}
