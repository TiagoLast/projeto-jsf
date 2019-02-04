package br.com.projeto.managebean;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.commons.lang3.StringUtils;

import br.com.projeto.comum.FacesUtil;
import br.com.projeto.entity.EstoqueEntity;
import br.com.projeto.interfaces.EstoqueFacade;
import br.com.projeto.interfaces.ICrudMB;

@ViewScoped
@Named
public class EstoqueManMB implements Serializable, ICrudMB {

	private static final long serialVersionUID = 3819230534860340809L;

	@Inject
	private EstoqueFacade estoqueFacade;

	@Inject
	private EstoqueEntity estoque;

	@PostConstruct
	public void inicia() {
		recuperaEstoque();
	}

	@Override
	public void grava() {
		if (estoque == null) {
			FacesUtil.addErrorMessage("Erro ao registrar");
		} else {

			estoqueFacade.save(this.estoque);
			limpar();
			FacesUtil.addInfoMessage("Registro gravado com sucesso!");
		}
	}

	public void limpar() {
		estoque = new EstoqueEntity();
	}

	private void recuperaEstoque() {
		String id = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("id");
		if (StringUtils.isNotEmpty(id) && StringUtils.isNotBlank(id)) {
			this.estoque = estoqueFacade.get(Long.valueOf(id));
		}
	}

	public EstoqueEntity getEstoque() {
		return estoque;
	}

	public void setEstoque(EstoqueEntity estoque) {
		this.estoque = estoque;
	}

}
