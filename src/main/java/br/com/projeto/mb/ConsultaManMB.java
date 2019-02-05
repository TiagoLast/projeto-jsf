package br.com.projeto.mb;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.projeto.comum.FacesUtil;
import br.com.projeto.entity.ConsultaEntity;
import br.com.projeto.entity.PacienteEntity;
import br.com.projeto.entity.ProcedimentoEntity;
import br.com.projeto.interfaces.ConsultaFacade;
import br.com.projeto.interfaces.ICrudMB;
import br.com.projeto.interfaces.PacienteFacade;
import br.com.projeto.interfaces.ProcedimentoFacade;
import br.com.projeto.types.Status;

@ViewScoped
@Named
public class ConsultaManMB implements Serializable, ICrudMB {

	private static final long serialVersionUID = 3819230534860340809L;

	@Inject
	private ConsultaFacade consultaFacade;

	@Inject
	private PacienteFacade pacienteFacade;

	@Inject
	private ProcedimentoFacade procedimentoFacade;

	@Inject
	private ConsultaEntity consulta;

	@Inject
	private PacienteEntity paciente;

	private List<PacienteEntity> pacientes;

	@Inject
	private ProcedimentoEntity procedimento;

	private List<ProcedimentoEntity> procedimentos;
	
	
	@PostConstruct
	public void start() {
		pacientes = pacienteFacade.all();
		procedimentos = procedimentoFacade.all();
	}

	@Override
	public void grava() {
		consultaFacade.save(consulta);
		FacesUtil.addInfoMessageInf();
		consulta = new ConsultaEntity();
	}

	public Status[] getStatus() {
		return Status.values();
	}
	
	public ConsultaEntity getConsulta() {
		return consulta;
	}

	public void setConsulta(ConsultaEntity consulta) {
		this.consulta = consulta;
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

	public List<PacienteEntity> getPacientes() {
		return pacientes;
	}

	public void setPacientes(List<PacienteEntity> pacientes) {
		this.pacientes = pacientes;
	}

	public List<ProcedimentoEntity> getProcedimentos() {
		return procedimentos;
	}

	public void setProcedimentos(List<ProcedimentoEntity> procedimentos) {
		this.procedimentos = procedimentos;
	}
	

}
