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
@Table(name = "TB_CLIENTE")
public class ClienteEntity extends AppBaseEntity implements Serializable {

	private static final long serialVersionUID = 1503752441249011654L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "CLI_ID", nullable = false)
	private Long id;

	@Column(name = "CLI_NOME", nullable = false, length = 60)
	private String nome;

	@Column(name = "CLI_CPF", nullable = false, length = 20)
	private String cpf;

	@Column(name = "CLI_RG", nullable = false, length = 20)
	private String rg;

	@OneToMany(targetEntity = FiadoEntity.class, fetch = FetchType.LAZY, mappedBy = "cliente")
	private List<FiadoEntity> fiados;
	
	public ClienteEntity() {
	}

	public ClienteEntity(Long id, String nome, String cpf, String rg, List<FiadoEntity> fiados) {
		super();
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.rg = rg;
		this.fiados = fiados;
	}

	@Override
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public List<FiadoEntity> getFiados() {
		return fiados;
	}

	public void setFiados(List<FiadoEntity> fiados) {
		this.fiados = fiados;
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
		ClienteEntity other = (ClienteEntity) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
