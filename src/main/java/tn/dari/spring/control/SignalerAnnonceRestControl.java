package tn.dari.spring.control;

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

import tn.dari.spring.service.*;
import tn.dari.spring.entity.*;
@RestController
@RequestMapping("/SignalerAnnonce")
public class SignalerAnnonceRestControl {
	@Autowired
	SignalerAnnonceService signalerAnnonceService;
	@Autowired
	AnnonceService annonceService;

	// URL :
	// http://Localhost:8081/SpringMVC/SignalerAnnonce/retrieve-All-SignalerAnnonce
	@GetMapping("/retrieve-All-SignalerAnnonce")
	public List<SignalerAnnonce> retrieveAllSignalerAnnonce() {
		List<SignalerAnnonce> List = signalerAnnonceService.retrieveAllSignalerAnnonce();
		return List;
	}

	// URL : http://Localhost:8081/SpringMVC/SignalerAnnonce/add-SignalerAnnonce
	@PostMapping("/add")
	@ResponseBody
	public BackendReponse addSignalerAnnonce(@RequestBody SignalerAnnonce s) {
		
		Annonce annonce = annonceService.retrieveAnnonceById(s.getIdAnnonce());
		s.setAnnonce(annonce);
		SignalerAnnonce added = signalerAnnonceService.addSignalerAnnonce(s);
		return new BackendReponse(200, "ajouté avec success ");
	}

//URL : http://Localhost:8081/SpringMVC/SignalerAnnonce/delete-SignalerAnnonce/

	@DeleteMapping("/delete/{id}")
	public BackendReponse DeleteSignalerAnnonce(@PathVariable("id") Long id) {
		signalerAnnonceService.deleteSignalerAnnonce(id);
		return new BackendReponse(200, "deleted successfuly");
	}

	@GetMapping("/{annonceId}")
	public List<SignalerAnnonce> getSignaux(@PathVariable("annonceId") Long annonceId) {
		List<SignalerAnnonce> List = signalerAnnonceService.getSignauxByAnnonceId(annonceId);
		return List;
	}
	
	@GetMapping("/getSignauxForAdmin")
	public List<Object> getSignauxForAdmin() {
		List<Object> List = signalerAnnonceService.getSignauxForAdmin();
		return List;
	}
	
	
}
