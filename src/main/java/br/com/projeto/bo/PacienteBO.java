package br.com.projeto.bo;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import br.com.projeto.dao.PacienteDAO;
import br.com.projeto.entity.PacienteEntity;
import br.com.projeto.interfaces.AppBO;

@ApplicationScoped
public class PacienteBO implements Serializable, AppBO<PacienteEntity> {

	private static final long serialVersionUID = 3609128568971127754L;

	@Inject
	private PacienteDAO pacienteDAO;

	@Override
	public void save(PacienteEntity agenda) {
		pacienteDAO.save(agenda);
	}

	@Override
	public void remove(PacienteEntity agenda) {
		pacienteDAO.remove(agenda);
	}

	@Override
	public List<PacienteEntity> all() {
		return pacienteDAO.all(PacienteEntity.class);
	}

	@Override
	public List<PacienteEntity> selected(String value) {
		return pacienteDAO.recuperaItem(PacienteEntity.class, value, "nome");
	}

	@Override
	public PacienteEntity get(Long id) {
		return pacienteDAO.get(PacienteEntity.class, id);
	}

}
