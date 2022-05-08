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
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import tn.dari.spring.entity.Role;
import tn.dari.spring.service.UserService;

@RestController
@RequestMapping("/role")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class RoleController {
	@Autowired
	UserService userService;

	
	// URL : http://localhost:8081/SpringMVC/User/retrieve-All-Users
	@GetMapping("/allRoles")
	public List<Role> retrieveAllRoles() {
		List<Role> List = userService.getRoles();
		return List;
	}

	// URL : http://localhost:8081/SpringMVC/User/add-User
	@PostMapping("/addRole")
	public Role addRole(@RequestBody Role R) {
		return userService.saveRole(R);
	}

	// URL : http://Localhost:8081/SpringMVC/User/modify-User/{id}
	@PutMapping("/modifRole/{id}")
	public Role updateRole(@RequestBody Role p, @PathVariable("id") Long id) {

		return userService.updateRole(p, id);
	}
	// URL : http://Localhost:8081/SpringMVC/User/delete-User/
		@DeleteMapping("/deleteRole/{id}")
		public void DeleteRole(@PathVariable("id") Long id) {
			userService.deleteRole(id);
		}
}