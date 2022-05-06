package tn.dari.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.dari.spring.entity.*;
import tn.dari.spring.repository.*;

@Service
public class CommentAnnonceServiceImpl  implements  CommentAnnonceService {
	@Autowired
 CommentAnnonceRepository CommentAnnonceRepository;
	@Override
	public List<CommentAnnonce> getCommentsByAnnonceId(Long annonceId) {

		return (List<CommentAnnonce>)CommentAnnonceRepository.getCommentsByAnnonceId(annonceId) ;
	}

	@Override
	public CommentAnnonce addCommentAnnonce(CommentAnnonce c) {
		return CommentAnnonceRepository.save(c);
	}
	
	@Override
	public CommentAnnonce updateCommentAnnonce(CommentAnnonce c) {
		return CommentAnnonceRepository.save(c);
	}
	

	@Override
	public void deleteCommentAnnonce(Long id) {
		CommentAnnonceRepository.deleteById(id);
		
	}

}
