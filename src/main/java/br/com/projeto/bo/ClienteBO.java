package br.com.projeto.bo;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import br.com.projeto.dao.ClienteDAO;
import br.com.projeto.entity.ClienteEntity;
import br.com.projeto.interfaces.AppBO;

@ApplicationScoped
public class ClienteBO implements Serializable, AppBO<ClienteEntity> {

	private static final long serialVersionUID = 3609128568971127754L;

	@Inject
	private ClienteDAO clienteDAO;

	@Override
	public void save(ClienteEntity cliente) {
		clienteDAO.save(cliente);
	}

	@Override
	public void remove(ClienteEntity cliente) {
		clienteDAO.remove(cliente);
	}

	@Override
	public List<ClienteEntity> all() {
		return clienteDAO.all(ClienteEntity.class);
	}

	@Override
	public List<ClienteEntity> selected(String value) {
		return clienteDAO.recuperaItem(ClienteEntity.class, value, "nome");
	}

	@Override
	public ClienteEntity get(Long id) {
		return clienteDAO.get(ClienteEntity.class, id);
	}

}
