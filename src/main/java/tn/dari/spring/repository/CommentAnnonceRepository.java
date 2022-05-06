package tn.dari.spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.dari.spring.entity.CommentAnnonce;



@Repository
public interface CommentAnnonceRepository extends CrudRepository<CommentAnnonce, Long>, CommentAnnonceRepositoryCustom {
	
}
