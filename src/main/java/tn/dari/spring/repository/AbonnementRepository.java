package tn.dari.spring.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.dari.spring.entity.Abonnement;




@Repository
public interface AbonnementRepository  extends CrudRepository<Abonnement,Long> {
	
	 @Query(value =" select count(*) from abonnement ab  where  ab.type = 'Server' ",nativeQuery = true)
	    public int countAbonserver ();

	    @Query(value = "select count(*) from abonnement ab where ab.type ='Gold' ",nativeQuery = true)
	    public int countAbonGold();

	    @Query(value = "select count(*) from abonnement ab where ab.type = 'Premium' ",nativeQuery = true)
	    public int ContAbonPremium();
}
