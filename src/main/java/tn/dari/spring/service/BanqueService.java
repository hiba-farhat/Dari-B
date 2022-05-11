package tn.dari.spring.service;

import java.util.List;

import org.springframework.stereotype.Repository;

import tn.dari.spring.entity.Credit;
import tn.dari.spring.entity.Banque;

@Repository
public interface BanqueService {
	
	List<Banque> retrieveAllBanques();
	Banque addBanque(Banque b);
	void deleteBanque(Long id);
	Banque updateBanque(Banque b);
	Banque retrieveBanqueById(Long id);
	List<String> getAllBankByNames();
	public Banque getBankByName(String nombanque);
	Credit getBankByName(Banque nombanque);

}
