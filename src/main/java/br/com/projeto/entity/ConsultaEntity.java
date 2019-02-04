package br.com.projeto.entity;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.projeto.comum.AppBaseEntity;
import br.com.projeto.types.Status;

@Entity
@Table(name = "TB_CONSULTA")
public class ConsultaEntity extends AppBaseEntity implements Serializable {

	private static final long serialVersionUID = 1503752441249011654L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "CON_ID", nullable = false)
	private Long id;

	@ManyToOne(targetEntity = PacienteEntity.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "CON_PACID")
	private PacienteEntity paciente;

	@ManyToOne(targetEntity = ProcedimentoEntity.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "CON_PROID")
	private ProcedimentoEntity procedimento;

	@Column(name = "CON_STATUS", nullable = false, length = 20)
	@Enumerated(EnumType.STRING)
	private Status status=Status.ABERTO;

	@Column(name = "CON_DATA", nullable = true)
	@Temporal(TemporalType.DATE)
	private Date data= new Date();

	@Column(name = "CON_HORAINICIO", nullable = true)
	@Temporal(TemporalType.TIME)
	private Date horaInicio= new Date();

	@Column(name = "CON_HORATERMINO", nullable = true)
	@Temporal(TemporalType.TIME)
	private Date horaTermino = new Date();

	@Column(name = "CON_OBSERVACAO", nullable = true, length = 255)
	private String observacao;

	public ConsultaEntity() {
	}

	public ConsultaEntity(Long id, PacienteEntity paciente, ProcedimentoEntity procedimento, Status status, Date data,
			Date horaInicio, Date horaTermino, String observacao) {
		super();
		this.id = id;
		this.paciente = paciente;
		this.procedimento = procedimento;
		this.status = status;
		this.data = data;
		this.horaInicio = horaInicio;
		this.horaTermino = horaTermino;
		this.observacao = observacao;
	}

	@Override
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public PacienteEntity getPaciente() {
		return paciente;
	}

	public void setPaciente(PacienteEntity paciente) {
		this.paciente = paciente;
	}

	public ProcedimentoEntity getProcedimento() {
		return procedimento;
	}

	public void setProcedimento(ProcedimentoEntity procedimento) {
		this.procedimento = procedimento;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Date getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(Date horaInicio) {
		this.horaInicio = horaInicio;
	}

	public Date getHoraTermino() {
		return horaTermino;
	}

	public void setHoraTermino(Date horaTermino) {
		this.horaTermino = horaTermino;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ConsultaEntity other = (ConsultaEntity) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
