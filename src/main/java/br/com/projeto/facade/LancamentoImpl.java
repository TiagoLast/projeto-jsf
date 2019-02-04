package br.com.projeto.facade;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import br.com.projeto.bo.LancamentoBO;
import br.com.projeto.entity.LancamentoEntity;
import br.com.projeto.interfaces.LancamentoFacade;
import br.com.projeto.jpa.Transactional;

@ApplicationScoped
public class LancamentoImpl implements Serializable, LancamentoFacade {

	private static final long serialVersionUID = 2101599288749513604L;

	@Inject
	private LancamentoBO lancamentoBO;

	@Transactional
	@Override
	public void save(LancamentoEntity lancamento) {
		lancamentoBO.save(lancamento);
	}

	@Transactional
	@Override
	public void remove(LancamentoEntity lancamento) {
		lancamentoBO.remove(lancamento);
	}

	@Override
	public List<LancamentoEntity> all() {
		return lancamentoBO.all();
	}

	@Override
	public List<LancamentoEntity> selected(String value) {
		return lancamentoBO.selected(value);
	}

	@Override
	public LancamentoEntity get(Long id) {
		return lancamentoBO.get(id);
	}

}
