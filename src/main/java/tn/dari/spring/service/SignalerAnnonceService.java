package tn.dari.spring.service;

import java.util.List;

import tn.dari.spring.entity.SignalerAnnonce;



public interface SignalerAnnonceService {
	List<SignalerAnnonce> retrieveAllSignalerAnnonce();
	SignalerAnnonce addSignalerAnnonce(SignalerAnnonce s);

	void deleteSignalerAnnonce(Long id);
	List<SignalerAnnonce> getSignauxByAnnonceId(Long annonceId);
	List<Object> getSignauxForAdmin();

}
