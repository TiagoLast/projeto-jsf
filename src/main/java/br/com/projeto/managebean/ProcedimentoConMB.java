package br.com.projeto.managebean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.commons.lang3.StringUtils;

import br.com.projeto.comum.FacesUtil;
import br.com.projeto.entity.ProcedimentoEntity;
import br.com.projeto.interfaces.ProcedimentoFacade;

@ViewScoped
@Named
public class ProcedimentoConMB implements Serializable {

	private static final long serialVersionUID = 3819230534860340809L;

	@Inject
	private ProcedimentoFacade procedimentoFacade;

	@Inject
	private ProcedimentoEntity procedimento;

	private List<ProcedimentoEntity> procedimentos;

	private String pesquisa;

	@PostConstruct
	public void start() {
		selected();
	}

	public void selected() {
		if (StringUtils.isNotEmpty(pesquisa)) {
			procedimentos = new ArrayList<>();
			procedimentos = procedimentoFacade.selected(pesquisa);
		} else {
			procedimentos = procedimentoFacade.all();
		}

	}

	public void remove() {
		try {
			procedimentoFacade.remove(procedimento);
			FacesUtil.addInfoMessageRemovido();
			procedimentos = procedimentoFacade.all();
		} catch (Exception e) {
			FacesUtil.addInfoMessageException(e);
		}
	}

	public String getPesquisa() {
		return pesquisa;
	}

	public void setPesquisa(String pesquisa) {
		this.pesquisa = pesquisa;
	}

	public ProcedimentoEntity getProcedimento() {
		return procedimento;
	}

	public void setProcedimento(ProcedimentoEntity procedimento) {
		this.procedimento = procedimento;
	}

	public List<ProcedimentoEntity> getProcedimentos() {
		return procedimentos;
	}

	public void setProcedimentos(List<ProcedimentoEntity> procedimentos) {
		this.procedimentos = procedimentos;
	}

}
