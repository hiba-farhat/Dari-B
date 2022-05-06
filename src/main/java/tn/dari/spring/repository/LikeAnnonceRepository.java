package tn.dari.spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.dari.spring.entity.likeAnnonce;


@Repository
public interface  LikeAnnonceRepository extends CrudRepository<likeAnnonce,Long> {

}
