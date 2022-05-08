package tn.dari.spring.repository;

import java.util.List;

import tn.dari.spring.entity.SignalerAnnonce;



public interface SignalerAnnonceRepositoryCustom {
	public List<SignalerAnnonce> getSignauxByAnnonceId(Long annonceId);
	public List<Object> getSignauxForAdmin();
}
