package tn.dari.spring.control;
import java.text.SimpleDateFormat;  
import java.util.Date;  
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.dari.spring.service.*;
import tn.dari.spring.entity.*;
@RestController
@RequestMapping("/commentsAnnonce")
public class CommentAnnonceRestControl {
	@Autowired
	CommentAnnonceService CommentAnnonceService;
	@Autowired
	AnnonceService annonceService;


	@GetMapping("/{annonceId}")
	public List<CommentAnnonce> getComments(@PathVariable("annonceId") Long annonceId) {
		List<CommentAnnonce> List = CommentAnnonceService.getCommentsByAnnonceId(annonceId);
		return List;
	}


	@PostMapping("/add")
	@ResponseBody
	public CommentAnnonce addCommentAnnonce(@RequestBody CommentAnnonce c) {
		
		Annonce annonce = annonceService.retrieveAnnonceById(c.getIdAnnonce());
		c.setAnnonce(annonce);
		return CommentAnnonceService.addCommentAnnonce(c);
	}
	
	@PutMapping("/update")
	@ResponseBody
	public CommentAnnonce updateCommentAnnonce(@RequestBody CommentAnnonce c) {
		
		Annonce annonce = annonceService.retrieveAnnonceById(c.getIdAnnonce());
		c.setAnnonce(annonce);
		return CommentAnnonceService.updateCommentAnnonce(c);
	}

	@DeleteMapping("/delete/{id}")
	public void DeletecommentAnnonce(@PathVariable("id") Long id) {
		CommentAnnonceService.deleteCommentAnnonce(id);
	}

}
