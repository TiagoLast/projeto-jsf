package br.com.projeto.interfaces;

import java.util.List;

import br.com.projeto.entity.CategoriaEntity;

public interface CategoriaFacade {
	
	public void save(CategoriaEntity categoria);

	public List<CategoriaEntity> all();

	public void remove(CategoriaEntity categoria);
	
	public List<CategoriaEntity> selected(String value);

	public CategoriaEntity get(Long id);
	
	
}
