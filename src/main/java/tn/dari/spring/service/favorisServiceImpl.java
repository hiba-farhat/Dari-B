package tn.dari.spring.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tn.dari.spring.entity.Annonce;
import tn.dari.spring.entity.Notification;
import tn.dari.spring.entity.User;
import tn.dari.spring.entity.favoris;
import tn.dari.spring.repository.AnnonceRepository;
import tn.dari.spring.repository.UserRepository;
import tn.dari.spring.repository.favorisRepository;


@Service
public class favorisServiceImpl implements favorisService {
	
	@Autowired
	favorisRepository favorisRepository;
	@Autowired
	UserRepository UserRepository ;
	@Autowired
	favorisRepository favo;
	
	@Autowired
	AnnonceRepository AnnonceRepository;

	@Override
	public List<favoris> retrieveAllfavoris() {
		return (List<favoris>) favorisRepository.findAll();
		
	}

	@Override
	public favoris addfavoris(favoris f) {
	return favorisRepository.save(f);
	}
	
	
	@Override
	public void deletefavoris(Long id) {
		favorisRepository.deleteById(id);
	}

	@Override
	public favoris retrievefavoris(Long id) {
		favoris f=  favorisRepository.findById(id).get();
		return f;
	}


	@Transactional
	public favoris AddFavoris(favoris f, Long id,Long IdAnnonce) {
		User user = UserRepository.findById(id).orElse(null); 
		f.setUser(user);
		Annonce Annonce = AnnonceRepository.findById(IdAnnonce).orElse(null);
		f.setAnnonce(Annonce);
		return favorisRepository.save(f);
	}

	@Override
	public Optional<favoris> findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	///public void sendSms(String to, String from, String body) {

		//try {
			//Twilio.init("AC4a30225de4e58465a1bb6e3a9b0348d5", "36f1f7e143fd687d791e1db7d3fbeefc");
			//Message message = Message.creator(new PhoneNumber(to), new PhoneNumber(from), body).create();

		//} catch (Exception e) {

			//e.printStackTrace();

		//}

	//}
	
///	@Override
	//public boolean rechercherFavorite(favoris f) {
	//	favoris search = favo.findfavoritenotbyid(f.getUser(), f.getAnnonce()).orElse(null);
	//	if (search != null)
	//		return true;
	//	else
			//return false;
	//}

	@Override
	public List<favoris> getfavoriteswhoseassetgotupdated(Annonce a) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean rechercherFavorite(favoris f) {
		// TODO Auto-generated method stub
		return false;
	}

	
	//@Override
	////public List<favoris> getfavoriteswhoseassetgotupdated(Annonce a) {
		////List<favoris> liste = (List<favoris>) favo.findfavsbyproperty(P);
		//List<User> user = new ArrayList<User>();

	//	for (int i = 0; i < liste.size(); i++) {
		//	user.add(liste.get(i).getUser());
			
			//String s = "+216" + liste.get(i).getUser().getPhoneNumber();

			//sendSms(s, "+14044917812", "A favorite asset has been changed!");

		//}

		//return liste;
	}
	

	
	




