package br.com.projeto.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.com.projeto.comum.AppBaseEntity;

@Entity
@Table(name = "TB_PROCEDIMENTO")
public class ProcedimentoEntity extends AppBaseEntity implements Serializable {

	private static final long serialVersionUID = -2288637528103406034L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "PRO_ID", nullable = false)
	private Long id;

	@Column(name = "PRO_TIPOPROCEDIMENTO")
	private String tipoProcedimento;

	@OneToMany(targetEntity = ConsultaEntity.class, fetch = FetchType.LAZY, mappedBy = "procedimento")
	private List<ConsultaEntity> consultas;

	@OneToMany(targetEntity = ProntuarioEntity.class, fetch = FetchType.LAZY, mappedBy="procedimento")
	private List<ProntuarioEntity> prontuarios;

	public ProcedimentoEntity() {
	}

	public ProcedimentoEntity(Long id, String tipoProcedimento, List<ConsultaEntity> consultas,
			List<ProntuarioEntity> prontuarios) {
		super();
		this.id = id;
		this.tipoProcedimento = tipoProcedimento;
		this.consultas = consultas;
		this.prontuarios = prontuarios;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public Long getId() {
		return id;
	}

	public String getTipoProcedimento() {
		return tipoProcedimento;
	}

	public void setTipoProcedimento(String tipoProcedimento) {
		this.tipoProcedimento = tipoProcedimento;
	}

	public List<ConsultaEntity> getConsultas() {
		return consultas;
	}

	public void setConsultas(List<ConsultaEntity> consultas) {
		this.consultas = consultas;
	}

	public List<ProntuarioEntity> getProntuarios() {
		return prontuarios;
	}

	public void setProntuarios(List<ProntuarioEntity> prontuarios) {
		this.prontuarios = prontuarios;
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
		ProcedimentoEntity other = (ProcedimentoEntity) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
