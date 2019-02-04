package br.com.projeto.bo;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import br.com.projeto.dao.ProntuarioDAO;
import br.com.projeto.entity.ProntuarioEntity;
import br.com.projeto.interfaces.AppBO;

@ApplicationScoped
public class ProntuarioBO implements Serializable, AppBO<ProntuarioEntity> {

	private static final long serialVersionUID = 3609128568971127754L;

	@Inject
	private ProntuarioDAO prontuarioDAO;

	@Override
	public void save(ProntuarioEntity prontuario) {
		prontuarioDAO.save(prontuario);
	}

	@Override
	public void remove(ProntuarioEntity prontuario) {
		prontuarioDAO.remove(prontuario);
	}

	@Override
	public List<ProntuarioEntity> all() {
		return prontuarioDAO.all(ProntuarioEntity.class);
	}

	@Override
	public List<ProntuarioEntity> selected(String value) {
		return prontuarioDAO.recuperaItem(ProntuarioEntity.class, value, "anamnese");
	}

	@Override
	public ProntuarioEntity get(Long id) {
		return prontuarioDAO.get(ProntuarioEntity.class, id);
	}

	public List<ProntuarioEntity> recuperaPronturios(Long id) {
		return prontuarioDAO.recuperaPorId(id);
	}

}
