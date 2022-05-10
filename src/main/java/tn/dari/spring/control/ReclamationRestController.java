package tn.dari.spring.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
import tn.dari.spring.entity.Reclamation;
import tn.dari.spring.service.ReclamationService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;


@RestController
@RequestMapping("/reclamation")
@Api(tags="Gestion des reclamations")
@CrossOrigin(origins = "http://localhost:4200")
public class ReclamationRestController {
	
	@Autowired
	ReclamationService reclamationService;
	
			//http://localhost:8081/DariTn/retrieve-all-reclamations
			@GetMapping("/retrieve-all-reclamations")	
			@ResponseBody
			public List<Reclamation> retrieveAllReclamations(){
				List<Reclamation> list = reclamationService.retrieveAllReclamations();
				return list;
			}
			
			//http://localhost:8081/DariTn/add-reclamation
			@PostMapping("/add-reclamation")
			@ResponseBody
			public Reclamation addReclamation(@RequestBody Reclamation r, @PathVariable String emailUser)  {
				
				return reclamationService.addReclamation(r, emailUser);
			}
			
			
			//http://localhost:8081/DariTn/update-reclamation/{id}
			
			@PutMapping("/reclamation/update/{id}")      
		    private Reclamation updateReclamation(@RequestBody Reclamation r, @PathVariable("id")Long id )
		    {        
		    	reclamationService.UpdateReclamation(r, id); 
		    //return reclamationService.UpdateReclamation(r, id);    
		    	return r;
		    }
			
			
			//http://localhost:8081/SpringMVC/DariTn/delete-reclamation/{id}
			@DeleteMapping("/delete-reclamation/{id}")
			@ResponseBody
			public void deleteReclamation(@PathVariable("id") Long id) {
				reclamationService.retrieveReclamationById(id);
			}
			
			//http://localhost:8081/DariTn/numberOfClaims
			@GetMapping("/numberOfClaims")
		    @ResponseBody
		    public Long countReclamation() {
		    	Long countReclamation= reclamationService.countReclamation() ;
		    	return countReclamation;
		    }
			
			//http://localhost:8081/DariTn/retrieveReclamation/{id}
			@GetMapping("/retrieveReclamation/{id}")
			@ResponseBody
			public Reclamation retrieveReclamation(@PathVariable("id") Long id) {
				return reclamationService.retrieveReclamationById(id);
			}


}
