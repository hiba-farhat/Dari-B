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
@RequestMapping("/LikeAnnonce")
public class LikeAnnonceRestControl {
	@Autowired
	LikeAnnonceService LikeAnnonceService;
	@Autowired
	AnnonceService annonceService;
	
	// URL : http://Localhost:8081/SpringMVC/likeAnnonce/retrieve-All-likeAnnonce
	   @GetMapping("/retrieve-All-LikeAnnonce")
 public List<likeAnnonce> retrieveAllAnnonce() {
		   List<likeAnnonce> List =LikeAnnonceService.retrieveAllLikeAnnonce();
		   return List; 
	   }
 
 // URL : http://Localhost:8081/SpringMVC/likeAnnonce/add-LikeAnnonce
 @PostMapping("/add-LikeAnnonce")
 @ResponseBody
 public likeAnnonce addLikeAnnonce(@RequestBody likeAnnonce l) {
	 Annonce annonce= annonceService.retrieveAnnonceById(l.getIdAnnonce());
	 l.setAnnonce(annonce);
	   return LikeAnnonceService.addLikeAnnonce(l);}
 
//URL : http://Localhost:8081/SpringMVC/likeAnnonce/delete-likeAnnonce/
 
 @DeleteMapping("/delete-LikeAnnonce/{id}")
 public void DeleteLikeAnnonce(@PathVariable("id") Long id) {
	 LikeAnnonceService.deleteLikeAnnonce(id);
 }
}
