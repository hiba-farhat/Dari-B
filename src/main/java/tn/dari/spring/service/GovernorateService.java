package tn.dari.spring.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.dari.spring.entity.Delegation;
import tn.dari.spring.entity.Governorate;
import tn.dari.spring.repository.DelegationRepository;
import tn.dari.spring.repository.GovernorateRepository;

import java.util.List;


@Service
public class GovernorateService implements IGovernorateService{

	@Autowired
	GovernorateRepository GovRep;
	
	@Autowired
	DelegationRepository DelRep;
	
	
	public List<Delegation> getDelegationsByGovernorate(int GovId)
	{ 
		return GovRep.getDelegationsByGovernorate(GovId);
	}
  
	
    public float getMetrePricePerGovernorate(int GovId){
    	return GovRep.getMetrePricePerGovernorate(GovId);
    }
	
  	public List<Governorate> getAllGovernorates(){return (List<Governorate>) GovRep.findAll();}

	
}