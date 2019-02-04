package br.com.projeto.interfaces;

import java.util.List;

import br.com.projeto.entity.PacienteEntity;

public interface PacienteFacade {

	public void save(PacienteEntity paciente);

	public List<PacienteEntity> all();

	public void remove(PacienteEntity paciente);

	public List<PacienteEntity> selected(String value);

	public PacienteEntity get(Long id);

}
