package br.com.projeto.interfaces;

import java.util.List;

import br.com.projeto.entity.DespesaEntity;

public interface DespesaFacade {
	
	public void save(DespesaEntity despesa);

	public List<DespesaEntity> all();

	public void remove(DespesaEntity despesa);
	
	public List<DespesaEntity> selected(String value);

	public DespesaEntity get(Long id);
	
	
	
}
