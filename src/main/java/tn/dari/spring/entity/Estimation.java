package tn.dari.spring.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Estimation implements Serializable {
	@Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long IdSearchA ;
	@NonNull String Keyword; 
	 String Location ;
	@NonNull String Status ;
	@NonNull String PropertyType ;
	@NonNull Float Price ;
	@NonNull int BedRoom ;
	@NonNull int Bathroom ;
	@NonNull Float Surface ;
    private String Governorate;
	private String Delegation;
	
	@JsonIgnore	
	@ManyToOne(cascade = CascadeType.ALL)
	private User user;
	@JsonIgnore	
	@ManyToOne(cascade = CascadeType.ALL)
	private Annonce Annonce ;

}

