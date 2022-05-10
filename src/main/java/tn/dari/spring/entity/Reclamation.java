package tn.dari.spring.entity;


	

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@ToString
@Table(name = "Reclamation")

public class Reclamation implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idReclamation;
	
	@NotBlank
	@Column(name = "titreReclamation")
	@NonNull private String titreReclamation;
	
	@NotBlank
	@Column(name = "descriptionReclamation")
	@NonNull private String descriptionReclamation;
	
	//@OneToMany(cascade=CascadeType.ALL,mappedBy="reclamation")
	//private Set <User> user;
	


}



