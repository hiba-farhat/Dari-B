package tn.dari.spring.service;

import java.util.List;

import tn.dari.spring.entity.likeAnnonce;


public interface LikeAnnonceService {
	List<likeAnnonce> retrieveAllLikeAnnonce();
	likeAnnonce addLikeAnnonce(likeAnnonce l);

	void deleteLikeAnnonce(Long id);

}
