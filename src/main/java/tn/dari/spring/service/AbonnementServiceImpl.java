package tn.dari.spring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import tn.dari.spring.entity.Abonnement;
import tn.dari.spring.repository.AbonnementRepository;




@Service
public class AbonnementServiceImpl implements AbonnementService{
	@Autowired
	AbonnementRepository  abonnementRepository;
	
	@Override
	public List<Abonnement> retrieveAllAbonnement() {
		// TODO Auto-generated method stub
		
		return (List<Abonnement>)abonnementRepository.findAll();
	}

	@Override
	public Abonnement addAbonnement(Abonnement a) {
		
		return abonnementRepository.save(a);
	}

	@Override
	public void deleteAbonnement(Long id) {
		// TODO Auto-generated method stub
		 abonnementRepository.deleteById(id);
	}

	@Override
	public Abonnement updateAbonnement(Abonnement a) {
		// TODO Auto-generated method stub
		return abonnementRepository.save(a);
	}

	@Override
	public Abonnement retrieveAbonnement(Long id) {
		// TODO Auto-generated method stub
		Abonnement a =abonnementRepository.findById(id).get();
		return a;
	}

	@Override
	public int countAbonserver() {
		// TODO Auto-generated method stub
		return abonnementRepository.countAbonserver();
	}

	@Override
	public int countAbonGold() {
		// TODO Auto-generated method stub
		//return abonnementRepository.countAbonGold();
		 int sommServer =  countAbonserver() ;
		 return sommServer;
		
	}

	@Override
	public String ContAbonPremium() {
		// TODO Auto-generated method stub
		String test= "select count(*) from abonnement ab where ab.type = 'Premium' ";
		 /*(value = "select count(*) from abonnement ab where ab.type = 'Premium' ",nativeQuery = true)
		    public int ContAbonPremium();
		int a=abonnementRepository.ContAbonPremium();*/
		return test;
	}

	

	@Override
	public Optional<Abonnement> getById(long id) {
		// TODO Auto-generated method stub
		return abonnementRepository.findById(id);
		
		
	}

	@Override
	public boolean existsId(long id) {
		
		return abonnementRepository.existsById(id);
	}
	
}
