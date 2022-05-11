package tn.dari.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.dari.spring.entity.Reclamation;
import tn.dari.spring.repository.ReclamationRepository;

@Service
public class ReclamationServiceImpl implements ReclamationService {
	
	@Autowired
	private ReclamationRepository reclamationRepository;

	@Override
	public List<Reclamation> retrieveAllReclamations() {
		List<Reclamation> reclamations = (List<Reclamation>) reclamationRepository.findAll();
		return reclamations;
	}

	@Override
	public Reclamation addReclamation(Reclamation r) {
		Reclamation reclamation = reclamationRepository.save(r);
		return reclamation;
	}

	@Override
	public Reclamation UpdateReclamation(Reclamation r, Long id) {
		Reclamation reclamation= reclamationRepository.findById(id).get();
		reclamation.setDescriptionReclamation(r.getDescriptionReclamation());
		reclamation.setTitreReclamation(r.getTitreReclamation());
		reclamationRepository.save(r);
		return r;
		
	}

	@Override
	public Long countReclamation() {
		return reclamationRepository.count();

	}

	@Override
	public Reclamation retrieveReclamationById(Long id) {
		Reclamation reclamation = reclamationRepository.findById(id).get();
		return reclamation;

	}

	@Override
	public void deleteReclamation(Long id) {
		reclamationRepository.deleteById(id);
	}
	
	

}
