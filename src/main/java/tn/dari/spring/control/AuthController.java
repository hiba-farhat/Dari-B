package tn.dari.spring.control;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import tn.dari.spring.entity.ERole;
import tn.dari.spring.entity.Role;
import tn.dari.spring.entity.User;
import tn.dari.spring.jwt.JwtUtils;
import tn.dari.spring.payload.request.LoginRequest;
import tn.dari.spring.payload.request.SignupRequest;
import tn.dari.spring.payload.response.JwtResponse;
import tn.dari.spring.payload.response.MessageResponse;
import tn.dari.spring.repository.RoleRepository;
import tn.dari.spring.repository.UserRepository;
import tn.dari.spring.security.UserDetailsImpl;
import tn.dari.spring.service.UserService;
import tn.dari.spring.userFunctions.AccountResponse;
import tn.dari.spring.userFunctions.UserCode;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
@Slf4j
public class AuthController {
	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	UserRepository userRepository;

	@Autowired
	RoleRepository roleRepository;

	@Autowired
	PasswordEncoder encoder;

	@Autowired
	JwtUtils jwtUtils;

	@Autowired
	UserService userService;

	@RequestMapping(value = "/signin", method = RequestMethod.POST)
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtUtils.generateJwtToken(authentication);

		UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
		List<String> roles = userDetails.getAuthorities().stream().map(item -> item.getAuthority())
				.collect(Collectors.toList());

		return ResponseEntity.ok(
				new JwtResponse(jwt, userDetails.getId(), userDetails.getUsername(), userDetails.getEmail(), roles));
	}

	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public AccountResponse registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
//		if (userRepository.existsByUsername(signUpRequest.getUsername())) {
//			return ResponseEntity.badRequest().body(new MessageResponse("Error: Username is already taken!"));
//		}
//
//		if (userRepository.existsByEmail(signUpRequest.getEmail())) {
//			return ResponseEntity.badRequest().body(new MessageResponse("Error: Email is already in use!"));
//		}

		// Create new user's account
		User user = new User(signUpRequest.getUsername(), signUpRequest.getEmail(),
				encoder.encode(signUpRequest.getPassword()), signUpRequest.getAddress(), signUpRequest.getTel(),
				signUpRequest.getNom(), signUpRequest.getPrenom());

		Set<String> strRoles = signUpRequest.getRole();
		Set<Role> roles = new HashSet<>();
		if (strRoles == null) {
			Role userRole = roleRepository.findByName(ERole.ROLE_USER);
			roles.add(userRole);
		} else {
			strRoles.forEach(role -> {
				switch (role) {
				case "ROLE_ADMIN":
					Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN);
					roles.add(adminRole);

					break;
				case "vendeur":
					Role vendRole = roleRepository.findByName(ERole.ROLE_VENDEUR);
					roles.add(vendRole);
					break;
				case "acheteur":
					Role achetRole = roleRepository.findByName(ERole.ROLE_ACHETEUR);
					roles.add(achetRole);

					break;
				default:
					Role userRole = roleRepository.findByName(ERole.ROLE_USER);
					roles.add(userRole);
				}
			});
		}

		AccountResponse accountResponse = new AccountResponse();
		boolean result = userRepository.existsByEmail(signUpRequest.getEmail());
		if (result) {
			accountResponse.setResult(0);

		} else {

			
			user.setAccountVerified(1);
			user.setRoles(roles);
			userRepository.save(user);
			accountResponse.setResult(1);

		}
		log.info("" + ResponseEntity.ok(new MessageResponse("User registered successfully!")));
		return accountResponse;
	}
}
