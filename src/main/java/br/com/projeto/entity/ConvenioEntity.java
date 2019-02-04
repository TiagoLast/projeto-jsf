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
@Table(name = "TB_CONVENIO")
public class ConvenioEntity extends AppBaseEntity implements Serializable {

	private static final long serialVersionUID = 505018411140118305L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "PAC_ID", nullable = false)
	private Long id;

	@Column(name = "PAC_NOMECONVENIO", nullable = false)
	private String nomeConvenio;

	@OneToMany(targetEntity = PacienteEntity.class, fetch = FetchType.LAZY)
	private List<PacienteEntity> pacientes;

	public ConvenioEntity() {
	}

	public ConvenioEntity(Long id, String nomeConvenio, List<PacienteEntity> pacientes) {
		super();
		this.id = id;
		this.nomeConvenio = nomeConvenio;
		this.pacientes = pacientes;
	}

	@Override
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeConvenio() {
		return nomeConvenio;
	}

	public void setNomeConvenio(String nomeConvenio) {
		this.nomeConvenio = nomeConvenio;
	}

	public List<PacienteEntity> getPacientes() {
		return pacientes;
	}

	public void setPacientes(List<PacienteEntity> pacientes) {
		this.pacientes = pacientes;
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
		ConvenioEntity other = (ConvenioEntity) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
