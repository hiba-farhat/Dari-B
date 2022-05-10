package tn.dari.spring.service;

import tn.dari.spring.entity.Delegation;

public interface IDelegationService {

    public int getMetrePricePerDelegation(int DelId);

	public Delegation AddDelegation(Delegation Del);
    
    public void setDelegationMetrePrice(int DelId,int PricePermetre);
}
