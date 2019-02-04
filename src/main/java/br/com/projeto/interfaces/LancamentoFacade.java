package br.com.projeto.interfaces;

import java.util.List;

import br.com.projeto.entity.LancamentoEntity;

public interface LancamentoFacade {
	
	public void save(LancamentoEntity lancamento);

	public List<LancamentoEntity> all();

	public void remove(LancamentoEntity lancamento);
	
	public List<LancamentoEntity> selected(String value);

	public LancamentoEntity get(Long id);
	
	
}
