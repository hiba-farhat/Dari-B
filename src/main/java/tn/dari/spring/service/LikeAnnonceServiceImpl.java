package tn.dari.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.dari.spring.entity.*;
import tn.dari.spring.repository.*;
@Service

public class LikeAnnonceServiceImpl implements LikeAnnonceService {
	@Autowired
	LikeAnnonceRepository LikeAnnonceRepository;

	@Override
	public List<likeAnnonce> retrieveAllLikeAnnonce() {
		return (List<likeAnnonce>)LikeAnnonceRepository.findAll();
	}

	@Override
	public likeAnnonce addLikeAnnonce(likeAnnonce l) {
		return LikeAnnonceRepository.save(l);
	}

	@Override
	public void deleteLikeAnnonce(Long id) {
		LikeAnnonceRepository.deleteById(id);
		
	}


	

}
