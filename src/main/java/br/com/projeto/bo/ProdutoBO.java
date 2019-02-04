package br.com.projeto.bo;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import br.com.projeto.dao.ProdutoDAO;
import br.com.projeto.entity.ProdutoEntity;
import br.com.projeto.interfaces.AppBO;

@ApplicationScoped
public class ProdutoBO implements Serializable, AppBO<ProdutoEntity> {

	private static final long serialVersionUID = 3609128568971127754L;

	@Inject
	private ProdutoDAO produtoDAO;

	@Override
	public void save(ProdutoEntity produto) {
		produtoDAO.save(produto);
	}
	
	@Override
	public void entradaProduto(ProdutoEntity produto) {
		produtoDAO.entradaProduto(produto);
	}
	
	@Override
	public void saidaProduto(ProdutoEntity produto) {
		produtoDAO.saidaProduto(produto);
	}

	@Override
	public void remove(ProdutoEntity produto) {
		produtoDAO.remove(produto);
	}

	@Override
	public ProdutoEntity get(Long id) {
		return produtoDAO.get(ProdutoEntity.class, id);
	}

	@Override
	public List<ProdutoEntity> all() {
		return produtoDAO.all(ProdutoEntity.class);
	}

	@Override
	public List<ProdutoEntity> selected(String value) {
		return produtoDAO.recuperaItem(ProdutoEntity.class, value, "nome");
	}

	public ProdutoEntity recuperaProduto(Long id) {
		return produtoDAO.recuperaProduto(id);
	}

}
