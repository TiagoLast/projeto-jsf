package br.com.projeto.dao;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class PersistenceUtils<T> {

	@Inject
	private EntityManager manager;

	public void save(T t) {
		manager.merge(t);
	}

	public void remove(T t) {
		manager.remove(manager.merge(t));
		manager.flush();
	}

	public void insert() {
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO person (id, first_name, last_name) VALUES (?,?,?)");
		manager.createNativeQuery(sql.toString()).setParameter(1, "");
		Query query = manager.createQuery("");
	}

}
