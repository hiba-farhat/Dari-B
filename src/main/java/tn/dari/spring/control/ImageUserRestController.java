//package tn.dari.spring.control;
//import java.io.IOException;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.core.io.ClassPathResource;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.prepost.PreAuthorize;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.multipart.MultipartFile;
//
//import lombok.extern.slf4j.Slf4j;
//import tn.dari.spring.entity.ImageUser;
//import tn.dari.spring.payload.response.ResponseMessage;
//import tn.dari.spring.service.IImageUserService;
//import tn.dari.spring.service.ImageUserServiceImpl;
//
//@RequestMapping("/imageUser")
//@Slf4j
//@RestController
//@CrossOrigin(origins = "*")
//
//public class ImageUserRestController {
//	
//	@Autowired
//	private ImageUserServiceImpl usi;
//	  
//	@Autowired
//	IImageUserService ius;
//	
//		// http://localhost:8081/DariTn/imageUser/uploaded
//		@PostMapping("/uploaded")
//		public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("file") MultipartFile file) {
//	    String message = "";
//	    try {
//	    usi.addImage(file);
//	    message = "Uploaded the file successfully: " + file.getOriginalFilename();
//	    return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
//	    }catch (Exception e) {
//	    message = "Could not upload the file: " + file.getOriginalFilename() + "!";
//	    return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
//	    }
//		}
//	  
//		// http://localhost:8081/DariTn/imageUser/affect-image-to-user
//		@PostMapping("/affect-image-to-user/{idimage}/{iduser}")
//		@ResponseBody
//		public void affectationImageToUser(@PathVariable("idimage") Long idimage,@PathVariable("iduser")Long iduser) throws IOException{
//	
//			usi.affectationImageToUser(idimage, iduser);
//		}
//		
//		// http://localhost:8081/DariTn/imageUser/retreive-all-images
//		//@PreAuthorize("hasAuthority('ADMINISTRATOR')")
//		@GetMapping ("/retreive-all-images")
//		@ResponseBody
//		public Iterable<ImageUser> retreiveAllImage(){
//			return ius.retreiveAllImage();
//		}
//		
//		// http://localhost:8081/DariTn/imageUser//getIdByImageName/{imageName}
//				//@PreAuthorize("hasAuthority('ADMINISTRATOR')")
//				@GetMapping ("/getIdByImageName/{imageName}")
//				@ResponseBody
//				public Long  getIdByImageName(@PathVariable("imageName") String imageName){
//					return ius.getIdByImageName(imageName);
//				}
//}