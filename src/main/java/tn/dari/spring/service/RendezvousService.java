package tn.dari.spring.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import tn.dari.spring.entity.Rendezvous;

public interface RendezvousService {
	
	List<Rendezvous> retrieveAllRdv();

	Rendezvous addRdv(Rendezvous r, Long idUser);

	void deleteRdv(Long id);
	
	Rendezvous accept(Rendezvous a);
	
	Rendezvous updateRdv(Rendezvous r);
	
	Rendezvous retrieveRdv(Long id);


}
 