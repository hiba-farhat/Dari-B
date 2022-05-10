package tn.dari.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.dari.spring.entity.Credit;
import tn.dari.spring.entity.Banque;
import tn.dari.spring.repository.BanqueRepository;

@Service
public class BanqueServiceImpl implements BanqueService  {
	

	@Autowired
	private BanqueRepository banqueRepository;
	
	@Override
	public List<Banque> retrieveAllBanques() {
		List<Banque> banques = (List<Banque>) banqueRepository.findAll();
		return banques;
	}

	@Override
	public Banque addBanque(Banque b) {
		Banque banque = banqueRepository.save(b);
		return banque;
	}

	@Override
	public void deleteBanque(Long id) {
		banqueRepository.deleteById(id);
		
	}

	@Override
	public Banque updateBanque(Banque b) {
		return banqueRepository.save(b);
		
	}

	@Override
	public Banque retrieveBanqueById(Long id) {
		Banque banque = banqueRepository.findById(id).get();
		return banque;
	}
	
	@Override
	public List<String> getAllBankByNames() {
		
		return banqueRepository.getAllBankByNames();
	}
	
	@Override
	public Banque getBankByName(String nombanque) {
		return banqueRepository.findByNombanque(nombanque);
	}

	@Override
	public Credit getBankByName(Banque nombanque) {
		return banqueRepository.findByNombanque(nombanque);
	}


}
