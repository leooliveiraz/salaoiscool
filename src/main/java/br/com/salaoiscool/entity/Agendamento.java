package br.com.salaoiscool.entity;

import java.math.BigDecimal;
import java.time.LocalTime;
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

@Entity
@Data
public class Agendamento {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	@ManyToOne
	@JoinColumn(name = "agenda_id", referencedColumnName = "id", foreignKey= @ForeignKey(name = "fk_agendamento_agenda"))
	private Agenda agenda;
	private LocalTime inicio;
	private LocalTime fim;
	private String nome;
	@OneToMany(fetch=FetchType.LAZY,  mappedBy = "agendamento")
	private List<ServicoFeito> servicosFeitos;
	private BigDecimal valorRecebido;
	private String descricao;
	private Boolean pago;
	
	public BigDecimal getValorCobrado() {
		BigDecimal valor = new BigDecimal("0");
		getServicosFeitos().stream().forEach(sf -> valor.add(sf.getValorCobrado()));
		return valor;
	}
	
}
