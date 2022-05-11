package tn.dari.spring.control;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
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
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import tn.dari.spring.entity.User;
import tn.dari.spring.repository.UserRepository;
import tn.dari.spring.service.UserService;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
@Slf4j
public class UserController {

	@Autowired
	UserService userService;
	@Autowired
	UserRepository userRepo;

	@Autowired
	PasswordEncoder encoder;

	// URL : http://localhost:8081/DariTn/User/retrieve-All-Users
	@GetMapping("/allUsers")
	public List<User> retrieveAllUsers() {
		List<User> List = userService.getUsers();
		return List;

	}

	// URL : http://localhost:8081/DariTn/User/add-User

	@PostMapping("/addUser")
	public User addUser(@RequestBody User user) {
		return userService.saveUser(user);

	}

	@PostMapping("/role/addToUser")
	public ResponseEntity<?> addRoleToUser(@RequestBody RoleToUserForm form) {
		userService.addRoleToUser(form.getUsername(), form.getRoleName());
		return ResponseEntity.ok().build();

	}

	// URL : http://Localhost:8081/DariTn/User/modify-User/{id}

	@PutMapping("/modifUser")
	public User updateUser(@RequestBody User p) {
		return userService.updateUser(p);
	}

	// URL : http://Localhost:8081/DariTn/User/delete-User/
	@DeleteMapping("/deleteUser/{id}")
	public void DeleteUser(@PathVariable("id") Long id) {
		userService.deleteUser(id);
	}

	@GetMapping("/retrieve-user-by-state/{user-state}")
	@ResponseBody
	public List<User> retrieveUserByState(@PathVariable("user-state") boolean stateUser) {
		return userService.retrieveUserByState(stateUser);
	}

	// http://localhost:9091/DariTn/servlet/activate-user
	// @PreAuthorize("hasAuthority('ADMINISTRATOR')")
	@PutMapping("/activate-user")
	public User activateUser(@RequestBody User user) throws Exception {
		return userService.activateUser(user);
	}

	@PutMapping("/updatepassword/{emailUser}/{password}/{cpassword}")
	void updatePassword(@PathVariable("emailUser") String emailUser, @PathVariable("password") String newPassword,
			@PathVariable("cpassword") String confirmPassword) {
		userService.updatePassword(emailUser, newPassword, confirmPassword);
	}

	@GetMapping("/sendme/{emailUser}")
	public void forgotpass(@PathVariable("emailUser") String emailUser) {
		userService.forgotpass(emailUser);
	}

	// URL : http://localhost:8081/DariTn/user/idUserForImage
	@GetMapping("/idUserForImage")
	public int nbUsers() {
		List<User> List = userService.getUsers();
		int nb = List.size() + 1;
		return nb;

	}

	// *******************statistics**************************

	// http://localhost:8081/DariTn/user/count-user
	// @PreAuthorize("hasAuthority('ADMINISTRATOR')")
	@GetMapping("/count-user")
	@ResponseBody
	public long retrieveClientByCount() {
		return userService.retrieveUserByCount();
	}

	// http://localhost:8081/DariTn/user/retrieve-user-by-adress/{user-adress}
	@GetMapping("/retrieve-user-by-adress/{user-adress}")
	@ResponseBody
	public List<User> retrieveUserByAddress(@PathVariable("user-adress") String adressUser) {
		return userService.retrieveUserByAddress(adressUser);
	}

	// http://localhost:8081/DariTn/user/min-age

	@GetMapping("/min-age")
	public Date agemin() throws Exception {
		log.info("date naissance de min age "+userRepo.getminage());
		return userRepo.getminage();
	}

	// http://localhost:8081/DariTn/user/max-age
	@Scheduled(fixedDelay = 1000)
	@GetMapping("/max-age")
	public Date agemax() throws Exception {
		log.info("date naissance de max age : "+userRepo.getmaxage());

		return userRepo.getmaxage();
	}
	@Scheduled(fixedDelay = 1000)
	@GetMapping("/nbDisabled")
	public int nbDisabled() throws Exception {
		log.info("nb of disabled users : "+userRepo.getNbDisabled());

		return userRepo.getNbDisabled();
	}

}

@Data
class RoleToUserForm {
	private String username;
	private String roleName;
}