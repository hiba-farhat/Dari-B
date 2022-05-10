package tn.dari.spring.control;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
import tn.dari.spring.entity.User;
import tn.dari.spring.repository.UserRepository;
import tn.dari.spring.service.UserService;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class UserController {

	@Autowired
	UserService userService;
	@Autowired
	UserRepository userRepo;

	@Autowired
	PasswordEncoder encoder;

	// URL : http://localhost:8081/SpringMVC/User/retrieve-All-Users
	//@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/allUsers")
	public List<User> retrieveAllUsers() {
		List<User> List = userService.getUsers();
		return List;
		
	}

	// URL : http://localhost:8081/SpringMVC/User/add-User
	//@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/addUser")
	public User addUser(@RequestBody User user) {
		return userService.saveUser(user);
		
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/role/addToUser")
	public ResponseEntity<?> addRoleToUser(@RequestBody RoleToUserForm form) {
		userService.addRoleToUser(form.getUsername(), form.getRoleName());
		return ResponseEntity.ok().build();

	}

	// URL : http://Localhost:8081/SpringMVC/User/modify-User/{id}
	@PreAuthorize("hasRole('ADMIN')")

	@PutMapping("/modifUser")
	public User updateUser(@RequestBody User p) {
		return userService.updateUser(p);
	}

	@PutMapping("/lockUser/{id}/{status}")
	public void lockUser(@PathVariable("id") Long id, @PathVariable("status") boolean status) {
		userService.lockUser(id, status);
	}

	// URL : http://Localhost:8081/SpringMVC/User/delete-User/
	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("/deleteUser/{id}")
	public void DeleteUser(@PathVariable("id") Long id) {
		userService.deleteUser(id);
	}

	@PreAuthorize("hasAuthority('ADMIN')")
	@GetMapping("/retrieve-user-by-state/{user-state}")
	@ResponseBody
	public List<User> retrieveUserByState(@PathVariable("user-state") boolean stateUser) {
	return userService.retrieveUserByState(stateUser);
	}	
	
	
	// http://localhost:9091/SpringMVC/servlet/activate-user
	//@PreAuthorize("hasAuthority('ADMINISTRATOR')")
	@PutMapping("/activate-user")
	public User activateUser(@RequestBody User user) throws Exception {
	return userService.activateUser(user);
	}
	
	// http://localhost:9091/SpringMVC/servlet/desactivate-User
	//@PreAuthorize("hasAuthority('ADMINISTRATOR')")
	@PutMapping("/desactivate-User")
	public User desactivateUser(@RequestBody User user) throws Exception {
	return userService.desactivateUser(user);
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
	

}

@Data
class RoleToUserForm {
	private String username;
	private String roleName;
}