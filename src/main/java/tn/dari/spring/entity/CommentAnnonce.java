 package tn.dari.spring.entity;

import java.io.Serializable;
import java.sql.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

@Entity

public class CommentAnnonce  implements Serializable  {
	@Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long idComment ;
	private Date createdAt ;
	private String commentContent ; 
	private Integer rate;
	@ManyToOne
	@JsonIgnore
	Annonce annonce;
	
	@Transient   //non pas dans la bd    
	private Long idAnnonce ;
	
	
	public Long getIdComment() {
		return idComment;
	}
	public void setIdComment(Long idComment) {
		this.idComment = idComment;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public String getCommentContent() {
		return commentContent;
	}
	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
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
	
	
	public Integer getRate() {
		return rate;
	}
	public void setRate(Integer rate) {
		this.rate = rate;
	}
	@Override
	public String toString() {
		return "CommentAnnonce [idComment=" + idComment + ", createdAt=" + createdAt + ", commentContent="
				+ commentContent + ", annonce=" + annonce + ", idAnnonce=" + idAnnonce + "]";
	}
	
	
	public CommentAnnonce() {
		
	}
	public CommentAnnonce(Long idComment, Date createdAt, String commentContent, Annonce annonce, Long idAnnonce) {
		
		this.idComment = idComment;
		this.createdAt = createdAt;
		this.commentContent = commentContent;
		this.annonce = annonce;
		this.idAnnonce = idAnnonce;
	}
	

}
