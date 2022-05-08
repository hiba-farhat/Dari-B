package tn.dari.spring.service;

import java.util.List;
import java.util.Optional;

import tn.dari.spring.entity.*;





public interface AbonnementService {
	
	List<Abonnement> retrieveAllAbonnement ();

	Abonnement  addAbonnement (Abonnement a) ;

	void deleteAbonnement (Long id);

	Abonnement  updateAbonnement (Abonnement  a);

	Abonnement  retrieveAbonnement (Long id);
	  int countAbonserver();
     int countAbonGold();
	 String ContAbonPremium();
 Optional<Abonnement> getById(long id);
boolean existsId(long id);
}
