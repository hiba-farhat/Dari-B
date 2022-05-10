package tn.dari.spring.service;

import java.util.List;

import tn.dari.spring.entity.Delegation;
import tn.dari.spring.entity.Governorate;

public interface IGovernorateService {

	public List<Delegation> getDelegationsByGovernorate(int GovId);
    public float getMetrePricePerGovernorate(int GovId);
  	public List<Governorate> getAllGovernorates();
}