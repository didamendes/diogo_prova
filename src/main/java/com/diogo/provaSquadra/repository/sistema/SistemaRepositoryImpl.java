package com.diogo.provaSquadra.repository.sistema;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.util.StringUtils;

import com.diogo.provaSquadra.model.Sistema;
import com.diogo.provaSquadra.repository.filter.SistemaFilter;

public class SistemaRepositoryImpl implements SistemaRepositoryQuery {

	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public List<Sistema> filtrar(SistemaFilter sistemaFilter) {
		
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Sistema> criteria = builder.createQuery(Sistema.class);
		Root<Sistema> root = criteria.from(Sistema.class);
		
		Predicate[] predicates = criarRestricoes(sistemaFilter, builder, root);
		criteria.where(predicates);
		
		TypedQuery<Sistema> query = manager.createQuery(criteria);
		
		return query.getResultList();
	}

	private Predicate[] criarRestricoes(SistemaFilter sistemaFilter, CriteriaBuilder builder, Root<Sistema> root) {
		
		List<Predicate> predicates = new ArrayList<>();
		
		if (!StringUtils.isEmpty(sistemaFilter.getDescricao())) {
			predicates.add(builder.like(
					builder.lower(root.get("descricao")), 
					"%" + sistemaFilter.getDescricao().toLowerCase() + "%"));
		}
		
		if (!StringUtils.isEmpty(sistemaFilter.getSigla())) {
			predicates.add(builder.like(
					builder.lower(root.get("sigla")), 
					"%" + sistemaFilter.getSigla().toLowerCase() + "%"));
		}
		
		if (!StringUtils.isEmpty(sistemaFilter.getEmail())) {
			predicates.add(builder.like(
					builder.lower(root.get("email")), 
					sistemaFilter.getEmail().toLowerCase()));
		}
		
		return predicates.toArray(new Predicate[predicates.size()]);
	}

}
