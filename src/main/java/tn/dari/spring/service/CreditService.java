package tn.dari.spring.service;

import java.util.List;

import org.springframework.stereotype.Repository;

import tn.dari.spring.entity.Credit;


@Repository
public interface CreditService {
	
List<Credit> retrieveAllCredits();
	
	Credit addCredit(Credit c);
	
	void deleteCredit(Long id);
	
	public Credit updateCredit(Credit c, Long id);
	
	//public List<Credit> BestOffre();
	
	Credit retrieveCreditById(Long id);
	
	public Credit simulation(Credit credit, Long idBanque);
	
	//public int Count(String name);

}
