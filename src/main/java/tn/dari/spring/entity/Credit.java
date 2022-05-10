package tn.dari.spring.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import tn.dari.spring.entity.Banque;
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@RequiredArgsConstructor
@Table(name = "Credit")
public class Credit implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCredit;
	
	@Column(name="montant")
	@NonNull private float montant;
	
	
	 @Column(name="salaire") 
	 @NonNull float salaire;
	 
	
	@Column(name="partmensuel")
	@NonNull private double partmensuel;
	
	/*
	 * @Column(name="interet") private double interet;
	 */
	
	@Column(name="duree")
	@NonNull private int duree;
	
	
	@ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	@JsonIgnore
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private Banque banque;
	
	@Transient
	private Long idBank;

	
	/*
	 * @ManyToOne private User user;
	 * 
	 * 
	 */
	
	


}
