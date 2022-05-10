package tn.dari.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.dari.spring.entity.Annonce;
import tn.dari.spring.repository.AnnonceRepository;


@Service
public class AnnonceServiceImpl implements AnnonceService {
	@Autowired
	AnnonceRepository AnnonceRepository;


	@Override
	public Annonce addAnnonce(Annonce annonce) {
		return AnnonceRepository.save(annonce);
	}

	@Override
	public Annonce  UpdateAnnonce(Annonce annonce) {
		return AnnonceRepository.save(annonce);
		
	}

	@Override
	public List<Annonce> retrieveAllAnnonces() {
		return (List<Annonce>) AnnonceRepository.findAll();
	}

	@Override
	public void deleteAnnonce(Long id) {
		AnnonceRepository.deleteById(id);
		
	}

	@Override
	public Annonce retrieveAnnonceById(Long id) {
		Annonce a = AnnonceRepository.findById(id).get();
		return a;
	}

	
	}

	

	
		
	


