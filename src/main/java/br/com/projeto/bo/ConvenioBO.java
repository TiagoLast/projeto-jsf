package br.com.projeto.bo;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import br.com.projeto.dao.ConvenioDAO;
import br.com.projeto.entity.ConvenioEntity;
import br.com.projeto.interfaces.AppBO;

@ApplicationScoped
public class ConvenioBO implements Serializable, AppBO<ConvenioEntity> {

	private static final long serialVersionUID = 3609128568971127754L;

	@Inject
	private ConvenioDAO convenioDAO;

	@Override
	public void save(ConvenioEntity agenda) {
		convenioDAO.save(agenda);
	}

	@Override
	public void remove(ConvenioEntity agenda) {
		convenioDAO.remove(agenda);
	}

	@Override
	public List<ConvenioEntity> all() {
		return convenioDAO.all(ConvenioEntity.class);
	}

	@Override
	public List<ConvenioEntity> selected(String value) {
		return convenioDAO.recuperaItem(ConvenioEntity.class, value, "nomeConvenio");
	}

	@Override
	public ConvenioEntity get(Long id) {
		return convenioDAO.get(ConvenioEntity.class, id);
	}

}
