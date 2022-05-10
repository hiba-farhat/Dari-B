package tn.dari.spring.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.dari.spring.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long>{


}