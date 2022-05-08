package tn.dari.spring.service;


import java.util.List;

import tn.dari.spring.entity.Annonce;



public interface AnnonceService {
	List<Annonce> retrieveAllAnnonces();
	Annonce addAnnonce(Annonce annonce);
	Annonce UpdateAnnonce(Annonce annonce);
	void deleteAnnonce(Long id);
	Annonce retrieveAnnonceById(Long id);

}
