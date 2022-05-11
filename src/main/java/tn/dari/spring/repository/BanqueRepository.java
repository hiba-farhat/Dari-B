package tn.dari.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.dari.spring.entity.Credit;
import tn.dari.spring.entity.Banque;

@Repository
public interface BanqueRepository  extends CrudRepository<Banque, Long>  {
	
	@Query("SELECT nombanque FROM Banque")
    public List<String> getAllBankByNames();
	
	@Query
	Banque findByNombanque(String nombanque);
	
	@Query
	Credit findByNombanque(Banque nombanque);
	
	

}
