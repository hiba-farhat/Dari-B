package tn.dari.spring.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.dari.spring.entity.Annonce;
import tn.dari.spring.entity.User;
import tn.dari.spring.entity.favoris;

@Repository
public interface favorisRepository extends CrudRepository<favoris, Long> {
	Optional<favoris> findById(Long id);
	//@Query(value = "SELECT f FROM favoris f WHERE f.user=:user" + " AND f.Annonce=:annonce")
	//Optional<favoris> findfavoritenotbyid(@Param("user") User user, @Param("Annonce") Annonce Annonce);
	
}
