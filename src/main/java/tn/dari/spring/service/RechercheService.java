package tn.dari.spring.service;

import java.util.List;
import java.util.Optional;

import tn.dari.spring.entity.SearchAnnonce;
import tn.dari.spring.entity.favoris;

public interface RechercheService {
	
	List<SearchAnnonce> retrieveAllRecherches();
	SearchAnnonce addRecherche(SearchAnnonce r);
	SearchAnnonce UpdateRecherche(SearchAnnonce r);
	void deleteRecherche(Long id);
	SearchAnnonce retrieveRecherche(Long id);
	SearchAnnonce AddRecherche(SearchAnnonce r, Long id, Long IdAnnonce);
	public void sendTextEmail(SearchAnnonce r);
 SearchAnnonce UpdateRecherche(SearchAnnonce r, Long id);
}
