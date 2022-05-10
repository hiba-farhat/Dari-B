package tn.dari.spring.control;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.itextpdf.text.DocumentException;

import io.swagger.annotations.Api;
import tn.dari.spring.entity.Credit;
import tn.dari.spring.service.CreditService;
import tn.dari.spring.service.PdfService;


@RestController
@Api(tags="Gestion des credits")
@RequestMapping("/credit")
@CrossOrigin(origins = "http://localhost:4200")

public class CreditRestController {
	

	@Autowired
	CreditService creditService;
	
	@Autowired
	PdfService pdfService;
	
	//http://localhost:8081/DariTn/credit/retrieve-all-credits
	@GetMapping("/retrieve-all-credits")	
	@ResponseBody
	public List<Credit> retrieveAllCredits(){
		List<Credit> list = creditService.retrieveAllCredits();
		return list;
	}
	
	//http://localhost:8081/DariTn/credit/add-credit
	@PostMapping("/add-credit")
	@ResponseBody
	public Credit addCredit(@RequestBody Credit c) {
		return creditService.addCredit(c);
	}
	
	//http://localhost:8081/DariTn/credit/delete-credit/{id}
	@DeleteMapping("/delete-credit/{id}")
	@ResponseBody
	public void deleteCredit(@PathVariable("id") Long id) {
		creditService.deleteCredit(id);
	}
	
	//http://localhost:8081/DariTn/credit/retrieveCredit/{id}
	@GetMapping("/retrieveCredit/{id}")
	@ResponseBody
	public Credit retrieveCredit(@PathVariable("id") Long id) {
		return creditService.retrieveCreditById(id);
	}
	
	//Simulation 
	@PostMapping(value = "/simulationcredit/{idBanque}") 
	private Credit simulationCredit(@RequestBody Credit credit, @PathVariable Long idBanque){
		creditService.simulation(credit, idBanque);
				   
		return credit;
				}
				
	//pdf
	@GetMapping("/credit/pdf")
	private void  exportPdf(HttpServletResponse response, Credit credit) throws IOException, DocumentException{
					
		byte[] content = Files.readAllBytes(Paths.get(pdfService.generatePdf(Optional.of(credit)).getAbsolutePath()));
				}
		
	//statistics used bank
	/*
	 * @GetMapping(value ="/count/{nombanque}")
	 * 
	 * @ResponseBody private int Count(@PathVariable ("nombanque") String
	 * nombanque){ return creditService.Count(nombanque); }
	 */


}
