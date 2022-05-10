package tn.dari.spring.service;

import java.util.List;

import tn.dari.spring.entity.Reclamation;

public interface ReclamationService {

	List<Reclamation> retrieveAllReclamations();

	Reclamation addReclamation(Reclamation r, String emailuser);

	Reclamation UpdateReclamation(Reclamation r, Long id);

	Long countReclamation();

	Reclamation retrieveReclamationById(Long id);

	Reclamation deleteReclamation(Long id);

}
