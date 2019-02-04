package br.com.projeto.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.com.projeto.entity.ProdutoEntity;
import br.com.projeto.interfaces.EntidadeBase;
import br.com.projeto.interfaces.IAssinaturaDAO;


public class DaoGenericos<T extends EntidadeBase> implements IAssinaturaDAO<T>   {
	
	private final static EntityManagerFactory emf = Persistence.createEntityManagerFactory("projetox");
	
	@Override
	public void grava(T t) {
		EntityManager manager = emf.createEntityManager();
		manager.getTransaction().begin();
		manager.persist(t);
		manager.getTransaction().commit();
		manager.close();
	}

	@Override
	public void update(T t) {
		EntityManager manager = emf.createEntityManager();
		manager.getTransaction().begin();
		manager.merge(t);		
		manager.getTransaction().commit();
		manager.close();
	}

	@Override
	public void remove(T t) {
		EntityManager manager = emf.createEntityManager();
		manager.getTransaction().begin();
		manager.remove(manager.merge(t));
		manager.getTransaction().commit();
		manager.close();
	}

	@Override
	public T buscaPorId(Class<T> classe, Long id) {
		EntityManager manager = emf.createEntityManager();
		return manager.find(classe, id);
	}
	
	
	@Override
	@SuppressWarnings("unchecked")
	public List<T> getAll(Class<T> classe) {
		EntityManager manager = emf.createEntityManager();
		return manager.createQuery("from " + classe.getName()).getResultList();
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<T> recuperaItensOrdenado(Class<T> classe, String parametroOrdenado) {
		EntityManager manager = emf.createEntityManager();
		StringBuilder sql = new StringBuilder();
		sql.append("select p from ")
		.append(classe.getName())
		.append(" as p order by p.").append(parametroOrdenado);
		return manager.createQuery(sql.toString()).getResultList();
	}
	
	
	
	@Override
	@SuppressWarnings("unchecked")
	public List<T> recuperaItemOrdenadoDescendente(Class<T> classe,String value,String nomeColuna) {
		EntityManager manager = emf.createEntityManager();
		StringBuilder sql = new StringBuilder();
		sql.append("select p  from ");
		sql.append(classe.getName());
		sql.append(" p where p."+nomeColuna);
		sql.append(" like :desc");		
		return manager.createQuery(sql.toString())
				.setParameter("desc", "%" + value + "%").getResultList();
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<T> recuperaItem(Class<T> classe,String valorARecuperar, String parametro) {
		EntityManager manager = emf.createEntityManager();
		StringBuilder sql = new StringBuilder();
		sql.append("from ").append(classe.getName()).append(" p where upper (p.").append(parametro)
				.append(") like :param");
		return manager.createQuery(sql.toString()).setParameter("param", "%" + valorARecuperar.toUpperCase() + "%")
				.getResultList();
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<T> recuperaPorData(Class<T> classe,Date inicio, Date fim, String nomeColuna) {
		EntityManager manager = emf.createEntityManager();		
		StringBuilder sql = new StringBuilder();		
		sql.append("select p from ");
		sql.append(classe.getName());
		sql.append(" p where p."+nomeColuna);
		sql.append("between :dinicio and :dfim");		
		Query query = manager.createQuery(sql.toString());		
		query.setParameter("dinicio", inicio);
		query.setParameter("dfim", fim);
		return query.getResultList();
	}
		
}
