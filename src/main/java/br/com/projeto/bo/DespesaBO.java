package br.com.projeto.bo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import com.google.common.collect.Lists;

import br.com.projeto.dao.DespesaDAO;
import br.com.projeto.entity.DespesaEntity;
import br.com.projeto.interfaces.AppBO;

@ApplicationScoped
public class DespesaBO implements Serializable, AppBO<DespesaEntity> {

	private static final long serialVersionUID = 3609128568971127754L;

	@Inject
	private DespesaDAO despesaDAO;

	@Override
	public void save(DespesaEntity despesa) {
		despesaDAO.save(despesa);
	}

	@Override
	public void remove(DespesaEntity despesa) {
		despesaDAO.remove(despesa);
	}

	@Override
	public List<DespesaEntity> all() {
		
		long tempInicial = System.currentTimeMillis();
		
//		List<DespesaEntity> paginationPage = new ArrayList<>();
//		List<DespesaEntity> outraLista = new ArrayList<>();
//		List<Long> ids2 = despesaDAO.getIds(DespesaEntity.class);
//		for (List<Long> umaListaIds : Lists.partition(ids2, 2000)) {
//			paginationPage = despesaDAO.paginationPage(DespesaEntity.class, umaListaIds);
//			for (DespesaEntity umaDespesa : paginationPage) {
//				outraLista.add(umaDespesa);
//			}
//		}
		
		List<DespesaEntity> all = despesaDAO.all(DespesaEntity.class);
		
		long tempFinal = System.currentTimeMillis();
		
		long dif = (tempFinal - tempInicial);
		
		System.out.println(String.format("%02d segundos  e %02d milisegundos", dif/60, dif%60));

		

		return null;
	}

	@Override
	public List<DespesaEntity> selected(String value) {
		return despesaDAO.recuperaItem(DespesaEntity.class, value, "descricao");
	}

	@Override
	public DespesaEntity get(Long id) {
		return despesaDAO.get(DespesaEntity.class, id);
	}

}
