package tn.dari.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import tn.dari.spring.entity.SearchAnnonce;
import tn.dari.spring.repository.RechercheRepository;
import org.springframework.mail.javamail.JavaMailSender;

@Service
public class RechercheServiceImpl implements RechercheService {
	@Autowired
	RechercheRepository RechercheRepository;

	@Autowired
	private JavaMailSender javaMailSender;
	
	@Override
	public SearchAnnonce addRecherche(SearchAnnonce r) {
		return RechercheRepository.save(r);
	}

	@Override
	public SearchAnnonce  UpdateRecherche(SearchAnnonce r) {
		return RechercheRepository.save(r);
		
	}
	//@Override
	//public  SearchAnnonce UpdateRecherche(SearchAnnonce r, Long id) {
		////SearchAnnonce rech = RechercheRepository.findById(id).get();
		//rech.setKeyword(rech.getKeyword());
		//rech.setLocation(rech.getLocation());
		//rech.setStatus(rech.getStatus());
		//rech.setPropertyType(rech.getPropertyType());
		//rech.setStatus(rech.getStatus());
		//rech.setBedRoom(rech.getBedRoom());
		//rech.setBathroom(rech.getBathroom());
		//rech.setStatus(rech.getStatus());
		//rech.setMinArea(rech.getMinArea());
		//rech.setMinPrice(rech.getMinPrice());
		//RechercheRepository.save(rech);
		//return rech;
		
	//}

	@Override
	public List<SearchAnnonce> retrieveAllRecherches() {
		return (List<SearchAnnonce>) RechercheRepository.findAll();
	}

	@Override
	public void deleteRecherche(@PathVariable(name="id") Long id) {
		RechercheRepository.deleteById(id);
		
	}

	
	@Override
	public SearchAnnonce retrieveRecherche(Long id) {
		SearchAnnonce r = RechercheRepository.findById(id).get();
		return r;
	}

	@Override
	public SearchAnnonce AddRecherche(SearchAnnonce r, Long id, Long IdAnnonce) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void sendTextEmail(SearchAnnonce emailTemplate) {
		SimpleMailMessage msg = new SimpleMailMessage();
		try {
			if (emailTemplate.getUser().getEmail().contains(",")) {
				String[] emails = emailTemplate.getUser().getEmail().split(",");
				int receipantSize = emails.length;
				for (int i = 0; i < receipantSize; i++) {
					msg.setTo(emails[i]);
					msg.setSubject("Alerte immo • Nouveaux biens dispos : "+emailTemplate.getAnnonce().name);
					msg.setText("Cher client,"+(emailTemplate.getUser().getNom()+emailTemplate.getUser().getPrenom()+" Bonjour, nous avons des nouvelles annonces pour vous. A Ne pas ratez  "
							+ " !\r\n"
							+ " ")+emailTemplate.getAnnonce().getOfferType());
					javaMailSender.send(msg);
				}
			}
		}

		catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public SearchAnnonce UpdateRecherche(SearchAnnonce r, Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}

	
		
	

