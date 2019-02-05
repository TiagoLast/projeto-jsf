package br.com.projeto.mb;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.commons.lang3.StringUtils;

import br.com.projeto.comum.FacesUtil;
import br.com.projeto.entity.ConvenioEntity;
import br.com.projeto.entity.PacienteEntity;
import br.com.projeto.interfaces.ConvenioFacade;
import br.com.projeto.interfaces.ICrudMB;
import br.com.projeto.interfaces.PacienteFacade;

@ViewScoped
@Named
public class PacienteManMB implements Serializable, ICrudMB {

	private static final long serialVersionUID = 3819230534860340809L;

	@Inject
	private PacienteFacade pacienteFacade;

	@Inject
	private PacienteEntity paciente;
	
	@Inject
	private ConvenioFacade convenioFacade;
	
	
	private List<ConvenioEntity> convenios;
	
	
	@PostConstruct
	public void inicia() {
		paciente = new PacienteEntity();
		convenios = convenioFacade.all();
	}
	

	@Override
	public void grava() {
		pacienteFacade.save(paciente);
		FacesUtil.addInfoMessageInf();
		paciente = new PacienteEntity();
	}

	private void recuperaPaciente() {
		String id = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("id");
		if (StringUtils.isNotEmpty(id) && StringUtils.isNotBlank(id)) {
			paciente = pacienteFacade.get(Long.valueOf(id));
		}
	}

	public PacienteEntity getPaciente() {
		return paciente;
	}

	public void setPaciente(PacienteEntity paciente) {
		this.paciente = paciente;
	}


	public List<ConvenioEntity> getConvenios() {
		return convenios;
	}


	public void setConvenios(List<ConvenioEntity> convenios) {
		this.convenios = convenios;
	}
	
	
	

}
