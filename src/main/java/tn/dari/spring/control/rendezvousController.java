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
import tn.dari.spring.entity.Rendezvous;
import tn.dari.spring.service.RendezvousService;

@RestController
@CrossOrigin("*")
@RequestMapping("/rendezvous")
@Api(tags="Gestion des rendezvous")
public class rendezvousController {
	@Autowired
	RendezvousService rendezvousService;
	
	@GetMapping("/retrieveRdv")
	public List<Rendezvous> retrieveAllRdv() {
		List<Rendezvous> list = rendezvousService.retrieveAllRdv();
		return list;
	}
	
	@ResponseBody
	@PostMapping("/addRdv/{User-id}")
	public Rendezvous addRdv(@RequestBody Rendezvous f,@PathVariable("User-id") Long id) {
		return rendezvousService.addRdv(f,id);
	}
	
	@PutMapping("/updateRdv")
	public Rendezvous updateRdv(@RequestBody Rendezvous f) {
		return rendezvousService.updateRdv(f);
	}
	
	@DeleteMapping("/deleteRdv/{id}")
	public void deleteRdv(@PathVariable("id") Long id) {
		rendezvousService.deleteRdv(id);
	}
	
	
	
	@PutMapping("/acceptRdv")
	public Rendezvous accept(@RequestBody Rendezvous f) {
		return rendezvousService.accept(f);
	} 
}
