package br.com.projeto.facade;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import br.com.projeto.bo.EstoqueBO;
import br.com.projeto.entity.EstoqueEntity;
import br.com.projeto.interfaces.EstoqueFacade;
import br.com.projeto.jpa.Transactional;

@ApplicationScoped
public class EstoqueImpl implements Serializable, EstoqueFacade {

	private static final long serialVersionUID = 2101599288749513604L;

	@Inject
	private EstoqueBO estoqueBO;

	@Transactional
	@Override
	public void save(EstoqueEntity estoque) {
		estoqueBO.save(estoque);
	}

	@Transactional
	@Override
	public void remove(EstoqueEntity estoque) {
		estoqueBO.remove(estoque);
	}

	@Override
	public List<EstoqueEntity> all() {
		return estoqueBO.all();
	}

	@Override
	public List<EstoqueEntity> selected(String value) {
		return estoqueBO.selected(value);
	}

	@Override
	public EstoqueEntity get(Long id) {
		return estoqueBO.get(id);
	}

}
