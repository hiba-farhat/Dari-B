package tn.dari.spring.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

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
public class Governorate {

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String GovernorateName;
	
	
	@OneToMany(mappedBy="governorate",cascade={CascadeType.PERSIST,CascadeType.REMOVE},fetch=FetchType.LAZY)
	@JsonIgnore
	private Set<Delegation> Delegations= new HashSet<>();


	
	
	
	
	}