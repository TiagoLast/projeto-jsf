package br.com.projeto.bo;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import br.com.projeto.dao.PersistenceUtils;
import br.com.projeto.dao.QueryUtils;
import br.com.projeto.entity.ProntuarioEntity;
import br.com.projeto.interfaces.AppBO;

@ApplicationScoped
public class ProntuarioBO implements Serializable, AppBO<ProntuarioEntity> {

	private static final long serialVersionUID = 3609128568971127754L;

	@Inject
	private PersistenceUtils<ProntuarioEntity> dao;

	@Inject
	private QueryUtils<ProntuarioEntity> query;


	@Override
	public void save(ProntuarioEntity prontuario) {
		dao.save(prontuario);
	}

	@Override
	public void remove(ProntuarioEntity prontuario) {
		dao.remove(prontuario);
	}

	@Override
	public List<ProntuarioEntity> all() {
		return query.all(ProntuarioEntity.class);
	}

	@Override
	public List<ProntuarioEntity> selected(String value) {
		return query.recuperaItem(ProntuarioEntity.class, value, "anamnese");
	}

	@Override
	public ProntuarioEntity get(Long id) {
		return query.get(ProntuarioEntity.class, id);
	}

//	public List<ProntuarioEntity> recuperaPronturios(Long id) {
//		return query.recuperaPorId(id);
//	}

}
