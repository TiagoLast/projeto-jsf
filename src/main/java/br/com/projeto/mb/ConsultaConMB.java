package br.com.projeto.mb;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.projeto.entity.ConsultaEntity;
import br.com.projeto.interfaces.ConsultaFacade;

@ViewScoped
@Named
public class ConsultaConMB implements Serializable {

	private static final long serialVersionUID = 3819230534860340809L;

	@Inject
	private ConsultaFacade consultaFacade;

	@Inject
	private ConsultaEntity consulta;

	private List<ConsultaEntity> consultas;
	
	@PostConstruct
	public void start() {
		consultas = consultaFacade.all();
	}

	public ConsultaEntity getConsulta() {
		return consulta;
	}

	public void setConsulta(ConsultaEntity consulta) {
		this.consulta = consulta;
	}

	public List<ConsultaEntity> getConsultas() {
		return consultas;
	}

	public void setConsultas(List<ConsultaEntity> consultas) {
		this.consultas = consultas;
	}
	
	
	

	

}
