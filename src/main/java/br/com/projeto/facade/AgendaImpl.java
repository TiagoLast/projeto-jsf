package br.com.projeto.facade;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import br.com.projeto.bo.AgendaBO;
import br.com.projeto.entity.AgendaContadoEntity;
import br.com.projeto.interfaces.AgendaFacade;
import br.com.projeto.jpa.Transactional;

@ApplicationScoped
public class AgendaImpl implements Serializable, AgendaFacade {

	private static final long serialVersionUID = 2101599288749513604L;

	@Inject
	private AgendaBO agendaBO;

	@Transactional
	@Override
	public void save(AgendaContadoEntity agenda) {
		agendaBO.save(agenda);
	}

	@Transactional
	@Override
	public void remove(AgendaContadoEntity agenda) {
		agendaBO.remove(agenda);
	}

	@Override
	public List<AgendaContadoEntity> all() {
		return agendaBO.all();
	}

	@Override
	public List<AgendaContadoEntity> selected(String value) {
		return agendaBO.selected(value);
	}

	@Override
	public AgendaContadoEntity get(Long id) {
		return agendaBO.get(id);
	}

}
