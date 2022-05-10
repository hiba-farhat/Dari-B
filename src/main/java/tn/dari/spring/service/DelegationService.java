package tn.dari.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.dari.spring.entity.Delegation;
import tn.dari.spring.entity.Governorate;
import tn.dari.spring.repository.DelegationRepository;
import tn.dari.spring.repository.GovernorateRepository;

@Service
public class DelegationService implements IDelegationService{

	@Autowired
	DelegationRepository DR;
	
	@Autowired
	GovernorateRepository GR;
	public int getMetrePricePerDelegation(int DelId){
		return DR.getMetrePricePerDelegation(DelId);
	}
	

	@Override
	public void setDelegationMetrePrice(int delId,int PricePermetre)
    {
		Governorate Gov=DR.getGovernorateByDelegationId(delId);
		String DelName=DR.findById(delId).get().getDelegationName();
	 	//DR.setDelegationMetrePrice(DelName,PricePermetre,Gov);
		Delegation D=new Delegation();
		D.setPricepermetre(PricePermetre);
		D.setDelegationName(DelName);
		D.setGovernorate(Gov);
		AddDelegation(D);
		System.out.print(Gov.getGovernorateName());
		System.out.println(DelName);
		
    }
	
	
	@Override
	public Delegation AddDelegation(Delegation Del){
         DR.save(Del);		
	     return Del;
	}
	
	

}