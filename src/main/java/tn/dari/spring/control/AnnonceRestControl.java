package tn.dari.spring.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import com.fasterxml.jackson.annotation.JsonIgnore;

import tn.dari.spring.entity.Annonce;
import tn.dari.spring.entity.BackendReponse;
import tn.dari.spring.service.AnnonceService;

@RestController
@RequestMapping("/Annonces")
@CrossOrigin(origins = "http://localhost:4200")
public class AnnonceRestControl {
	@Autowired
	AnnonceService annonceService;
	final static String success = "success";
	@GetMapping("/")
	public List<Annonce> retrieveAllAnnonces() {
		List<Annonce> List = annonceService.retrieveAllAnnonces();
		return List;
	}

	@PostMapping("/add")
	@ResponseBody
	public BackendReponse addAnnonce(@RequestBody Annonce annonce) {
		if (VerifyAnnonce(annonce) == success) {
			annonceService.addAnnonce(annonce);
			return new BackendReponse(200, "Annonce Ajouté avec succés");
		} else {
			return new BackendReponse(201, VerifyAnnonce(annonce));
		}
	}

	private String VerifyAnnonce(Annonce annonce) {
		if (annonce.getDescription() == "") {
			return "le champ description est manquant";
		}
		if (annonce.getSurface() == 0 || annonce.getSurface() < 0) {
			return "le champ surface ne doit pas etre zero ou negatif";
		}
		if (annonce.getLocalisation() == "") {
			return "le champ location est manquant";
		}
		if (annonce.getPrice() == 0 || annonce.getPrice() < 0) {
			return "le champ prix ne doit pas etre zero ou negatif";
		}
		if (annonce.getImage() == "") {
			return "Il faut ajouter une image";
		}
		if (annonce.getRoomsNum() == 0) {
			return "le champ nombre de chzambre ne doit pas etre zero ou negatif";
		}

		return success;
	}

	@PutMapping("/update")
	public BackendReponse updateAnnonce(@RequestBody Annonce annonce) {
		if (VerifyAnnonce(annonce) == success) {
			annonceService.UpdateAnnonce(annonce);
			return new BackendReponse(200, "Annonce modifié avec succés");
		} else {
			return new BackendReponse(201, VerifyAnnonce(annonce));
		}

	}

	@DeleteMapping("/delete/{id}")
	public BackendReponse DeleteAnnonce(@PathVariable("id") Long id) {
		annonceService.deleteAnnonce(id);
		return new BackendReponse(200, "Annonce supprimé avec succés");
	}

	@GetMapping("/annonce/{id}")
	private Annonce retrieveAnnonceById(@PathVariable Long id) {
		return annonceService.retrieveAnnonceById(id);
	}
}
