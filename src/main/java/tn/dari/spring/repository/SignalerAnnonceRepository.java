package tn.dari.spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.dari.spring.entity.SignalerAnnonce;


@Repository
public interface SignalerAnnonceRepository extends CrudRepository<SignalerAnnonce,Long> ,SignalerAnnonceRepositoryCustom  {

}
