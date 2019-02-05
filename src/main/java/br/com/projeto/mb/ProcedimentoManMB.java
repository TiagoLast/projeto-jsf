package br.com.projeto.mb;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.commons.lang3.StringUtils;

import br.com.projeto.comum.FacesUtil;
import br.com.projeto.entity.ProcedimentoEntity;
import br.com.projeto.interfaces.ICrudMB;
import br.com.projeto.interfaces.ProcedimentoFacade;

@ViewScoped
@Named
public class ProcedimentoManMB implements Serializable, ICrudMB {

	private static final long serialVersionUID = 3819230534860340809L;

	@Inject
	private ProcedimentoFacade procedimentoFacade;

	@Inject
	private ProcedimentoEntity procedimento;

	@PostConstruct
	public void start() {
		recuperaProcedimento();
	}

	@Override
	public void grava() {
		try {
			procedimentoFacade.save(procedimento);
			FacesUtil.addInfoMessageInf();
			this.procedimento = new ProcedimentoEntity();
		} catch (Exception e) {
			FacesUtil.addErrorMessageFatal("Erro " + e.getMessage());
		}
	}

	private void recuperaProcedimento() {
		String id = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("id");
		if (StringUtils.isNotEmpty(id) && StringUtils.isNotBlank(id)) {
			this.procedimento = procedimentoFacade.get(Long.valueOf(id));
		}
	}

	public ProcedimentoEntity getProcedimento() {
		return procedimento;
	}

	public void setProcedimento(ProcedimentoEntity procedimento) {
		this.procedimento = procedimento;
	}

}
