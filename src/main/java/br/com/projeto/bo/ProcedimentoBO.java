package br.com.projeto.bo;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import br.com.projeto.dao.ProcedimentoDAO;
import br.com.projeto.entity.ProcedimentoEntity;
import br.com.projeto.interfaces.AppBO;

@ApplicationScoped
public class ProcedimentoBO implements Serializable, AppBO<ProcedimentoEntity> {

	private static final long serialVersionUID = 3609128568971127754L;

	@Inject
	private ProcedimentoDAO procedimentoDAO;

	@Override
	public void save(ProcedimentoEntity procedimento) {
		procedimentoDAO.save(procedimento);
	}

	@Override
	public void remove(ProcedimentoEntity procedimento) {
		procedimentoDAO.remove(procedimento);
	}

	@Override
	public List<ProcedimentoEntity> all() {
		return procedimentoDAO.all(ProcedimentoEntity.class);
	}

	@Override
	public List<ProcedimentoEntity> selected(String value) {
		return procedimentoDAO.recuperaItem(ProcedimentoEntity.class, value, "tipoProcedimento");
	}

	@Override
	public ProcedimentoEntity get(Long id) {
		return procedimentoDAO.get(ProcedimentoEntity.class, id);
	}

}
