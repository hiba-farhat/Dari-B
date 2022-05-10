package tn.dari.spring.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Table(name = "users", uniqueConstraints = { @UniqueConstraint(columnNames = "username"),
@UniqueConstraint(columnNames = "email") })
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	@Size(max = 50)
	@NotNull
	String username;

//	@NotBlank
	@Size(max = 80)
	@Email
	@NotNull
	private String email;
	@Column(name = "resettoken")
	protected String resetPasswordToken;
	
	protected String confirmPasswordUser ;

//	@NotBlank
	@Size(max = 120)
	@NotNull
	private String password;

//	@NotBlank
	//@Column(columnDefinition=" DEFAULT 'inconnue'")
	private String address;

//	@NotBlank
	//@Column(columnDefinition=" DEFAULT 'inconnue'")

	@Size(max = 50)
	private String tel;
//	@NotBlank
	@Size(max = 50)
	private String nom;
//	@NotBlank
	@Size(max = 50)
	private String prenom;

	private int accountVerified;

	@ManyToMany(fetch = FetchType.LAZY)
	@JsonIgnore
	@JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles = new HashSet<>();

	
	
	private boolean enabled;

//	public User() {
//	}

//	public User(String username, String email, String password) {
//		this.username = username;
//		this.email = email;
//		this.password = password;
//	}

//	public Set<Role> getRoles() {
//		return roles;
//	}
//
//	public void setRoles(Set<Role> roles) {
//		this.roles = roles;
//	}
//
//	public boolean isAccountVerified() {
//		return accountVerified;
//	}
//
//	public boolean isEnabled() {
//		return enabled;
//	}
//
//	public void setEnabled(boolean enabled) {
//		this.enabled = enabled;
//	}

	public User(@Size(max = 80) String username, @Size(max = 50) @Email String email, @Size(max = 120) String password,
			String address, @Size(max = 50) String tel, @Size(max = 50) String nom, @Size(max = 50) String prenom
			) {
		this.username = username;
		this.email = email;
		this.password = password;
		this.address = address;
		this.tel = tel;
		this.nom = nom;
		this.prenom = prenom;
	
	}

}