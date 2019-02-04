package br.com.projeto.bo;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import br.com.projeto.dao.ConsultaDAO;
import br.com.projeto.entity.ConsultaEntity;
import br.com.projeto.interfaces.AppBO;

@ApplicationScoped
public class ConsultaBO implements Serializable, AppBO<ConsultaEntity> {

	private static final long serialVersionUID = 3609128568971127754L;

	@Inject
	private ConsultaDAO consultaDAO;

	@Override
	public void save(ConsultaEntity consulta) {
		consultaDAO.save(consulta);
	}

	@Override
	public void remove(ConsultaEntity consulta) {
		consultaDAO.remove(consulta);
	}

	@Override
	public List<ConsultaEntity> all() {
		return consultaDAO.all(ConsultaEntity.class);
	}

	@Override
	public List<ConsultaEntity> selected(String value) {
		return consultaDAO.recuperaItem(ConsultaEntity.class, value, "");
	}

	@Override
	public ConsultaEntity get(Long id) {
		return consultaDAO.get(ConsultaEntity.class, id);
	}

}
