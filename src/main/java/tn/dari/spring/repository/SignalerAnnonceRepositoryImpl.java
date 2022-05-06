package tn.dari.spring.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.dari.spring.entity.SignalerAnnonce;



public class SignalerAnnonceRepositoryImpl implements SignalerAnnonceRepositoryCustom {
	@PersistenceContext
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	@Override
	public List<SignalerAnnonce> getSignauxByAnnonceId(Long annonceId) {
		List<SignalerAnnonce> list = this.entityManager
				.createQuery("select c from SignalerAnnonce c where c.annonce.idAnnonce = '" + annonceId + "'")
				.getResultList();
		for (int i = 0; i < list.size(); i++) {
			list.get(i).setIdAnnonce(list.get(i).getAnnonce().getIdAnnonce());
		}
		return list;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Object> getSignauxForAdmin(){
		List<Object> list = this.entityManager
				.createQuery("select s,COUNT(s) as nbre from SignalerAnnonce s GROUP BY s.annonce.idAnnonce")
				.getResultList();
		
		return list;
	}
}
