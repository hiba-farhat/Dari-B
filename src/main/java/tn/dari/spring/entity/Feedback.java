package tn.dari.spring.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="T_FEEDBACK")
public class Feedback implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	private String review;
	private float note;
	private int flags=0 ;
	private boolean flagtreated = false ;
	//@ManyToOne
	//private User user;
	//@ManyToOne
	//private Ad ad;
	//===========================================================================================
	
	
}