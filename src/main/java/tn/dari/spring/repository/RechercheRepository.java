package tn.dari.spring.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.dari.spring.entity.SearchAnnonce;
import tn.dari.spring.entity.favoris;

@Repository
public interface RechercheRepository extends CrudRepository<SearchAnnonce, Long> {
	//Optional<favoris> findById(Long id);

}
