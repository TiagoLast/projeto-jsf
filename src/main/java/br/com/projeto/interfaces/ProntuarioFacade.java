package br.com.projeto.interfaces;

import java.util.List;

import br.com.projeto.entity.ProntuarioEntity;

public interface ProntuarioFacade {
	
	public void save(ProntuarioEntity prontuario);
	
	public List<ProntuarioEntity> all();

	public void remove(ProntuarioEntity prontuario);

	public List<ProntuarioEntity> selected(String value);
	
	public List<ProntuarioEntity> recuperaPronturios(Long id);
	
	public ProntuarioEntity get(Long id);

}
