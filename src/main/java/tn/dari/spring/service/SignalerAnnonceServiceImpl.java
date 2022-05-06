package tn.dari.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.dari.spring.entity.SignalerAnnonce;
import tn.dari.spring.repository.*;
@Service
public class SignalerAnnonceServiceImpl implements SignalerAnnonceService {
	@Autowired
	SignalerAnnonceRepository SignalerAnnonceRepository;
	
	

	@Override
	public List<SignalerAnnonce> retrieveAllSignalerAnnonce() {
		return (List<SignalerAnnonce>) SignalerAnnonceRepository.findAll();
	}

	@Override
	public SignalerAnnonce addSignalerAnnonce(SignalerAnnonce s) {
		return SignalerAnnonceRepository.save(s);
	}

	@Override
	public void deleteSignalerAnnonce(Long id) {
		SignalerAnnonceRepository.deleteById(id);
		
	}

	@Override
	public List<SignalerAnnonce> getSignauxByAnnonceId(Long annonceId) {
		return (List<SignalerAnnonce>)SignalerAnnonceRepository.getSignauxByAnnonceId(annonceId) ;

	}
	
	@Override
	public List<Object> getSignauxForAdmin(){
		return SignalerAnnonceRepository.getSignauxForAdmin() ;
	}

}
