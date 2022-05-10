package tn.dari.spring.service;


import java.util.List;

import tn.dari.spring.entity.Annonce;
import tn.dari.spring.entity.Estimation;
import tn.dari.spring.entity.SearchAnnonce;
import tn.dari.spring.entity.favoris;


public interface AnnonceService {
	List<Annonce> retrieveAllAnnonces();
	Annonce addAnnonce(Annonce annonce);
	Annonce UpdateAnnonce(Annonce annonce);
	void deleteAnnonce(Long id);
	Annonce retrievesAnnonce(Long id);
	public List<Annonce> GetBestReductions();
	public List<Annonce> findByCriteria(SearchAnnonce r) ;
public float findEstimation(Estimation AdE);
    public List<Annonce> SearchBytitle(String description);
}