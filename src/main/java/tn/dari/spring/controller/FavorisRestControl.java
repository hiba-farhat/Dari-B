package tn.dari.spring.controller;

import java.util.List;



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
import io.swagger.annotations.Api;
import tn.dari.spring.entity.Annonce;
import tn.dari.spring.entity.favoris;
import tn.dari.spring.service.favorisService;

@RestController
@CrossOrigin("*")
@RequestMapping("/favoris")
@Api(tags="Gestion des favoris")
public class FavorisRestControl {
	
	@Autowired
	favorisService favorisService;
	

	//URL : http://localhost:8081/SpringMVC/favoris/retrieve-all-favoris
	@PostMapping("/retrieve-all-favoris")
	public List<favoris> retrieveAllfavoris() {
		List<favoris> list = favorisService.retrieveAllfavoris();
		return list;
	}
	
	//URL : http://localhost:8081/SpringMVC/favoris/add-favoris
	@ResponseBody
	@PostMapping("/add-favoris")
	public favoris addfavoris(@RequestBody favoris f) {
		return favorisService.addfavoris(f);
	}
	
	//URL : http://localhost:8081/SpringMVC/favoris/delete-favoris
	@DeleteMapping("/delete-favoris/{id}")
	public void deletefavoris(@PathVariable("id") Long id) {
		favorisService.deletefavoris(id);
	}
	//http://localhost:8081/SpringMVC/favoris/retrievefavoris/{id}
	@PostMapping("/retrievefavoris/{id}")
	@ResponseBody
	public favoris retrievefavoris(@PathVariable("id") Long id) {
		return favorisService.retrievefavoris(id);
	}
	//http://localhost:8081/SpringMVC/favoris/Addfavoris/1/3
		@PostMapping("/Addfavoris/{id}/{IdAnnonce}")
	public favoris Addfavoris(@RequestBody favoris f,@PathVariable Long id ,@PathVariable Long IdAnnonce)
		{
			favoris favoris = favorisService.AddFavoris( f, id, IdAnnonce);
			return favoris;
	}
		@GetMapping("/User/{id}/Favorite/Notification")
		public List<favoris> getfavoriteswhoseassetgotupdated(@PathVariable("id") Annonce a) {
			return favorisService.getfavoriteswhoseassetgotupdated(a);
		}

}
