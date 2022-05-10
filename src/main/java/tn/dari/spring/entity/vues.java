package tn.dari.spring.entity;

/*import java.io.Serializable;
import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class vues implements Serializable {
	@Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;
	private String adresse;
	private String paysCode;
	private Date date;
	private String operateur;
	private String pays;
	private String region;
	private String ville;
	@ManyToOne
	@JsonIgnore
	Annonce annonce;
	
	@Transient   //non pas dans la bd    
	private Long idAnnonce ;
	public Long getId() {
		return id;
		
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getPaysCode() {
		return paysCode;
	}
	public void setPaysCode(String paysCode) {
		this.paysCode = paysCode;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getOperateur() {
		return operateur;
	}
	public void setOperateur(String operateur) {
		this.operateur = operateur;
	}
	public String getPays() {
		return pays;
	}
	public void setPays(String pays) {
		this.pays = pays;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
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
	public vues() {
		
	}
	@Override
	public String toString() {
		return "vues [id=" + id + ", adresse=" + adresse + ", paysCode=" + paysCode + ", date=" + date + ", operateur="
				+ operateur + ", pays=" + pays + ", region=" + region + ", ville=" + ville + ", annonce=" + annonce
				+ ", idAnnonce=" + idAnnonce + "]";
	}
	public vues(Long id, String adresse, String paysCode, Date date, String operateur, String pays, String region,
			String ville, Annonce annonce, Long idAnnonce) {
		super();
		this.id = id;
		this.adresse = adresse;
		this.paysCode = paysCode;
		this.date = date;
		this.operateur = operateur;
		this.pays = pays;
		this.region = region;
		this.ville = ville;
		this.annonce = annonce;
		this.idAnnonce = idAnnonce;
	}
	

}
*/