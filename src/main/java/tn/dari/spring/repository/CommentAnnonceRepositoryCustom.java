package tn.dari.spring.repository;

import java.util.List;

import tn.dari.spring.entity.CommentAnnonce;



public interface CommentAnnonceRepositoryCustom {

	public List<CommentAnnonce> getCommentsByAnnonceId(Long annonceId);

}
