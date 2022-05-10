package tn.dari.spring.service;

import java.net.PasswordAuthentication;
import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tn.dari.spring.entity.Reclamation;
import tn.dari.spring.repository.ReclamationRepository;

@Slf4j
@Service
public class ReclamationServiceImpl implements ReclamationService {
	
	@Autowired
	private ReclamationRepository reclamationRepository;

	@Override
	public List<Reclamation> retrieveAllReclamations() {
		List<Reclamation> reclamations = (List<Reclamation>) reclamationRepository.findAll();
		return reclamations;
	}

	@Override
	public Reclamation addReclamation(Reclamation r, String emailuser ) {
		Reclamation reclamation = reclamationRepository.save(r);
		final String username = "daritn248@gmail.com";
		final String password = "nlpi glei goil dmfy";
		
		emailuser = "cyrine.belguith@esprit.tn";

		Properties prop = new Properties();
		prop.put("mail.smtp.host", "smtp.gmail.com");
		prop.put("mail.smtp.port", "587");
		prop.put("mail.smtp.auth", "true");
		prop.put("mail.smtp.starttls.enable", "true"); // TLS
		prop.put("mail.smtp.ssl.trust", "smtp.gmail.com");
		Session session = Session.getInstance(prop, new javax.mail.Authenticator() {
			protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
				return new javax.mail.PasswordAuthentication(username, password);
			}
		});
		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("daritn248@gmail.com"));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(emailuser));
			message.setSubject("Reset Your Password");
			message.setText("This a non reply message from DariTn\n your claim is submitted");
			Transport.send(message);
			log.info("Done");
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		return reclamation;
	}

	@Override
	public Reclamation UpdateReclamation(Reclamation r, Long id) {
		Reclamation reclamation= reclamationRepository.findById(id).get();
		reclamation.setDescriptionReclamation(r.getDescriptionReclamation());
		reclamation.setTitreReclamation(r.getTitreReclamation());
		reclamationRepository.save(r);
		return r;
		
	}

	@Override
	public Long countReclamation() {
		return reclamationRepository.count();

	}

	@Override
	public Reclamation retrieveReclamationById(Long id) {
		Reclamation reclamation = reclamationRepository.findById(id).get();
		return reclamation;

	}

	@Override
	public Reclamation deleteReclamation(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
