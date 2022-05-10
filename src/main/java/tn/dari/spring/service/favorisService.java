package tn.dari.spring.service;

import java.util.List;
import java.util.Optional;

import tn.dari.spring.entity.Annonce;
import tn.dari.spring.entity.favoris;

public interface favorisService {
	
	List<favoris> retrieveAllfavoris();

	favoris addfavoris(favoris f);

	void deletefavoris(Long id);
		
	favoris retrievefavoris(Long id);
    Optional<favoris> findById(Long id);

	 favoris AddFavoris(favoris f, Long id, Long IdAnnonce);
	 public boolean rechercherFavorite(favoris f);
	
    public List<favoris> getfavoriteswhoseassetgotupdated(Annonce a );

}
