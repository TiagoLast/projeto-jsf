package br.com.projeto.bo;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import br.com.projeto.dao.PersistenceUtils;
import br.com.projeto.dao.QueryUtils;
import br.com.projeto.entity.ConsultaEntity;
import br.com.projeto.interfaces.AppBO;

@ApplicationScoped
public class ConsultaBO implements Serializable, AppBO<ConsultaEntity> {

	private static final long serialVersionUID = 3609128568971127754L;

	@Inject
	private QueryUtils<ConsultaEntity> query;
		
	@Inject
	private PersistenceUtils<ConsultaEntity> dao;

	@Override
	public void save(ConsultaEntity consulta) {
		dao.save(consulta);
	}

	@Override
	public void remove(ConsultaEntity consulta) {
		dao.remove(consulta);
	}

	@Override
	public List<ConsultaEntity> all() {
		return query.all(ConsultaEntity.class);
	}

	@Override
	public List<ConsultaEntity> selected(String value) {
		return query.recuperaItem(ConsultaEntity.class, value, "");
	}

	@Override
	public ConsultaEntity get(Long id) {
		return query.get(ConsultaEntity.class, id);
	}

}
