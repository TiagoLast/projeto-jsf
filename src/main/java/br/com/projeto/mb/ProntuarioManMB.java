package br.com.projeto.mb;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.commons.lang3.StringUtils;

import br.com.projeto.comum.FacesUtil;
import br.com.projeto.comum.Util;
import br.com.projeto.entity.ConsultaEntity;
import br.com.projeto.entity.ProntuarioEntity;
import br.com.projeto.interfaces.ConsultaFacade;
import br.com.projeto.interfaces.ProntuarioFacade;

@ViewScoped
@Named
public class ProntuarioManMB implements Serializable {

	private static final long serialVersionUID = 3819230534860340809L;

	@Inject
	private ProntuarioFacade prontuarioFacade;

	@Inject
	private ConsultaFacade consultaFacade;

	@Inject
	private ConsultaEntity consulta;

	@Inject
	private ProntuarioEntity prontuario;

	private boolean iniciaConsulta = false;

	private String iniciaFinaliza = "Inicia";

	public void inicia() {
		iniciaConsulta = true;
	}

	@PostConstruct
	public void start() {
		recuperaPaciente();
	}

	public void grava() {

		if ("Inicia".equals(iniciaFinaliza)) {
			iniciaConsulta = true;
			iniciaFinaliza = "Finaliza";
		}else {
			prontuarioFacade.save(prontuario);
			FacesUtil.addInfoMessageInf();
			Util.redirecionarPagina("agendacon.xhtml");
		}

	}

	private void recuperaPaciente() {
		String id = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("id");
		if (StringUtils.isNotEmpty(id)) {
			this.consulta = consultaFacade.get(Long.valueOf(id));
		}
	}

	public boolean isIniciaConsulta() {
		return iniciaConsulta;
	}

	public void setIniciaConsulta(boolean iniciaConsulta) {
		this.iniciaConsulta = iniciaConsulta;
	}

	public String getIniciaFinaliza() {
		return iniciaFinaliza;
	}

	public void setIniciaFinaliza(String iniciaFinaliza) {
		this.iniciaFinaliza = iniciaFinaliza;
	}

	public ProntuarioEntity getProntuario() {
		return prontuario;
	}

	public void setProntuario(ProntuarioEntity prontuario) {
		this.prontuario = prontuario;
	}

	public ConsultaEntity getConsulta() {
		return consulta;
	}

	public void setConsulta(ConsultaEntity consulta) {
		this.consulta = consulta;
	}

}
