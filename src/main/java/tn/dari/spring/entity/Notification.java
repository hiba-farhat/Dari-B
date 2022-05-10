package tn.dari.spring.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class Notification {
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @NonNull private Long IdNotif;
	    // @Enumerated (EnumType.STRING)
	    // private TypeNotification notifType;
	     @Column(name = "titre")
	 	 public String titre;
	 	 @Column(name = "description")
	 	 public String description_notif;
	 //	@JsonIgnore
	     @ManyToOne(cascade = CascadeType.ALL)
	    Annonce Annonce ;
		//@JsonIgnore
	     @ManyToOne(cascade = CascadeType.ALL)
	    	User user;
	 //	@OneToOne
//	 	@JoinColumn(name="Notif_annonces")
	  //  @JsonIgnore
	  //  @ManyToOne
	   // private User user;
}
