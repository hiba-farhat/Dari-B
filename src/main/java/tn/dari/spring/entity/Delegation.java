package tn.dari.spring.entity;

import java.util.Set;

import javax.persistence.CascadeType;
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
public class Delegation {

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String DelegationName;
	
	private int Pricepermetre;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JsonIgnore 
	private Governorate governorate;

	


	
	
	
}