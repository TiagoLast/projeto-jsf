package br.com.projeto.bo;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import br.com.projeto.dao.LancamentoDAO;
import br.com.projeto.entity.LancamentoEntity;
import br.com.projeto.interfaces.AppBO;

@ApplicationScoped
public class LancamentoBO implements Serializable, AppBO<LancamentoEntity> {

	private static final long serialVersionUID = 3609128568971127754L;

	@Inject
	private LancamentoDAO lancamentoDAO;

	@Override
	public void save(LancamentoEntity lancamento) {
		lancamentoDAO.save(lancamento);
	}

	@Override
	public void remove(LancamentoEntity lancamento) {
		lancamentoDAO.remove(lancamento);
	}

	@Override
	public List<LancamentoEntity> all() {
		return lancamentoDAO.all(LancamentoEntity.class);
	}

	@Override
	public List<LancamentoEntity> selected(String value) {
		return lancamentoDAO.recuperaItem(LancamentoEntity.class, value, "titulo");
	}

	@Override
	public LancamentoEntity get(Long idLancamento) {
		return lancamentoDAO.get(LancamentoEntity.class, idLancamento);
	}

}
