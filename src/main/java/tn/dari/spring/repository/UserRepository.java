package tn.dari.spring.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.dari.spring.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User,Long> {

	//User findByUsername(String username);
	User findByEmail(String email);

	User findByUsername(String username);
	Boolean existsByUsername(String username);
	Boolean existsByEmail(String email);
	

	User findByStateUser (boolean stateUser);
	
}