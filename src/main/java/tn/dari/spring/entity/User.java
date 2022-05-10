package tn.dari.spring.entity;

import java.io.Serializable;
import java.util.*;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;




import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@ToString
@Table(name="user")
public class User implements Serializable   {
    @Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;

	@Column(name="email")
	private String email;

	@Column(name="nom")
	private String nom;
	
	@Column(name="prenom")
	private String prenom;
	
	@Column(name="username")
	private String username;
	
	@Column(name="tel")
	private String tel;
	

	@Column(name="password")
	private String password;
	

     
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
    
    @JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
	private Set<favoris> favoris;



	
	
	
}