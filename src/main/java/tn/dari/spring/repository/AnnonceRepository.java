package tn.dari.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.dari.spring.entity.Annonce;


@Repository 
public interface AnnonceRepository   extends CrudRepository<Annonce,Long> {
	@Query("SELECT AVG(A.taux_reduction) FROM Annonce A")
	public float GetAVGReduction();
	
	@Query("select A from Annonce A where A.taux_reduction > :C")
    public List<Annonce> GetBestReduction(@Param("C") int C);
	@Query("SELECT A FROM Annonce A WHERE A.name LIKE %?1%")
	List<Annonce> findByTextContainingIgnoreCase(String Text);
}