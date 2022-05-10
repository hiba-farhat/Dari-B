package tn.dari.spring.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.dari.spring.entity.Delegation;
import tn.dari.spring.entity.Governorate;

@Repository
	public interface DelegationRepository extends CrudRepository<Delegation,Integer>{

		@Query("select avg(D.Pricepermetre) from Delegation D where D.id=:DelId")
	    public int getMetrePricePerDelegation(@Param("DelId") int DelId);
	    
		
		@Query("select D.governorate from Delegation D where D.id=:DelId")
		public Governorate getGovernorateByDelegationId(@Param("DelId") int DelId);
		
}
