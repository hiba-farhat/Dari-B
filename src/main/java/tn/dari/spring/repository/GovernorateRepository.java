package tn.dari.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.dari.spring.entity.Delegation;
import tn.dari.spring.entity.Governorate;

@Repository
public interface GovernorateRepository extends CrudRepository<Governorate,Integer>{

	
	
	@Query("select D from Delegation D where D.governorate.id=:GovId")
	public List<Delegation> getDelegationsByGovernorate(@Param("GovId") int GovId);

	
	@Query("select avg(D.Pricepermetre) from Delegation D where D.governorate.id=:GovId")
    public float getMetrePricePerGovernorate(@Param("GovId") int GovId);

	
}

