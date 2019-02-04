package br.com.projeto.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.projeto.comum.AppBaseEntity;

@Entity
@Table(name = "TB_PACIENTE")
public class PacienteEntity extends AppBaseEntity implements Serializable {

	private static final long serialVersionUID = -8295136230885733924L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "PAC_ID", nullable = false)
	private Long id;

	@Column(name = "PAC_NOME", nullable = false, length = 80)
	private String nome;

	@Column(name = "PAC_DATANASC", nullable = true)
	@Temporal(TemporalType.DATE)
	private Date nascimento;

	@Column(name = "PAC_SEXO", nullable = true, length = 10)
	private String sexo;

	@Column(name = "PAC_ENDERECO", nullable = true, length = 80)
	private String endereco;

	@Column(name = "PAC_NUMERO", nullable = true)
	private Integer numero;

	@Column(name = "PAC_BAIRRO", nullable = true, length = 80)
	private String bairro;

	@Column(name = "PAC_CIDADE", nullable = true, length = 60)
	private String cidade;

	@Column(name = "PAC_CEP", nullable = true, length = 20)
	private String cep;

	@Column(name = "PAC_ESTADO", nullable = true, length = 60)
	private String estado;

	@Column(name = "PAC_TELEFONE", nullable = true, length = 20)
	private String telefone;

	@Column(name = "PAC_EMAIL", nullable = true, length = 80)
	private String email;

	@Column(name = "PAC_OBSERVACAO", nullable = true, length = 255)
	private String observacao;

	@ManyToOne(targetEntity = ConvenioEntity.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "PAC_CONID")
	private ConvenioEntity convenio;

	@OneToMany(targetEntity = ProntuarioEntity.class, fetch = FetchType.LAZY)
	private List<ProntuarioEntity> prontuarios;

	@OneToMany(targetEntity = ConsultaEntity.class, fetch = FetchType.LAZY)
	private List<ConsultaEntity> consultas;

	public PacienteEntity() {
	}

	public PacienteEntity(Long id, String nome, Date nascimento, String sexo, String endereco, Integer numero, String bairro,
			String cidade, String cep, String estado, String telefone, String email, String observacao,
			ConvenioEntity convenio, List<ProntuarioEntity> prontuarios, List<ConsultaEntity> consultas) {
		super();
		this.id = id;
		this.nome = nome;
		this.nascimento = nascimento;
		this.sexo = sexo;
		this.endereco = endereco;
		this.numero = numero;
		this.bairro = bairro;
		this.cidade = cidade;
		this.cep = cep;
		this.estado = estado;
		this.telefone = telefone;
		this.email = email;
		this.observacao = observacao;
		this.convenio = convenio;
		this.prontuarios = prontuarios;
		this.consultas = consultas;
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

	public Date getNascimento() {
		return nascimento;
	}

	public void setNascimento(Date nascimento) {
		this.nascimento = nascimento;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public ConvenioEntity getConvenio() {
		return convenio;
	}

	public void setConvenio(ConvenioEntity convenio) {
		this.convenio = convenio;
	}

	public List<ProntuarioEntity> getProntuarios() {
		return prontuarios;
	}

	public void setProntuarios(List<ProntuarioEntity> prontuarios) {
		this.prontuarios = prontuarios;
	}

	public List<ConsultaEntity> getConsultas() {
		return consultas;
	}

	public void setConsultas(List<ConsultaEntity> consultas) {
		this.consultas = consultas;
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
		PacienteEntity other = (PacienteEntity) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
