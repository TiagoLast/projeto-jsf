package br.com.projeto.bo;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import br.com.projeto.dao.AgendaDAO;
import br.com.projeto.entity.AgendaContadoEntity;
import br.com.projeto.interfaces.AppBO;

@ApplicationScoped
public class AgendaBO implements Serializable, AppBO<AgendaContadoEntity> {

	private static final long serialVersionUID = 3609128568971127754L;

	@Inject
	private AgendaDAO agendaDAO;

	@Override
	public void save(AgendaContadoEntity agenda) {
		agendaDAO.save(agenda);
	}

	@Override
	public void remove(AgendaContadoEntity agenda) {
		agendaDAO.remove(agenda);
	}

	@Override
	public List<AgendaContadoEntity> all() {
		return agendaDAO.all(AgendaContadoEntity.class);
	}

	@Override
	public List<AgendaContadoEntity> selected(String value) {
		return agendaDAO.recuperaItem(AgendaContadoEntity.class, value, "nome");
	}

	@Override
	public AgendaContadoEntity get(Long id) {
		return agendaDAO.get(AgendaContadoEntity.class, id);
	}

}
