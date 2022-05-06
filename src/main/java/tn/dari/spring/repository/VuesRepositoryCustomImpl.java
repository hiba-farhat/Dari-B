package tn.dari.spring.repository;
/* package com.essai.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.essai.entity.vues;

public class VuesRepositoryCustomImpl implements VuesRepositoryCustom {

	@PersistenceContext
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	@Override
	public List<vues> getvuesByAnnonceId(Long annonceId) {
		List<vues> list = this.entityManager
				.createQuery("select v from vues v where v.annonce.idAnnonce = '" + annonceId + "'").getResultList();
		for (int i = 0; i < list.size(); i++) {
			list.get(i).setIdAnnonce(list.get(i).getAnnonce().getIdAnnonce());
		}
		return list;
	}
}
*/