package br.com.projeto.bo;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import br.com.projeto.dao.CategoriaDAO;
import br.com.projeto.entity.CategoriaEntity;
import br.com.projeto.interfaces.AppBO;

@ApplicationScoped
public class CategoriaBO implements Serializable, AppBO<CategoriaEntity> {

	private static final long serialVersionUID = 3609128568971127754L;

	@Inject
	private CategoriaDAO categoriaDAO;

	@Override
	public void save(CategoriaEntity categoria) {
		categoriaDAO.save(categoria);
	}

	@Override
	public void remove(CategoriaEntity categoria) {
		categoriaDAO.remove(categoria);
	}

	@Override
	public List<CategoriaEntity> all() {
		return categoriaDAO.all(CategoriaEntity.class);
	}

	@Override
	public List<CategoriaEntity> selected(String value) {
		return categoriaDAO.recuperaItem(CategoriaEntity.class, value, "descricao");
	}

	@Override
	public CategoriaEntity get(Long id) {
		return categoriaDAO.get(CategoriaEntity.class, id);
	}

}
