package tn.dari.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.springframework.boot.ApplicationArguments;


import tn.dari.spring.entity.Rendezvous;
import tn.dari.spring.entity.User;
import tn.dari.spring.repository.RendezvousRepository;
import tn.dari.spring.repository.UserRepository;

@Service
public class RendezvousServiceImpl implements RendezvousService{
	//SMS 
	private final static String ACCOUNT_SID = "AC623eab300e4fb83165a966ce6ad5e9f0";
	private final static String AUTH_ID = "d1b214e53f656ef5b76db373f0f929da";

	static {
		Twilio.init(ACCOUNT_SID, AUTH_ID);
	}  

	@Autowired
	RendezvousRepository rendezvousRepository;
	@Autowired
	UserRepository userRepository;
	@Override
	public List<Rendezvous> retrieveAllRdv() {
		// TODO Auto-generated method stub
		return (List<Rendezvous>) rendezvousRepository.findAll();
	}

	@Override
	public Rendezvous addRdv(Rendezvous rdv, Long idUser) {

		// TODO Auto-generated method stub
		User user =userRepository.findById(idUser).orElse(null);

		rdv.setUser(user);
		return rendezvousRepository.save(rdv);}
	
	//SMS
		  public void run(ApplicationArguments arg0) throws Exception {
		      Message.creator(new PhoneNumber("+12620456568"), new PhoneNumber("+18507714598"),
		         "Votre RendezVous est accepté ").create();
		   }
	@Override
	public void deleteRdv(Long idRdv) {
		rendezvousRepository.deleteById(idRdv);

	}

	@Override
	public Rendezvous updateRdv(Rendezvous r) {
		// TODO Auto-generated method stub
		return rendezvousRepository.save(r);
	}

	@Override
	public Rendezvous retrieveRdv(Long idRdv) {
		Rendezvous r = rendezvousRepository.findById(idRdv).get();
		return r;		
	}

}
