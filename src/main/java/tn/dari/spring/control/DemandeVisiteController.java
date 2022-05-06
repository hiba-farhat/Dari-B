package tn.dari.spring.control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import tn.dari.spring.entity.DemandeVisite;
import tn.dari.spring.entity.User;
import tn.dari.spring.repository.UserRepository;
import tn.dari.spring.service.DemandeVisiteService;
import tn.dari.spring.storage.StorageService;

@RestController
@Api(tags="Manage visits")
@RequestMapping("/DemandeVisite")
public class DemandeVisiteController {
@Autowired
DemandeVisiteService demandeVisiteService;
@Autowired
StorageService storage ;
@Autowired
UserRepository userRepository;
@ApiOperation(value="getDemandeVisit")
@GetMapping("/getVisitsByUser/{UserId}")
@ResponseBody
	List<DemandeVisite> retrieveAllVisitsByUser(@PathVariable  Long  UserId){
	
	return demandeVisiteService.retrieveAllVisitsByUser(userRepository.findById(UserId).get());
}

@ApiOperation(value="retrieveDemandeVisite")
@GetMapping("/retrieveDemandeVisite/{visiteId}")
@ResponseBody
	DemandeVisite retrieveDemandeVisite(@PathVariable  Long visiteId) {
	return demandeVisiteService.retrieveDemandeVisite(visiteId);
}

@ApiOperation(value="updateDemandeVisite")
@PutMapping("/updateDemandeVisite")
@ResponseBody
	DemandeVisite updateDemandeVisite(@RequestBody DemandeVisite f) {
	return demandeVisiteService.updateDemandeVisite(f);

	
}

@ApiOperation(value="addDemandeVisite")
@PostMapping("/addDemandeVisite/{User-id}/{property-id}")
@ResponseBody
	DemandeVisite addDemandeVisite(@RequestParam("demandeVisite") String demandeVisite,@PathVariable("User-id") Long id,
	@RequestParam("cin") MultipartFile cin,@RequestParam("garant") MultipartFile garant,@PathVariable("property-id") Long idProperty) throws JsonMappingException, JsonProcessingException {
		DemandeVisite a = new ObjectMapper().readValue(demandeVisite, DemandeVisite.class);
	return demandeVisiteService.addDemandeVisite(a,id,cin,garant,idProperty);

	
}

@ApiOperation(value="deleteDemandeVisite")
@DeleteMapping("/deleteDemandeVisite/{visiteId}")
void deleteDemandeVisite(@PathVariable Long visiteId) {
	
demandeVisiteService.deleteDemande(visiteId);
	
}
@ApiOperation(value = "Upload file")
@PostMapping("/updloadFile/{visiteId}/{type}")
public void handleFileUpload(@PathVariable Long visiteId, @PathVariable  String type, @RequestParam("file") MultipartFile file) {

	storage.store(file, visiteId, type);
}
@ApiOperation(value = "Get file")
@GetMapping("/getFile/{filename:.+}")
@ResponseBody
public ResponseEntity<Resource> serveFile(@PathVariable String filename) {

	Resource file = storage.loadAsResource(filename);
	return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
			"attachment; filename=\"" + file.getFilename() + "\"").body(file);
}



	
	
	
}
