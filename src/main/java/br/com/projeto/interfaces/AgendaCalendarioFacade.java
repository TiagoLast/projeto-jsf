package br.com.projeto.interfaces;

import java.util.List;

import br.com.projeto.entity.AgendaxpEntity;

public interface AgendaCalendarioFacade {

	public void save(AgendaxpEntity agenda);

	public List<AgendaxpEntity> all();

	public void remove(AgendaxpEntity categoria);

	public List<AgendaxpEntity> selected(String value);

	public AgendaxpEntity get(Long id);

}
