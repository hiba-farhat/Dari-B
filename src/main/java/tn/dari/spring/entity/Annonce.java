package tn.dari.spring.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

//annonce

@Entity

@Table(name = "Annonce")
public class Annonce implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idAnnonce;
	@Column(name = "titre")
	private String titre;
	@Column(name = "surface")
	private Float surface;
	@Column(name = "description")
	private String description;
	@Column(name = "localisation")
	private String localisation;
	@Column(name = "price")
	private Long price;
	@Column(name = "yearBuilt")
	private Date yearBuilt;

	@Column(name = "parking")
	private Boolean parking;
	@Column(name = "roomsNum")
	private Integer roomsNum;
	@Column(name = "age")
	private Integer age;
	@Column(name = "bathNum")
	private Integer bathNum;
	@Column(name = "bedNum")
	private Integer bedNum;
	@Column(name = "garagenum")
	private Integer garagenum;

	@Column(name = "image",columnDefinition = "longtext")
	private String image;
	@Column(name = "imageplan",columnDefinition = "longtext")
	private String imageplan;
	@Column(name = "video",columnDefinition = "longtext")
	private String video;
	//@Column(name = "story")
	//private boolean story;

	private String typeProp;
	private String offerType;

	@OneToMany(cascade = CascadeType.ALL,mappedBy = "annonce")
	@JsonIgnore
	private Set<CommentAnnonce> comments;

	@OneToMany(cascade = CascadeType.ALL,mappedBy = "annonce")
	@JsonIgnore
	private Set<SignalerAnnonce> signaux;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "annonce")
	@JsonIgnore
	private Set<likeAnnonce> likes;

	public Long getIdAnnonce() {
		return idAnnonce;
	}

	public void setIdAnnonce(Long idAnnonce) {
		this.idAnnonce = idAnnonce;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public Float getSurface() {
		return surface;
	}

	public void setSurface(Float surface) {
		this.surface = surface;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLocalisation() {
		return localisation;
	}

	public void setLocalisation(String localisation) {
		this.localisation = localisation;
	}

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	public Date getYearBuilt() {
		return yearBuilt;
	}

	public void setYearBuilt(Date yearBuilt) {
		this.yearBuilt = yearBuilt;
	}

	public Boolean getParking() {
		return parking;
	}

	public void setParking(Boolean parking) {
		this.parking = parking;
	}

	public Integer getRoomsNum() {
		return roomsNum;
	}

	public void setRoomsNum(Integer roomsNum) {
		this.roomsNum = roomsNum;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Integer getBathNum() {
		return bathNum;
	}

	public void setBathNum(Integer bathNum) {
		this.bathNum = bathNum;
	}

	public Integer getBedNum() {
		return bedNum;
	}

	public void setBedNum(Integer bedNum) {
		this.bedNum = bedNum;
	}

	public Integer getGaragenum() {
		return garagenum;
	}

	public void setGaragenum(Integer garagenum) {
		this.garagenum = garagenum;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getImageplan() {
		return imageplan;
	}

	public void setImageplan(String imageplan) {
		this.imageplan = imageplan;
	}

	public String getVideo() {
		return video;
	}

	public void setVideo(String video) {
		this.video = video;
	}

	public String getTypeProp() {
		return typeProp;
	}

	public void setTypeProp(String typeProp) {
		this.typeProp = typeProp;
	}

	public String getOfferType() {
		return offerType;
	}

	public void setOfferType(String offerType) {
		this.offerType = offerType;
	}

	public Set<CommentAnnonce> getComments() {
		return comments;
	}

	public void setComments(Set<CommentAnnonce> comments) {
		this.comments = comments;
	}

	public Set<SignalerAnnonce> getSignaux() {
		return signaux;
	}

	public void setSignaux(Set<SignalerAnnonce> signaux) {
		this.signaux = signaux;
	}

	public Set<likeAnnonce> getLikes() {
		return likes;
	}

	public void setLikes(Set<likeAnnonce> likes) {
		this.likes = likes;
	}

	@Override
	public String toString() {
		return "Annonce [idAnnonce=" + idAnnonce + ", titre=" + titre + ", surface=" + surface + ", description="
				+ description + ", localisation=" + localisation + ", price=" + price + ", yearBuilt=" + yearBuilt
				+ ", parking=" + parking + ", roomsNum=" + roomsNum + ", age=" + age + ", bathNum=" + bathNum
				+ ", bedNum=" + bedNum + ", garagenum=" + garagenum + ", image=" + image + ", imageplan=" + imageplan
				+ ", video=" + video + ", typeProp=" + typeProp + ", offerType=" + offerType + ", comments=" + comments
				+ ", signaux=" + signaux + ", likes=" + likes + "]";
	}

	public Annonce(Long idAnnonce, String titre, Float surface, String description, String localisation, Long price,
			Date yearBuilt, Boolean parking, Integer roomsNum, Integer age, Integer bathNum, Integer bedNum,
			Integer garagenum, String image, String imageplan, String video, String typeProp, String offerType,
			Set<CommentAnnonce> comments, Set<SignalerAnnonce> signaux, Set<likeAnnonce> likes) {
		this.idAnnonce = idAnnonce;
		this.titre = titre;
		this.surface = surface;
		this.description = description;
		this.localisation = localisation;
		this.price = price;
		this.yearBuilt = yearBuilt;
		this.parking = parking;
		this.roomsNum = roomsNum;
		this.age = age;
		this.bathNum = bathNum;
		this.bedNum = bedNum;
		this.garagenum = garagenum;
		this.image = image;
		this.imageplan = imageplan;
		this.video = video;
		this.typeProp = typeProp;
		this.offerType = offerType;
		this.comments = comments;

		this.signaux = signaux;
		this.likes = likes;
	}

	public Annonce() {
	};

	@Override
	public int hashCode() {
		return Objects.hash(age, bathNum, bedNum, comments, description, garagenum, idAnnonce, image, imageplan, likes,
				localisation, offerType, parking, price, roomsNum, signaux, surface, titre, typeProp, video, yearBuilt);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Annonce other = (Annonce) obj;
		return Objects.equals(age, other.age) && Objects.equals(bathNum, other.bathNum)
				&& Objects.equals(bedNum, other.bedNum) && Objects.equals(comments, other.comments)
				&& Objects.equals(description, other.description) && Objects.equals(garagenum, other.garagenum)
				&& Objects.equals(idAnnonce, other.idAnnonce) && Objects.equals(image, other.image)
				&& Objects.equals(imageplan, other.imageplan) && Objects.equals(likes, other.likes)
				&& Objects.equals(localisation, other.localisation) && Objects.equals(offerType, other.offerType)
				&& Objects.equals(parking, other.parking) && Objects.equals(price, other.price)
				&& Objects.equals(roomsNum, other.roomsNum) && Objects.equals(signaux, other.signaux)
				&& Objects.equals(surface, other.surface) && Objects.equals(titre, other.titre)
				&& Objects.equals(typeProp, other.typeProp) && Objects.equals(video, other.video)
				&& Objects.equals(yearBuilt, other.yearBuilt);
	}

}
