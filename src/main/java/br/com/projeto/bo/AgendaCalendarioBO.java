package br.com.projeto.bo;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import br.com.projeto.dao.AgendaCalendaoDAO;
import br.com.projeto.entity.AgendaxpEntity;
import br.com.projeto.interfaces.AppBO;

@ApplicationScoped
public class AgendaCalendarioBO implements Serializable, AppBO<AgendaxpEntity> {

	private static final long serialVersionUID = 3609128568971127754L;

	@Inject
	private AgendaCalendaoDAO agendaDAO;

	@Override
	public void save(AgendaxpEntity agenda) {
		agendaDAO.save(agenda);
	}

	@Override
	public void remove(AgendaxpEntity agenda) {
		agendaDAO.remove(agenda);
	}

	@Override
	public List<AgendaxpEntity> all() {
		return agendaDAO.all(AgendaxpEntity.class);
	}

	@Override
	public List<AgendaxpEntity> selected(String value) {
		return agendaDAO.recuperaItem(AgendaxpEntity.class, value, "nome");
	}

	@Override
	public AgendaxpEntity get(Long id) {
		return agendaDAO.get(AgendaxpEntity.class, id);
	}

}
