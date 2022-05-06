package tn.dari.spring.service;

import java.util.List;

import tn.dari.spring.entity.CommentAnnonce;


public interface CommentAnnonceService {
	List<CommentAnnonce> getCommentsByAnnonceId(Long annonceId);
	CommentAnnonce addCommentAnnonce(CommentAnnonce c);
	CommentAnnonce updateCommentAnnonce(CommentAnnonce c);
	void deleteCommentAnnonce(Long id);

	
}
