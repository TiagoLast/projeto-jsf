package br.com.projeto.facade;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import br.com.projeto.bo.CategoriaBO;
import br.com.projeto.entity.CategoriaEntity;
import br.com.projeto.interfaces.CategoriaFacade;
import br.com.projeto.jpa.Transactional;

@ApplicationScoped
public class CategoriaImpl implements Serializable, CategoriaFacade {

	private static final long serialVersionUID = 2101599288749513604L;

	@Inject
	private CategoriaBO categoriaBO;

	@Transactional
	@Override
	public void save(CategoriaEntity categoria) {
		categoriaBO.save(categoria);
	}

	@Transactional
	@Override
	public void remove(CategoriaEntity categoria) {
		categoriaBO.remove(categoria);
	}

	@Override
	public List<CategoriaEntity> all() {
		return categoriaBO.all();
	}

	@Override
	public List<CategoriaEntity> selected(String value) {
		return categoriaBO.selected(value);
	}

	@Override
	public CategoriaEntity get(Long id) {
		return categoriaBO.get(id);
	}

}
