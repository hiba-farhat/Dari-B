package tn.dari.spring.controller;

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

import io.swagger.annotations.Api;
import tn.dari.spring.service.AnnonceService;
import tn.dari.spring.service.IDelegationService;
import tn.dari.spring.service.IGovernorateService;
import tn.dari.spring.entity.Annonce;
import tn.dari.spring.entity.Delegation;
import tn.dari.spring.entity.Estimation;
import tn.dari.spring.entity.Governorate;
import tn.dari.spring.entity.SearchAnnonce;
import tn.dari.spring.entity.favoris;
@Api(tags="Gestion des Annonces")
@CrossOrigin("*")
@RestController
@RequestMapping("/Annonce")
public class AnnonceRestController {
	@Autowired
	AnnonceService AnnonceService;
	 @Autowired
		IGovernorateService Govservice;
	    
	    @Autowired
		IDelegationService Delservice;
	// URL : http://Localhost:8081/SpringMVC/Annonce/retrieve-All-Annonces
	@GetMapping("/retrieve-All-Annonces")
	public List<Annonce> retrieveAllAnnonces() {
		List<Annonce> List = AnnonceService.retrieveAllAnnonces();
		return List;
	}

	// URL : http://Localhost:8081/SpringMVC/Annonce/add-Annonce
	@PostMapping("/add-Annonce")
	@ResponseBody
	public ResponseEntity<String> addAnnonce(@RequestBody Annonce annonce) {
		if (VerifyAnnonce(annonce)=="succes")
		{
			return ResponseEntity.ok("Annonce Ajouté avec succés");
		}
		else {
			return ResponseEntity.status(202).body(VerifyAnnonce(annonce));
		}
	
	}

	private String VerifyAnnonce(Annonce annonce) {
		if (annonce.getDescription() == "") {
			return "le champ description est manquant";
		}
		if (annonce.getSurface() == 0 || annonce.getSurface() <0 ) {
			return "le champ surface ne doit pas etre zero ou negatif";
		}
		if (annonce.getLocalisation() == "") {
			return "le champlocation est manquant";
		}
		if (annonce.getPrice() == 0  || annonce.getPrice() <0  ) {
			return "le champ surface ne doit pas etre zero ou negatif";
		}
		if (annonce.getImage() == ""  ) {
			return "Il faut ajouter une image";
		}
		if (annonce.getRoomsNum() == 0  ) {
			return "le champ nombre de chzambre ne doit pas etre zero ou negatif";
		}
	
		return "succes";
	}

	// URL : http://Localhost:8081/SpringMVC/Annonce/modify-Annonce
	@PutMapping("/modify-Annonce")
	public ResponseEntity<String> updateAnnonce(@RequestBody Annonce annonce) {
		if (VerifyAnnonce(annonce)=="succes")
		{
			return ResponseEntity.ok("Annonce Ajouté avec succés");
		}
		else {
			return ResponseEntity.status(202).body(VerifyAnnonce(annonce));
		}
	}

	// URL : http://Localhost:8081/SpringMVC/Annonce/delete-Annonce/
	@DeleteMapping("/delete-Annonce/{id}")
	public ResponseEntity<String>  DeleteAnnonce(@PathVariable("id") Long id) {
		AnnonceService.deleteAnnonce(id);
		return ResponseEntity.ok("Annonce supprimé avec succés");
	}
	
	
    @GetMapping("/GetBestReductions")
	@ResponseBody
	public List<Annonce> GetBestReductions()
    {
       return AnnonceService.GetBestReductions();
    }
    
	//http://localhost:8081/SpringMVC/Annonce/findByCriteria
	  	@PostMapping("/findByCriteria")
	  	@ResponseBody
		 public List<Annonce> findByCriteria(@RequestBody SearchAnnonce r) {
	  	    return AnnonceService.findByCriteria(r);
	  	}
	  	
	  //http://localhost:8081/SpringMVC/Annonce/retrieveAnnonce/1
		@GetMapping("/retrieveAnnonce/{id}")
		
		public Annonce retrievesannonce(@PathVariable("id") Long id) {
			return AnnonceService.retrievesAnnonce(id);
		}
	 	@PostMapping("/findEstimation")
	 	
	 	public float findEstimation(@RequestBody Estimation AdE) {
	  		return AnnonceService.findEstimation(AdE);
	  	}
	 	 @GetMapping("/SearchBytitle/{description}")
		    public List<Annonce> SearchBytitle(@PathVariable("description")String description){
		  		return AnnonceService.SearchBytitle(description);
		  		
		  	}
	 	@GetMapping(value="/getDelegationsByGovernorate/{GovId}")
	  	@ResponseBody
	  	public List<Delegation> getDelegationsByGovernorate(@PathVariable("GovId") int GovId)
	  	{
	  		return Govservice.getDelegationsByGovernorate(GovId);
	  	}
	  	
	  	@GetMapping(value="/getMetrePricePerGovernorate/{GovId}")
	  	@ResponseBody
	  	public int getMetrePricePerGovernorate(@PathVariable("GovId") int GovId)
	  	{
	  		return (int) Govservice.getMetrePricePerGovernorate(GovId);
	  	}
	  	
	  	@GetMapping(value="/getMetrePricePerDelegation/{DelId}")
	  	@ResponseBody
	  	public int getMetrePricePerDelegation(@PathVariable("DelId") int DelId)
	  	{
	  		return Delservice.getMetrePricePerDelegation(DelId);
	  	}
	  	
	  	@GetMapping(value="/getAllGovernorates")
	  	@ResponseBody
	  	public List<Governorate> getAllGovernorates()
	  	{
	  		return Govservice.getAllGovernorates();
	  	}
	  	
	  	//http://localhost:8081/SpringMVC/servlet/setDelegationMetrePrice/1/1400
	  	@PostMapping(value="setDelegationMetrePrice/{DelId}/{PricePermetre}")
	  	@ResponseBody
	  	public void setDelegationMetrePrice(@PathVariable("DelId")int DelId,@PathVariable("PricePermetre")int PricePermetre)
	  	{
	  		Delservice.setDelegationMetrePrice(DelId,PricePermetre);

	  	}
	  	
	  //http://localhost:8081/SpringMVC/servlet/AddDelegation
	  	@PostMapping("/AddDelegation")
	  	@ResponseBody
	  	public Delegation AddDelegation(@RequestBody Delegation Del){
	  		Delegation D=Delservice.AddDelegation(Del);
	          
	  		return D;
	  	}
}