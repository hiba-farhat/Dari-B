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
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor

@Table(name = "users", uniqueConstraints = { @UniqueConstraint(columnNames = "username"),
		@UniqueConstraint(columnNames = "email") })
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	

	@Size(max = 50)
	private String nom;
//	@NotBlank
	@Size(max = 50)
	private String prenom;
	
	@NotBlank
	@Size(max = 50)
	@NotNull
	String username;
	private boolean stateUser;

//	@NotBlank
	@Size(max = 80)
	@Email
	@NotNull
	private String email;


//	@NotBlank
	@Size(max = 120)
	@NotNull
	private String password;
	protected String confirmPasswordUser;

//	@NotBlank
	// @Column(columnDefinition=" DEFAULT 'inconnue'")
	private String address;

//	@NotBlank

	@Size(max = 50)
	private String tel;
//	@NotBlank


	@ManyToMany(fetch = FetchType.LAZY)
	@JsonIgnore
	@JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles = new HashSet<>();
	
	@Temporal (TemporalType.DATE)
	private Date birth ;
	
	
	private boolean connected;



	public User(@Size(max = 80) String username, @Size(max = 50) @Email String email, @Size(max = 120) String password,
			String address, @Size(max = 50) String tel, @Size(max = 50) String nom, @Size(max = 50) String prenom, Date birth) {
		this.username = username;
		this.email = email;
		this.password = password;
		this.address = address;
		this.tel = tel;
		this.nom = nom;
		this.prenom = prenom;
		this.birth=birth;

	}

}