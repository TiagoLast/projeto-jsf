package br.com.projeto.dao;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.projeto.entity.ProdutoEntity;
import br.com.projeto.entity.ProntuarioEntity;

public class DaoGenerico<T> implements Serializable {

	private static final long serialVersionUID = 4650591858452084435L;

	@Inject
	private EntityManager manager;

	public void save(T t) {
		manager.merge(t);
	}

	@SuppressWarnings("unchecked")
	public T get(Class<?> entityClass, Long id) {
		return (T) manager.find(entityClass, id);
	}

	@SuppressWarnings("unchecked")
	public List<T> all(Class<T> classe) {
		return manager.createQuery("from " + classe.getName()).getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<Long> getIds(Class<T> classe) {
		return manager.createQuery("select p.id from " + classe.getName() + " p").getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<T> paginationPage(Class<T> classe, List<Long> lIds) {
		return manager.createQuery("select p from " + classe.getName() + " p where p.id in :ids")
				.setParameter("ids", lIds).getResultList();
	}

	public void remove(T t) {
		manager.remove(manager.merge(t));
		manager.flush();
	}

	public ProdutoEntity recuperaProduto(Long id) {
		StringBuilder sql = new StringBuilder();
		sql.append("select p from ProdutoEntity p").append(" join p.categoria c ").append(" join p.estoque e ")
				.append(" where p.id =:id ");
		return (ProdutoEntity) manager.createQuery(sql.toString()).setParameter("id", id).getSingleResult();

	}
	
	@SuppressWarnings("unchecked")
	public List<T> recuperaPorIds(Class<T> classe, List<Long> lIds) {
		return manager.createQuery("select p from " + classe.getName() + " p where p.id in :ids")
				.setParameter("ids", lIds).getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<T> recuperaPorId(Long id) {
		StringBuilder sql = new StringBuilder();
		sql.append("select pro from ProntuarioEntity pro ");
		sql.append(" join pro.paciente pac ");
		sql.append(" where pac.id =:id");
		return manager.createQuery(sql.toString())
				.setParameter("id", id).getResultList();
	}
	

	@SuppressWarnings("unchecked")
	public List<T> recuperaItem(Class<T> classe, String valorARecuperar, String parametro) {
		StringBuilder sql = new StringBuilder();
		sql.append("from ").append(classe.getName()).append(" p where upper (p.").append(parametro)
				.append(") like :param");
		return manager.createQuery(sql.toString()).setParameter("param", "%" + valorARecuperar.toUpperCase() + "%")
				.getResultList();
	}

	public void entradaProduto(ProdutoEntity produto) {
		StringBuilder sql = new StringBuilder();
		sql.append("update ProdutoEntity p ");
		sql.append(" set p.quantidade = p.quantidade + :novaquantidade");
		sql.append(" where p.id =:idproduto");
		manager.createQuery(sql.toString()).setParameter("novaquantidade", produto.getQuantidade())
				.setParameter("idproduto", produto.getId()).executeUpdate();
	}

	public void saidaProduto(ProdutoEntity produto) {
		StringBuilder sql = new StringBuilder();
		sql.append("update ProdutoEntity p ");
		sql.append(" set p.quantidade = p.quantidade - :novaquantidade where p.id = :idproduto");
		manager.createQuery(sql.toString()).setParameter("novaquantidade", produto.getQuantidade())
				.setParameter("idproduto", produto.getId()).executeUpdate();
	}

}
