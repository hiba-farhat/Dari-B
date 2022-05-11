package tn.dari.spring.repository;


import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Repository;

import tn.dari.spring.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User,Long> {

	//User findByUsername(String username);
	User findByEmail(String email);

	User findByUsername(String username);
	Boolean existsByUsername(String username);
	Boolean existsByEmail(String email);
	List<User> findByAddress(String address);
	User findByStateUser (boolean stateUser);
	
	@Query("SELECT MIN(e.birth) FROM User e ")
	Date getminage(); 
	@Query("SELECT MAX(e.birth) FROM User e ")
	Date getmaxage(); 
 
	
	@Query("SELECT COUNT(e.stateUser) FROM User e WHERE stateUser=false")
	int getNbDisabled(); 
     
     
}