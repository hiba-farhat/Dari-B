package tn.dari.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tn.dari.spring.entity.Banque;
import tn.dari.spring.entity.Credit;
import tn.dari.spring.repository.BanqueRepository;
import tn.dari.spring.repository.CreditRepository;


@Service
public class CreditServiceImpl implements CreditService {
	

	@Autowired
	CreditRepository creditRepository;
	@Autowired
	BanqueRepository banqueRepository;
	@Autowired
	BanqueService banqueService;

	@Override
	public List<Credit> retrieveAllCredits() {
		return (List<Credit>) creditRepository.findAll();
	}

	@Override
	public Credit addCredit(Credit c) {
		Credit credit = creditRepository.save(c);
		return credit;
	}

	@Override
	public void deleteCredit(Long id) {
		creditRepository.deleteById(id);
		
	}

	@Override
	public Credit updateCredit(Credit c, Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * @Override public List<Credit> BestOffre() { return (List<Credit>)
	 * creditRepository.findAllByOrderByNmbDesc(); }
	 */

	@Override
	public Credit retrieveCreditById(Long id) {
		Credit credit = creditRepository.findById(id).get();
		return credit;
	}
	
	@Transactional
	public Credit simulation(Credit credit, Long idBanque) {
		Banque banque = banqueRepository.findById(idBanque).orElse(null);
		float interetBanque;
		float montant;
		float interet;
		Banque nombanque = credit.getBanque();
		//interetBanque= banqueService.getBankByName(nombanque).getInteret();
		//interetBanque= banqueService.getBankByName(nombanque).getInteret();
		interet = (float) banque.getInteretBanque();
		int periode;
		int nb_versement = 0;
		float cout_total = 0;
		float mensualite =0;
		montant = credit.getMontant();
		periode = credit.getDuree();
		cout_total = montant+((montant*interet)/100);
		mensualite = cout_total/periode;
		credit.setBanque(banque);
		credit.setPartmensuel(mensualite);
		credit.setDuree(periode);
		//credit.setInteret(interet);
		return creditRepository.save(credit);
		
	}
	
	//count credit by bank name
	/*
	 * public int Count(String name){ int Occ = 0; String bankname; bankname =
	 * banqueService.getBankByName(name).getNombanque(); Occ =
	 * creditRepository.countByNombanque(bankname); return Occ; }
	 */
	
	


}
