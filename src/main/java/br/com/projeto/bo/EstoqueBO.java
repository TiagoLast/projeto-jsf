package br.com.projeto.bo;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import br.com.projeto.dao.EstoqueDAO;
import br.com.projeto.entity.EstoqueEntity;
import br.com.projeto.interfaces.AppBO;

@ApplicationScoped
public class EstoqueBO implements Serializable, AppBO<EstoqueEntity> {

	private static final long serialVersionUID = 3609128568971127754L;

	@Inject
	private EstoqueDAO estoqueDAO;

	@Override
	public void save(EstoqueEntity estoque) {
		estoqueDAO.save(estoque);
	}

	@Override
	public void remove(EstoqueEntity estoque) {
		estoqueDAO.remove(estoque);
	}

	@Override
	public List<EstoqueEntity> all() {
		return estoqueDAO.all(EstoqueEntity.class);
	}

	@Override
	public List<EstoqueEntity> selected(String value) {
		return estoqueDAO.recuperaItem(EstoqueEntity.class, value, "descricao");
	}

	@Override
	public EstoqueEntity get(Long id) {
		return estoqueDAO.get(EstoqueEntity.class, id);
	}

}
