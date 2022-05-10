package tn.dari.spring.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.dari.spring.entity.Credit;
@Repository
public interface CreditRepository extends CrudRepository<Credit, Long> {
	
	//List<Credit> findAllByOrderByNmbDesc();
	/*
	 * @Query int countByNombanque(String bankname);
	 */
}
