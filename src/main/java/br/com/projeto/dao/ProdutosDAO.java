package br.com.projeto.dao;

import java.io.Serializable;

import javax.inject.Inject;
import javax.persistence.EntityManager;

public class ProdutosDAO implements Serializable{

	private static final long serialVersionUID = 5447095424176469703L;

	@Inject
	private EntityManager manager;

	
	
}
