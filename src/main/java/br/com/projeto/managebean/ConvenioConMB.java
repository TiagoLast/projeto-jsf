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
import br.com.projeto.entity.ConvenioEntity;
import br.com.projeto.interfaces.ConvenioFacade;

@ViewScoped
@Named
public class ConvenioConMB implements Serializable {

	private static final long serialVersionUID = 3819230534860340809L;

	@Inject
	private ConvenioFacade convenioFacade;

	@Inject
	private ConvenioEntity convenio;

	private List<ConvenioEntity> convenios;

	private String pesquisa;

	@PostConstruct
	public void start() {
		convenios = convenioFacade.all();
	}

	public void selected() {
		if (StringUtils.isNotEmpty(pesquisa)) {
			convenios = new ArrayList<>();
			convenios = convenioFacade.selected(pesquisa);
		} else {
			convenios = convenioFacade.all();
		}

	}

	public void remove() {
		try {
			convenioFacade.remove(convenio);
			FacesUtil.addInfoMessageRemovido();
			convenios = convenioFacade.all();
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

	public ConvenioEntity getConvenio() {
		return convenio;
	}

	public void setConvenio(ConvenioEntity convenio) {
		this.convenio = convenio;
	}

	public List<ConvenioEntity> getConvenios() {
		return convenios;
	}

	public void setConvenios(List<ConvenioEntity> convenios) {
		this.convenios = convenios;
	}

}
