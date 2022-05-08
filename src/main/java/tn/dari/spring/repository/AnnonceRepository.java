package tn.dari.spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.dari.spring.entity.Annonce;


@Repository
public interface AnnonceRepository extends CrudRepository<Annonce, Long> {

}
