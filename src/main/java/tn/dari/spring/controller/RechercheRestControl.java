package tn.dari.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
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

import io.swagger.annotations.Api;
import tn.dari.spring.service.RechercheService;

import tn.dari.spring.entity.SearchAnnonce;
import tn.dari.spring.entity.favoris;

@Api(tags="Gestion des Recherches")
@RestController
@CrossOrigin("*")
@RequestMapping("/Recherche")
public class RechercheRestControl {
	@Autowired
	RechercheService RechercheService;

	// URL : http://Localhost:8081/SpringMVC/Recherche/retrieve-All-Recherches
	@GetMapping("/retrieve-All-Recherches")
	public List<SearchAnnonce> retrieveAllRecherches() {
		List<SearchAnnonce> List = RechercheService.retrieveAllRecherches();
		return List;
	}

	//URL : http://localhost:8081/SpringMVC/Recherche/add-Recherche
		@ResponseBody
		@PostMapping("/add-Recherche")
		public SearchAnnonce addRecherche(@RequestBody SearchAnnonce r) {
			return RechercheService.addRecherche(r);
		}
	private String VerifySearchAnnonce(SearchAnnonce SearchAnnonce) {
		return "succes";
	}

	// URL : http://Localhost:8081/SpringMVC/Recherche/modify-Recherche
	@PutMapping("/modify-Recherche")
	public SearchAnnonce editRecherche(@RequestBody SearchAnnonce r) {
		return RechercheService.UpdateRecherche(r);
	}
	
	// URL : http://Localhost:8081/SpringMVC/Recherche/modify-Recherche/{id}
	
	//@PutMapping("/modify-Recherche/{id}")      
  //  private SearchAnnonce updateRecherche(@RequestBody SearchAnnonce r, @PathVariable("id")Long id )
   // {        
		//RechercheService.UpdateRecherche(r, id); 
    	//return r;
   // }
	// URL : http://Localhost:8081/SpringMVC/Recherche/delete-Recherche
	@DeleteMapping("/delete-Recherche/{id}")
	public ResponseEntity<String>  DeleteRecherche(@PathVariable("id") Long id) {
		RechercheService.deleteRecherche(id);
		return ResponseEntity.ok("Recherche supprimé avec succés");
	}
	// URL : http://Localhost:8081/SpringMVC/Recherche/textemail
	@Scheduled(cron ="")
	@PostMapping(value="/textemail",consumes = "application/json", produces = "application/json")
	public String sendEmail(@RequestBody SearchAnnonce emailTemplate) {
		try {
			//log.info("Sending Simple Text Email....");
			RechercheService.sendTextEmail(emailTemplate);
			return "Email Sent!";
		} catch (Exception ex) {
			return "Error in sending email: " + ex;
		}
	}
	
	
}