package tn.dari.spring.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import tn.dari.spring.entity.ERole;
import tn.dari.spring.entity.Role;
import tn.dari.spring.entity.User;
import tn.dari.spring.repository.RoleRepository;
import tn.dari.spring.repository.UserRepository;

@Service
@RequiredArgsConstructor
//@Transactional
@Slf4j

public class UserServiceImpl implements UserService, UserDetailsService {
//	public class UserServiceImpl implements UserService {

	private final UserRepository userRepo;
	private final RoleRepository roleRepo;

	private final PasswordEncoder passwordEncoder;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepo.findByUsername(username);
		if (user == null) {
			log.error("user {} not found in the database", username);
			throw new UsernameNotFoundException("user not found");

		} else {
			log.info("user {} found in the database", username);
		}
		Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
		user.getRoles().forEach(role -> {
			authorities.add(new SimpleGrantedAuthority(role.getName().name()));
		});
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
				authorities);

	}

	@Override
	public List<User> getUsers() {
		log.info("fetching all users");
		return (List<User>) userRepo.findAll();
	}

	@Override
	public List<Role> getRoles() {
		log.info("fetching all roles");
		return (List<Role>) roleRepo.findAll();
	}

	@Override
	public Role saveRole(Role role) {
		log.info("saving new role {} to the database", role.getName());
		return roleRepo.save(role);
	}

	@Override
	public void addRoleToUser(String username, ERole roleName) {
		log.info("adding role {} to user {}", roleName, username);
		User user = userRepo.findByUsername(username);
		Role role = roleRepo.findByName(roleName);
		user.getRoles().add(role);
	}

	@Override
	public void deleteUser(Long id) {
		userRepo.deleteById(id);
	}

	@Override
	public void deleteRole(Long id) {
		roleRepo.deleteById(id);
	}

	@Override
	public User updateUser(User user) {
		return userRepo.save(user);
	}

//	@Override
//	public void lockUser(Long id, boolean status) {
//		// TODO Auto-generated method stub
//		User user = userRepo.findById(id).get();
//		user.setAccountNonLocked(status);
//		;
//		userRepo.save(user);
//	}

	@Override
	public Role updateRole(Role role, Long id) {
		return roleRepo.save(role);
	}

	@Override
	public User getUser(String username) {
		log.info("fetching user {} ", username);
		return userRepo.findByUsername(username);
	}

	@Override
	public User saveUser(User user) {
		log.info("saving new user {} to the database", user.getUsername());
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		return userRepo.save(user);
	}

	@Override
	public void lockUser(Long id, boolean status) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addRoleToUser(String username, String roleName) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean ifEmailExist(String email) {
		return userRepo.existsByEmail(email);
	}

	@Override
	public User getUserByMail(String mail) {
		return this.userRepo.findByEmail(mail);
	}

	@Override
	public void updatePassword(String emailUser, String newPassword, String confirmPassword) {
		User u = userRepo.findByEmail(emailUser);
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String encodedPassword = passwordEncoder.encode(newPassword);
		String encodedConfirmPassword = passwordEncoder.encode(confirmPassword);
		u.setPassword(encodedPassword);
		u.setConfirmPasswordUser(encodedConfirmPassword);

		u.setResetPasswordToken(null);
		userRepo.save(u);
	}

	@Override
	public void forgotpass(String emailuser) {
		// TODO Auto-generated method stub
		User d = userRepo.findByEmail(emailuser);

		final String username = "hiba.farhat.fh@gmail.com";
		final String password = "tlyl dnxq itty qrsw";

		Properties prop = new Properties();
		prop.put("mail.smtp.host", "smtp.gmail.com");
		prop.put("mail.smtp.port", "587");
		prop.put("mail.smtp.auth", "true");
		prop.put("mail.smtp.starttls.enable", "true"); // TLS
		prop.put("mail.smtp.ssl.trust", "smtp.gmail.com");

		Session session = Session.getInstance(prop, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("hiba.farhat.fh@gmail.com"));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(emailuser));
			message.setSubject("Reset Your Password");
			message.setText("This a non reply message from DariTn\n " + "Dear Client \n"
					+ "Please follow the following link to reser your password: \n" + "http://localhost:4200/update");

			Transport.send(message);

			log.info("Done");

		} catch (MessagingException e) {
			e.printStackTrace();
		}

	}

	@Override
	public User activateUser(User user) {

		if (user.isStateUser() == false) {

			user.setStateUser(true);
		} else {
			user.setStateUser(false);
		}
		return userRepo.save(user);
	}

	@Override
	public User desactivateUser(User user) {
		user.setEnabled(false);
		return userRepo.save(user);
	}

	@Override
	public List<User> retrieveUserByState(boolean stateUser) {
		return (List<User>) userRepo.findByStateUser(stateUser);
	}

	public boolean getstateUser(User user) {
		if (user.isStateUser()) {
			return true;
		} else {
			return false;
		}

	}

}