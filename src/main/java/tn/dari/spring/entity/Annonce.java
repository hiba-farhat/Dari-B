package tn.dari.spring.entity;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

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

@Table(name="Annonce")
public class Annonce implements Serializable  {
	@Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
	 private Long IdAnnonce ;
    public String name;
	@Column(name="Surface")
	@NonNull Float Surface ;
	@Column(name="Description")
	@NonNull String Description ;
	@Column(name="Localisation")
	@NonNull String Localisation ;
	@Column(name="price")
	@NonNull Float price ;
	@Column(name="Parking")
	@NonNull Boolean Parking ;
	@Column(name="RoomsNum")
	@NonNull Integer RoomsNum ;
	@Column(name="bathNum")
	@NonNull Integer bathNum ;
	@Column(name="image")
	@NonNull String image ;
	 private String Governorate;
		private String Delegation;
    private int taux_reduction ;
    private String  OfferType ;
     private TypeBiensEnum TypeProp  ;
    // private OfferTypeEnum OfferType ;
    // @OneToMany(cascade = CascadeType.ALL, mappedBy="Annonce")
   //  private Set<SearchAnnonce> Searchs;
     @JsonIgnore
 	@OneToMany(cascade = CascadeType.ALL, mappedBy = "Annonce")
 	private Set<favoris> favoris;
    
    // @OneToMany(cascade = CascadeType.ALL, mappedBy = "Annonce")
  	//private Collection<Annonce> Annonce;
 	// @JsonIgnore
    // @OneToMany(cascade = CascadeType.ALL, mappedBy = "Annonce")
    // private Set<Notification> Notification;
     @ManyToOne(cascade = CascadeType.ALL)
 	User User;
}