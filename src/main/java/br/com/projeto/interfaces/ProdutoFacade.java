package br.com.projeto.interfaces;

import java.util.List;

import br.com.projeto.entity.ProdutoEntity;

public interface ProdutoFacade {
	
	public void save(ProdutoEntity produto);

	public List<ProdutoEntity> all();

	public void remove(ProdutoEntity produto);
	
	public List<ProdutoEntity> selected(String value);

	public ProdutoEntity get(Long id);
	
	public ProdutoEntity recuperaProduto(Long id);
	
	default void entradaProduto(ProdutoEntity produto) {	}
	
	default void saidaProduto(ProdutoEntity produto) {	}
	
	
	
}
