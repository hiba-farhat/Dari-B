package tn.dari.spring.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;
import tn.dari.spring.entity.*;

@Entity

public class likeAnnonce  implements Serializable{

	@Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long idLike ;
	private Date dateCreation;
	private typeLike typeLike;
	@ManyToOne
	@JsonIgnore
	Annonce annonce;
	@Transient   //non pas dans la bd    
	private Long idAnnonce ;
	
	public Long getIdLike() {
		return idLike;
	}
	public void setIdLike(Long idLike) {
		this.idLike = idLike;
	}
	public Date getDateCreation() {
		return dateCreation;
	}
	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}
	public typeLike getTypeLike() {
		return typeLike;
	}
	public void setTypeLike(typeLike typeLike) {
		this.typeLike = typeLike;
	}
	public Annonce getAnnonce() {
		return annonce;
	}
	public void setAnnonce(Annonce annonce) {
		this.annonce = annonce;
	}
	public Long getIdAnnonce() {
		return idAnnonce;
	}
	public void setIdAnnonce(Long idAnnonce) {
		this.idAnnonce = idAnnonce;
	}
	@Override
	public String toString() {
		return "likeAnnonce [idLike=" + idLike + ", dateCreation=" + dateCreation + ", typeLike=" + typeLike
				+ ", annonce=" + annonce + ", idAnnonce=" + idAnnonce + "]";
	}
	public likeAnnonce(Long idLike, Date dateCreation,  typeLike typeLike, Annonce annonce,
			Long idAnnonce) {
		
		this.idLike = idLike;
		this.dateCreation = dateCreation;
		this.typeLike = typeLike;
		this.annonce = annonce;
		this.idAnnonce = idAnnonce;
	}
	
}
