package tn.dari.spring.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.dari.spring.entity.CommentAnnonce;



public class CommentAnnonceRepositoryImpl implements CommentAnnonceRepositoryCustom {
	@PersistenceContext
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	@Override
	public List<CommentAnnonce> getCommentsByAnnonceId(Long annonceId) {
		List<CommentAnnonce> list = this.entityManager.createQuery("select c from CommentAnnonce c where c.annonce.idAnnonce = '" + annonceId + "'")
				.getResultList();
		for (int i = 0; i < list.size(); i++) {
			list.get(i).setIdAnnonce(list.get(i).getAnnonce().getIdAnnonce());
		}
		return list;
	}

}