package tn.dari.spring.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

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

@JsonIdentityInfo(generator= ObjectIdGenerators.IntSequenceGenerator.class)

public class Assurance  implements Serializable  {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	 @NonNull private long idAssu ;

	 @NonNull private String nomAssu ;
	 @NonNull private String descAssu ;
	 @NonNull  private  String dureAss ;
	    @Temporal(TemporalType.DATE)
	    @NonNull private Date dateDebutAssu ;
	    @Temporal(TemporalType.DATE)
	    @NonNull private Date dateFintAssu ;
	    @NonNull private float prixAss ;
	    @Enumerated(EnumType.STRING)
	    private  TypeAssurence typeAssurence ;



	   @JsonIgnore
	    @ManyToOne(cascade=CascadeType.PERSIST)
	    private Abonnement  AssAbon ;
	   

}
