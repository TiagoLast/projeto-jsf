package br.com.projeto.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.projeto.comum.AppBaseEntity;

@Entity
@Table(name = "TB_PRONTUARIO")
public class ProntuarioEntity extends AppBaseEntity implements Serializable {

	private static final long serialVersionUID = -2288637528103406034L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "PRO_ID", nullable = false)
	private Long id;

	@Column(name = "PRO_DATA", nullable = true)
	private Date data;

	@ManyToOne(targetEntity = PacienteEntity.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "PRO_PACID")
	private PacienteEntity paciente;

	@ManyToOne(targetEntity = ProcedimentoEntity.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "PRO_PROID")
	private ProcedimentoEntity procedimento;

	@Column(name = "PRO_ANAMNESE", nullable = true, length = 255)
	private String anamnese;

	@Column(name = "PRO_DIAGNOSTICO", nullable = true, length = 255)
	private String diagnostico;

	@Column(name = "PRO_PROCEDIMENTOREALIZANDO", nullable = true, length = 255)
	private String procedimentoRealizado;

	@Column(name = "PRO_PRESCICAOREMEDIOS", nullable = true, length = 255)
	private String prescricaoRemedios;

	@Column(name = "PRO_PRESCRICAOEXAMES", nullable = true, length = 255)
	private String prescricaoExames;

	@Column(name = "PRO_RESULTADOS", nullable = true, length = 255)
	private String resultados;

	@Column(name = "PRO_OBSERVACAO", nullable = true, length = 255)
	private String observacao;

	public ProntuarioEntity() {
	}

	public ProntuarioEntity(Long id, Date data, PacienteEntity paciente, ProcedimentoEntity procedimento,
			String anamnese, String diagnostico, String procedimentoRealizado, String prescricaoRemedios,
			String prescricaoExames, String resultados, String observacao) {
		super();
		this.id = id;
		this.data = data;
		this.paciente = paciente;
		this.procedimento = procedimento;
		this.anamnese = anamnese;
		this.diagnostico = diagnostico;
		this.procedimentoRealizado = procedimentoRealizado;
		this.prescricaoRemedios = prescricaoRemedios;
		this.prescricaoExames = prescricaoExames;
		this.resultados = resultados;
		this.observacao = observacao;
	}

	@Override
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
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

	public String getAnamnese() {
		return anamnese;
	}

	public void setAnamnese(String anamnese) {
		this.anamnese = anamnese;
	}

	public String getDiagnostico() {
		return diagnostico;
	}

	public void setDiagnostico(String diagnostico) {
		this.diagnostico = diagnostico;
	}

	public String getProcedimentoRealizado() {
		return procedimentoRealizado;
	}

	public void setProcedimentoRealizado(String procedimentoRealizado) {
		this.procedimentoRealizado = procedimentoRealizado;
	}

	public String getPrescricaoRemedios() {
		return prescricaoRemedios;
	}

	public void setPrescricaoRemedios(String prescricaoRemedios) {
		this.prescricaoRemedios = prescricaoRemedios;
	}

	public String getPrescricaoExames() {
		return prescricaoExames;
	}

	public void setPrescricaoExames(String prescricaoExames) {
		this.prescricaoExames = prescricaoExames;
	}

	public String getResultados() {
		return resultados;
	}

	public void setResultados(String resultados) {
		this.resultados = resultados;
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
		ProntuarioEntity other = (ProntuarioEntity) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
