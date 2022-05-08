package tn.dari.spring.service;

import java.util.List;


import tn.dari.spring.entity.*;

public interface AssuranceService {
	List<Assurance> retrieveAllAssurance ();

	Assurance addAssurance (Assurance a) ;

	void deleteAssurance (Long id);

	Assurance updateAssurance (Assurance  a);

	Assurance  retrieveAssurance (Long id);
	
	void affecteAssurAbonn ( Long idAssu  ,  Long idAbon);
	
	void desaffecterAssurenceDuAbon( Long idAssu );
}
