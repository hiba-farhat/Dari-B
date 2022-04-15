package tn.dari.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

import tn.dari.spring.entities.Assurance;

import tn.dari.spring.service.AssuranceService;

@RestController
@RequestMapping("/Assurance")
@Api(tags="Gestion des assurances")
public class AssuranceResetController {
	@Autowired
	 AssuranceService  AssuranceService;
	
	
	//URL : http://localhost:8081/DariTn/Assurance/retrieve-all-Assurance
	@GetMapping("/retrieve-all-Assurance")
	public List<Assurance> retrieveAllAssurances() {
		List<Assurance> list = AssuranceService.retrieveAllAssurance();
		return list;
	}
	//URL : http://localhost:8081/DariTn/Assurance/add-Assurance
		@ResponseBody
		@PostMapping("/add-Assurance")
		public Assurance addAssurance(@RequestBody Assurance A) {
			return AssuranceService.addAssurance(A);
		}
		
		//URL : http://localhost:8081/DariTn/Assurancet/update-Assurance
		@PostMapping("/update-Assurance")
		public Assurance updAbonnement(@RequestBody Assurance A) {
			return AssuranceService.updateAssurance(A);
		}
		
		//URL : http://localhost:8081/DariTn/Assurance/delete-Assurance
		@DeleteMapping("/delete-Assurance/{id}")
		public void deleteAssurance(@PathVariable("id") Long id) {
			AssuranceService.deleteAssurance(id);
		}

}
