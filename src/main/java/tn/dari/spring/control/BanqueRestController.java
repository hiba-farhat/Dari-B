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
import tn.dari.spring.entity.Banque;
import tn.dari.spring.service.BanqueService;



@RestController
@RequestMapping("/banques")
@CrossOrigin(origins = "http://localhost:4200")
@Api(tags="gestion des banques")
public class BanqueRestController {
	

	@Autowired
	BanqueService banqueService;
	
		//http://localhost:8081/DariTn/banque/retrieve-all-banques
		@GetMapping("/retrieve-all-banques")	
		@ResponseBody
		public List<Banque> retrieveAllBanques(){
			List<Banque> list = banqueService.retrieveAllBanques();
			return list;
		
		}
		
		//http://localhost:8081/DariTn/banque/add-bank
		@PostMapping("/add-bank")
		@ResponseBody
		public Banque addBanque(@RequestBody Banque b) {
			return banqueService.addBanque(b);
		}
		
		//http://localhost:8081/DariTn/banque/update-bank
		 @PutMapping("/updateBanque")      
		    private Banque updateBank(@RequestBody Banque banque )
		    {        
		    	banqueService.updateBanque(banque); 
		    //return banqueService.updateBanque(banque, id);  
		    	return banqueService.updateBanque(banque);
		    }
		
		//http://localhost:8081/DariTn/banque/delete-bank/{id}
		@DeleteMapping("/delete-bank/{id}")
		@ResponseBody
		public void deletebanque(@PathVariable("id") Long id) {
			banqueService.deleteBanque(id);
		}
		
		//http://localhost:8081/DariTn/banque/retrieveBank/{id}
		@GetMapping("/retrieveBank/{id}")
		public Banque retrieveBanque(@PathVariable("id") Long id) {
			return banqueService.retrieveBanqueById(id);
		}
		
		// http://localhost:8081/DariTn/banque/getAllBankByNames
		@GetMapping("/getAllBankByNames")
		public List<String> getAllBankByNames(){
			return banqueService.getAllBankByNames();
		}
		
		@GetMapping("/getBankByName")
		public Banque getBankByName(String nombanque) {
			return banqueService.getBankByName(nombanque);
			
		}

}
