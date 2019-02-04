package br.com.projeto.facade;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import br.com.projeto.bo.DespesaBO;
import br.com.projeto.entity.DespesaEntity;
import br.com.projeto.interfaces.DespesaFacade;
import br.com.projeto.jpa.Transactional;

@ApplicationScoped
public class DespesaImpl implements Serializable, DespesaFacade {

	private static final long serialVersionUID = 2101599288749513604L;

	@Inject
	private DespesaBO despesaBO;

	@Transactional
	@Override
	public void save(DespesaEntity despesa) {
		despesaBO.save(despesa);
	}

	@Transactional
	@Override
	public void remove(DespesaEntity despesa) {
		despesaBO.remove(despesa);
	}

	@Override
	public List<DespesaEntity> all() {
		return despesaBO.all();
	}

	@Override
	public List<DespesaEntity> selected(String value) {
		return despesaBO.selected(value);
	}

	@Override
	public DespesaEntity get(Long id) {
		return despesaBO.get(id);
	}

}
