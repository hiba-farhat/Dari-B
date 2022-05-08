package tn.dari.spring.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Abonnement implements Serializable {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name = "id_abonnement")
	@NonNull private long id;
	
	@Column(name = "date_debut")
	@NonNull private Date date_debut;

	@Column(name = "date_fin")
	@NonNull private Date date_fin;
	
	@Enumerated (EnumType.STRING)
	TypeAbonnement Type;
	
	@Column(name = "prix")
	@NonNull private float prix;
	
	@JsonIgnore
    @OneToMany(cascade = CascadeType.ALL , mappedBy = "AssAbon" )
    private List<Assurance> Assurences = new ArrayList<>();

}